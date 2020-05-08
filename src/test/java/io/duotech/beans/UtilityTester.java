package io.duotech.beans;

import java.util.List;
import java.util.Map;

import io.duotech.utilities.DatabaseUtils;

public class UtilityTester {

	public static void main(String[] args) {
//To work with this DB use MySQL properties dt_url, dt_user and dt_password!!!!!!
// db_user=admin
// db_password=Kutsevito1984
// db_url=jdbc:mysql://natadatabase.coothfitkxmt.us-east-2.rds.amazonaws.com/employees		
		
		DatabaseUtils.createConnection(); //Connect to DB
		System.out.println("Connection Succsesful!");

//		System.out.println(DatabaseUtils.getColumnNames("select first_name, last_name from employees"));
//		
//		System.out.println(DatabaseUtils.getRowCount());
		
//		List<List<Object>> queryResultList = DatabaseUtils.getQueryResultList("select first_name, last_name from employees limit 20");
//		System.out.println(queryResultList);
//		for (List<Object> list : queryResultList) {
//			System.out.println(list);
//		}
		
		List<Map<String, Object>> queryResultMap = DatabaseUtils.getQueryResultMap("select first_name, last_name from employees limit 30");
		
		for (Map<String, Object> map : queryResultMap) {
			System.out.println(map);
		}
	}

}
