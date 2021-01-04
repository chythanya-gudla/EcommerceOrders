package com.ecomm.ordering.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PaymentDetails {

  @Id @GeneratedValue private Long id;

  @Column private String billingAddressLine1;

  @Column private String billingAddressLine2;

  @Column private String billingCity;

  @Column private String billingState;

  @Column private String billingZip;

  @ManyToOne
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  public PaymentDetails(
      String billingAddressLine1,
      String billingAddressLine2,
      String billingCity,
      String billingState,
      String billingZip,
      Order order) {
    this.billingAddressLine1 = billingAddressLine1;
    this.billingAddressLine2 = billingAddressLine2;
    this.billingCity = billingCity;
    this.billingState = billingState;
    this.billingZip = billingZip;
    this.order = order;
  }

  public PaymentDetails() {}

  public String getBillingAddressLine1() {
    return billingAddressLine1;
  }

  public void setBillingAddressLine1(String billingAddressLine1) {
    this.billingAddressLine1 = billingAddressLine1;
  }

  public String getBillingAddressLine2() {
    return billingAddressLine2;
  }

  public void setBillingAddressLine2(String billingAddressLine2) {
    this.billingAddressLine2 = billingAddressLine2;
  }

  public String getBillingCity() {
    return billingCity;
  }

  public void setBillingCity(String billingCity) {
    this.billingCity = billingCity;
  }

  public String getBillingState() {
    return billingState;
  }

  public void setBillingState(String billingState) {
    this.billingState = billingState;
  }

  public String getBillingZip() {
    return billingZip;
  }

  public void setBillingZip(String billingZip) {
    this.billingZip = billingZip;
  }
}
