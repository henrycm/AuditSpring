package com.auditing.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;

@Aspect
public class AuditInterceptor {

	private static final Logger log = Logger.getLogger("audit");

	@Before("execution(* com.auditing.backend.repositories.*.save(..))")
	public void logBefore(JoinPoint aPoint) {
		String userName = getUserName();
		String entry = "Saving User:" + userName;
		if (aPoint.getArgs().length > 0) {
			entry += ", Data:" + aPoint.getArgs()[0];
			log.info(entry);
		}
	}

	private String getUserName() {
		try {
			return SecurityContextHolder.getContext().getAuthentication().getName();
		} catch (NullPointerException npe) {
			return "Unknown";
		}
	}
}
