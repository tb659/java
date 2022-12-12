package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

/**
 * @Classname FavoriteDaoImpl
 * @Description TODO
 * @Date 2022-12-12 18:11
 * @Created by @tb659
 */

public class FavoriteDaoImpl implements FavoriteDao {

  private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

  @Override
  public Favorite queryByRidAndUid(int rid, int uid) {
    Favorite favorite = null;
    try {
      String sql = " select * from tab_favorite where rid = ? and uid = ?";
      favorite = template.queryForObject(sql, new BeanPropertyRowMapper<>(Favorite.class), rid, uid);
    } catch (DataAccessException e) {
      e.printStackTrace();
    }
    return favorite;
  }

  @Override
  public int queryCountByRid(int rid) {
    String sql = "SELECT COUNT(*) FROM tab_favorite WHERE rid = ?";

    return template.queryForObject(sql, Integer.class, rid);
  }

  @Override
  public void add(int rid, int uid) {
    String sql = "insert into tab_favorite values(?,?,?)";

    template.update(sql, rid, new Date(), uid);
  }


}
