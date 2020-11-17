package hello.hellospring.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;


public class MemberService {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	//직접 new 하지않고 다른곳에서 넣어주고 있음 => DI
	public MemberService(MemberRepository memberRepository) {
		System.out.println("생성자");
		this.memberRepository = memberRepository;
	}

	//회원가입
	public Long join(Member member) {
		//같은 이름으로 중복회원 가입 안되나.
		validateDuplicateMember(member);
		memberRepository.save(member);	
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
//		Optional<Member> result=memberRepository.findByName(member.getName());
//		
//		result.ifPresent(m->{
//			throw new IllegalStateException("이미 존재하는 이름(회원) 입니다.");
//		});
		memberRepository.findByName(member.getName())
						.ifPresent(m->{
							throw new IllegalStateException("이미 존재하는 이름(회원) 입니다.");
						});
	}
	
	public Optional<Member> findOne(Long memberId){
		
		return memberRepository.findById(memberId);
	}
	
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
}
