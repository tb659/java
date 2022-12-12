package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Classname CategoryDaoImpl
 * @Description TODO
 * @Date 2022-12-05 09:21
 * @Created by @tb659
 */

public class CategoryDaoImpl implements CategoryDao {

  private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

  /**
   * @desc: 查询分类数据
   * @author: @tb659
   * @date: 2022-12-05 09:23

   * @return: java.util.List<cn.itcast.travel.domain.Category>
   */
  @Override
  public List<Category> queryList() {
    String sql = "select * from tab_category";
    return template.query(sql, new BeanPropertyRowMapper<>(Category.class));
  }
}
