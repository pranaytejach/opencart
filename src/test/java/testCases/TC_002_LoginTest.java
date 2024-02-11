package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest  extends BaseClass{
	
	@Test(groups={"regression","master"})
	public void  verify_login()
	{
		logger.info("*** started***");
		try {
			//home page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		// Login page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		
		// my account page
		MyAccountPage myacc = new MyAccountPage(driver);
		
     	boolean targetPage 	= myacc.isMyAccountPageExists();
	       if(targetPage == true)
	       {
	    	   Assert.assertTrue(true);
	       }
	       else
	       {
	    	   Assert.fail();
	       }
	  }
	     catch(Exception e )
	  {
		  Assert.fail();
	  }
	  
		logger.info("***closed***");
		
		
		
	
	}
	
	


}
