package jp.co.systena.tigerscase.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscase.model.form.PurchaseForm;
import jp.co.systena.tigerscase.model.service.Cart;
import jp.co.systena.tigerscase.model.service.Purchase;

@Controller
public class PurchaseController extends BaseController {
  @RequestMapping(value = "/purchase", method = RequestMethod.GET)
  public ModelAndView show(ModelAndView mav) {

    //合計金額を設定
    Cart cart = getCartFromSession();
    int totalPrice = cart.getTotalPrice();
    mav.addObject("totalPrice", totalPrice);

    //合計時間を設定
    int totalSpeed = cart.getTotalSpeed();
    mav.addObject("totalSpeed", totalSpeed);

    //購入履歴を設定
    List<Purchase> list = cart.getPurchaseList();
    mav.addObject("list", list);

    mav.addObject("purchaseForm", new PurchaseForm());
    return mav;
  }

  @RequestMapping(value = "/purchase", method = RequestMethod.POST)
  private ModelAndView remove(@Valid PurchaseForm purchaseForm) {

    //履歴を削除
    Cart cart = getCartFromSession();
    cart.clear();
    setCartFromSession(cart);

    return new ModelAndView("redirect:/purchase");
  }
}