package cn.itcast.travel.service;

import cn.itcast.travel.domain.Category;

import java.util.List;

/**
 * @Classname CategoryService
 * @Description TODO
 * @Date 2022-12-05 10:15
 * @Created by @tb659
 */

public interface CategoryService {

  /**
   * @desc: 查询分类数据
   * @author: @tb659
   * @date: 2022-12-05 09:23
   * @return: java.util.List<cn.itcast.travel.domain.Category>
   */
  List<Category> queryList();
}
