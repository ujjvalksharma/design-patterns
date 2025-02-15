package org.example;

public class AdapatorDesignPattern {
  // we can use similar strategy to convert Xml to Json.
  class IndianSocket {
    private int size;
    public IndianSocket(int size) {
      this.size = size;
    }
    public boolean doesFit(IndianPlug indianPlug) {
      return indianPlug.getSize() < this.size;
    }

  }

  class IndianPlug {
    private int size;
    public IndianPlug() {

    }
    public IndianPlug(int size) {
      this.size = size;
    }

    public int getSize() {
      return this.size;
    }

  }

  class AmericanPlug {

    int size;

    public AmericanPlug(int size) {
      this.size = size;
    }

  }

  class IndianAmericanAdapater extends IndianPlug {
    AmericanPlug americanPlug;
    public IndianAmericanAdapater(AmericanPlug americanPlug) {
      super();
      this.americanPlug = americanPlug;
    }

    @Override
    public int getSize() {
      return this.americanPlug.size/2;
    }


  }
  public static void main(String[] args) {
    AdapatorDesignPattern obj = new AdapatorDesignPattern();
    obj.execute();
  }

  private void execute() {
    IndianSocket indianSocket= new IndianSocket(10);
    IndianPlug indianPlug = new IndianPlug(5);
    AmericanPlug americanPlug = new AmericanPlug(10);
    IndianAmericanAdapater indianAdpater = new IndianAmericanAdapater(americanPlug);
    System.out.println("does indian socket fit: " + indianSocket.doesFit(indianPlug));
    System.out.println("does indian socket fit: " + indianSocket.doesFit(indianAdpater));

  }
}
