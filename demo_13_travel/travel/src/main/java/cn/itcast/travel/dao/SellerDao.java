package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

/**
 * @Classname sellerDao
 * @Description TODO
 * @Date 2022-12-12 11:19
 * @Created by @tb659
 */

public interface SellerDao {
  Seller queryBySid(int sid);
}
