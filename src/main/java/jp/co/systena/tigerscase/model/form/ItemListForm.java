package jp.co.systena.tigerscase.model.form;

import java.util.List;
import javax.validation.Valid;
import jp.co.systena.tigerscase.model.service.Item;

public class ItemListForm {

  @Valid
  private List<Item> itemList;

  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }
}
