/**
 * クラス名：UnitTest_OrderControl03
 * 概要　　：CustomerSearchAction単体テスト
 * 作成者名：ヒエプ
 * 作成日　：2018/11/13(火)
 * 修正者名：
 * 修正日　：
 */
package unittest;

import action.CustomerSearchAction;

public class UnitTest_OrderControl03 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		CustomerSearchAction act = new CustomerSearchAction();
		try {
			String[] data1= {"09012345678",""};
			String[][] list1=act.execute(data1);
			System.out.println("CUSTID:\t"+list1[0][0]+"\t"+"CUSTNAME:\t"+list1[0][1]);
			System.out.println("-------------------------------------");

			String[] data2= {"","タカハシミホ"};
			String[][] list2=act.execute(data2);
			System.out.println("CUSTID:\t"+list2[0][0]+"\t"+"CUSTNAME:\t"+list2[0][1]);
			System.out.println("-------------------------------------");

			String[] data3= {"09081234567","ハギワラトモコ"};
			String[][] list3=act.execute(data3);
			System.out.println("CUSTID:\t"+list3[0][0]+"\t"+"CUSTNAME:\t"+list3[0][1]);
			System.out.println("-------------------------------------");

			String[] data4= {"01012345678",""};
			String[][] list4=act.execute(data4);
			System.out.println("null");
			System.out.println("-------------------------------------");

			String[] data5= {"","ナカムラハナコ"};
			String[][] list5=act.execute(data5);
			System.out.println("null");
			System.out.println("-------------------------------------");

			String[] data6= {"",""};
			String[][] list6=act.execute(data6);
			System.out.println("null");
			System.out.println("-------------------------------------");

			String[] data7= {"09012345678",""};
			String[][] list7=act.execute(data7);
			System.out.println("テスト失敗");
			System.out.println("-------------------------------------");

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
