package com.example.n1.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "car_id", unique = true, nullable = false)
  int id;

  @Column(name = "color")
  String color;

  @ManyToOne
  CarShop shop;

  public Car() {}

  public Car(String color,CarShop carShop) {
    this.shop=carShop;
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public CarShop getShop() {
    return shop;
  }

  public void setShop(CarShop shop) {
    this.shop = shop;
  }
}
