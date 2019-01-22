<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ch.renhor.models.Person, java.util.List, java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person - Overview</title>
</head>
<body>
    <h3>Person - Overview</h3>
    <hr>
<%
    List<Person> personList = (ArrayList)session.getAttribute("personList");
    //
    Person newPerson1 = (Person) session.getAttribute("newPerson");
    if (newPerson1 == null) {
        newPerson1 = (Person) request.getAttribute("newPerson");
    }
    //
    if (newPerson1 != null) {
        out.println("<i>New Person successfully added:</i> <b>" + newPerson1.getFirstName() + " " + newPerson1.getLastName() + "</b>");
        out.println("<hr>");
    }
%>

<%--
<jsp:useBean id="newperson" class="ch.renhor.models.Person" scope="request">
    <jsp:setProperty name="newperson" property="firstName" value="First name not defined at the moment!"/>
</jsp:useBean>
<p>
Firstname: <jsp:getProperty property="firstName" name="newperson"/>
</p>

<%
    if (newperson != null) {
        out.println("<i>New person via useBean scope:request loaded:</i> <b>" + newPerson1.getFirstName() + " " + newPerson1.getLastName() + "</b>");
    } else {
        out.println("<i>No new person loaded via useBean scope:request laoded!</i>");
    }
    out.println("<hr>");
%>
--%>

    <table>
        <tr>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Age</td>
            <td>Mail</td>
        </tr>
        <%
        if (personList != null) {
            for (Person person: personList) {
                out.println("<tr>");
                out.println("<td><a href='/servlet-app/person-details?personId=" + person.getId() + "' title='Click to see the person details ..'>" + person.getFirstName() + "</a></td>");
                out.println("<td>" + person.getLastName() + "</td>");
                out.println("<td>" + person.getAge() + "</td>");
                out.println("<td>" + person.getMail() + "</td>");
                out.println("</tr>");
            }
        } else {
                out.println("<tr>");
                out.println("<td> - </td>");
                out.println("<td> - </td>");
                out.println("<td> - </td>");
                out.println("<td> - </td>");
                out.println("</tr>");
        }
        %>
    </table
</body>
</html>