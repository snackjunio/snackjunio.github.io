/**
 * クラス名：	ControlDBAccess
 * 概要　　：	データベースとの接続切断の管理
 * 作成者名：佐々木　智也
 * 作成日　：２０１９年１月９日
 * 修正者名：
 * 修正日　：
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControlDBAccess {


protected Connection createConnection()throws Exception{
	Connection con = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://root@localhost/KIDDA_LA", "", "");
	}catch(ClassNotFoundException e) {
		throw new Exception("DB接続処理に失敗しました！");
	}catch(SQLException e) {
		throw new Exception("Db接続処理に失敗しました！");
	}
	return con;
}

protected void closeConnection(Connection con)throws Exception{
	try {
		if(con != null) {
			con.close();
		}
	}catch(SQLException e ) {
		throw new Exception("DB接続処理に失敗しました！ ");
}
	}
}
