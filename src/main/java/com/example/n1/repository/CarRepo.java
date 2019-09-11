package com.example.n1.repository;

import com.example.n1.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car,Integer> {

  Car findByColor(String color);

}
