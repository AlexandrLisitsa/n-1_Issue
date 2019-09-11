package com.example.n1.repository;

import com.example.n1.Entity.CarShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarShopRepo extends JpaRepository<CarShop,Integer> {

  CarShop findByShopName(String shopName);

}
