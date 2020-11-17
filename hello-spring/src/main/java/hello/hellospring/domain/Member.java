package hello.hellospring.domain;

import javax.persistence.Id;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity // 앞으로 이 클래스는 jpa가 관리하다.
public class Member {
	
	@Id //Primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) // insert 하면 DB가 ID를 자동생성 => Identity 라고도 한다.
	private Long id; //시스템이 구분하기위해 저장하는 아이디, 사용자가 지정한 아이디가 아님
	//@Colum(name="username") => DB의 컬럼명이 username일 경우 이렇게하면 맵핑된다.
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
	
}
