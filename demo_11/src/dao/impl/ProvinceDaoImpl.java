package dao.impl;

import dao.ProvinceDao;
import doMain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

/**
 * @Classname ProvinceImpl
 * @Description TODO
 * @Date 2022-11-27 20:41
 * @Created by @tb659
 */

public class ProvinceDaoImpl implements ProvinceDao {

  private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

  @Override
  public List<Province> queryProvinceList() {
    String sql = "select * from province";
    return template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
  }
}
