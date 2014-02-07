package org.rgn.ajia.around.infra;

import org.rgn.ajia.around.infra.Transactor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public aspect TransactionAspect {
	static final Logger LOG = LoggerFactory.getLogger(TransactionAspect.class);

	private Transactor transactor = new Transactor();
	
	pointcut transactionDaoContext()
		: execution (  public * org.rgn.ajia.around.daos.*Daos.* (..) );
	
	Object around() :  transactionDaoContext(){
		
		LOG.trace("---- TRANSACTION ASPECT BEGIN ----");
		
		Object[] args = thisJoinPoint.getArgs();
		
		transactor.begin(args);
		
		Object ret = proceed();
		
		transactor.commit(args);

		LOG.trace("---- TRANSACTION ASPECT COMMIT ----");
		
		return ret;
	}
	
}
