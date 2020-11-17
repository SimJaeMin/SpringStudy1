//package hello.hellospring.service;
//
//import static org.junit.jupiter.api.Assertions.fail;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import hello.hellospring.domain.Member;
//import hello.hellospring.repository.MemberRepository;
//import hello.hellospring.repository.MemoryMemberRepository;
//
//class MemberServiceTest {
//	
//		MemberService memberService;
//		MemoryMemberRepository memberRepository;
//		
//		
//		//그런데 만약 memberRepository에 store가 static이 아니라면 다른객체라 잘못된 조회가 될 수 있음
//		//MemoryMemberRepository memberRepository = new MemoryMemberRepository();
//		 
//		//그걸 방지하기 위해 MemberService에서 생성자를 만들고
//		@BeforeEach
//		//테스트를 실행할 떄마다 독립적으로 만들어준다.
//		public void beforeEach() {
//			System.out.println("before");
//			memberRepository = new MemoryMemberRepository();
//			memberService = new MemberService(memberRepository);
//		}
//		
//		@AfterEach
//		public void afterEach() {
//			System.out.println("after");
//			memberRepository.clearStore();
//		}
//		
//		
//		@Test
//		void join() {
//			//given -> 무언가가 주어젔는데
//			Member member = new Member();
//			member.setName("hello");
//			
//			//when -> 이거를 실행했을때 
//			Long saveId= memberService.join(member);
//			
//			//then -> 결과가 이게 나와야된다.
//			Member findMember = memberService.findOne(member.getId()).get();
//			Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
//		}
//
//		@Test
//		public void 중복_회원_예외() {
//			//given
//			Member member1= new Member();
//			member1.setName("Spring");
//			
//			Member member2= new Member();
//			member2.setName("Spring");
//			
//			memberService.join(member1);
//			//첫번째 인수가 터저야됨 => 언제 ? => 두번쨰 인자(로직)이 진행될 때 
//			IllegalStateException e = org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, ()->memberService.join(member2)); 
//		
//			//메시지도 비교하고 싶으면 위에처럼 받아서 사용가능
//			Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름(회원) 입니다.");
//			
////			try {
////				memberService.join(member2);
////				fail();
////			}catch (IllegalStateException e) {
////				// TODO: handle exception
////				Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름(회원)입니다.");
////			}
//			
//			
//			//when
//			
//			//then
//		}
//		@Test
//		void findMembers() {
//			
//		}
//		
//		@Test
//		void fidOne() {
//			
//		}
//}
