package com.newtours.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.newtours.pages.FindFlightPage;
import com.newtours.pages.FlightConfirmation;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegistrationConfirmation;
import com.newtours.pages.RegistrationPage;

import Tests.BaseTest;

public class BookingFlightTest extends BaseTest{
   
   private String noofPassangers;
   private String expectedPrice;
   
   @BeforeTest
   @Parameters({"noofPassangers","expectedPrices"})
   public void setUpDriver(String noofPassangers,String expectedPrices) {
	   this.noofPassangers=noofPassangers;
	   this.expectedPrice=expectedPrices;
//	   System.setProperty("webdriver.chrome.driver","./chromedriver_win32/chromedriver.exe");
//	   this.driver=new ChromeDriver();
   }
   
   @Test
   public void registrationPageTest() throws InterruptedException {
	   RegistrationPage registertionPage=new RegistrationPage(driver);
	   registertionPage.goTo();
	   registertionPage.enterUserDetails("selenium", "docker");
	   registertionPage.enterUserCredentials("selenium", "docker", "docker");
	   System.out.println("Entered user credentials");
       registertionPage.submit();
   }
   
   @Test(dependsOnMethods = "registrationPageTest")
   public void registrationConfirmationPage()
   {
	   RegistrationConfirmation registrationConfirmation=new RegistrationConfirmation(driver);
	   registrationConfirmation.ClickonFlightLink();
	   System.out.println("Clicked on flight links");
   }
   
   @Test(dependsOnMethods = "registrationConfirmationPage")
   public void enterFlightDetails() {
	   FlightDetailsPage flightDetails=new FlightDetailsPage(driver);
	   flightDetails.selectPassengers(noofPassangers);
	   System.out.println("Selected passagers");
	   flightDetails.gotoFindFlightsPage();
   }
   
   @Test(dependsOnMethods = "enterFlightDetails")
   public void findFlightPage()
   {
	   FindFlightPage findflightpage=new FindFlightPage(driver);
	   findflightpage.SubmitFindFlightPage();
	   findflightpage.goToFlightConfigmationPage();
	   System.out.println("Going to flight confirmation page");
   }
   
   @Test(dependsOnMethods = "findFlightPage")
   public void flightConfirmation()
   {
	   FlightConfirmation flightconfirmation=new FlightConfirmation(driver);
	  String price= flightconfirmation.getPrice();
	  Assert.assertEquals(price,expectedPrice, "price did not match");
	   System.out.println("Verified the price");
   }
   
   
}
