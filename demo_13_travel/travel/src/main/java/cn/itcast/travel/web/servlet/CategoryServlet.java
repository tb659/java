package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-12-04 15:54
 * @Created by @tb659
 */
@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

  final CategoryService service = new CategoryServiceImpl();

  public void queryList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    ResultInfo info = new ResultInfo();

    List<Category> list = service.queryList();
    if (list != null && list.size() > 0) {
      info.setFlag(true);
      info.setData(list);
    }

    writeValue(info, res);
  }
}
