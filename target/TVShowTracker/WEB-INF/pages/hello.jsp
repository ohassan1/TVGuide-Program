<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>${message}<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</title>

</head>
<body>
<style>
    #Grid {
        line-height: 30px;
        background-color: #eeeeee;
        height: 2600px;
        width: 1250px;
        font-family: Arial,Verdana,Helvetica,sans-serif;
        font-weight: bold;
        float: left;
        padding: 5px;
    }

    table, th, td {
        border: 1px solid black;
        border-collapse: separate;
    }

    #times {
        border: 1px solid #4B4C4C;
        background-color: #E7E7E7;
        font-family: Arial,Verdana,Helvetica,sans-serif;
        font-size: 1em;
        font-weight: 700;
        color: #4B4C4C;
        text-align: center;
    }

    #numbers {
        color: #039;
        font-family: "Noto Sans",Arial,Verdana,Helvetica,sans-serif;
        font-size: 1.2em;
        font-weight: bold;
        align: center;
    }
    #header {
        background-color: #039;
        color: #ffffff;
        padding: 15px;
        position: static;
        width: 100%;
        position:fixed;
        margin: auto;
        z-index: 1;
    }
</style>

<header id="header">
    <h1>Nife's TV Listings</h1>
</header>

<div id="Grid" class="container-fluid">
    <br><br><br><br>
    <table style="width:100%" align="center" >
        <tr id="times">
            <td id="numbers" align="center">Channel</td>
            <td id="numbers" align="center">#</td>
            <c:forEach items="${realTimes}" var="time">

                <td id="numbers"><c:out value="${time}" /></td>

            </c:forEach>
        </tr>
        <c:forEach items="${chanList}" var="channel">
            <tr>
                <td align="center"><img src="${channel.icon}" height="35" width="35" ></td>
                <td id="numbers" align="center">${channel.number}</td>

                <c:forEach items="${showList}" var="show">
                    <c:if test="${show.channel.equals(channel.id)}">
                        <c:if test="${(show.playTime <= realTimes.get(0)) && (show.endTime > realTimes.get(0))}">
                            <td id="ShowCells" align="center"><c:out value="${show.name}" /></td>
                        </c:if>
                        <c:if test="${(show.playTime <= realTimes.get(1)) && (show.endTime > realTimes.get(1))}">
                            <td align="center"><c:out value="${show.name}" /></td>
                        </c:if>
                        <c:if test="${(show.playTime <= realTimes.get(2)) && (show.endTime > realTimes.get(2))}">
                            <td align="center"><c:out value="${show.name}" /></td>
                        </c:if>
                        <c:if test="${(show.playTime <= realTimes.get(3)) && (show.endTime > realTimes.get(3))}">
                            <td align="center"><c:out value="${show.name}" /></td>
                        </c:if>
                        <c:if test="${(show.playTime <= realTimes.get(4)) && (show.endTime > realTimes.get(4))}">
                            <td align="center"><c:out value="${show.name}" /></td>
                        </c:if>
                        <c:if test="${(show.playTime <= realTimes.get(5)) && (show.endTime > realTimes.get(5))}">
                            <td align="center"><c:out value="${show.name}" /></td>
                        </c:if>
                    </c:if>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>