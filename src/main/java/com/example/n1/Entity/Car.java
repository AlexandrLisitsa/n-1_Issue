package com.example.n1.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "car_id", unique = true, nullable = false)
  int id;

  @Column(name = "color")
  String color;

  @ManyToOne CarShop shop;

  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  @JoinColumn(name = "car_id")
  List<Wheel> wheels = new ArrayList<>();

  public Car() {}

  public Car(String color, CarShop carShop, Wheel... wheels) {
    this.shop = carShop;
    this.color = color;
    this.wheels.addAll(Arrays.asList(wheels));
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
