package jp.co.systena.tigerscase.model.service;

import javax.validation.constraints.Pattern;

public class Food {

  @Pattern(regexp="^[0-9]*$")
  private String itemId;
  public String getItemId() {
    return itemId;
  }
  public void setItemId(String itemId) {
    this.itemId = itemId;
  }
  public String getItemName() {
    return itemName;
  }
  public void setItemName(String itemName) {
    this.itemName = itemName;
  }
  public String getPrice() {
    return price;
  }
  public void setPrice(String price) {
    this.price = price;
  }
  private String itemName;
  @Pattern(regexp="^[0-9]*$")
  private String price;
}
