package hello.hellospring;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;

@Configuration
//Component Scan / Java Configuration 장단점
//DI 에는 필드 주입, setter 주입, 생성자 주입 3개가 있다. => 생성자 주입이 많이 사용된다.

public class SpringConfig {

	//private DataSource dataSource;
	
	//private EntityManager em;
	
	private final MemberRepository memberRepository;
	
	@Autowired
	//이렇게 하면 스프링 jpa가 만든걸 injection 해준다.
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository=memberRepository;
	}
	

	//	@Autowired
//	public SpringConfig(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
//
//	@Autowired
//	public SpringConfig(EntityManager em) {
//		this.em = em;
//	}


	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	
	//@Bean
	//다형성 
	//구현체만 바꿔끼면 다른데는 고칠게 없음 , Java Configuraion을 써서 우리가 di를 하면 이렇게 편하게 할수 있음
	//컨트롤러에서 -> 서비스를, 서비스에서 Repository를 참조하고 있기 때문에 만약에 repository가 바꼈으면 service, 컨트롤러에서도 코드가 변경이 일어나야했지만
	// 이렇게 Repository의 구현체만 바꾸어주면 되로록 할 수 있다.
	//MemberService는 MemberRepository를 참조하고있음, MemberRepository를 구현체만 JDBC로 바꾼거
	//OCP (개방 폐쇄 원칙) 확장에는 열려있고, 수정,변경에는 닫혀있다.
	//public MemberRepository memberRepository() {
		//return new MemoryMemberRepository();
		//return new JdbcMemberRepository(dataSource);
		//return new JdbcTemplateMemberRepository(dataSource);
		//return new JpaMemberRepository(em);
		
	//}
	
//	@Bean
//	public TimeTraceAop timeTraceAop() {
//		return new TimeTraceAop();
//	}
}
