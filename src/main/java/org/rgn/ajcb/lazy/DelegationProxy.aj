package org.rgn.ajcb.lazy;

import org.aspectj.lang.JoinPoint;

public aspect DelegationProxy extends ProxyPatternAspect{

	declare parents : MyDearObject implements Subject;

	protected pointcut requestTriggered() : call (* MyDearObject.doTheMagic(..));

	@Override
	protected boolean reject(Object caller, Subject subject, JoinPoint joinPoint) {
		return false;
	}
	
	
	@Override
	protected boolean delegate(Object caller, Subject subject,
			JoinPoint joinPoint) {
		
		return true;
	}

	@Override
	protected Object rejectRequest(Object caller, Subject subject,
			JoinPoint joinPoint) {
		return null;
	}

	@Override
	protected Object delegateRequest(Object caller, Subject subject,
			JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		ProxyDear proxyDear = new ProxyDear();

		if(args != null && (args[0] instanceof String)){
			return proxyDear.doTheRealMagic((String) args[0]);
		}
		return "No Magick ";
	}

}
