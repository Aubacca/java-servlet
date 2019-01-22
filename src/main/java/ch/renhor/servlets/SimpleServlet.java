package ch.renhor.servlets;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(description = "A simple servlet", name = "SimpleAppServlet", urlPatterns = "/SimpleServlet",
        initParams = {@WebInitParam(name = "version-from-xml", value = "1.1.0"),
        @WebInitParam(name = "tool-from-xml", value = "1.2.0")})
public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log("doGet>Begin");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(200);
        writer.println("<h2>This is the SimpleServlet of this app</h2>");
        writer.println("<hr>");
        writer.println("<p>Servlet Version via web.xml or via annotations: <b>" + getServletConfig().getInitParameter("version-from-xml") + "</b></p>");
        writer.println("<p>Tool Version via web.xml or via annotations: <b>" + getServletConfig().getInitParameter("tool-from-xml") + "</b></p>");
        log("doGet>End");
    }
}
