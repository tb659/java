package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.RouteImgDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.PageList;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.service.RouteService;

import java.util.List;

/**
 * @Classname RouteServiceImpl
 * @Description TODO
 * @Date 2022-12-08 09:20
 * @Created by @tb659
 */

public class RouteServiceImpl implements RouteService {

  RouteDao routeDao = new RouteDaoImpl();
  RouteImgDao routeImgDao = new RouteImgDaoImpl();
  SellerDao sellerDao = new SellerDaoImpl();
  FavoriteDao favoriteDao = new FavoriteDaoImpl();

  /**
   * @desc: 分页查询
   * @author: @tb659
   * @date: 2022-12-08 22:12
   * @Param cid:
   * @Param pageNumber:
   * @Param pageSize:
   * @return: cn.itcast.travel.domain.PageList
   */
  @Override
  public PageList<Route> queryList(int cid, int pageNumber, int pageSize, String rname) {

    PageList<Route> pageList = new PageList<>();
    pageList.setPageNumber(pageNumber);
    pageList.setPageSize(pageSize);

    int totalCount = routeDao.queryTotalCount(cid, rname);
    pageList.setTotalCount(totalCount);

    int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize + 1);
    pageList.setTotalPage(totalPage);

    List<Route> routes = routeDao.queryList(cid, (pageNumber - 1) * pageSize, pageSize, rname);
    pageList.setList(routes);

    return pageList;
  }

  /**
   * @desc: 路线详情
   * @author: @tb659
   * @date: 2022-12-12 11:04
   * @Param rid:
   * @return: cn.itcast.travel.domain.Route
   */
  @Override
  public Route queryDetail(String rid) {
    //1.根据id去route表中查询route对象
    Route route = routeDao.queryByRid(Integer.parseInt(rid));

    //2.根据route的id 查询图片集合信息
    List<RouteImg> routeImgList = routeImgDao.queryByRid(route.getRid());
    //2.2将集合设置到route对象
    route.setRouteImgList(routeImgList);
    //3.根据route的sid（商家id）查询商家对象
    Seller seller = sellerDao.queryBySid(route.getSid());
    route.setSeller(seller);
    //4. 查询收藏次数
    int count = favoriteDao.queryCountByRid(route.getRid());
    route.setCount(count);

    return route;
  }
}
