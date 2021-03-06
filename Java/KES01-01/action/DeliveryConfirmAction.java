/**
 * クラス名：	DeliveryConfirmAction
 * 概要　　：	配達情報確認アクション
 * 作成者名：チャン
 * 作成日　：2019/1/9（水）
 * 修正者名：チャン
 * 修正日　：
 */

package action;
import java.util.ArrayList;

import dao.DeliveryConfirmDBAccess;
import model.OrderDetail;


public class DeliveryConfirmAction {

	public ArrayList<OrderDetail> execute(String custId) throws Exception{

		int intCustId = Integer.parseInt(custId);
		DeliveryConfirmDBAccess dc = new DeliveryConfirmDBAccess();

		ArrayList<OrderDetail> list = new ArrayList<OrderDetail>();
		list = dc.searchDeliveryByCustId(intCustId);

		return list;
	}
}
