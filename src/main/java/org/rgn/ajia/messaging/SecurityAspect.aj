package org.rgn.ajia.messaging;

import org.rgn.ajia.messaging.Authenticator;


public aspect SecurityAspect {
	private Authenticator authenticator = new Authenticator();

	pointcut secureAccess()
		: execution( * *MessageCommunicator.deliver(..));

	before(): secureAccess(){
		System.out.println("\tSecurityAspect - Checking and authenticaintg user");
		authenticator.authenticate();
	}

}
