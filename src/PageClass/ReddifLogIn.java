package PageClass;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReddifLogIn {
	
	WebDriver driver;
	ExtentTest test;

	By usrnm = (By.id("login1"));
	By pass = (By.id("password"));
	By signinbutton = (By.name("proceeed"));
	
	
	public  ReddifLogIn (WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		
	}
		
	public void username (String usrname) {
		
		try {
			WebElement uname = driver.findElement(usrnm);
			uname.sendKeys(usrname);
			test.log(LogStatus.PASS, "UserName entered as : "+usrname);
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "UserName Field not found");	
		}
	}
	
	public void password (String pword) {
		
	try {	
		WebElement paswrd = driver.findElement(pass);
		paswrd.sendKeys(pword);
		test.log(LogStatus.PASS, "Password entered as : "+pword);
	}
	catch(Exception e) {
		test.log(LogStatus.FAIL, "Password Field not found");		
	}
		
	}
	
	public void login () {
	
	try {	
		WebElement sign = driver.findElement(signinbutton);
		sign.click();
		test.log(LogStatus.PASS, "Clicked on sigIn button");
	}
	catch(Exception e) {
		test.log(LogStatus.FAIL, "Unable to locate SignIn Button");
	}
	}
	
	
	
	
	
	
}
