package org.example;

public class ProxyDesignPattern {

  interface IImage {
    public String displayName();
  }
  class RealImage implements IImage {
    @Override
    public String displayName() {
      return "goldenretriver.png";
    }
  }

  //proxy is like using filter before 3rd party library
  //proxy is caching results of a service
  //proxy is
  // manipulating/filtering/authorizing/caching
  // results of a servide
  class ProxyImage implements IImage {
    IImage realImage;
    String cacheImageName;
    ProxyImage(IImage realImage) {
      this.realImage = realImage;
    }
    @Override
    public String displayName() {
      if(cacheImageName == null)
        cacheImageName = displayName();
      if("random.png".equals(cacheImageName)
              || cacheImageName == null) {
        new InternalError("Unauthorized");
      }
      return cacheImageName;
    }
  }

  public static void main(String[] args) {
    ProxyDesignPattern obj = new ProxyDesignPattern();
    obj.execute();

  }

  private void execute() {
    IImage image = new RealImage();
    IImage proxyImage = new ProxyImage(image);
    proxyImage.displayName();
  }
}
