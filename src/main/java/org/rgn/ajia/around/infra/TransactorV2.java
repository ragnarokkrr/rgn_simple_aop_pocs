package org.rgn.ajia.around.infra;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactorV2 {
	static final Logger LOG = LoggerFactory.getLogger(TransactorV2.class);

	private static ThreadLocal<TXContext> TX_CONTEXT = new ThreadLocal<TXContext>();
	private static AtomicInteger connIdGen = new AtomicInteger(10);

	public static void begin(Object... args) {
		String tName = Thread.currentThread().getName();
		LOG.trace(String.format("---- TRANSACTOR V2 - BEGIN TX [%s]", tName));
		int connId = connIdGen.addAndGet(100);
		TX_CONTEXT.set(new TXContext(tName, connId));
	}

	public static void commit() {
		String tName = TX_CONTEXT.get().toString();
		LOG.trace(String.format("---- TRANSACTOR V2 - COMMIT TX [%s]", tName));
	}

	public static void rollback() {
		String tName = TX_CONTEXT.get().toString();
		LOG.trace(String.format("---- TRANSACTOR V2 - ROLLBACK TX [%s]", tName));
	}

	public static TXContext getTxContext() {
		return TX_CONTEXT.get() != null ? TX_CONTEXT.get() : new TXContext(
				"Sem Contexto!!!", -1);
	}

}
