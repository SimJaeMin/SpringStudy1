package hello.hellospring.repository;


import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;

public interface MemberRepository {
	Member save(Member member); // 저장
	Optional<Member> findById(Long id); //아이디를 찾았을 때 null일수도 있음 그런경우를 처리해주기위해
	Optional<Member> findByName(String name); // 이름으로 찾을 때
	List<Member> findAll();  //모든 리스트

}
