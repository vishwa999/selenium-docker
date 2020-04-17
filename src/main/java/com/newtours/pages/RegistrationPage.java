package com.newtours.pages;

import com.google.common.base.Strings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstNameText;

    @FindBy(name="lastName")
    private WebElement lastNameText;

    @FindBy(name="email")
    private WebElement userName;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(name="confirmPassword")
    private WebElement confirmPassword;

    @FindBy(name="register")
    private  WebElement Submit;

    public RegistrationPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goTo() throws InterruptedException
    {
        this.driver.get("http://newtours.demoaut.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
        Thread.sleep(3000);
        PageFactory.initElements(driver, this);
    }

    public void enterUserDetails(String firstName, String LastName)
    {
        this.firstNameText.sendKeys(firstName);
        this.lastNameText.sendKeys(LastName);
    }
    
    public void enterUserCredentials(String userName,String Password,String ConfirmPassword)
    {
    	this.userName.sendKeys(userName);
    	this.password.sendKeys(Password);
    	this.confirmPassword.sendKeys(ConfirmPassword);
    }
    
    public void submit()
    {
    	this.Submit.click();
    }
    
}
