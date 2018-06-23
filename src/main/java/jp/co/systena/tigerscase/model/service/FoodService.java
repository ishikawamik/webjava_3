package jp.co.systena.tigerscase.model.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jp.co.systena.tigerscase.model.form.ItemListForm;

@Service
public class FoodService {

  @Autowired
  JdbcTemplate jdbcTemplate;

  /**
   * データベースからアイテムデータ一覧を取得する
   *
   * @return
   */
  public List<Item> getItemList() {

    //SELECTを使用してテーブルの情報をすべて取得する
    List<Item> list = jdbcTemplate.query("SELECT * FROM items ORDER BY item_id", new BeanPropertyRowMapper<Item>(Item.class));

    return list;
  }

  //itemIDをキーに商品名を取り出す
  public String getSelectItemName(String itemId) {

    List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM items WHERE item_id = ?",
        Integer.parseInt(itemId));

    for(Map<String, Object> map : list) {
      return map.get("item_name").toString();
    }

    return null;
  }

  //itemIDをキーに価格を取り出す
  public int getSelectPrice(String itemId) {

    List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM items WHERE item_id = ?",
        Integer.parseInt(itemId));

    for(Map<String, Object> map : list) {
      return (int) map.get("price");
    }

    return 0;
  }

  /**
   * 「更新」ボタン押下時の処理
   *
   * 入力された名前と価格をアイテムIDをキーとして更新する
   *
   * @param listForm
   * @param result
   * @param model
   * @return
   */

  public Model update(ItemListForm listForm,
                        BindingResult result,
                        Model model) {

    // listFormに画面で入力したデータが入っているので取得する
    List<Item> itemList = listForm.getItemList();
    // ビューに受け渡し用にmodelにセット
    model.addAttribute("items", itemList);
    model.addAttribute("listForm", listForm);


    //画面入力値にエラーがない場合
    if (!result.hasErrors()) {
      if (itemList != null) {
        //画面入力値1行ずつ処理をする
        for (Item item : itemList) {

          //1行分の値でデータベースをUPDATEする
          //item_idをキーに名称と価格を更新する
          //SQL文字列中の「?」の部分に、後ろで指定した変数が埋め込まれる
          int updateCount = jdbcTemplate.update(
              "UPDATE items SET item_name = ?, price = ? WHERE item_id = ?",
              item.getItemName(),
              Integer.parseInt(item.getPrice()),
              Integer.parseInt(item.getItemId()));
        }
      }
    }

    return model;

  }

  /**
   * 「削除」リンク押下時の処理
   *
   * パラメータで受け取ったアイテムIDのデータを削除する
   *
   * @param itemId
   * @param model
   * @return
   */
  public Model update(String itemId, Model model) {


    // 本来はここで入力チェックなど


    // パラメータで受けとったアイテムIDのデータを削除する
    // SQL文字列中の「?」の部分に、後ろで指定した変数が埋め込まれる
    int deleteCount = jdbcTemplate.update("DELETE FROM items WHERE item_id = ?",
        Integer.parseInt(itemId));


    return model;

  }

  public Model insert(Item form,
                        BindingResult result,
                        Model model) {

    //画面入力値にエラーがない場合
    if (!result.hasErrors()) {

          //1行分の値をデータベースにINSERTする
          //SQL文字列中の「?」の部分に、後ろで指定した変数が埋め込まれる
          int insertCount = jdbcTemplate.update(
                "INSERT INTO items VALUES( ?, ?, ? )",
                Integer.parseInt(form.getItemId()),
                form.getItemName(),
                Integer.parseInt(form.getPrice())
              );

    }

    return model;

  }


}