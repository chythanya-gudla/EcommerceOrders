package com.ecomm.ordering.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CartItem {

  @Id
  @GeneratedValue
  private Long id;

  @Column
  private int quantity;

  @ManyToOne
  @JoinColumn(name="order_id", nullable = false)
  private Order order;

  @OneToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private Product product;

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public CartItem() {};
  public CartItem(int quantity, Order order, Product product) {
    this.quantity = quantity;
    this.order = order;
    this.product = product;
  }
}
