package service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import doMain.Province;
import jedis.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;
import service.ProvinceService;

import java.util.List;

/**
 * @Classname ProvinceServiceImpl
 * @Description TODO
 * @Date 2022-11-28 11:03
 * @Created by @tb659
 */

public class ProvinceServiceImpl implements ProvinceService {

  private ProvinceDao dao = new ProvinceDaoImpl();

  @Override
  public List<Province> queryProvinceList() {
    return dao.queryProvinceList();
  }

  @Override
  public String queryProvinceJson() {
    Jedis jedis = JedisPoolUtils.getJedis();
    String provinceJson = jedis.get("province");
    if (provinceJson == null || provinceJson.equals("")) {
      System.out.println("redis没有数据，从数据库查询");

      List<Province> provinces = dao.queryProvinceList();
      ObjectMapper mapper = new ObjectMapper();
      try {
        provinceJson = mapper.writeValueAsString(provinces);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("redis有数据，从缓存中查询");
    }
    return provinceJson;
  }
}
