package jp.co.systena.tigerscase.model.service;

public class Purchase {
  private Menu menu;
  private int num;

  public Purchase(Menu menu, int num) {
    setMenu(menu);
    setNum(num);
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
  }

}
