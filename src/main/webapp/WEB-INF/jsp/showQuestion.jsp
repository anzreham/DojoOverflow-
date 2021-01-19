<%--
  Created by IntelliJ IDEA.
  User: great
  Date: 1/12/2021
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="/">Dashboard</a>
</nav>
<div>

    <div class="row">
        <div class="col">
            <h1>Tags</h1>
            <ul>
                <c:forEach items="${question.tags}" var="tag">
                    <li>${tag.subject}</li>
                </c:forEach>
            </ul>

            <br />
            <h3>Answers:</h3>
            <ul>
                <c:forEach items="${ question.answers }" var="answer">
                    <li>${ answer.answer }</li>
                </c:forEach>
            </ul>
        </div>
        <div class="col">
            <form:form action="/questions/answers" method="post" modelAttribute="answerobject">
                <div class="form-group">
                    <form:label path="answer">Answer</form:label>
                    <form:errors path="answer"/>
                    <form:textarea class="form-control" path="answer"></form:textarea>
                </div>
                <form:hidden path="question" value="${ question.id }"/>
                <button class="btn btn-primary">Answer it!</button>
            </form:form>

        </div>
    </div>


</div>
</body>
</html>