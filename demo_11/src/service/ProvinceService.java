package service;

import doMain.Province;

import java.util.List;

/**
 * @Classname ProvinceService
 * @Description TODO
 * @Date 2022-11-27 21:05
 * @Created by @tb659
 */

public interface ProvinceService {

  public List<Province> queryProvinceList();

  public String queryProvinceJson();
}
