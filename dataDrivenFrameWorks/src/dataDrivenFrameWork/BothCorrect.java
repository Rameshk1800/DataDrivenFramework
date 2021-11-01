package dataDrivenFrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothCorrect {
	
	String [][] data= {
			
			{"Admin","admin123"},
			{"Admin","admin1232"},
			{"Adminn","admin123"},
			{"Adminn","admin1234"}
			
	};
	
	@DataProvider(name="logindata")
	private String[][] loginDataProvider() {
		
		return data;
	}

	
	

	@Test(dataProvider ="logindata" )
	public void loginWithBothCorrect(String uName, String pWord) {
		System.setProperty("webdriver.chrome.driver","E:\\Automation\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");

		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys(uName);

		WebElement passWord = driver.findElement(By.id("txtPassword"));
		passWord.sendKeys(pWord);

		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		loginButton.click();
		
		driver.quit();

}




	
}