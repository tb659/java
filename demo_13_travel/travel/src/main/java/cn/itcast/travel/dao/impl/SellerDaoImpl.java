package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Classname SellerDaoImpl
 * @Description TODO
 * @Date 2022-12-12 11:37
 * @Created by @tb659
 */

public class SellerDaoImpl implements SellerDao {

  private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

  @Override
  public Seller queryBySid(int sid) {
    String sql = "select * from tab_seller where sid = ? ";
    return template.queryForObject(sql,new BeanPropertyRowMapper<>(Seller.class), sid);
  }
}
