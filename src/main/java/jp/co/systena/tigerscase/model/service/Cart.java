package jp.co.systena.tigerscase.model.service;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  private List<Purchase> purchaseList = new ArrayList<Purchase>();

  public List<Purchase> getPurchaseList(){
    return this.purchaseList;
  }
  public void setPurchaseList(List<Purchase> purchaseList) {
    this.purchaseList = purchaseList;
  }

  //購入回数をゲットする
  public int getNum() {
    int purchaseNum = 0;

    for(Purchase purchase : purchaseList) {
      purchaseNum += purchase.getNum();
    }
    return purchaseNum;
  }

  //合計金額を計算する
  public int getTotalPrice() {
    int totalPrice = 0;

    for(Purchase purchase : purchaseList) {
      totalPrice += (purchase.getMenu().getPrice() * purchase.getNum());
    }
    return totalPrice;
  }

  //合計時間を計算する
  public int getTotalSpeed() {
    int totalSpeed = 0;

    for(Purchase purchase : purchaseList) {
      totalSpeed += (purchase.getMenu().getSpeed() * purchase.getNum());
    }
    return totalSpeed;
  }

  //合計購入回数を計算する
  public int getTotalNum() {
    int totalNum = 0;

    for(Purchase purchase : purchaseList) {
      totalNum += purchase.getNum();
    }
    return totalNum;
  }

  //購入回数を追加する
  public void addNum(Purchase purchase) {
    purchaseList.add(purchase);
  }

  //購入履歴を削除
  public void clear() {
    purchaseList.clear();
  }
}
