package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage
{

	public LoginPage( WebDriver driver)          // constructor 
	{
	 super(driver);
	}

// Identification of WebElements
	
@FindBy(xpath="//input[@id='input-email']")
	  WebElement txt_email;
@	FindBy(xpath = "//input[@id='input-password']")
      WebElement txt_pwd;
@FindBy(xpath="//button[@class='btn btn-primary btn-lg hidden-xs']")
	     WebElement btn;
	
	
	//Action Methods

public void  setEmail (String email)
{
	txt_email.sendKeys(email);
}
	
public void setPassword (String pwds)
{
	txt_pwd.sendKeys(pwds);
}

public void Login()
{
	btn.click();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}