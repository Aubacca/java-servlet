<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Servlet Scopes</title>
</head>
<body>
    <h2>Servlet Scopes</h2>
    <p>Application Object: <%=application %></p>
    <p>Session Object: <%=session %></p>
    <p>Session.getId(): <%=session.getId() %></p>
    <p>pageContext Object: <%=pageContext %></p>
    <p>Request Object: <%=request %></p>

    <hr>
    <%
    String personName = request.getParameter("personName");
    if (personName != null && personName.length() > 0) {
      session.setAttribute("sessionPerson", personName);
      application.setAttribute("applicationPerson", personName);
      pageContext.setAttribute("pageContextPerson", personName);
      pageContext.setAttribute("pageContextapplicationPerson", "Person name is " + personName, PageContext.APPLICATION_SCOPE);
    }
    %>
    <p>Request - personName: <%=request.getParameter("personName") %></p>
    <p>PageContext - pageContextPerson: <%=pageContext.getAttribute("pageContextPerson") %></p>
    <p>Session - sessionPerson: <%=session.getAttribute("sessionPerson") %></p>
    <p>Application - applicationPerson: <%=application.getAttribute("applicationPerson") %></p>
    <p>Application - pageContextapplicationPerson: <%=application.getAttribute("pageContextapplicationPerson") %></p>

    <hr>
    <p>PageContext - pageContextapplicationPerson: <%=pageContext.findAttribute("pageContextapplicationPerson") %></p>
    <p>PageContext - applicationPerson: <%=pageContext.findAttribute("applicationPerson") %></p>
    <p>PageContext - sessionPerson: <%=pageContext.findAttribute("sessionPerson") %></p>
    <p>PageContext - pageContextPerson: <%=pageContext.findAttribute("pageContextPerson") %></p>
    <p>PageContext - nix: <%=pageContext.findAttribute("nix") %></p>
</body>
</html>