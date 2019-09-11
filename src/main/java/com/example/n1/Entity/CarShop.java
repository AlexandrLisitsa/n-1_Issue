package com.example.n1.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CarShop {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "car_shop_id", unique = true, nullable = false)
  int id;

  @Column(name = "shop_name")
  String shopName;

  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "shop")
  List<Car> cars = new ArrayList<>();

  public CarShop() {}

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }
}
