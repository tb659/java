package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname RouteDaoImpl
 * @Description TODO
 * @Date 2022-12-08 09:21
 * @Created by @tb659
 */

public class RouteDaoImpl implements RouteDao {

  private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

  /**
   * @desc: 路线总数
   * @author: @tb659
   * @date: 2022-12-08 22:17
   * @Param cid:
   * @return: int
   */
  @Override
  public int queryTotalCount(int cid, String rname) {
    String sql = "select count(*) from tab_route where 1 = 1 ";
    StringBuilder sb = new StringBuilder(sql);
    List<Object> params = new ArrayList<>();

    if (cid != 0) {
      sb.append(" and cid = ? ");
      params.add(cid);
    }
    if (rname != null && rname.length() != 0) {
      sb.append(" and rname like ? ");
      params.add("%" + rname + "%");
    }

    sql = sb.toString();
    return template.queryForObject(sql, Integer.class, params.toArray());
  }

  /**
   * @desc: 分页查询
   * @author: @tb659
   * @date: 2022-12-08 09:41
   * @Param cid:
   * @Param pageNumber:
   * @Param pageSize:
   * @return: cn.itcast.travel.domain.PageList
   */
  @Override
  public List<Route> queryList(int cid, int pageNumber, int pageSize, String rname) {
    String sql = "select * from tab_route where 1 = 1 ";
    StringBuilder sb = new StringBuilder(sql);
    List<Object> params = new ArrayList<>();

    if (cid != 0) {
      sb.append(" and cid = ? ");
      params.add(cid);
    }
    if (rname != null && rname.length() != 0) {
      sb.append(" and rname like ? ");
      params.add("%" + rname + "%");
    }

    sb.append(" limit ? , ? ");
    sql = sb.toString();

    params.add(pageNumber);
    params.add(pageSize);

    return template.query(sql, new BeanPropertyRowMapper<>(Route.class), params.toArray());
  }

  /**
   * @desc: 根据id查询路线
   * @author: @tb659
   * @date: 2022-12-12 11:14
   * @Param parseInt:
   * @return: cn.itcast.travel.domain.Route
   */
  @Override
  public Route queryByRid(int rid) {
    String sql = "select * from tab_route where rid = ?";
    return template.queryForObject(sql, new BeanPropertyRowMapper<>(Route.class), rid);
  }

}
