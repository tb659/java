<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <%
      String date = null;
      Cookie[] cookies = request.getCookies();

      if (cookies != null && cookies.length > 0) {
        for (Cookie cookie: cookies){
          if ("lastTime".equals(cookie.getName())) {
            date = URLDecoder.decode(cookie.getValue(), "utf-8");
            break;
          }
        }
      }
      Cookie lastTime = new Cookie("lastTime",
        URLEncoder.encode(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss")
          .format(new Date()), "utf-8"));

      lastTime.setMaxAge(60 * 60 * 24 * 30);

      response.addCookie(lastTime);

      if (date == null) {
    %>
    <h1>您好，欢迎您首次访问</h1>
    <%
    } else {
    %>
    <h1>
      <span>欢迎回来，您上次访问的时间是: </span>
      <span><%=date%></span>
    </h1>
    <%
      }
    %>
  </body>
</html>
