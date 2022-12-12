package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Classname CategoryServiceImpl
 * @Description TODO
 * @Date 2022-12-05 10:15
 * @Created by @tb659
 */

public class CategoryServiceImpl implements CategoryService {

  CategoryDao categoryDao = new CategoryDaoImpl();

  /**
   * @desc: 查询分类数据
   * @author: @tb659
   * @date: 2022-12-05 09:23
   * @return: java.util.List<cn.itcast.travel.domain.Category>
   */
  @Override
  public List<Category> queryList() {

    List<Category> list;
    Jedis jedis = JedisUtil.getJedis();
    // Set<String> travel_category = jedis.zrange("travel_category", 0, -1);
    Set<Tuple> travel_category = jedis.zrangeWithScores("travel_category", 0, -1);

    if (travel_category == null || travel_category.size() == 0) {
      list = categoryDao.queryList();
      for (int i = 0; i < list.size(); i++) {
        jedis.zadd("travel_category", list.get(i).getCid(), list.get(i).getCname());
      }
    } else {
      list = new ArrayList<>();

      for (Tuple tuple : travel_category) {
        Category category = new Category();
        category.setCid((int) tuple.getScore());
        category.setCname(tuple.getElement());
        list.add(category);
      }
    }

    return list;
  }
}
