package testUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	//define all common utilities
	public static WebDriver driver;
	public static long PageLoad_Timeout=20;
	public static long Implicitly_Wait=20;
	public static String excelsheetPath="C:\\Users\\Dipali Tailor\\Desktop\\excel\\opencartsheet.xlsx";
	public org.apache.poi.ss.usermodel.Sheet sheet;
	public Workbook wb;
	
	
	//this class constructor
	public TestUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	//incase we have to use frame, we can use this common method
	public void switchToFrame()   //not necessary
	{
	driver.switchTo().frame("frame");	
	}
	
	public Object[][] getData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=null;
		try {
			file=new FileInputStream(excelsheetPath);
		}
		catch(FileNotFoundException e)
		{
		e.printStackTrace();
		}
			catch(IOException e)
			{
				e.printStackTrace();
		}
		catch(EncryptedDocumentException e)
		{
			e.printStackTrace();
		}
		
		wb=WorkbookFactory.create(file);
		sheet=wb.getSheet(sheetName);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
}
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "Screenshot" +System.currentTimeMillis()+".png"));
		
		
	
	}
}
