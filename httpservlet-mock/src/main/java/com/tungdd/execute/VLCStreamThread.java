package com.tungdd.execute;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tungdd.util.Constants;
import com.tungdd.video.VideoInfo;

public class VLCStreamThread extends Thread {

	final Logger logger = LogManager.getLogger(this);

	private long sleepTime;
	
	public VLCStreamThread(long sleepTime) {
		super();
		this.sleepTime = sleepTime;
	}

	public long getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		logger.info("run time sleep : " + this.getSleepTime());
		try {
			
			Thread.sleep(this.getSleepTime());

			VLCStreamExecute.getInstance().streamingFile();
			
		} catch (Exception e) {
			logger.error(e);
		}
	}

}
