package jdbcbasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcTest {
	public static void main(String[] args) {
		readDb();
		//updateDb();
		//insertDb();
		//deleteDb();
	}
	static void deleteDb() {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Archu@2000");
				Statement statement = connection.createStatement();) {
			String qry = "delete from account where accno=1";
			statement.executeUpdate(qry);
			System.out.println("Successfully deleted");
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	static void updateDb() {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Archu@2000");
				Statement statement = connection.createStatement();) {
			String qry = "update account set accno=2 where accno=4";
			statement.executeUpdate(qry);
			System.out.println("Successfully updated");
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	static void insertDb() {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Archu@2000");
				Statement statement = connection.createStatement();) {
			String qry = "insert into account values(4,'Max','Lucas',5000)";
			int rows= statement.executeUpdate(qry);
			System.out.println("Rows : " + rows);
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	static void readDb(){
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Archu@2000");
				Statement statement = connection.createStatement();) {
		
			ResultSet rs = statement.executeQuery("select * from account");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}
		} catch (SQLException e) {
		e.printStackTrace();
		}
	
	}
}