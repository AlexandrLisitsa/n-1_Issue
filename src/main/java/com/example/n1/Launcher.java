package com.example.n1;

import com.example.n1.Entity.Car;
import com.example.n1.Entity.CarShop;
import com.example.n1.Entity.Wheel;
import com.example.n1.repository.CarRepo;
import com.example.n1.repository.CarShopRepo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Launcher {

  ApplicationContext context;

  public Launcher(ApplicationContext context) {
    this.context=context;
  }

  @Transactional
  @PostConstruct
  void test(){
    CarShop carShop = new CarShop();
    carShop.setShopName("QWE");

    Wheel orangeWheel = new Wheel("orange");
    Wheel purpleWheel = new Wheel("purple");
    Wheel grayWheel = new Wheel("gray");

    List<Car> cars = new ArrayList<>();
    Car redCar =new Car("Red",carShop,orangeWheel,purpleWheel);
    Car greenCar=new Car("Green",carShop,grayWheel);
    Car blueCar=new Car("Blue",carShop,purpleWheel,grayWheel);
    cars.add(redCar);
    cars.add(greenCar);
    cars.add(blueCar);

    carShop.setCars(cars);

    CarShopRepo repo = context.getBean(CarShopRepo.class);
    repo.save(carShop);

    CarShop qwe = repo.findByShopName("QWE");
    List<Car> cars1 = qwe.getCars();
    System.out.println(cars1);
  }

}
