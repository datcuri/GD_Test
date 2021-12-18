package TestPart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DangnhapDao {
	Connection conn = null;
	
	public Connection connect(){
		try {
			String url = "jdbc:sqlserver://WINDOWS-9V3RQKK\\SQLEXPRESS:1433;databaseName=std2;user=sa;password=123456";
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
	
	public int getAccount(String Account, String Passwork){
		PreparedStatement sttm = null;
		ResultSet rs = null;
		int check = 0 ;
		try {
			String sSQL = "SELECT * FROM ACCOUNT WHERE ACCOUNT = ? AND PASSWORK = ? ";
			sttm = connect().prepareStatement(sSQL);
			sttm.setString(1, Account);
			sttm.setString(2, Passwork);
			rs = sttm.executeQuery();
			while (rs.next()){
				check++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error select " + e.toString());
		} finally {
			try {
				rs.close();
				sttm.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return check ;
		
	}
	public static void main(String[] args) {
		DangnhapDao dao = new DangnhapDao();
		System.out.println("=>" + dao.getAccount("abc", "123456")); 
	}
}
