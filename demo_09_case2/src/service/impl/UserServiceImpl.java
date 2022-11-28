package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.Account;
import domain.PageList;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2022-11-21 21:58
 * @Created by @tb659
 */

public class UserServiceImpl implements UserService {
  private UserDao dao = new UserDaoImpl();

  @Override
  public List<User> findAll() {
    // 调用DAO完成查询
    return dao.findAll();
  }

  @Override
  public Account login(Account account) {
    return dao.login(account.getUsername(), account.getPassword());
  }

  @Override
  public void addUser(User user) { dao.addUser(user); }

  @Override
  public void deleteUser(String id) {
    dao.deleteUser(Integer.parseInt(id));
  }

  @Override
  public User queryUserById(String id) {
    return dao.queryUserById(Integer.parseInt(id));
  }

  @Override
  public void updateUser(User user) {
    dao.updateUser(user);
  }

  @Override
  public void deleteSelectedUsers(String[] ids) {
    if (ids != null && ids.length > 0) {
      for (String id : ids) {
        dao.deleteUser(Integer.parseInt(id));
      }
    }
  }

  @Override
  public PageList<User> queryUserByPage(String _pageSize, String _pageNumber, Map<String, String[]> condition) {

    int pageSize = Integer.parseInt(_pageSize);
    int pageNumber = Integer.parseInt(_pageNumber);

    PageList<User> pageList = new PageList<>();

    pageList.setPageSize(pageSize);
    pageList.setPageNumber(pageNumber);

    int totalCount = dao.QueryTotalCount(condition);
    pageList.setTotalCount(totalCount);

    int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    pageList.setTotalPage(totalPage);

    int start = (pageNumber - 1) * pageSize;
    List<User> list = dao.queryUserByPage(start, pageSize, condition);
    pageList.setList(list);

    return pageList;
  }


}
