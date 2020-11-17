package hello.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;

@Controller
//스프링 실행 시 스프링 컨테이너에 컨트롤러 어노테이션이 있으면 생성에서 넣어준다.
//그리고 스프링이 관리한다. => 스프링 컨테이너에서 bean이 관리된다고 표현한다.
public class MemberController {
	
	//이렇게  new로 생성할 수 있지만 이제 스프링한테 받아서 쓰는 형태로 변경해야한다.
	//왜냐하면 다른데서도 가져다 쓸수 있음, 또한 하나만 사용해서 같이 쓸수 있음
	//private final MemberService memberService = new MemberService();

	private final MemberService memberService;
	
	@Autowired
	//스프링이 memverServie를 넣어준다.
	public MemberController(MemberService memberService) {
		this.memberService=memberService;
	}
	
	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	
	@PostMapping("/members/new")
	public String create(MemberForm form) { //MemberForm form에 어떻게 form 태그의 name이 넘어가냐면 
											//form 태그의 input의 name="????" 이 MemberForm의 name에 바로 맵핑해줌
											//setName()을 통해 값이 넘어간다.
		Member member = new Member();
		member.setName(form.getName());
		memberService.join(member);
		return "redirect:/"; // redirect 회원가입이 끝나면 홈화면으로 이동
	}
	
	
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members= memberService.findMembers();
//		System.out.println("멤버 수 : " + members.size());
//		members.stream().forEach((s)->{
//			System.out.println("아이디 : " + s.getId());
//			System.out.println("이름 : " + s.getName());
//		});	
		model.addAttribute("members",members);
		return "members/memberList";
	}
	
	
}
