<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sample JSP</title>
</head>
<body>
    <h1>Welcome to Sample JSP</h1>
    <%@ include file="./tools/timestamp.jsp" %>

    <b>
    <%!
    public int summary(int a, int b) {
      return a + b;
    }
    %>
    <%
    int age = 25;
    boolean member = true;

    out.println("Age: " + age);
    %>
    </b>

    <p>
    Result = <%=56896 * 986986 %>
    </p>

    <p>
    Result = <%=summary(82184, 1984511) %>
    </p>

</body>
</html>