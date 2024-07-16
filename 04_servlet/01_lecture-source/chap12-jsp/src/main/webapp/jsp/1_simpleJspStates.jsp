<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- html 주석 -->
    <%--out/println("html 주석");으로 변환됨--%>

    <%-- jsp 주석 --%>

    <!-- 선언 태그 -->
    <!-- 서블릿으로 변환 시 선언 태그 내에 작성한 내용을 필드로 선언한다. -->
    <%!
        private String name;
        private int age;
    %>

    <!-- scriptlet 태그 -->
    <!-- 간단한 자바 코드를 작성할 수 있는 부분 -->
    <%
        // 자바 코드 작성
        /* 자바 코드로 해석되기 때문에
        * 자바에서 사용하는 주석을 그대로 사용 가능
        * */

        name = "송만두";
        age = 23;

        System.out.println("name : " + name);
        System.out.println("age : " + age);
    %>

    <!-- expression 태그 -->
    name : <%= name%><br>  <!--out.println(name)과 동일-->
    age : <%= age%><br>
</body>
</html>
