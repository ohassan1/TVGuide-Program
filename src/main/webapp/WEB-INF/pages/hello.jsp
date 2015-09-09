<%@ page language="java" %>
<%@ page import="com.TVShowApp.mvc.Dao.TVDao" %>
<%@ page import="com.TVShowApp.mvc.Models.Channel" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title><h1>${message}</h1></title></head>
<body>
<style>
    #channels {
        line-height: 30px;
        background-color: #eeeeee;
        height: 800px;
        width: 100px;
        float: left;
        padding: 5px;
    }

</style>
<div id="channels">

    <c:forEach items="${chanList}" var="c">
        <tr>
            ${c.abbr}<br/>
        </tr>
    </c:forEach>
</div>

<div id="shows">

    <table>
        <c:set var="temp" >${chanName.get(0)}</c:set>
        <c:forEach items="${showList}" var="s">
            ${s.name}
            <c:if test="${!temp.equals(s.channel)}">
                <c:set var="temp" >${s.channel}</c:set>
                <c:out value="<br>" default="" escapeXml="false"></c:out>
            </c:if>

        </c:forEach>

    </table>
</div>

    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
    <table style="width:50%">
        <th>${message}</th>
        <tr>
            <td></td>
        </tr>
    </table>
</body>
</html>