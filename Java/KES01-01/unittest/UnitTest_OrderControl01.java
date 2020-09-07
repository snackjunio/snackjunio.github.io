/**
 * クラス名： UnitTest_OrderControl01
 * 概要　　：単体テストでのドライバ
 * 作成者名：佐々木智也
 * 作成日　：１１月１３日
 * 修正者名：
 * 修正日　：
 */
package unittest;
import model.Customer;
public class UnitTest_OrderControl01 {
	public static void main(String[] args) {
		Customer ct1 = new Customer(1,"青木まゆみ","アオキマユミ","09012345678","東京都千代田区"
		+ "神田小川町１−１−１");
		Customer ct2 = new Customer(0,null,null,null,null);

			System.out.println("CUSTID:   " + ct1.getCustId());
			System.out.println("CUSTNAME:   " + ct1.getCustName());
			System.out.println("KANA:   " + ct1.getKana());
			System.out.println("TEL:   " + ct1.getTel());
			System.out.println("ADDRESS:   " + ct1.getAddress());
			System.out.println("引数の値が属性に記録されている");
			System.out.println("-------------------------");

			System.out.println("CUSTID:   " + ct2.getCustId());
			ct2.setCustName(null);
			System.out.println("CUSTNAME:   " + ct2.getCustName());
			ct2.setKana(null);
			System.out.println("KANA:   " + ct2.getKana());
			ct2.setTel(null);
			System.out.println("TEL:   " + ct2.getTel());
			ct2.setAddress(null);
			System.out.println("ADDRESS:   " + ct2.getAddress());
			System.out.println("引数の値が属性に記録されている");
			System.out.println("-------------------------");

			ct1.setCustId(2);
			System.out.println("CUSTID:   " + ct1.getCustId());
			ct1.setCustName("伊藤華絵");
			System.out.println("CUSTNAME:   " + ct1.getCustName());
			ct1.setKana("KANA:   " + "イトウハナエ");
			System.out.println(ct1.getKana());
			ct1.setTel("TEL:   " + "09023456781");
			System.out.println(ct1.getTel());
			ct1.setAddress("ADDRESS:   " + "東京都千代田区神田小川町２−１−１");
			System.out.println(ct1.getAddress());
			System.out.println("引数の値が属性に記録されている");
			System.out.println("-------------------------");

			ct2.setCustId(0);
			System.out.println("CUSTID:   " + ct2.getCustId());
			ct2.setCustName(null);
			System.out.println("CUSTNAME:   " + ct2.getCustName());
			ct2.setKana(null);
			System.out.println("KANA:   " + ct2.getKana());
			ct2.setTel(null);
			System.out.println("TEL:   " + ct2.getTel());
			ct2.setAddress(null);
			System.out.println("ADDRESS:   " + ct2.getAddress());
			System.out.println("引数の値が属性に記録されている");
			System.out.println("-------------------------");

	}
}