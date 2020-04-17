package com.newtours.pages;

import java.awt.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmation {
	private WebDriver driver;
    private WebDriverWait wait;
    
    public FlightConfirmation(WebDriver driver)
    {
    	this.driver=driver;
    	this.wait=new WebDriverWait(driver, 30);
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//font[contains(text(), 'Confirmation')]")
    private WebElement FligntConfirmation;
    
    @FindBy(xpath = "//font[contains(text(), 'USD')]")
    private WebElement prices;
    
    @FindBy(linkText = "SIGN-OFF")
    WebElement signOfLink;
    
    public String getPrice()
    {
    	this.wait.until(ExpectedConditions.visibilityOf(FligntConfirmation));
    	System.out.println(this.FligntConfirmation.getText());
    	System.out.println(this.prices.getText());
    	String price=this.prices.getText();
    	this.signOfLink.click();
    	return price;
    	
    }
    }
