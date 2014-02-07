package org.rgn.ajia.around.infra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect ActionTransactionAspect {

	static final Logger LOG = LoggerFactory
			.getLogger(ActionTransactionAspect.class);

	pointcut transactionBoundaryContext()
		: call (  public Object org.rgn.ajia.around.infra.ActionRunner.doRequestRR (String, String, Object...) );

	pointcut transactionActionBelow()
		: (transactionBoundaryContext() && !cflowbelow(transactionBoundaryContext()));

	before(): transactionActionBelow(){
		LOG.trace("---- TRANSACTION ASPECT BEGIN ----");
		String chamada = thisJoinPoint.toLongString();
		TransactorV2.begin(chamada);
	}

	after() returning: transactionActionBelow(){
		LOG.trace("---- TRANSACTION ASPECT COMMIT ----");
		TransactorV2.commit();
	}

	after() throwing: transactionActionBelow(){
		LOG.trace("---- TRANSACTION ASPECT ROLLBACK ----");
		TransactorV2.rollback();
	}
}
