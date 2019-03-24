package com.olx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.olx.util.CheckUtil;

/**
 * Servlet implementation class WeiXinServlet
 */
@WebServlet("/WeiXinServlet")
public class WeiXinServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("111");
		String signature = request.getParameter("signature");

		String timestamp = request.getParameter("timestamp");

		String nonce = request.getParameter("nonce");

		String echostr = request.getParameter("echostr");
		
		 System.out.println(signature);
		 System.out.println(timestamp);
		 System.out.println(nonce);
		 System.out.println(echostr);

		PrintWriter out = response.getWriter();

		if(CheckUtil.checkSignature(signature,timestamp, nonce)){

		//如果校验成功，将得到的随机字符串原路返回

		out.print(echostr);
	}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
