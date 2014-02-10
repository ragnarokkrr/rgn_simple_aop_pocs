package org.rgn.ajcb.lazy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		MyDearObject dearObject = new MyDearObject(1, "Description");

		LOG.info(dearObject.doTheMagic("It´s a kind of magick!"));

		LOG.info(dearObject.doTheMagic(null));
	
	}

}
