 package org.rgn.ajia.around;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.rgn.ajia.around.infra.ActionRunner;

public class Main {

	private static ActionRunner action = new ActionRunner();
	private static ExecutorService executor = Executors.newFixedThreadPool(5);

	public static void main(String[] args) {

		// action.doRequest("myAction", "doSomething", (Object[]) null);

		doActionInThread("myAction", "doSomething", (Object[]) null);

		doActionInThread("secondAction", "doSomething", (Object[]) null);
		
		// doActionInThread("myAction", "doSomething", (Object[]) null);
		
		// doActionInThread("myAction", "doSomething", (Object[]) null);
		
		// doActionInThread("myAction", "doSomething", (Object[]) null);

		// doActionInThread("myAction", "doSomething", (Object[]) null);
		
		// doActionInThread("myAction", "doSomething", (Object[]) null);
		
		// doActionInThread("myAction", "doSomething", (Object[]) null);
		

		//action.doRequest("myAction", "doSomething", (Object[]) null);

		executor.shutdown();
	}

	private static void doActionInThread(final String actionName,
			final String method, final Object[] myArgs) {
		executor.execute(new Runnable() {

			@Override
			public void run() {
				action.doRequest(actionName, method, myArgs);
			}
		});
	}
}