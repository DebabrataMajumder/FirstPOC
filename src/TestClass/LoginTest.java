package TestClass;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BaseClass.BaseClass;
import ExcelSheet.ReddifLoginExcel;
import PageClass.ReddifLogIn;

public class LoginTest extends BaseClass{
	
	@Test
	
	public void login() throws InvalidFormatException {

//	System.setProperty("webdriver.chrome.driver","C:\\Users\\debabrata.majumder\\Software\\Drivers\\chromedriver_win32\\chromedriver.exe");
//	WebDriver driver = new ChromeDriver();
//	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	
	ReddifLogIn logn = new ReddifLogIn(driver,test);
	ReddifLoginExcel exe = new ReddifLoginExcel();
	
	try {
	logn.username(exe.getExcelData("Sheet1", 1, 0));
	logn.password(exe.getExcelData("Sheet1", 1,1));
	logn.login();
	
	//exe.setExcelData("Sheet1", 1, 2, "Login was successful");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
}