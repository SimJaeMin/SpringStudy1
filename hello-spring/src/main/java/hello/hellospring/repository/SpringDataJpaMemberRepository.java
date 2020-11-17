package hello.hellospring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.hellospring.domain.Member;

//JpaRepository -> 2번째 아이디 -> PK
//인터페이스가 JpaRepository를 상속받고 있으면 스프링이 알아서 구현체를 만들고 빈등록해준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository{

		//selelct m form Member m where m.name = ? 
		@Override
		Optional<Member> findByName(String name);
	
	
}
