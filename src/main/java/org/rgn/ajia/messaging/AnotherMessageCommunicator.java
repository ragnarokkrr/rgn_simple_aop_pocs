package org.rgn.ajia.messaging;

public class AnotherMessageCommunicator {

	public void deliver(String message) {
		System.out.println("AnotherMessageCommunicator=> " + message);
	}

	public void deliver(String person, String message) {
		System.out.printf("AnotherMessageCommunicator=> %s, %s\n", person, message);
	}
}
