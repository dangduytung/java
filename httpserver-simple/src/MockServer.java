import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class MockServer {
	
	static Logger logger = Logger.getLogger(MockServer.class.getName());
	
	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateStr = sdf.format(new Date());
		
		FileHandler fileHandler = new FileHandler("MockServer-" + dateStr + ".log", true);
		SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        
        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false);
//        if (logger.isLoggable(Level.INFO)) {
//            logger.info("Information message");
//        }
//
//        if (logger.isLoggable(Level.WARNING)) {
//            logger.warning("Warning message");
//        }
		
		HttpServer server = HttpServer.create(new InetSocketAddress(18080), 0);
		server.createContext("/reportCollector/reportADPlayWithExternalAd", new MyHandler());
		// Thread control is given to executor service.
		server.setExecutor(java.util.concurrent.Executors.newCachedThreadPool());
		server.start();
	}

	static int count = 0;

	static class MyHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "This is the response";
			long threadId = Thread.currentThread().getId();
			response = response + "Thread Id = " + threadId;
			
			String outThread = ++count + " ~ I am thread " + threadId + ", " + new Date();
			URI outRes = t.getRequestURI();
			
			System.out.println(outThread);
			System.out.println(outRes);
			
			logger.info(outThread);
			logger.info(outRes.toString() + "\n");

			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
}