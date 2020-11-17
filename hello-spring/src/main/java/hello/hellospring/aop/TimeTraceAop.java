package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // AOP로 사용하겠다.
@Component
public class TimeTraceAop {
	//메소드 호출이 될때 마다 joinPoint에 정보가 오고 조작할 수있다.
	@Around("excution(*hello.hellospring..*(..))") //이 공통관심사항을 어디에다가 적용할것인가?  패키지명 .. 클래스명(파라미터)
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("START : "+ joinPoint.toString());
		try {
			Object r=joinPoint.proceed(); // 다음 메소드로 진행함 , 프록시가 메서드 호출을 가로채고 이후에 프록시가 가로챈 메서드(실제로 수행할려고했던 메서드)를 실행시킨다
			return r;
		}finally {
			long finish= System.currentTimeMillis();
			long timeMs= finish-start;
			System.out.println("END : "+ joinPoint.toString() + " " +timeMs+"ms");
			
		}
		
	}
}
