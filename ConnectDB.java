package TestPart;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class ConnectDB {
	Connection conn ;
	Statement stmt;
	public void connect() {
		try {
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLSeverDriver").getConstructor().newInstance();;
			String url = "jdbc:sqlserver://WINDOWS-9V3RQKK\\SQLEXPRESS:1433;databaseName=std2;user=sa;password=123456";
			conn = DriverManager.getConnection(url);
			System.out.println("Connected.....");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
	}
	public int executeBD(String sql) {
	int record=0;
	try {
		connect();
		stmt = conn.createStatement();
		record = stmt.executeUpdate(sql);		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		try {
			conn.close();
			stmt.close();
		} catch (Exception e2){
			e2.printStackTrace();
		}
	}
	return record;
}

}	

