package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

/**
 * @Classname FavoriteDao
 * @Description TODO
 * @Date 2022-12-12 18:11
 * @Created by @tb659
 */

public interface FavoriteDao {
  Favorite queryByRidAndUid(int parseInt, int uid);

  int queryCountByRid(int rid);

  void add(int parseInt, int uid);
}
