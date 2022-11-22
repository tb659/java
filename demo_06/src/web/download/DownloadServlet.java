package web.download;

import web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-19 15:03
 * @Created by @tb659
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String filename = request.getParameter("filename");
    // System.out.println(filename);

    ServletContext servletContext = request.getServletContext();
    String path = servletContext.getRealPath("/img/" + filename);
    FileInputStream fis = new FileInputStream(path);


    String agent = request.getHeader("user-agent");
    filename = DownLoadUtils.getFileName(agent, filename);

    response.setContentType(servletContext.getMimeType(filename));
    response.setHeader("content-disposition", "attachment;filename=" + filename);

    ServletOutputStream sos = response.getOutputStream();
    byte[] buff = new byte[1024 * 8];
    int len = 0;
    while((len = fis.read(buff)) != -1) {
      sos.write(buff, 0, len);
    }

    fis.close();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
