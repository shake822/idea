/******************************************************************************
 * Copyright (C) 2015 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/
package com.comtop.jetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * FIXME 类注释信息

 * @author zhaoqunqi
 * @since 1.0
 * @createDate 2015-04-24 
 */
public class HelloWorld extends AbstractHandler {

	/**
	 * @see org.eclipse.jetty.server.Handler#handle(java.lang.String, org.eclipse.jetty.server.Request, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void handle(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		((Request) baseRequest).setHandled(true);
		response.getWriter().println("<h1>HelloWorld</h1>");
	}
	
	
	 public static void main(String[] args) throws Exception

	    {

	       Server server = new Server(8080);
	       server.setHandler(new HelloWorld());
	       server.start();
	       server.join();
	    }
}
