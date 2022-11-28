package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import doMain.Province;
import service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-11-27 21:11
 * @Created by @tb659
 */
@WebServlet("/queryProvinceServlet")
public class QueryProvinceServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    res.setCharacterEncoding("utf-8");
    res.setContentType("application/json,charset=utf-8");

    ProvinceServiceImpl service = new ProvinceServiceImpl();
    List<Province> provinces = service.queryProvinceList();

    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(provinces);

    res.getWriter().write(json);
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    this.doPost(req, res);
  }
}
