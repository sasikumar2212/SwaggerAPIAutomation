package api.utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "fetchData")
	public Object[][] getData() throws IOException {
		String filename = "testData/APITestData.xlsx";
		//System.out.println("./data/Lead.xlsx");
		//String filename = "NewLeadExtrenalData";
		Object[][] readData = ReadExcel.readExcel(filename, "Sheet1");
		System.out.println(readData);
		return readData;
	}

}
