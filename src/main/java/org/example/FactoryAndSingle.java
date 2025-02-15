package org.example;

public class FactoryAndSingle {

  //create an object of SingleObject
  private static FactoryAndSingle instance = new FactoryAndSingle();

  //make the constructor private so that this class cannot be
  //instantiated
  private FactoryAndSingle(){}

  //Get the only object available
  public static FactoryAndSingle getInstance(){
    return instance;
  }

  public ICar getCarInstance(String type) {
    if("toyota".equals(type)) {
      return new Toyota();
    } else  if("ford".equals(type)) {
      return new Ford();
    } else {
      return new Kia();
    }
  }

  interface ICar { //this can be interface or entity class

  }
  class Toyota implements ICar {

  }

  class Ford implements ICar {

  }

  class Kia implements ICar {

  }

  public static void main(String[] args) {
    FactoryAndSingle obj = new FactoryAndSingle();
    obj.execute();
  }

  private void execute() {
    ICar toyota = FactoryAndSingle
            .getInstance()
            .getCarInstance("toyota");
  }
}