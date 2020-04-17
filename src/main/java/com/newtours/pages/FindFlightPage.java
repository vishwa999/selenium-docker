package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {
	private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(name="reserveFlights")
    WebElement continueFlightBtn;
    
    @FindBy(name="buyFlights")
    WebElement buyFlightsElement;
    
    public FindFlightPage(WebDriver driver)
    {
    	this.driver=driver;
    	this.wait=new WebDriverWait(driver, 30);
    	PageFactory.initElements(driver, this);
    }
    
    public void SubmitFindFlightPage()
    {
    	this.wait.until(ExpectedConditions.elementToBeClickable(continueFlightBtn));
        this.continueFlightBtn.click();
    }
    
    public void goToFlightConfigmationPage() {
    	this.wait.until(ExpectedConditions.elementToBeClickable(buyFlightsElement));
        this.buyFlightsElement.click();
    }
}
