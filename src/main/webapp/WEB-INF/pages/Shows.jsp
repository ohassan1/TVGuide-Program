<%@ page import="com.TVShowApp.mvc.Models.Show" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All the shows</title>
</head>
<body>
    <th>
        <td>ID</td>
        <td>Title</td>
        <td>Author</td>
    </th>
    <%
        Show show = new Show("Friends", 1, "This is a test description");
    %>
    <tr>
        <td> ${id} </td>
        <td> ${name} </td>
        <td> ${description} </td>
    </tr>
</body>
</html>
