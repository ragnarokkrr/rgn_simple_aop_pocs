package org.rgn.ajia.messaging;

public class MessageCommunicator {

	public void deliver(String message) {
		System.out.println("MessageCommunicator: " + message);
	}

	public void deliver(String person, String message) {
		System.out.printf("MessageCommunicator: %s, %s\n", person, message);
	}
}
