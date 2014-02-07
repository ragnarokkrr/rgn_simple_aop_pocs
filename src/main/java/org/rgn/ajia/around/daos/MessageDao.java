package org.rgn.ajia.around.daos;

import org.rgn.ajia.around.infra.TXContext;
import org.rgn.ajia.around.infra.TransactorV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageDao {

	static final Logger LOG = LoggerFactory.getLogger(MessageDao.class);

	public void find(String message) {
		TXContext context = TransactorV2.getTxContext();

		LOG.info(String.format(".find('%s'): ----> %s", message, context));
	}

	public void insert(String person, String message) {
		TXContext context = TransactorV2.getTxContext();
		LOG.info(String.format(".insert('%s','%s'): ----> %s", person, message,
				context));
	}
}
