/**
 * クラス名：CustomerSerchDBAccess
 * 概要　　：KIDDA_LAデータベースへのアクセス(顧客情報)を管理する。
 * 作成者名：大村乃々華
 * 作成日　：2018/11/8(木)
 * 修正者名：大村乃々華
 * 修正日　：2018/11/9(金)
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;

public class CustomerSearchDBAccess {
	//KIDDA_LAデータベースとの接続を確立する。
	private Connection createConnection() throws Exception {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://root@localhost/KIDDA_LA", "", "");
			//		con = DriverManager.getConnection("jdbc:mysql://localhost:65534/KIDDA_LA", "user1", "pass1");
		} catch (SQLException e) {
			throw new SQLException("DB接続時にエラーが発生しました！");
		}
		return con;
	}
	//KIDDA_LAデータベースとの接続を切断する。
	private void closeConnection(Connection con) throws Exception {
		try{
			if(con != null) 	con.close();
		} catch(SQLException e) {
			System.out.println("DB切断時にエラーが発生しました。");
			e.printStackTrace();
		}
	}
	//電話番号のみの検索。
	public ArrayList<Customer> searchCustomerByTel(String tel) throws Exception {
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();
		if(con != null) {
			String sql = 	"SELECT CUSTID, CUSTNAME, KANA, ADDRESS " +
					"FROM CUSTOMER " +
					"WHERE TEL = '" + tel + "' ;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next() == true) {
				int CUSTID = rs.getInt("CUSTID");
				String CUSTNAME = rs.getString("CUSTNAME");
				String KANA = rs.getString("KANA");
				String ADDRESS = rs.getString("ADDRESS");
				Customer customer = new Customer(CUSTID, CUSTNAME, KANA, tel, ADDRESS);
				list.add(customer);
			}
		}
		closeConnection(con);
		return list;
	}
	//名前のみの検索。
	public ArrayList<Customer> searchCustomerByKana(String kana) throws Exception {
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();
		if(con != null) {
			String sql = 	"SELECT CUSTID, CUSTNAME, KANA, TEL, ADDRESS " +
					"FROM CUSTOMER " +
					"WHERE KANA LIKE '%" + kana + "%' ;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next() == true) {
				int CUSTID = rs.getInt("CUSTID");
				String CUSTNAME = rs.getString("CUSTNAME");
				String KANA = rs.getString("KANA");
				String TEL = rs.getString("TEL");
				String ADDRESS = rs.getString("ADDRESS");
				Customer customer = new Customer(CUSTID, CUSTNAME, KANA, TEL, ADDRESS);
				list.add(customer);
			}
		}
		closeConnection(con);
		return list;
	}
	//電話番号と名前の検索。
	public ArrayList<Customer> searchCustomer(String tel, String kana) throws Exception {
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();
		if(con != null) {
			String sql = 	"SELECT CUSTID, CUSTNAME, KANA, ADDRESS " +
					"FROM CUSTOMER " +
					"WHERE TEL = '" + tel + "' AND KANA LIKE '%" + kana + "%' ;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next() == true) {
				int CUSTID = rs.getInt("CUSTID");
				String CUSTNAME = rs.getString("CUSTNAME");
				String KANA = rs.getString("KANA");
				String ADDRESS = rs.getString("ADDRESS");
				Customer customer = new Customer(CUSTID, CUSTNAME, KANA, tel, ADDRESS);
				list.add(customer);
			}
		}
		closeConnection(con);
		return list;
	}
}