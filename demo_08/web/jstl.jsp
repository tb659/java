<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>

    <%--  test  --%>
    <c:if test=""></c:if>


    <%

      List list = new ArrayList();
      list.add("aaa");
      list.add("bbb");
      list.add("ccc");
      request.setAttribute("list", list);

    %>

    <c:if test="${not empty list}">
      list
    </c:if>

    <hr>

    <%
      int num = 12;
      request.setAttribute("num", num);
    %>
    <c:choose>
      <c:when test="${num == 1}">星期一</c:when>
      <c:when test="${num == 2}">星期二</c:when>
      <c:when test="${num == 3}">星期三</c:when>
      <c:when test="${num == 4}">星期四</c:when>
      <c:when test="${num == 5}">星期五</c:when>
      <c:when test="${num == 6}">星期六</c:when>
      <c:when test="${num == 7}">星期七</c:when>
      <c:otherwise>数字输入有误</c:otherwise>
    </c:choose>

    <hr>

    <c:forEach begin="1" end="10" var="i" step="2" varStatus="v">
      ${i} ${v.begin} ${v.end} ${v.current} ${v.step} ${v.index} ${v.count} ${v.first} ${v.last} <br>
    </c:forEach>

    <c:forEach items="${list}" var="str" varStatus="s">
      ${str} ${s.index} ${s.count} <br>
      </c:forEach>

    <hr>

    <%

      List userList = new ArrayList();
      userList.add(new User("张三", 23, new Date()));
      userList.add(new User("李四", 24, new Date()));
      userList.add(new User("王五", 25, new Date()));

      request.setAttribute("userList", userList);
    %>

    <table border width="500" align="center">
      <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
      </tr>
      <c:forEach items="${userList}" var="user" varStatus="item">
        <c:if test="${item.count % 2 != 0}">
          <tr bgcolor="#90ee90">
            <td>${item.count}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.birthdayStr}</td>
          </tr>
        </c:if>
        <c:if test="${item.count % 2 == 0}">
          <tr bgcolor="#add8e6">
            <td>${item.count}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.birthdayStr}</td>
          </tr>
        </c:if>
      </c:forEach>
    </table>


  </body>
</html>
