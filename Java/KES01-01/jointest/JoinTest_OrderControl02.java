package jointest;

import java.util.ArrayList;

import dao.CustomerSearchDBAccess;
import model.Customer;

//結合番号2 ドライバクラス
public class JoinTest_OrderControl02 {
	public static void main(String[] args) throws Exception {

	ArrayList<Customer> list = new ArrayList<Customer>();
	CustomerSearchDBAccess dao = new CustomerSearchDBAccess();

	ArrayList<Customer> list1 = dao.searchCustomerByTel("09034567812");
	System.out.println("size: " + list1.size() + "   CUSTID: " + list1.get(0).getCustId());
	System.out.println("------------------------------");

	ArrayList<Customer> list2 = dao.searchCustomerByKana("アオキマユミ");
	System.out.println("size: " + list2.size() + "   CUSTID: " + list2.get(0).getCustId());
	System.out.println("------------------------------");

	ArrayList<Customer> list3 = dao.searchCustomer("09078123456", "ナカムラマイ");
	System.out.println("size: " + list3.size() + "   CUSTID: " + list3.get(0).getCustId());
	System.out.println("------------------------------");
	}
}
