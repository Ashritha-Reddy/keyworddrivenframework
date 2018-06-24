package keywordgmailfill;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registrationmethods {
WebDriver driver;

public void launch(String l,String d)
{
	System.setProperty("webdriver.chrome.driver","C://testing1//chromedriver.exe");
 driver=new ChromeDriver();	
 driver.get(d);
}


public void fill(String l,String d)
{
	driver.findElement(By.xpath(l)).sendKeys(d);
}


public void click(String l,String d)
{
	driver.findElement(By.xpath(l)).click();
	
}


}
