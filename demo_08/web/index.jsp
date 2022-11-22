<%@ page import="domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    ${3 > 4}
    \${3 > 4}

    <%

      pageContext.setAttribute("name", "张三");
      pageContext.setAttribute("age", 21);
      request.setAttribute("age", 23);
      session.setAttribute("gander", "male");
      application.setAttribute("hobby", "学习");

      User user = new User();
      user.setName("zhangsan");
      user.setAge(12);
      user.setBirthday(new Date());
      request.setAttribute("user", user);

      List list = new ArrayList();
      list.add("张三");
      list.add("李四");
      list.add(user);
      request.setAttribute("list", list);

      Map map = new HashMap<>();
      map.put("name", "张三");
      map.put("age", 13);
      map.put("user", user);
      request.setAttribute("map", map);
    %>

    <ul>
      <li> ${age} </li>
      <li> ${pageScope.name} </li>
      <li> ${requestScope.age} </li>
      <li> ${sessionScope.gander} </li>
      <li> ${applicationScope.hobby} </li>
      <hr>
      <li> ${requestScope.user} </li>
      <li> ${requestScope.user.name} </li>
      <li> ${requestScope.user.age} </li>
      <li> ${requestScope.user.birthday} </li>
      <li> ${requestScope.user.birthdayStr} </li>
      <hr>
      <li> ${requestScope.list} </li>
      <li> ${requestScope.list[0]} </li>
      <li> ${requestScope.list[1]} </li>
      <li> ${requestScope.list[11]} </li>
      <li> ${requestScope.list[2]} </li>
      <li> ${requestScope.list[2].name} </li>
      <hr>
      <li> ${requestScope.map} </li>
      <li> ${requestScope.map.name} </li>
      <li> ${requestScope.map["user"].birthdayStr} </li>
      <hr>
      <li> ${pageContext.request.contextPath} </li>
      <li> ${pageContext.request.getContextPath()} </li>
      <li> ${pageContext.request.getServletPath()} </li>
      <li> ${pageContext.request.getProtocol()} </li>
    </ul>
  </body>
</html>
