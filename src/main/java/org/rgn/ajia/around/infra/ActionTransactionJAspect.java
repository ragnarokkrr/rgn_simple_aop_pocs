package org.rgn.ajia.around.infra;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class ActionTransactionJAspect {
	
	static final Logger LOG = LoggerFactory
			.getLogger(ActionTransactionJAspect.class);

	@Pointcut("call (public Object org.rgn.ajia.around.infra.ActionRunner.doRequest (String, String, Object...))")
	void transactionBoundaryContext(){}
	
	@Pointcut("(transactionBoundaryContext() && !cflowbelow(transactionBoundaryContext()))")
	void transactionActionBelow(){}
	
	@Before("transactionActionBelow()")
	public void beforeTransaction(JoinPoint pjp){
		LOG.trace("---- TRANSACTION ASPECT BEGIN ----");
		String chamada = pjp.toLongString();   //thisJoinPoint.toLongString();
		TransactorV2.begin(chamada);
	}
	
	@AfterReturning("transactionActionBelow()")
	public void afterReturningTransaction(JoinPoint pjp){
		LOG.trace("---- TRANSACTION ASPECT COMMIT ----");
		TransactorV2.commit();
	}

	@AfterThrowing("transactionActionBelow()")
	public void afterThrowing(JoinPoint pjp){
		LOG.trace("---- TRANSACTION ASPECT ROLLBACK ----");
		TransactorV2.commit();
	}

}
