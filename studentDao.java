package TestPart;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class studentDao {
	Connection conn = null ;

	// kết nối sql
	public Connection connect() {
		try {
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLSeverDriver").getConstructor().newInstance();;
			String url = "jdbc:sqlserver://WINDOWS-9V3RQKK\\SQLEXPRESS:1433;databaseName=std2;user=sa;password=123456";
			conn = DriverManager.getConnection(url);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();	
		} 
		return conn;
	}
	
	//thiet lap them du lieu
	public int insert(student st){

		PreparedStatement sttm = null;
		//Câu lệnh SQL
		String sSQL = "INSERT INTO students (NAME,AGE,PHONE,ADDRESS) VALUES (?,?,?,?)";
		try {
					
			sttm = connect().prepareStatement(sSQL);
			sttm.setString(1, st.getName());
			sttm.setInt(2, st.getAge());
			sttm.setString(3, st.getPhone());
			sttm.setString(4, st.getAddress());
			
			
			// Nếu thêm thành công
			if (sttm.executeUpdate() > 0){
				System.out.println("add thanh cong");
				return 1;
			}
			
		} catch (SQLException e) {
			// Nếu thêm thất bại
			System.out.println("Error insert " + st.toString());
		} finally {
			try {
				// Dóng SQL
				conn.close();
				sttm.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	public int update(student st){
		//Câu lệnh SQL
		PreparedStatement sttm = null;
		String sSQL = " UPDATE STUDENTS SET NAME = ?,  AGE = ? , PHONE = ?, ADDRESS = ? WHERE ID = ?";
		try {
					
			sttm = connect().prepareStatement(sSQL);
			sttm.setString(1, st.getName());
			sttm.setInt(2, st.getAge());
			sttm.setString(3, st.getPhone());
			sttm.setString(4, st.getAddress());
			sttm.setInt(5, st.getID());
			
			// Nếu thêm thành công
			if (sttm.executeUpdate() > 0){
				System.out.println("update thanh cong");
				return 1;
			}
			
		} catch (SQLException e) {
			// Nếu thêm thất bại
			System.out.println("Error update " + st.toString());
		} finally {
			try {
				// Dóng SQL
				conn.close();
				sttm.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	public int delete(int ID){
		//Câu lệnh SQL
		PreparedStatement sttm = null;
		String sSQL = "DELETE STUDENTS WHERE ID = ?";
		try {
					
			sttm = connect().prepareStatement(sSQL);
			sttm.setInt(1, ID);

			// Nếu thêm thành công
			if (sttm.executeUpdate() > 0){
				System.out.println("update thanh cong");
				return 1;
			}
			
		} catch (SQLException e) {
			// Nếu thêm thất bại
			System.out.println("Error delete from student where id ="+ ID);
		} finally {
			try {
				// Dóng SQL
				conn.close();
				sttm.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	
	public java.util.List<student> getAllStudent(){
		java.util.List<student> Lst = new ArrayList<student>();
		Statement sttm = null ;
		ResultSet rs = null;
		
		try {
			String sSQL = "SELECT ID,NAME,AGE,PHONE,ADDRESS FROM STUDENTS ORDER BY ID DESC ";
			sttm = connect().createStatement();
			rs = sttm.executeQuery(sSQL);
			while (rs.next()){
				student st = new student();
				st.setID(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setAge(rs.getInt(3));
				st.setPhone(rs.getString(4));
				st.setAddress(rs.getString(5));
				Lst.add(st);
			}
		} catch (Exception e) {
			System.out.println("Error update " + e.toString());
		} finally {
			try {
				rs.close();
				sttm.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return Lst;
	}
	
	public student getStudentbyID(int ID){
		PreparedStatement sttm = null ;
		ResultSet rs = null;
		student st = new student();
		try {
			String sSQL = "SELECT ID,NAME,AGE,PHONE,ADDRESS FROM STUDENTS WHERE ID = ? ";
			sttm = connect().prepareStatement(sSQL);
			sttm.setInt(1, ID);
			rs = sttm.executeQuery();
			while (rs.next()){
				st.setID(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setAge(rs.getInt(3));
				st.setPhone(rs.getString(4));
				st.setAddress(rs.getString(5));
				return st;
			}
		} catch (Exception e) {
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
		return null;
	}
	
	public static void main(String[] args) {

		// Test
		studentDao dao = new studentDao();
		student st = new student(0,"96",30,"56265","quang tri");
		dao.insert(st);
		//dao.update(st);
		//dao.delete(2);
		System.out.println("=>" + dao.getStudentbyID(4)); 
		
	}

}
