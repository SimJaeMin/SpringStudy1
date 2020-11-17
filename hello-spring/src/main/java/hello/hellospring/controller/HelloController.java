package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("hello")
	//Model model 스프링이 생성해준다.
	//return이 문자열이면 src/main/resources/templates 에서 찾는다.
	public String hello(Model model) {
		model.addAttribute("data","hello!!");
		return "hello";
	}
	
	
	@GetMapping("hello-mvc")
	//@RequestParam : 외부에서 무언가를 받을 때 , "name"만 적어도 가능 디폴트는 value 인듯
	//그런데 require(무조건 입력받는가에 대해서)랑 같이 하면 value를 추가해줘야함
	public String helloMvc(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name",name);
		return "hello-template";
	}
	
	@GetMapping("hello-string")
	@ResponseBody
	//@ResponseBody => http의 body부에 이 데이터(return 값 ) 를 직접 넣어주겠다.
	//@ResponseBody는 view 그런게 없고 그냥 데이터만 내려간다. => 페이지 소스보기를 봐도 html 태그는 없고 그냥 문자만 보임
	//@ResponseBody가 있으면 viewResolver로 던지지 않는다.
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name;
	}
	
	@GetMapping("hello-api")
	@ResponseBody
	//@ResponseBody 문자열이면 그냥 문자열 던진다.
	//@ResponseBody 그런데 객체가 오면 스프링은 디폴트로 json 방식으로 데이터를 만들어서 http 응답에 반환한다.
	
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello();
		hello.setName(name);
		return hello; //스프링이 default로 객체를 반환하면 json으로 반환한다.
	}
	
	static class Hello{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}
}
