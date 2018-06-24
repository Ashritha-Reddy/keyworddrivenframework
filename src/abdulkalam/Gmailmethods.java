package abdulkalam;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Gmailmethods 
{
public WebDriver driver=null;
public String launch(String l,String d,String c) throws Exception
{
	if(l.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","C:\\testing1\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(l.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver","C:\\testing1\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	
	else
	{
		System.setProperty("webdriver.ie.driver","C:\\testing1\\iedriver.exe");
		driver=new InternetExplorerDriver();
	}
	driver.get(d);
	Thread.sleep(5000);
	return("Done");
		
}
public String fill(String l,String d,String c) throws Exception
{
driver.findElement(By.xpath(l)).sendKeys(d);
Thread.sleep(5000);
return("Done");
}
public String click(String l,String d,String c) throws InterruptedException
{
	driver.findElement(By.xpath(l)).click();
	Thread.sleep(5000);
	return("Done");
}
public String validateuserid(String l,String d,String c) throws Exception
{
	try {
		if(c.equalsIgnoreCase("blank")&&driver.findElement(By.xpath("//*[text()='Enter an email or phone number']")).isDisplayed())
		{
			return("blank userid testpassed");
			
		}
		else if(c.equalsIgnoreCase("valid")&&driver.findElement(By.name("password")).isDisplayed())
		{
			return("valid userid test passed");
			
		}
		else if(c.equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("(//*[@aria-live='assertive'])[1]")).isDisplayed())
		{
			return("invalid userid testpassed");
			
		}
		else
		{
			String x=this.screenshot();
			return("user id test failed and screenshot is "+x);
			
		}
		
	}
	catch(Exception e)
	{
		String x=this.screenshot();
		return("user id test was interrupted and screenshot is "+x);
		
	}
}


public String close(String l,String d,String c)throws Exception
{
	driver.quit();
	Thread.sleep(5000);
	return("Done");
}
public String validatepwd(String l,String d,String c) throws Exception
{
	try
	{
		if(c.equalsIgnoreCase("blank")&&driver.findElement(By.xpath("(//*[contains(text(),'Enter a password')])[2]")).isDisplayed())
		{
			return("blank password test passed");
			
		}
		else if(c.equalsIgnoreCase("valid")&&driver.findElement(By.xpath("//*[@title='Starred']")).isDisplayed())
		{
			return("valid password test passed");
			
		}
		else if(c.equalsIgnoreCase("invalid")&&driver.findElement(By.xpath("//*[contains(text(),'Wrong password')]")).isDisplayed())
		{
			return("Invalid password test passed");
			
		}
		else
		{
			String x=this.screenshot();
			return("password test failed and screenshot is "+x);
			
		}

	}
	catch(Exception ex)
	{
		String x=this.screenshot();
		return("pwd test interrupted and screensht is "+x);
		
	}
}
public String screenshot()throws Exception
{
	Date d=new Date();
	SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	String fname=df.format(d);
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest=new File(fname+".png");
	FileUtils.copyFile(src,dest);
	return(fname);
	
	
	
	
	
}

}


