/**
 * クラス名：UnitTest_OrderControl04
 * 概要　　：KiddalaController単体テスト
 * 作成者名：エー チャン ス
 * 作成日　：2018/11/13(火)
 * 修正者名：エー チャン ス
 * 修正日　：2018/11/()
 */
package unittest;

import control.KiddaLaController;

public class UnitTest_OrderControl04 {
	//単体番号4 searchCustomer()メソッド ドライバクラス

	public static void main(String[] args) {

		try {
			String[] data1 = {"08012345678",""};
			String[][] list1 = KiddaLaController.customerSearch(data1);
			System.out.println("CUSTID:"+list1[0][0] + "   " +"CUSTNAME:"+ list1[0][1]);
			System.out.println("----------------------");

			String[] data2 = {"","ワタナベカナコ"};
			String[][] list2 = KiddaLaController.customerSearch(data2);
			System.out.println("CUSTID:"+list2[0][0] + "   " +"CUSTNAME:"+ list2[0][1]);
			System.out.println("---------------------------");

			String[] data3 = {"09012345678","アオキマユミ"};
			String[][] list3 = KiddaLaController.customerSearch(data3);
			System.out.println("CUSTID:"+list3[0][0] + "   " + "CUSTNAME:"+list3[0][1]);
			System.out.println("---------------------------");

			String[] data4= {"09034567812",""};
			String[][] list4 = KiddaLaController.customerSearch(data4);
			System.out.println("null");
			System.out.println("---------------------------");

			String[] data5 = {"","サインサイン"};
			String[][] list5 = KiddaLaController.customerSearch(data5);
			System.out.println("null");
			System.out.println("---------------------------");

			String[] data6 = {"",""};
			String[][] list6 = KiddaLaController.customerSearch(data6);
			System.out.println("null");
			System.out.println("---------------------------");

			String[] data7 = {"09012345678","アオキマユミ"};
			String[][] list7 = KiddaLaController.customerSearch(data7);
			System.out.println("テスト失敗");

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}