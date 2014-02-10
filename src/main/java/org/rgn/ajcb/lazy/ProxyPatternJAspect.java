package org.rgn.ajcb.lazy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public abstract class ProxyPatternJAspect {
	final Logger LOG = LoggerFactory.getLogger(this.getClass());

	protected interface Subject {
	}

	@Pointcut
	protected abstract void requestTriggered();

	@Pointcut("(requestTriggered() && this(caller))")
	private void accessByCaller(Object caller) {

	}

	@Pointcut("(requestTriggered() && !accessByCaller(Object))")
	private void accessByUnknown() {

	}

	public Object around(ProceedingJoinPoint joinPoint, Subject subject)
			throws Throwable {
		LOG.debug(joinPoint.toLongString());
		return joinPoint.proceed(joinPoint.getArgs());
	}

}
