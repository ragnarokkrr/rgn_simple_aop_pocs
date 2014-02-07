package org.rgn.ajia.around.actions;

import org.apache.commons.lang.ArrayUtils;
import org.rgn.ajia.around.daos.AnotherDao;
import org.rgn.ajia.around.daos.MessageDao;
import org.rgn.ajia.around.infra.BaseAction;

public class MyAction extends BaseAction {
	public String a;

	public MyAction() {
	}

	public void doSomething() {
		System.out
				.println("\n================MyAction.doSomething()===============================\n");

		MessageDao messageDao = new MessageDao();

		messageDao.find("Alou, voce!!!  <<1>>");
		messageDao.insert("Amigo da rede globo <<1>>", "ronaldinho fazendo cera!!! <<1>>");

		System.out.println("--------------------------------------");

		AnotherDao anotherDao = new AnotherDao();

		anotherDao.find("segundo find <<1>>");

		anotherDao.insert("segundo insert <<1>>", "ronaaaaaaaaldinho!!!!! <<1>>");

		System.out
				.println("\n=================MyAction.doSomething() - FIM ==============================\n");
	}

	public void doSomething(Object... args) {
		System.out
				.printf("\n================MyAction.doSomething(%s)===============================\n\n",
						ArrayUtils.toString(args));

		MessageDao messageDao = new MessageDao();

		messageDao.find("Alou, voce!!!");
		messageDao.insert("Amigo da rede globo", "ronaldinho fazendo cera!!!");

		System.out.println("--------------------------------------");

		AnotherDao anotherDao = new AnotherDao();

		anotherDao.find("segundo find");

		anotherDao.insert("segundo insert", "ronaaaaaaaaldinho!!!!!");

		System.out
				.println("\n===============================================\n");
	}

}