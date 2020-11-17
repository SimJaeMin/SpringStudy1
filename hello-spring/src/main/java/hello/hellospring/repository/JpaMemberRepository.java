package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import hello.hellospring.domain.Member;

public class JpaMemberRepository implements MemberRepository{

	private final EntityManager em; //JPA는 EntityManager로 모든 것이 동작함
	//build-gradle에서 data-jpa를 받아서 스프링부트가 자동으로 EntityManager를 생성한다.
	//우리는 만들어진것을 injection 받으면 된다.
	
	
	public JpaMemberRepository(EntityManager em) {
		this.em=em;
	}

	@Override
	public Member save(Member member) {
		em.persist(member); //persist -> 영구저장한다 라는 의미
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		Member member= em.find(Member.class, id); // 조회할 클래스와 찾을 값 , pk니까 이렇게 가능
		return Optional.ofNullable(member);
	}

	@Override
	public Optional<Member> findByName(String name) {
//		Member member= em.find(Member.class, name);
//		return Optional.ofNullable(member);
		List<Member> result=em.createQuery("select m from Member m where m.name=:name",Member.class)
					.setParameter("name", name)
					.getResultList();
		
		return result.stream().findAny();
	}

	@Override
	public List<Member> findAll() {
		List<Member> result= em.createQuery("select m from member as m",Member.class).getResultList(); //jpql 
		//보통 테이블에 대해 쿼리를 날리지만 이거는 객체(Entity)에 대해 날린다고 생각하기
		//select m => m 은 객체 자체를 주면된다.
		return result;
	}

	
}
