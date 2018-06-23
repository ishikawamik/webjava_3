package jp.co.systena.tigerscase.model.form;

public class MenuForm {
  private String selectedCostomer;
  private String selectedFood;
  private String selectedChef;
  private String selectedFoodDB;

  public String getSelectedCostomer() {
    return selectedCostomer;
  }
  public void setSelectedCostomer(String selectedCostomer) {
    this.selectedCostomer = selectedCostomer;
  }

  public String getSelectedFood() {
    return selectedFood;
  }
  public void setSelectedFood(String selectedFood) {
    this.selectedFood = selectedFood;
  }

  public String getSelectedChef() {
    return selectedChef;
  }
  public void setSelectedChef(String selectedChef) {
    this.selectedChef = selectedChef;
  }
  public String getSelectedFoodDB() {
    return selectedFoodDB;
  }
  public void setSelectedFoodDB(String selectedFoodDB) {
    this.selectedFoodDB = selectedFoodDB;
  }

}