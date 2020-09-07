/**
 * クラス名：	UnitTest_OrderControl2_8
 * 概要　　：
 * 作成者名：ヒエプ
 * 作成日　：2019/1/16(水)
 * 修正者名：
 * 修正日　：
 */
package unittest;
import dao.TaxSearchDBAccess;
import model.Tax;
public class UnitTest_OrderControl2_8 {
	public static void main(String[] args) {
		TaxSearchDBAccess tDB = new TaxSearchDBAccess();
		Tax list1= null;
		try {
			list1 = tDB.searchCurrentTax();
			System.out.println("TaxID:"+list1.getTaxId());
			System.out.println("Rate:"+list1.getRate());
			System.out.println("EndDate:"+list1.getEndDate());

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
