/**
 * クラス名：	UnitTest_OrderControl2_5
 * 概要　　：
 * 作成者名：ヒエプ
 * 作成日　：2019/1/16(水)
 * 修正者名：
 * 修正日　：
 */
package unittest;
import java.util.ArrayList;

import dao.ItemMenuDisplayDBAccess;
import model.Item;
public class UnitTest_OrderControl2_5 {
	public static void main(String[] args) {
		ItemMenuDisplayDBAccess itDB = new ItemMenuDisplayDBAccess();
		try {
			ArrayList<Item> list = itDB.searchAllItem();
			System.out.println(list.size());
			System.out.println("----------------------");
			for(int i=0; i<list.size();i++) {
				System.out.println(list.get(i).getItemId());
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
