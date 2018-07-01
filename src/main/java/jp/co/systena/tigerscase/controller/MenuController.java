package jp.co.systena.tigerscase.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscase.model.form.MenuForm;
import jp.co.systena.tigerscase.model.gusyo.Cock;
import jp.co.systena.tigerscase.model.gusyo.Elder;
import jp.co.systena.tigerscase.model.gusyo.Itamae;
import jp.co.systena.tigerscase.model.gusyo.Younger;
import jp.co.systena.tigerscase.model.service.Cart;
import jp.co.systena.tigerscase.model.service.FoodService;
import jp.co.systena.tigerscase.model.service.Menu;
import jp.co.systena.tigerscase.model.service.MenuService;
import jp.co.systena.tigerscase.model.service.Purchase;
import jp.co.systena.tigerscase.model.tyusho.Chef;
import jp.co.systena.tigerscase.model.tyusho.Costomer;

@Controller
public class MenuController extends BaseController{

  private Younger younger = new Younger();
  private Elder elder = new Elder();
  private Cock cock = new Cock();
  private Itamae itamae = new Itamae();

  private MenuService menuService;

  @Autowired
  private FoodService foodService;

  @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public ModelAndView show(ModelAndView mav) {


    mav.addObject("costomerList", menuService.getCostomer());
    mav.addObject("chefList", menuService.getChef());

    //メニュー表に選択する項目名を設定
    mav.addObject("youngerName", talkName(younger));
    mav.addObject("elderName", talkName(elder));
    mav.addObject("cockName", talkName(cock));
    mav.addObject("itamaeName", talkName(itamae));

    mav.addObject("foods", foodService.getFoodList());

    //セッションから選択に合わせたメッセージを設定
    String message = getMessageFromSession();
    removeMessageFromSession();
    mav.addObject("message", message);

    //セッションから購入の回数を設定
    Cart cart = getCartFromSession();
    mav.addObject("purchaseNum", cart.getNum());

    //フォームを設定
    mav.addObject("menuForm", new MenuForm());
    return mav;
  }

  @RequestMapping(value = "/menu", method = RequestMethod.POST)
  private ModelAndView order(
      @Valid MenuForm menuForm) {

    //選択に合わせたメッセージ
    StringBuilder orderMessage = new StringBuilder();

    //選択したお客
    String selectedCostomer = menuForm.getSelectedCostomer();

    //選択したお客に合わせた速さをメッセージに収納
    int speed = 0;
    if (selectedCostomer.equals(talkName(younger))) {
      //若い人の場合
      speed = talkSpeed(younger);
      orderMessage.append(speed);
    } else if (selectedCostomer.equals(talkName(elder))) {
      //年配の人の場合
      speed = talkSpeed(elder);
      orderMessage.append(speed);
    } else {
      orderMessage.append(speed);
    }
    orderMessage.append("秒で");

    //選択した食材をメッセージに収納
    String foodDB = menuForm.getSelectedFoodDB();
    String foodName = foodService.getSelectFoodName(foodDB);
    int price = foodService.getSelectPrice(foodDB);
    orderMessage.append(foodName);
    orderMessage.append("の");

    //選択したシェフ
    String selectedChef = menuForm.getSelectedChef();

    //選択したシェフに合わせた料理をメッセージに収納
    String cooking = "おまかせ";
    if (selectedChef.equals(talkName(cock))) {
      cooking = talkCooking(cock);
      //コックの場合
      orderMessage.append(cooking);
    } else if (selectedChef.equals(talkName(itamae))) {
      //板前の場合
      cooking = talkCooking(itamae);
      orderMessage.append(cooking);
    } else {
      orderMessage.append(cooking);
    }
    orderMessage.append("を承りました。");

    //メッセージをセッションに保存
    setMessageFromSession(orderMessage.toString());

    //購入をセッションに保存
    Menu menu = new Menu(cooking, price , speed);
    Purchase purchase = new Purchase(menu, 1);
    Cart cart = getCartFromSession();
    cart.addNum(purchase);
    setCartFromSession(cart);

    return new ModelAndView("redirect:/menu");
  }


  //お客の名前を返す
  public String talkName(Costomer co) {
    return co.introduce();
  }
  //シェフの名前を返す
  public String talkName(Chef ch) {
    return ch.introduce();
  }

  //お客の速さを返す
  public int talkSpeed(Costomer co) {
    return co.eat();
  }

  //シェフの料理名を返す
  public String talkCooking(Chef ch) {
    return ch.cook();
  }

}