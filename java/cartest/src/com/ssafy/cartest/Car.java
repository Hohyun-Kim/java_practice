package com.ssafy.cartest;

import java.io.Serializable;

/*
 * - carNum:int - carName:String + Car() + Car(carNum:int, carName:String) + getter & setter +
 * toString():String
 */
public class Car implements Serializable, Comparable<Car> {

  private int carNum;
  private String carName;

  public Car() {}

  public Car(int carNum, String carName) {
    super();
    this.carNum = carNum;
    this.carName = carName;
  }

  @Override
  public String toString() {
    return "Car [carNum=" + carNum + ", carName=" + carName + "]";
  }

  public int getCarNum() {
    return carNum;
  }

  public void setCarNum(int carNum) {
    this.carNum = carNum;
  }

  public String getCarName() {
    return carName;
  }

  public void setCarName(String carName) {
    this.carName = carName;
  }

  @Override
  public int compareTo(Car car) {
    if (this.carNum > car.carNum) {
      return 1;
    } else if (this.carNum < car.carNum) {
      return -1;
    }
    return 0;
  }
}
