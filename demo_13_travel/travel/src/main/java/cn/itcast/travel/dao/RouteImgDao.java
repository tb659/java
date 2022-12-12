package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

/**
 * @Classname routeImgDao
 * @Description TODO
 * @Date 2022-12-12 11:31
 * @Created by @tb659
 */

public interface RouteImgDao {
  List<RouteImg> queryByRid(int rid);
}
