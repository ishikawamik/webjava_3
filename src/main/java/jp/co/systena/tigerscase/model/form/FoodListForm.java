package jp.co.systena.tigerscase.model.form;

import java.util.List;
import javax.validation.Valid;
import jp.co.systena.tigerscase.model.service.Food;

public class FoodListForm {

  @Valid
  private List<Food> foodList;

  public List<Food> getFoodList() {
    return foodList;
  }

  public void setFoodList(List<Food> foodList) {
    this.foodList = foodList;
  }
}
