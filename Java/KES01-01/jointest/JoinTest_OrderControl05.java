package jointest;

import action.CustomerSearchAction;

public class JoinTest_OrderControl05 {
	public static void main(String[] args) throws Exception {
		CustomerSearchAction csa = new CustomerSearchAction();
		String[] data = {"","アオキマユミ"};
		String[][] tableData = csa.execute(data);

		System.out.println("項番１〜２");
		System.out.println(tableData[0][0]);
		System.out.println(tableData[0][1]);
		System.out.println(tableData[0][2]);
		System.out.println(tableData[0][3]);
	}

}
