package com.searchModule.searchTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.searchModules.pages.searchPage;

import Tests.BaseTest;

public class searchTest extends BaseTest{
	
	@Test
	@Parameters({"keyword"})
	public void search(String keyword) throws InterruptedException {
		searchPage searchpage=new searchPage(driver);
		searchpage.goTo();
		searchpage.doSearch(keyword);
		searchpage.gotoVideos();
		int size=searchpage.getResult();	
	}
	
	

}
