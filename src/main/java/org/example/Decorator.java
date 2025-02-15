package org.example;

interface Beverage {
  public String cost();
}

class Decaf implements Beverage {
  @Override
  public String cost() {
    return "Decaf-";
  }
}

class Expresso implements Beverage {
  @Override
  public String cost() {
    return "Expresso-";
  }
}

abstract class AddOnDecorator implements Beverage { // we can decorator pattern without implement without AddOnDecorator
  Beverage beverage;
  public AddOnDecorator(Beverage beverage) {
    this.beverage = beverage;
  }
  public String cost() {
    return this.beverage.cost();
  }
}

class WipCream extends AddOnDecorator {
  public WipCream(Beverage beverage) {
    super(beverage);
  }

  @Override
  public String cost() {
    return this.beverage.cost() + "WipCream-";
  }
}

class SoyMilk extends AddOnDecorator {
  public SoyMilk(Beverage beverage) {
    super(beverage);
  }

  @Override
  public String cost() {
    return this.beverage.cost() + "SoyMilk-";
  }
}

public class Decorator {
  public static void main(String[] args) {

    Beverage beverage = new Decaf();
    System.out.println(beverage.cost());
    Beverage beverage1 = new SoyMilk(beverage);
    System.out.println(beverage1.cost());
    Beverage beverage2 = new SoyMilk(beverage1);
    System.out.println(beverage2.cost());
    Beverage beverage3 = new WipCream(beverage2);
    System.out.println(beverage3.cost());

  }
}