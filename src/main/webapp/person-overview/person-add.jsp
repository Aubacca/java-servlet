<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="ch.renhor.models.Person, java.lang.String"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person - Add a New Person</title>
    <style>
        .input-line {padding-top: 0px;}
    </style>
</head>
<body>
<%
  Person newPerson = (Person) session.getAttribute("newPerson");
  if (newPerson == null) {
    newPerson = (Person) request.getAttribute("newPerson");
  }
%>
<%
  String errorMessage = (String)session.getAttribute("errorMessage");
  if (errorMessage == null) {
      errorMessage = (String) request.getAttribute("errorMessage");
  }
%>

<%
if (errorMessage != null) {
    out.println("<h3>" + errorMessage + "</h3>");
}
%>
    <h3>Person - Add a New Person</h3>
    <hr>
    <form action="./persons" method="POST">
        <p class="input-line"><label for="firstName">First name<input type="text" id="firstName" name="firstName" value="${newPerson.getFirstName()}"></label></p>
        <p class="input-line"><label for="lastName">Last name<input type="text" id="lastName" name="lastName" value="${newPerson.getLastName()}"></label></p>
        <p class="input-line"><label for="age">Age<input type="number" id="age" name="age" min="0" max="120" value="${newPerson.getAge()}"></label></p>
        <p class="input-line"><label for="mail">Mail address<input type="text" id="mail" name="mail" value="${newPerson.getMail()}"></label></p>
        <hr>
        <button type="submit">Add New Person</button>
    </form>
</body>
</html>