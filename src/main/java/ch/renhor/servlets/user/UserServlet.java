package ch.renhor.servlets.user;

import ch.renhor.models.Person;
import ch.renhor.services.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/person-overview/persons",
        initParams = {@WebInitParam(name = "servletVersion", value = "1.0.0"),
                @WebInitParam(name = "servletTool", value = "1.0.0")})
public class UserServlet extends HttpServlet {
    private PersonService personService = new PersonService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("doPost>begin");
        final Person newPerson = new Person();
        boolean isValidPerson = false;
        String errorMessage = "";
        try {
            newPerson.setMail(req.getParameter("mail"));
            newPerson.setLastName(req.getParameter("lastName"));
            newPerson.setFirstName(req.getParameter("firstName"));
            newPerson.setAge(Integer.valueOf(req.getParameter("age")).byteValue());
            newPerson.setId(personService.getNextPersonId());
            log("doPost>newPerson: " + newPerson);
            isValidPerson = personService.validatePerson(newPerson);
            personService.addPerson(newPerson);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            errorMessage = e.getMessage();
            log("*** ERROR doPost>" + errorMessage);
        }
//        personService.showPersons();
        //
        if (isValidPerson) {
            log("doPost>correct person data entered.");
            resp.setStatus(HttpServletResponse.SC_CREATED);
            req.getSession().setAttribute("newPerson", newPerson);
            log("doPost>personService.getPersonList().size(): " + personService.getPersonList().size());
            req.getSession().setAttribute("personList", personService.getPersonList());
            resp.sendRedirect("person-overview.jsp");
        } else {
            log("doPost>invalid person data entered");
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
            //
/*            req.getSession().setAttribute("newPerson", newPerson);
            req.getSession().setAttribute("errorMessage", errorMessage);
            resp.sendRedirect("person-add.jsp");*/
            //
            req.setAttribute("newPerson", newPerson);
            req.setAttribute("errorMessage", errorMessage);
            final RequestDispatcher requestDispatcher = req.getRequestDispatcher("person-add.jsp");
            requestDispatcher.forward(req, resp);
        }
        log("doPost>end");
    }
}
