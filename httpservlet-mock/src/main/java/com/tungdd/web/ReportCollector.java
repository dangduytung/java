package com.tungdd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tungdd.util.Utils;

@WebServlet({"/reportCollector", "/"})
public class ReportCollector extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8075129694532666792L;
	final Logger logger = LogManager.getLogger(this);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		logger.info("GET Url : " + Utils.getFullURL(req));
		
        resp.setContentType("text/plain;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.print("OK");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.info("POST redirect to GET");
		
		this.doGet(req, resp);
	}

}
