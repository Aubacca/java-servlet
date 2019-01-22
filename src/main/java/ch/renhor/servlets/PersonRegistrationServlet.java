package ch.renhor.servlets;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/person-registration",
        initParams = {@WebInitParam(name = "servletVersion", value = "1.1.1"),
                @WebInitParam(name = "servletTool", value = "5.5.5")})
public class PersonRegistrationServlet extends HttpServlet {

    private static final String SERVLET_VERSION = "servletVersion";
    private static final String FIRST_USER_NAME = "firstUserName";
    private static final String LAST_NAME = "lastName";
    private static final String FIRST_NAME = "firstName";
    private static final String PERSON_ID = "person_id";
    private static final String SERVLET_TOOL = "servletTool";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log("doGet>begin");
        resp.setContentType("text/html;charset=utf-8");
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        //
        // Session context/object.
        HttpSession session = req.getSession();
        if (lastName.length() > 0) {
            session.setAttribute(PERSON_ID, lastName);
        }
        //
        // Application context/object.
        final ServletContext servletContext = req.getServletContext();
        if (lastName.length() > 0) {
            servletContext.setAttribute(FIRST_USER_NAME, firstName);
        }
        //
        // Create HTML output.
        PrintWriter writer = resp.getWriter();
        writer.println("<h2>Person Details (via GET)</h2>");
        writer.println("<p>First Name: <b>" + firstName + "</b></p>");
        writer.println("<p>Last Name: <b>" + lastName + "</b></p>");
        writer.println("<hr>");
        writer.println("<p>Person ID: <b>" + session.getAttribute(PERSON_ID) + "</b></p>");
        writer.println("<p>First Name of first logged in user: <b>" + servletContext.getAttribute(FIRST_USER_NAME) + "</b></p>");
        writer.println("<hr>");
        writer.println("<p>Servlet Version via Annotation: <b>" + getServletConfig().getInitParameter(SERVLET_VERSION) + "</b></p>");
        writer.println("<p>Servlet Tool via Annotation: <b>" + getServletConfig().getInitParameter(SERVLET_TOOL) + "</b></p>");
        log("doGet>end");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log("doPost>begin");
        resp.setContentType("text/html;charset=utf-8");
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);

        req.getSession().getId();
        //
        // Session context/object.
        HttpSession session = req.getSession();
        log("doPost>lastName=" + lastName);
        if (lastName.length() > 0) {
            session.setAttribute(PERSON_ID, lastName);
        }
        //
        // Application context/object.
        final ServletContext servletContext = req.getServletContext();
        if (lastName.length() > 0) {
            servletContext.setAttribute(FIRST_USER_NAME, firstName);
        }
        //
        // Create HTML output.
        PrintWriter writer = resp.getWriter();
        writer.println("<h2>Person Details (via POST)</h2>");
        writer.println("<p>First Name: <b>" + firstName + "</b></p>");
        writer.println("<p>Last Name: <b>" + lastName + "</b></p>");
        writer.println("<hr>");
        writer.println("<p>Person ID: <b>" + session.getAttribute(PERSON_ID) + "</b></p>");
        writer.println("<p>First Name of first logged in user: <b>" + servletContext.getAttribute(FIRST_USER_NAME) + "</b></p>");
        writer.println("<hr>");
        writer.println("<p>Servlet Version via Annotation: <b>" + getServletConfig().getInitParameter(SERVLET_VERSION) + "</b></p>");
        writer.println("<p>Servlet Tool via Annotation: <b>" + getServletConfig().getInitParameter("tool") + "</b></p>");
        log("doPost>end");
    }
}
