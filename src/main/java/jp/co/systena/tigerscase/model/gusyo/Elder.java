package jp.co.systena.tigerscase.model.gusyo;

import jp.co.systena.tigerscase.model.tyusho.Costomer;

public class Elder implements Costomer {
  //時間を返す
  public int eat() {
    return 5000;
  }

  //自分の名前を返す
  public String introduce() {
    return "50歳以上";
  }

}