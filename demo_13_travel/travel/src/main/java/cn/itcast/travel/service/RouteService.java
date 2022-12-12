package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageList;
import cn.itcast.travel.domain.Route;

/**
 * @Classname RouteService
 * @Description TODO
 * @Date 2022-12-08 09:19
 * @Created by @tb659
 */

public interface RouteService {
  PageList queryList(int cid, int pageNumber, int pageSize, String rname);

  Route queryDetail(String rid);
}
