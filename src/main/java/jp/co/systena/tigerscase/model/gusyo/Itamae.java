package jp.co.systena.tigerscase.model.gusyo;

import jp.co.systena.tigerscase.model.tyusho.Chef;

public class Itamae implements Chef {
  //料理名を返す
  public String cook() {
    return "寿司";
  }

  //自分の名前を返す
  public String introduce() {
    return "板前";
  }

}