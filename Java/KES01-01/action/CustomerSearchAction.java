/**
 * クラス名：	CustomerModifyAction
 * 概要　　：	顧客情報変更アクション
 * 作成者名：ヒエプ
 * 作成日　：１１月８日
 * 修正者名：ヒエプ
 * 修正日　：１１月９日
 */
package action;
import java.util.ArrayList;

import dao.CustomerSearchDBAccess;
import model.Customer;
import model.OrderControlUtility;

public class CustomerSearchAction {
	public String[][] execute(String[] data) throws Exception {
		CustomerSearchDBAccess sdb = new CustomerSearchDBAccess();
		ArrayList<Customer> list = new ArrayList<>();
		//半数スペースと全数スペースを取り除く
		data[0] = data[0].replaceAll(" ", "").replaceAll("　", "");
		data[1] = data[1].replaceAll(" ", "").replaceAll("　", "");
		//条件分を行う
		if(!(data[0].equals("")) && data[1].equals("")) {
			list = sdb.searchCustomerByTel(data[0]);
		}
		if(data[0].equals("") && !(data[1].equals(""))) {
			list = sdb.searchCustomerByKana(data[1]);
		}
		if(!(data[0].equals("")) && !(data[1].equals(""))) {
			list = sdb.searchCustomer(data[0],data[1]);
		}
		if(data[0].equals("") && data[1].equals("")) {
			return null;
		}
		//顧客情報リストを検索結果表示用データに変換する
		String[][] tabledata = null;
		if(list.size() == 0)	return tabledata;
		tabledata = OrderControlUtility.customerToArray(list);
		//検索結果表示用データを
		return tabledata;
	}
}
