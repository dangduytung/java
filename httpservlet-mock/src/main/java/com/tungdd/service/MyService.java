package com.tungdd.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyService {
	final static Logger logger = LogManager.getLogger(MyService.class);

	public void doWork() {
		logger.info("MyService's doWork() called");
	}
}
