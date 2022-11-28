package domain;

import java.util.List;

/**
 * @Classname PageList
 * @Description 分页
 * @Date 2022-11-24 11:39
 * @Created by @tb659
 */

public class PageList<T> {
  private int pageSize; // 每页条数
  private int pageNumber; // 当前页数
  private int totalCount; // 总记录数
  private int totalPage; // 总页码数
  private List<T> list; // 列表数据

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public int getTotalPage() {
    return totalPage;
  }

  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  public List<T> getList() {
    return list;
  }

  public void setList(List<T> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return "PageList{" +
      "pageSize=" + pageSize +
      ", pageNumber=" + pageNumber +
      ", totalCount=" + totalCount +
      ", totalPage=" + totalPage +
      ", list=" + list +
      '}';
  }
}
