package org.example;

import javax.crypto.Mac;

//It is used to group factory
public class AbstractFactory {

  interface Button {
    void display();
  }

  class WindowButton implements Button {
    @Override
    public void display() {
      System.out.println("X");
    }
  }

  class MacButton implements Button {
    @Override
    public void display() {
      System.out.println("X");
    }
  }

  interface Mouse {
    void display();
  }

  class WindowMouse implements Mouse {
    @Override
    public void display() {
      System.out.println("B");
    }
  }

  class MacMouse implements Mouse {
    @Override
    public void display() {
      System.out.println("B");
    }
  }

  interface SystemFactory {
    Button createButton();
    Mouse createMouse();
  }

  class MacFactory implements SystemFactory {

    @Override
    public Button createButton() {
      return new MacButton();
    }

    @Override
    public Mouse createMouse() {
      return new MacMouse();
    }
  }

  class WindowFactory implements SystemFactory  {

    @Override
    public Button createButton() {
      return new WindowButton();
    }

    @Override
    public Mouse createMouse() {
      return new WindowMouse();
    }
  }

  public static void main(String[] args) {
    AbstractFactory obj = new AbstractFactory();
    obj.execute();
  }
  private void execute() {

    MacFactory macFactory = new MacFactory();
    macFactory.createButton().display();
    macFactory.createMouse().display();
    WindowFactory windowFactory = new WindowFactory();
    windowFactory.createButton().display();
    windowFactory.createMouse().display();
  }
}
