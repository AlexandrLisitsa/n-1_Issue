package com.example.n1.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wheel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "wheel_id", unique = true, nullable = false)
  int id;

  public Wheel() {
  }

  @Column(name = "wheel_color")
  String color;

  public Wheel(String color) {
    this.color = color;
  }

}
