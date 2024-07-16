<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!--isErrorPage="true" > 에러 페이지라고 선언-->
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      String exceptionType = exception.getClass().getName();
      String exceptionMessage = exception.getMessage();
      //exception -> 내장 객체 중 한 개
    %>

    <h1><%= exceptionType%></h1>
    <h2><%= exceptionType%></h2>
    <!--에러 발생 시 경로는 2_pageDirective.jsp로 유지되는데 errorPage.jsp로 리디렉션됨-->
</body>
</html>
