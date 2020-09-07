/**
 * クラス名：	UnitTest_OrderControl2_9
 * 概要　　：
 * 作成者名：ヒエプ
 * 作成日　：2019/1/16(水)
 * 修正者名：
 * 修正日　：
 */
package unittest;
import action.ItemMenuDisplayAction;
public class UnitTest_OrderControl2_9 {

	public static void main(String[] args) {
		ItemMenuDisplayAction act = new ItemMenuDisplayAction();
		try {
			String[] data = {"",""};
			String [][] list = act.execute();
			System.out.println("ITEMID:\t"+list[0][0]+"		"+"ITEMNAME:\t"+list[0][1]);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
