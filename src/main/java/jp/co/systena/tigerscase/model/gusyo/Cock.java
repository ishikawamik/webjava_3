package jp.co.systena.tigerscase.model.gusyo;

import jp.co.systena.tigerscase.model.tyusho.Chef;

public class Cock implements Chef {
  //料理名を返す
  public String cook() {
    return "オードブル";
  }

  //自分の名前を返す
  public String introduce() {
    return "コック";
  }

}