package io.duotech.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTexter {
	
	public static void main(String[] args) throws SQLException {
		
		String user = "admin";
		String password = "Kutsevito1984";
		String url = "jdbc:mysql://natadatabase.coothfitkxmt.us-east-2.rds.amazonaws.com/employees";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println("DB connection has been established");
		
		Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery("select * from employees limit 10"); // limit for amount rows
		
//		rs.next();
//		rs.next();
//		System.out.println(rs.getObject(4));
//		System.out.println(rs.getString("first_name"));
		
//		while(rs.next()); // next() returns boolean, it checkes table has next pow or not
//		System.out.println(rs.getObject(1)+"\t"+ rs.getObject("first_name")+ "\t" + rs.getObject("last_name"));
//		
//		rs.first(); //first row
//		System.out.println(rs.getObject(1)+"\t"+ rs.getObject("first_name")+ "\t" + rs.getObject("last_name"));
//		
		rs.last();
		System.out.println(rs.getObject(1)+"\t"+ rs.getObject("first_name")+ "\t" + rs.getObject("last_name"));
		
		rs.absolute(5); // shows result from row number 5
		System.out.println(rs.getObject(1)+"\t"+ rs.getString("first_name")+ "\t" + rs.getObject("last_name"));
//		
		rs.last(); // last row
		System.out.println(rs.getRow());
		int rowCount = rs.getRow();
		
		ResultSetMetaData metaData = rs.getMetaData();
		System.out.println(metaData.getColumnCount());
		int columnCount = metaData.getColumnCount();
		
//		resultSet.next();
//		System.out.println(resultSet.findColumn("hire_date"));
		
		rs.beforeFirst();
		for (int i = 0; i < rowCount; i++) {
			rs.next();
		//	resultSet.previous();
			
			for (int j = 1; j <= columnCount; j++) {
				System.out.print(rs.getObject(j) + "\t");
				
			}
			System.out.println();
			
		}
		
//		resultSet.close();
//		statement.close();
//		connection.close();
		
	}

}
