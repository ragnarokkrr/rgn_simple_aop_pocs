package org.rgn.ajia.around.actions;

import org.rgn.ajia.around.daos.AnotherDao;
import org.rgn.ajia.around.daos.MessageDao;
import org.rgn.ajia.around.infra.BaseAction;

public class SecondAction extends BaseAction{
	public String a;

	public SecondAction() {
	}

	public void doSomething() {
		System.out
		.println("\n================SecondAction.doSomething()===============================\n");
		
		MessageDao messageDao = new MessageDao();

		messageDao.find("Alou, voce!!!  <<2>>");
		messageDao.insert("Amigo da rede globo  <<2>>" , "ronaldinho fazendo cera!!!  <<2>>");

		System.out
				.println("\n===============================================\n");

		AnotherDao anotherDao = new AnotherDao();

		anotherDao.find("segundo find  <<2>>");

		anotherDao.insert("segundo insert <<2>>", "ronaaaaaaaaldinho!!!!!  <<2>>");

		System.out
		.println("\n================SecondAction.doSomething() - FIM ===============================\n");
	
	}

}