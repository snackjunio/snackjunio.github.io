package unittest;
import java.util.ArrayList;

import dao.OrderConfirmDBAccess;
import model.OrderDetail;
public class UnitTest_OrderControl2_6 {

	public static void main(String[] args) {
		OrderConfirmDBAccess oDB = new OrderConfirmDBAccess();
		try {
			ArrayList<OrderDetail> list = oDB.searchOrderByCustId(1);
			System.out.println(list.size());
			System.out.println(list.get(1).getNo());
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		try {
			ArrayList<OrderDetail> list = oDB.searchOrderByCustId(0);
			System.out.println(list.size());
			System.out.println(list.get(1).getNo());
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}


	}

}
