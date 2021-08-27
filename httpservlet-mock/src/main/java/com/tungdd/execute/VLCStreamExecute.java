package com.tungdd.execute;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tungdd.util.Constants;

public class VLCStreamExecute {

	private static VLCStreamExecute instance;
	
	final Logger logger = LogManager.getLogger(VLCStreamExecute.class);

	public static synchronized VLCStreamExecute getInstance() {
		if (instance == null) {
			instance = new VLCStreamExecute();
		}
		return instance;
	}
	
	public void streamingFile() throws Exception{
	
//		:sout=#transcode{vcodec=hevc,acodec=mpga,ab=128,channels=2,samplerate=44100,scodec=none}:rtp{dst=239.0.0.1,port=5004,mux=ts} :no-sout-all :sout-keep
//		:sout=#transcode{vcodec=h264,acodec=mpga,ab=128,channels=2,samplerate=44100,scodec=none}:rtp{dst=239.0.0.1,port=5004,mux=ts} :sout-all :sout-keep
//		vlc D:\\iphone11_trailer.mp4 --sout=\"#transcode{vcodec=hevc,acodec=mpga,ab=128,channels=2,samplerate=44100,scodec=none}:rtp{dst=239.0.0.1,port=5004,mux=ts}\" --sout-keep --loop
//		vlc D:\\iphone11_trailer.mp4 :sout=#transcode{vcodec=h264,acodec=mpga,ab=128,channels=2,samplerate=44100,scodec=none}:rtp{dst=239.0.0.1,port=5004,mux=ts} :sout-all :sout-keep vlc://quit
		
		logger.info("streamingFile " + Constants.FILE_PATH);
		
		/** A fatal error EXCEPTION_ACCESS_VIOLATION (just run local is ok) */
//		logger.info("streamingFile duration " + VideoInfo.getVideoDuration(Constants.FILE_PATH).toMillis() + " (ms)");
		
		ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe",
				Constants.FILE_PATH,
				":sout=#transcode{vcodec=h264,acodec=mpga,ab=128,channels=2,samplerate=44100,scodec=none}:rtp{dst=239.0.0.1,port=5004,mux=ts}",
				":sout-all",
				":sout-keep",
				"vlc://quit"
				);
		
		pb.start();
	}
}
