package com.schooltracker.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;

@Aspect
@Controller
public class SchoolTrackerLoggerAspect {
	
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declaration
	@Pointcut("execution(* com.schooltracker.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	@Pointcut("execution(* com.schooltracker.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	//do the same for service and service and dao
	@Pointcut("execution(* com.schooltracker.service.*.*(..))")
	private void forServicePackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage() ")
	private void forAppFlow() {}
	
	//add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("In @Before: method calling method: " + theMethod);
		
		//display the arguments to the method
		
		//get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		//loop thru and display args
		
		for(Object tempArg : args) {
			myLogger.info("=====> argument: " + tempArg);
		}
	}
	
	//add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		//display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("In @AfterReturning: from method: " + theMethod);
		
		//display data returned
		myLogger.info("=====>> result: " + theResult);
		
	}

}
