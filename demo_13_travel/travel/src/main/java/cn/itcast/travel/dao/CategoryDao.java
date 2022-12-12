package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @Classname CategoryDao
 * @Description TODO
 * @Date 2022-12-05 09:20
 * @Created by @tb659
 */

public interface CategoryDao {
  /**
   * @desc: 查询分类数据
   * @author: @tb659
   * @date: 2022-12-05 09:23
   * @return: java.util.List<cn.itcast.travel.domain.Category>
   */
  List<Category> queryList();
}
