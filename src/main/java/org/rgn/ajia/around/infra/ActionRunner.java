package org.rgn.ajia.around.infra;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.reflect.MethodUtils;
import org.rgn.ajia.around.actions.MyAction;
import org.rgn.ajia.around.actions.SecondAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionRunner {

	static final Logger LOG = LoggerFactory.getLogger(ActionRunner.class);
	private Map<String, BaseAction> actionMap;

	public ActionRunner() {
		doInit();
	}

	private void doInit() {
		actionMap = new HashMap<String, BaseAction>();
		actionMap.put("myAction", new MyAction());
		actionMap.put("secondAction", new SecondAction());
		LOG.info("Actions Inicializadas");
	}

	public final Object doRequest(String actionName, String method,
			Object... args) {
		LOG.info(String
				.format("##################################> Processando request '%s.%s'\n",
						actionName, method));
		Object ret = null;

		if (actionName != null && !actionMap.containsKey(actionName)) {
			throw new AroundException(String.format("'%s' NAO EXISTE",
					actionName));
		}
		BaseAction act = actionMap.get(actionName);

		try {
			ret = MethodUtils.invokeExactMethod(act, method, args);
			LOG.info(String
					.format("Metodo '%s.%s' chamado", actionName, method));
		} catch (NoSuchMethodException | IllegalAccessException
				| InvocationTargetException e) {
			LOG.trace(String.format(
					"Metodo '%s' da action '%s' nao encontrado!", method,
					actionName), e);
		}

		LOG.info(String
				.format("##################################> FINAL Processando request '%s.%s'\n",
						actionName, method));

		return ret;
	}
}
