
package com.shrikantmutyala;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
If a web application is configured both through annotations and through
a web.xml deployment descriptor, settings in web.xml take precedence.
*/
@WebServlet(name = "SimpleServlet", urlPatterns = {"/mySimpleServlet"},
initParams = {
  @WebInitParam(name = "param1", value = "value12"),
  @WebInitParam(name = "param2", value = "value22")})

public class SimpleServlet extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    try {
      response.setContentType("text/html");
      PrintWriter printWriter = response.getWriter();
      printWriter.println("<h2>");
      printWriter.println("If you are reading this, "
              + "your Servlet works fine!");
      printWriter.println("</h2>");
      ServletConfig servletConfig = getServletConfig();
      String param1Val = servletConfig.getInitParameter("param1");
      String param2Val = servletConfig.getInitParameter("param2");
      printWriter.println("<p>");
      printWriter.println("Value of param1 is " + param1Val);
      printWriter.println("</p>");
      printWriter.println("<p>");
      printWriter.println("Value of param2 is " + param2Val);
      printWriter.println("</p>");
    } catch (IOException ioException) {
      System.out.println(ioException.getMessage());
    }
  }
}
