package org.rgn.ajia.around.infra;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Transactor {
	static final Logger LOG = LoggerFactory.getLogger(Transactor.class);

	private static ThreadLocal<TXContext> TX_CONTEXT = new ThreadLocal<TXContext>();

	public Transactor() {
		String tName = Thread.currentThread().getName();
		TX_CONTEXT.set(new TXContext(tName, -1));
	}

	public void begin() {
		LOG.info(String.format("---- TRANSACTOR BEGIN TRANSACTION [%s]",
				TX_CONTEXT.get().getId()));
	}

	public void begin(Object... args) {
		String ap = ArrayUtils.toString(args);
		LOG.info(String.format(
				"---- TRANSACTOR BEGIN TRANSACTION [%s] - params - %s",
				TX_CONTEXT.get().getId(), ap));
	}

	public void commit() {
		LOG.info("---- TRANSACTOR COMMIT TRANSACTION [%s]", TX_CONTEXT.get()
				.getId());
	}

	public void commit(Object... args) {
		String ap = ArrayUtils.toString(args);
		LOG.info(String.format(
				"---- TRANSACTOR COMMIT TRANSACTION [%s] - params - %s\n",
				TX_CONTEXT.get().getId(), ap));
	}

	public void rollback() {
		LOG.info("---- TRANSACTOR ROLLBACK TRANSACTION [%s]", TX_CONTEXT.get()
				.getId());
	}

	public void rollback(Object... args) {
		String ap = ArrayUtils.toString(args);
		LOG.info(String.format(
				"---- TRANSACTOR ROLLBACK TRANSACTION [%s] - params - %s\n",
				TX_CONTEXT.get().getId(), ap));
	}

}
