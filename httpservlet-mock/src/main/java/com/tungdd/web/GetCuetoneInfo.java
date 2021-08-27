package com.tungdd.web;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tungdd.execute.VLCStreamThread;
import com.tungdd.util.Constants;
import com.tungdd.util.FileUtil;
import com.tungdd.util.Utils;

@WebServlet("/adsm/getCuetoneInfo")
public class GetCuetoneInfo extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8075129694532666792L;
	final Logger logger = LogManager.getLogger(this);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		logger.info("GET Url : " + Utils.getFullURL(req));
        
		URL url = GetCuetoneInfo.class.getResource("/cuetoneInfo.json");
		logger.info("Read file : " + url.getPath());
		
//        String json = "{\"userId\":\"abcde1234\",\"adList\":[{\"durationSec\":15,\"slotNumber\":1,\"impression\":\"http://172.23.35.232:18080/reportCollector/86ffe9243a1bdb4feb8b069b00d13411/impression\",\"firstQuartile\":\"http://172.23.35.232:18080/reportCollector/86ffe9243a1bdb4feb8b069b00d13411/firstQuartile\",\"midpoint\":\"http://172.23.35.232:18080/reportCollector/86ffe9243a1bdb4feb8b069b00d13411/midpoint\",\"thirdQuartile\":\"http://172.23.35.232:18080/reportCollector/86ffe9243a1bdb4feb8b069b00d13411/thirdQuartile\",\"complete\":\"http://172.23.35.232:18080/reportCollector/86ffe9243a1bdb4feb8b069b00d13411/complete\"},{\"durationSec\":15,\"slotNumber\":2,\"impression\":\"http://172.23.35.232:18080/reportCollector/25aw45143a1bdb4feb8b069b00dabdqq/impression\",\"firstQuartile\":\"http://172.23.35.232:18080/reportCollector/25aw45143a1bdb4feb8b069b00dabdqq/firstQuartile\",\"midpoint\":\"http://172.23.35.232:18080/reportCollector/25aw45143a1bdb4feb8b069b00dabdqq/midpoint\",\"thirdQuartile\":\"http://172.23.35.232:18080/reportCollector/25aw45143a1bdb4feb8b069b00dabdqq/thirdQuartile\",\"complete\":\"http://172.23.35.232:18080/reportCollector/25aw45143a1bdb4feb8b069b00dabdqq/complete\"}],\"startTime\":\"2020-07-29 14:21:00.000\",\"endTime\":\"2020-07-29 14:21:30.000\",\"multicastIp\":\"239.192.10.1\",\"multicastPort\":49220}";
		String json = FileUtil.readFile(url.getPath());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
        
        // Run VLC server streaming
        new VLCStreamThread(Constants.TIME_SLEEP_CUETON_MILIS).start();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.info("POST redirect to GET");
		
		this.doGet(req, resp);
	}
	
	
}
