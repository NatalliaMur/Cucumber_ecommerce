package io.duotech.utilities;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestExcelUtils {
	
	
	public static void main(String[] args) {
		
		ExcelUtils sheet = new ExcelUtils("file.xlsx", "Sheet1");
		System.out.println(sheet.getCellData(3, 2));
		
		System.out.println(Arrays.deepToString(sheet.getDataAs2DArray()));
		
		List<Map<String, String>> dataAsList = sheet.getDataAsList();
		
		for (Map<String, String> map : dataAsList) {
			System.out.println(map);
		}
		
		System.out.println(sheet.getColumnNames());
		
		sheet.setCellData("phone", 0, 8);
		sheet.setCellData("703-261-99-00", 1, 8);
		sheet.setCellData("Smith", "last_name", 2);
		
		

		
		
		
		
	}
	

}
