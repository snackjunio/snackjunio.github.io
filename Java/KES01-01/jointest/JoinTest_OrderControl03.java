/**
 * クラス名：CustomerSerchDBAccess
 * 概要　　：結合テスト
 * 作成者名：ヒエプ
 * 作成日　：2018/11/13(火)
 * 修正者名：
 * 修正日　：
 */
package jointest;
import action.CustomerSearchAction;
/**
 * @author suginami
 *
 */
public class JoinTest_OrderControl03 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		CustomerSearchAction act = new CustomerSearchAction();
		try {
			String[] data1= {"09012345678",""};
			String[][] list1=act.execute(data1);
			System.out.println("CUSTID:\t"+list1[0][0]+"\t"+"CUSTNAME:\t"+list1[0][1]);
			
			String[] data2= {"","タカハシミホ"};
			String[][] list2=act.execute(data2);
			System.out.println("CUSTID:\t"+list2[0][0]+"\t"+"CUSTNAME:\t"+list2[0][1]);
			
			String[] data3= {"09081234567","ハギワラトモコ"};
			String[][] list3=act.execute(data3);
			System.out.println("CUSTID:\t"+list3[0][0]+"\t"+"CUSTNAME:\t"+list3[0][1]);
		
			}catch(Exception e) {
				e.printStackTrace();
		}
	}

}
