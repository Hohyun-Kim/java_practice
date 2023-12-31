package com.ssafy.cartest;

import java.util.List;

public class CarMain {

  public static void main(String[] args) {
    CarManager carManager = CarManagerImpl.getCarManager();

    System.out.println("[자동차 등록하기]");
    try {
      carManager.add(new Car(7777, "쏘나타"));
      carManager.add(new Car(1111, "SM6"));
      carManager.add(new Car(5555, "그랜저"));
      carManager.add(new Car(3333, "코란도"));
      carManager.add(new Car(3333, "K7"));
    } catch (SameNumberException e) {
      // e.printStackTrace();
      System.out.println(e.getMessage());
    }

    System.out.println("[자동차 목록보기]");
    List<Car> list = carManager.search();
    for (Car car : list) {
      System.out.println(car);
    }

    int carNum = 1111;
    System.out.println("[차번호(" + carNum + ")검색]");
    try {
      Car car = carManager.searchByNum(carNum);
      System.out.println(car);
    } catch (NotFoundException e) {
      // e.printStackTrace();
      System.out.println(e.getMessage());
    }

    carNum = 9999;
    System.out.println("[차번호(" + carNum + ")검색]");
    try {
      Car car = carManager.searchByNum(carNum);
      System.out.println(car);
    } catch (NotFoundException e) {
      // e.printStackTrace();
      System.out.println(e.getMessage());
    }

    String carName = "쏘나타";
    carManager.deleteCar(carName);
    for (Car car : list) {
      System.out.println(car);
    }

    System.out.println("car.dat에 자동차 정보(객체) 저장");
    carManager.save();
    System.out.println("car.dat에서 자동차 정보 얻기");
    list = carManager.load();
    for (Car car : list) {
      System.out.println(car);
    }

  }

}
