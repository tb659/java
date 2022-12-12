package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

/**
 * @Classname RouteDao
 * @Description TODO
 * @Date 2022-12-08 09:20
 * @Created by @tb659
 */

public interface RouteDao {
  int queryTotalCount(int cid, String rname);

  List<Route> queryList(int cid, int pageNumber, int pageSize, String rname);

  Route queryByRid(int rid);
}
