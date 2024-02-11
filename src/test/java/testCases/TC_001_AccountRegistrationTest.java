package testCases;


import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups ={"regression","master"})
	public void verify_account_registration()
	{
		logger.info("*** starting driver ***");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*** clicked on my account***");
		hp.clickRegister();
		logger.info("*** clicked on register ***");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		//regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric(); // generating and storing in a password variable
		
		regpage.setPassword(password);
		//regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("*** clicked on click***");
		
	
		
	}
	
	
	
	
}

