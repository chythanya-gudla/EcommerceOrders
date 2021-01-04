package com.ecomm.ordering.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

  @Id @GeneratedValue private Long id;

  @Column @NotNull private String name;

  @Column @NotNull private Double price;

  public Double getPrice() {
    return price;
  }

}
