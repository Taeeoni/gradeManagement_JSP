package kr.ac.kopo.kopo11.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	@Before("execution(* kr.ac.kopo.kopo11.service.*.*AopBefore(..))")
	public void onBeforeHandler() {
		System.out.println("LogAsepect.onBeforeHandler() 핸들러 호출");
	}
	
	@After("execution(* kr.ac.kopo.kopo11.service.*.*AopAfter(..))")
	public void onAfterHandler() {
		System.out.println("LogAsepect.onAfterHandler() 핸들러 호출");
	}
	
	@AfterReturning(value="execution(* kr.ac.kopo.kopo11.service.*.*AopAfterReturning(..))", 
			returning="returnValue")
	public void onAfterReturningHandler(Object returnValue) {
		System.out.println("LogAsepect.onAfterReturningHandler() 핸들러 호출");
		System.out.println("ReturnValue: " + returnValue);
	}
	
	@AfterThrowing(value="execution(* kr.ac.kopo.kopo11.service.*.*AopAfterThrowing(..))", 
			throwing="exception")
	public void onAfterThrowingHandler(Exception exception) {
		System.out.println("LogAsepect.onAfterThrowingHandler() 핸들러 호출");
		System.out.println("ReturnValue: " + exception);
	}
	
	@Around("execution(* kr.ac.kopo.kopo11.service.*.*AopAround(..))")
	public void onAroundHandler(ProceedingJoinPoint pjp) {
		System.out.println("LogAspect.onAroundHandler() 핸들러 호출, 시작점");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("LogAspect.onAroundHandler() 핸들러 호출, 끝점");
	}
	
}
