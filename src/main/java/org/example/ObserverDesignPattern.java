package org.example;

import java.util.ArrayList;
import java.util.List;

// Concrete Observable
class WeatherStation {
  private int temperature;
  private List<Observer> observers = new ArrayList<>();

  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  private void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(this);
    }
  }

  public void setTemperature(int temperature) {
    this.temperature = temperature;
    System.out.println("WeatherStation: Temperature updated to " + temperature);
    notifyObservers();
  }

  public int getTemperature() {
    return temperature;
  }
}

class MobileDisplay implements Observer {
  @Override
  public void update(WeatherStation observable) {
    WeatherStation weatherStation = observable;
    System.out.println("MobileDisplay: Temperature is now " + weatherStation.getTemperature());
  }
}

// Concrete Observer 2
class TVDisplay implements Observer {
  @Override
  public void update(WeatherStation observable) {
    WeatherStation weatherStation = observable;
    System.out.println("TVDisplay: Temperature updated to " + weatherStation.getTemperature());
  }
}

interface Observer {
  void update(WeatherStation observable);
}

public class ObserverDesignPattern {
  public static void main(String[] args) {
    WeatherStation weatherStation = new WeatherStation();

    Observer mobileDisplay = new MobileDisplay();
    Observer tvDisplay = new TVDisplay();

    weatherStation.addObserver(mobileDisplay);
    weatherStation.addObserver(tvDisplay);

    // Update temperature (this should notify all observers)
    weatherStation.setTemperature(25);
    weatherStation.setTemperature(30);
  }
}