package jp.co.systena.tigerscase.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jp.co.systena.tigerscase.model.form.ItemListForm;
import jp.co.systena.tigerscase.model.service.FoodService;
import jp.co.systena.tigerscase.model.service.Item;

@Controller // Viewあり。Viewを返却するアノテーション
public class FoodListController {

  @Autowired
  private FoodService foodService;

  //画面に一覧表示
  @RequestMapping(value = "/food", method = RequestMethod.GET) // URLとのマッピング
  public String index(Model model) {
    model.addAttribute("items", foodService.getItemList());

    return "food";
  }

  //更新ボタン押下
  @RequestMapping(value = "/food", method = RequestMethod.POST) // URLとのマッピング
  public String update(@Valid ItemListForm listForm,
      BindingResult result, Model model) {
    model = foodService.update(listForm, result, model);

    return "food";
  }

  //削除リンク押下
  @RequestMapping(value = "/deleteitem", method = RequestMethod.GET) // URLとのマッピング
  public String update(@RequestParam(name = "item_id", required = true)
      String itemId, Model model) {
    model = foodService.update(itemId, model);
    model.addAttribute("item_id", itemId);

    return "redirect:/food";
  }

  //登録ボタン押下
  @RequestMapping(value = "/additem", method = RequestMethod.POST) // URLとのマッピング
  public String insert(@Valid Item form,
                        BindingResult result, Model model) {
    model = foodService.insert(form, result, model);

    return "redirect:/food";
  }
}