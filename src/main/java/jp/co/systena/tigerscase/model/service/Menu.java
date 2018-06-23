package jp.co.systena.tigerscase.model.service;

public class Menu {
  private String cooking;    //料理名
  private int price;        //値段
  private int speed;        //時間

  public Menu (String cooking, int price, int speed) {
    setCooking(cooking);
    setPrice(price);
    setSpeed(speed);
  }

  public String getCooking() {
    return cooking;
  }
  public void setCooking(String cooking) {
    this.cooking = cooking;
  }

  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }

  public int getSpeed() {
    return speed;
  }
  public void setSpeed(int speed) {
    this.speed = speed;
  }

}
