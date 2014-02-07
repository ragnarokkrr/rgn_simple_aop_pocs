package org.rgn.ajia.around.daos;

import org.rgn.ajia.around.infra.AbstractDao;
import org.rgn.ajia.around.infra.TXContext;
import org.rgn.ajia.around.infra.TransactorV2;

public class AnotherDao extends AbstractDao{

	public void find(String message) {
		TXContext context  = TransactorV2.getTxContext(); 
		
		System.out.printf("%s.find(): %s ====> %s\n", getClass().getSimpleName(), message, context);
	}

	public void insert(String person, String message) {
		TXContext context  = TransactorV2.getTxContext(); 

		System.out.printf("%s.insert(): %s, %s ====>%s\n", getClass().getSimpleName(), person, message, context);
	}
}
