package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * 	Aspect Oriented Programming (AOP)
 * 	
 * 	- 핵심 비즈니스 로직과 상관없는 작업을 처리할때 주로 사용한다.
 *  1. Log
 */

//어노테이션을 붙이고 component scan 을 이용해서 bean 으로 등록.
@Aspect // 2
@Component //1
public class PrintLogAspect {
	
	@Around("execution(public * *(..))")
	public Object printLog(ProceedingJoinPoint joinPoint) 
				throws Throwable{
		
		System.out.println("비즈니스 로직을 수행하기 직전입니다.");
		
		// 로직 수행 joinPoint.proceed()호출시 AOP실핼
		Object obj=joinPoint.proceed(); // throws 함 
		
		System.out.println("비즈니스 로직을 수행했습니다.");
		
		return obj;
	}
	// 메소드를 하나 더만들어서 select 메소드에 적용 해 보세요.
	// @Around("execution(public void select()")
	public Object printLog2(ProceedingJoinPoint joinPoint) 
			throws Throwable{
		System.out.println("비즈니스 로직 수행 직전");
		
		Object obj=joinPoint.proceed();
		
		System.out.println("로직 수행");
	
		return obj;
		
	}
	
}
