package ch.renhor.servlets;

import ch.renhor.models.Person;
import ch.renhor.services.PersonService;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/person-details", loadOnStartup = 1, initParams = {@WebInitParam(name = "initParamAnno", value = "1.1.1")})
public class PersonDetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log("doGet>Begin");
        String personName = req.getParameter("personName");
        String personId = req.getParameter("personId");
        Person personDetails = null;
        log("doGet>personName=" + personName);
        log("doGet>personId=" + personId);
        //
        if (personId != null) {
            final PersonService personService =  new PersonService();
            personDetails = personService.getPersonById(Integer.valueOf(personId));
        }
        //
//        resp.setContentType(MediaType.TEXT_HTML_TYPE.withCharset(UTF_8.name()).toString());
        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(200);
        PrintWriter writer = resp.getWriter();
        writer.println("<h2>Person Details - " + personName + "</h2>");
        writer.append("<h2>Person Details - " + personName + "</h2>");
        //
        if (personDetails != null) {
            writer.println("<hr>");
            writer.append("<hr>");
            writer.println("<h2>Person Details</h2>");
            writer.append("<h2>Person Details</h2>");
            writer.println("<div>" + personDetails.toString() + "</div>");
            writer.append("<div>" + personDetails.toString() + "</div>");
        }
        //
        log("doGet>End");
    }

}
