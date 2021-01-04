package com.ecomm.ordering;

import java.util.List;

public class BulkStatusUpdateDTO {

  private List<Long> ids;
  private OrderStatus orderStatus;

  public List<Long> getIds() {
    return ids;
  }

  public void setIds(List<Long> ids) {
    this.ids = ids;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }
}
