package org.rgn.ajia.around.actions;

import org.rgn.ajia.around.daos.AnotherDao;
import org.rgn.ajia.around.daos.MessageDao;
import org.rgn.ajia.around.infra.BaseAction;

public class ThirdAction extends BaseAction{
	public String a;

	public ThirdAction() {
	}

	public void doSomething() {
		System.out
		.println("\n================ThirdAction.doSomething()===============================\n");
		
		MessageDao messageDao = new MessageDao();

		messageDao.find("Alou, voce!!! - <<<3>>> ");
		messageDao.insert("Amigo da rede globo <<<3>>>", "ronaldinho fazendo cera!!! <<<3>>>");


		System.out
		.println("\n================ThirdAction.doSomething() - FIM ===============================\n");
	
	}

}