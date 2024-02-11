package testBase;



import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.sun.jdi.connect.spi.TransportService.Capabilities;

public class BaseClass {

	 static public WebDriver driver;
	public Logger logger;  // Adding global log4j variable to modify 
	public Properties p ;
	@BeforeClass(groups = {"sanity ","regression","master"})
	@Parameters({"os" ,"browser"})   // Here we are receiving from xml
	
	public void setup( String  os , String br) throws 
IOException
	{
		// loading properties file 
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
	logger	= LogManager.getLogger(this.getClass()); // to assign logger to all tcs
	
	if(p.getProperty( "execution_env").equalsIgnoreCase("remote"))         // oka vela remote environment aiythe then execute below code
	{
		DesiredCapabilities  cap = new DesiredCapabilities();
		// os
		if(os.equalsIgnoreCase("windows"))
		{
			cap.setPlatform(Platform.WIN11);
		}
		else if(os.equalsIgnoreCase("mac"))
		{
			cap.setPlatform(Platform.IOS);
			
		}
		else
		{
			System.out.println(" No matching  os");
			return;
		}
		
		//browser
		switch(br.toLowerCase())
		{
		case "chrome" :  cap.setBrowserName("chrome"); break;
		case "edge" 	: cap.setBrowserName("MicrosoftEdge");break;
		default: System.out.println("No matching browser..");
		}
		driver = new RemoteWebDriver(new  URL("192.168.2.145"),cap);
	}

else if(p.getProperty("exceution_env").equalsIgnoreCase("remote"))
{
	
	

	
	
	
	switch (br.toLowerCase())  // creating switch statement   launching browser locally 
	{
	case "chrome":  driver = new ChromeDriver(); break;
	case "edge" : driver = new EdgeDriver(); break;
	default:System.out.println("no match for driver ");
	                   return;  // exit from entire script
	
	}
}
	driver.get(p.getProperty("appURL"));
	driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown()
	{
		driver.close();
	}
	

	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
		
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}