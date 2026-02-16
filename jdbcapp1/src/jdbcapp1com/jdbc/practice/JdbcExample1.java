package jdbcapp1com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class JdbcExample1 {
//	static {
//		try {//this part is automatic
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	static Connection cn;
	static String url ="jdbc:mysql://localhost:3306/test";
	static String username="root";
	static String password="root";
	static PreparedStatement pst = null;
	static ResultSet rs =null;
	static String insertCommand = "INSERT INTO product VALUES(?,?,?)";
	static String selectCommand = "SELECT * FROM product";
	static String updateCommand = "UPDATE product SET prodname =?,price=? WHERE prodcode=?";
	static String deleteCommand = "DELETE FROM product WHERE prodcode=?";
	public static void main(String[] args) {
		try {
			cn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			System.out.println("Exception caught-> "+e.getMessage());
		}
//		addRecord();
		showAllRecords();
//		updateRecord();
//		deleteRecord();
		
	}
	public static void addRecord() {
		try {
			pst =cn.prepareStatement(insertCommand);
			pst.setInt(1, 101);
			pst.setString(2, "S25");
			pst.setDouble(3, 3000.00);
		    pst.executeUpdate();
			
		    //here onwards 2nd record
			pst.setInt(1, 102);
			pst.setString(2, "IPhone-16");
			pst.setDouble(3, 3300.00);
			pst.executeUpdate();
			
			//here onwards 3rd record
			pst.setInt(1, 103);
			pst.setString(2, "Airpods");
			pst.setDouble(3, 300.00);
			pst.executeUpdate();
			
			//here onwards 4th record
			pst.setInt(1, 104);
			pst.setString(2, "HeadSet");
			pst.setDouble(3, 1650.00);
			pst.executeUpdate();
			
			//here onwards 5th record
			pst.setInt(1, 105);
			pst.setString(2, "Laptop");
			pst.setDouble(3, 6000.00);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Exception caught add record method-> "+e.getMessage());
		}
		System.out.println("Records added successfully...");
	}
	public static void showAllRecords() {
		try {
			pst = cn.prepareStatement(selectCommand);
			rs = pst.executeQuery(selectCommand);
			while(rs.next()) {
				int prodcode =rs.getInt("prodcode");
				String prodname = rs.getString("prodname");
				double price = rs.getDouble("price");
				System.out.println(prodcode+" "+prodname+" "+price);
			}
		} catch (SQLException e) {
			System.out.println("Exception caught in select records..."+e.getMessage());
		}
	}
	public static void deleteRecord() {
		try {
			pst=cn.prepareStatement(deleteCommand);
			pst.setInt(1, 101);//first record with column index 1 deleted
			pst.executeUpdate();
			System.out.println("record deleted...");
		} catch (SQLException e) {
			System.out.println("Exception occured in deleteRecord "+e.getMessage());
			
		}
	}
	public static void updateRecord() {
		try {
			pst = cn.prepareStatement(updateCommand);
			pst.setString(1, "S25 new");//prodname, 1 is column index
			pst.setDouble(2, 4000.00);//price, 2 is column index
			pst.setInt(3,101);//where prodcode = 101,  3 is column index
			pst.executeUpdate();
			System.out.println("Records updated successfully...");
		} catch (SQLException e) {
			System.out.println("Exception caught in update method..."+e.getMessage());
		}
	}
}
