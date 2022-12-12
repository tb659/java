package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageList;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date 2022-12-08 09:18
 * @Created by @tb659
 */
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

  RouteService RouteService = new RouteServiceImpl();
  FavoriteService favoriteService = new FavoriteServiceImpl();

  /**
   * @desc: 分页查询
   * @author: @tb659
   * @date: 2022-12-08 09:23
   * @Param req:
   * @Param res:
   * @return: void
   */
  public void queryList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    String cidStr = req.getParameter("cid");
    String pageSizeStr = req.getParameter("pageSize");
    String pageNumberStr = req.getParameter("pageNumber");

    String rname = req.getParameter("rname");
    rname = new String(rname.getBytes("iso-8859-1"), "utf-8");


    int cid = 0;
    if (cidStr != null && cidStr.length() != 0 && !cidStr.equals("null")) {
      cid = Integer.parseInt(cidStr);
    }

    int pageSize = 10;
    if (pageSizeStr != null && pageSizeStr.length() != 0) {
      pageSize = Integer.parseInt(pageSizeStr);
    }

    int pageNumber = 1;
    if (pageNumberStr != null && pageNumberStr.length() != 0) {
      pageNumber = Integer.parseInt(pageNumberStr);
    }

    PageList list = RouteService.queryList(cid, pageNumber, pageSize, rname);

    writeValue(list, res);
  }

  /**
   * 根据id查询一个旅游线路的详细信息
   *
   * @param req
   * @param res
   * @throws ServletException
   * @throws IOException
   */
  public void queryDetail(HttpServletRequest req, HttpServletResponse res) throws IOException {

    String rid = req.getParameter("rid");

    Route route = RouteService.queryDetail(rid);

    writeValue(route, res);
  }

  public void isFavorite(HttpServletRequest req, HttpServletResponse res) throws IOException {
    //1. 获取线路id
    String rid = req.getParameter("rid");

    //2. 获取当前登录的用户 user
    User user = (User) req.getSession().getAttribute("user");
    int uid;//用户id
    if (user == null) {
      //用户尚未登录
      uid = 0;
    } else {
      //用户已经登录
      uid = user.getUid();
    }

    //3. 调用FavoriteService查询是否收藏
    boolean flag = favoriteService.isFavorite(rid, uid);

    //4. 写回客户端
    writeValue(flag, res);
  }

  public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //1. 获取线路rid
    String rid = request.getParameter("rid");
    //2. 获取当前登录的用户
    User user = (User) request.getSession().getAttribute("user");
    int uid;//用户id
    if (user == null) {
      //用户尚未登录
      return;
    } else {
      //用户已经登录
      uid = user.getUid();
    }


    //3. 调用service添加
    favoriteService.add(rid, uid);

  }

}
