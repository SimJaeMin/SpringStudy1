package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest {
	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach 
	//테스트를 한번 할때마다 AfterEach 때문에 한번씩 실행된다.
	//초기화해줘야 다른 테스트 할 때 상관이 없음
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void save() { // @Test 어노테이션을 통해 바로 save() 함수를 실행시킬수있게된다(MemoryMemberRepository save아님).
		Member member = new Member();
		member.setName("Spring");
		
		
		repository.save(member); //여기서 save함수를 통해  멤버 추가
		
		Member result = repository.findById(member.getId()).get(); //이름을 바탕으로 추가된 멤버 가져오기, Optional이기 때문에 get으로
		//Assertions.assertEquals(member, null);
		assertThat(member).isEqualTo(result);
	}
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		Member result= repository.findByName("spring1").get();
		assertThat(result).isEqualTo(member1);
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		List<Member> result= repository.findAll();
		assertThat(result.size()).isEqualTo(2);
	}
}
