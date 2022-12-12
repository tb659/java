package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Classname RouteImgDaoImpl
 * @Description TODO
 * @Date 2022-12-12 11:31
 * @Created by @tb659
 */

public class RouteImgDaoImpl implements RouteImgDao {

  private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

  @Override
  public List<RouteImg> queryByRid(int rid) {
    String sql = "select * from tab_route_img where rid = ?";
    return template.query(sql, new BeanPropertyRowMapper<>(RouteImg.class), rid);
  }
}
