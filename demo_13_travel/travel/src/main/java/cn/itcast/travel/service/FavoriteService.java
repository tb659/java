package cn.itcast.travel.service;

/**
 * @Classname favoriteService
 * @Description TODO
 * @Date 2022-12-12 18:05
 * @Created by @tb659
 */

public interface FavoriteService {
  boolean isFavorite(String rid, int uid);

  void add(String rid, int uid);
}
