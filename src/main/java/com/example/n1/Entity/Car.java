package com.example.n1.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "car_id", unique = true, nullable = false)
  int id;

  @Column(name = "color")
  String color;

  public Car() {}

  public Car(String color) {
    this.color = color;
  }
}
