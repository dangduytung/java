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

import com.tungdd.service.MyService;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7058624886981913367L;
	final Logger logger = LogManager.getLogger(this);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("MyServlet's doGet() called");

        MyService service = new MyService();
        service.doWork();

        response.setContentType("text/plain;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print("MyServlet called");
    }

}
