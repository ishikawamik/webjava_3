package jp.co.systena.tigerscase.model.gusyo;

import jp.co.systena.tigerscase.model.tyusho.Chef;
import jp.co.systena.tigerscase.model.tyusho.MyName;

public class Cock implements Chef, MyName {
  //interface Chef
  //料理名を返す
  public String cook() {
    return "オードブル";
  }

  //interface NameInterface
  //自分の名前を返す
  public String introduce() {
    return "コック";
  }

}