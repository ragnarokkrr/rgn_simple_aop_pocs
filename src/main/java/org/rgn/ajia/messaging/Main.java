package org.rgn.ajia.messaging;

public class Main {

	public static void main(String[] args) {
		MessageCommunicator messageComunitator = new MessageCommunicator();

		messageComunitator.deliver("Alou, voce!!!");
		messageComunitator.deliver("Amigo da rede globo", "ronaldinho fazendo cera!!!");
		
		System.out.println("\n\n\n============================================\n\n\n");
	
		AnotherMessageCommunicator anotherMessageCommunicator = new AnotherMessageCommunicator();

		anotherMessageCommunicator.deliver("Ola´, Enfermeira!!!!");
		anotherMessageCommunicator.deliver("Sao os bichinhos!!!", "Os Animaniacs!!!");
	
	}
}
