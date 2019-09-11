package com.example.n1;

import com.example.n1.Entity.Car;
import com.example.n1.Entity.CarShop;
import com.example.n1.repository.CarRepo;
import com.example.n1.repository.CarShopRepo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Launcher {

  ApplicationContext context;

  public Launcher(ApplicationContext context) {
    this.context=context;
  }

  @PostConstruct
  void test(){
    CarShop carShop = new CarShop();
    carShop.setShopName("QWE");

    List<Car> cars = new ArrayList<>();
    cars.add(new Car("Red",carShop));
    cars.add(new Car("Green",carShop));
    cars.add(new Car("Blue",carShop));

    carShop.setCars(cars);

    CarShopRepo repo = context.getBean(CarShopRepo.class);
    repo.save(carShop);

    CarShop qwe = repo.findByShopName("QWE");
    List<Car> cars1 = qwe.getCars();
    System.out.println(cars1);
  }

}
