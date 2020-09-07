package jointest;

import action.CustomerSearchAction;

//結合番号6 ドライバクラス
public class JoinTest_OrderControl06 {

	public static void main(String[] args) throws Exception {

		CustomerSearchAction act = new CustomerSearchAction();

		String[] data1 = {"09023456781",""};
		String[][] list1 = act.execute(data1);
		System.out.println("CUSTID:"+list1[0][0] + "   " +"CUSTNAME:"+ list1[0][1]);
		System.out.println("----------------------");

		String[] data2 = {"","スズキヒロシ"};
		String[][] list2 =act.execute(data2);
		System.out.println("CUSTID:"+list2[0][0] + "   " +"CUSTNAME:"+ list2[0][1]);
		System.out.println("---------------------------");

		String[] data3 = {"0314142135","セトダイヤ"};
		String[][] list3 = act.execute(data3);
		System.out.println("CUSTID:"+list3[0][0] + "   " + "CUSTNAME:"+list3[0][1]);
		System.out.println("---------------------------");
	}

}
