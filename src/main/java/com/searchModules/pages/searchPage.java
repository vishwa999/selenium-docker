package com.searchModules.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchPage {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(name="q")
    private WebElement SearchTextBox;
    
    @FindBy(xpath="//input[@id='search_button_homepage']")
    private WebElement searchBtn;
    
    @FindBy(xpath="//a[text()='Videos']")
    private WebElement videoLink;
    
    @FindBy(xpath="//div[@class='tile__media']/..")
    private List<WebElement> totalAllVideos;
  
    
    public searchPage(WebDriver driver)
    {
    	this.driver=driver;
    	this.wait=new WebDriverWait(driver, 30);
    	PageFactory.initElements(driver, this);
    }
    
    public void goTo() {
    	this.driver.get("https://duckduckgo.com/");
    }
    
    public void doSearch(String keyword) {
    	this.SearchTextBox.sendKeys(keyword);
    	this.searchBtn.click();
    }
    
    public void gotoVideos() throws InterruptedException {
    	this.videoLink.click();
    	Thread.sleep(3000);
    }
    
    public int getResult() {
    	int size=this.totalAllVideos.size();
    	System.out.println("Total number of videos displayed in doing search-->"+ this.totalAllVideos.size());
		return size;
    }

}
