<%--
  Created by IntelliJ IDEA.
  User: great
  Date: 1/13/2021
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <meta charset="ISO-8859-1">
</head>
<body>
<div class = "container"></div>
<h1>Dashboard </h1>


<br />



<table class="table">
    <thead class="thead-light">
    <tr>
        <th>Question</th>
        <th>Tags</th>
    </tr>
    </thead>
    <c:forEach items="${ questions }" var="question">
        <tr>
            <td><a href="/questions/${ question.id }">${ question.question}</a></td>
            <td>
                <c:forEach items="${ question.tags }" var="tag">
                    <span>${ tag.subject }<c:if test="${ question.tags.indexOf(tag) != question.tags.size() - 1 }">, </c:if></span>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/new">New Question </a>






</body>
</html>