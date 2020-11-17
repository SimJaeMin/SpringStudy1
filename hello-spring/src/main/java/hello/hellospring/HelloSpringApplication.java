package hello.hellospring;
// 실행하면 여기서부터 실행되고
// main이 담겨저있는 클래스 및 하위 패키
//스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록한다.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		//����� ��� �������� ��ü������ ���� ��������Ʈ�� �ö󰣴�.
		//������ ��Ʈ ���ø����̼��� ����ȴ�.
		SpringApplication.run(HelloSpringApplication.class, args);
															
		
	}

}
