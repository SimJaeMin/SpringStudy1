package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import hello.hellospring.domain.Member;


public class MemoryMemberRepository implements MemberRepository{

	private static Map<Long,Member> store = new HashMap<Long, Member>(); //실무에서는 동시성문제 때문에 공유되는 변수일때는 컨커런트 Hashmap을 해야한다.
	private static long sequence = 0L;
	
	@Override
	public Member save(Member member) {
		// TODO Auto-generated method stub
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		// TODO Auto-generated method stub
		return store.values().stream()
				.filter(member -> member.getName().equals(name))
				.findAny(); //하나라도 찾으면
	}
	
	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		
		return new ArrayList<Member>(store.values());
	}

	public void clearStore() {
		store.clear();
	}
	
}
