package com.ixigo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ixigo_Front_Page {

	WebDriver driver;

	public Ixigo_Front_Page(WebDriver driver) {
		this.driver = driver;
	}

	private By clearText = By.xpath("(//div[@class='clear-input ixi-icon-cross'])[1]");
	private By fromCity = By.xpath("//*[(text()='From')]/../input");
	private By toCity = By.xpath("//*[(text()='To')]/../input");
	private By Return = By.xpath("//input[@placeholder='Return']");
	private By toDate = By.xpath("//td[@data-date='17092020']");
	private By fromDate = By.xpath("(//tr/td[@data-date='24102020'])[2]");
	private By travellerBtn = By.xpath("//*[text()='Travellers | Class']/../input");
	private By travellerCount = By.xpath("(//*[text()='2'][@class='counter-item u-text-center u-ib'])[1]");
	private By SearchBtn = By.xpath("//div[@class='search u-ib u-v-align-bottom']");
	private By checkPageLoad = By.xpath("//*[@class='fltrs-cntnr']");
	private By departure = By.xpath("//div[text()='Early Morning']");
	private By airline = By.xpath("//div[text()='Air India']");
	private By moreFilter = By.xpath("//div[text()='MORE FILTERS']");
	private By lowestprice = By.xpath("(//div[@class='c-price-display u-text-ellipsis ']/span[2])[1]");
	private By highestprice = By.xpath("(//div[@class='c-price-display u-text-ellipsis ']/span[2])[2]");
	private By apply = By.xpath("//*[text()='APPLY']");

	public WebElement getclearText() {
		return driver.findElement(clearText);
	}

	public WebElement getfromCity() {
		return driver.findElement(fromCity);
	}

	public WebElement gettoCity() {
		return driver.findElement(toCity);
	}

	public WebElement getReturn() {
		return driver.findElement(Return);
	}

	public WebElement gettoDate() {
		return driver.findElement(toDate);
	}

	public WebElement getfromDate() {
		return driver.findElement(fromDate);
	}

	public WebElement getTravellerBtn() {
		return driver.findElement(travellerBtn);
	}

	public WebElement getTravellerCount() {
		return driver.findElement(travellerCount);
	}

	public WebElement getSearchBtn() {
		return driver.findElement(SearchBtn);
	}

	public WebElement getcheckPageLoad() {
		return driver.findElement(checkPageLoad);
	}

	public String getdeparture() {
		return driver.findElement(departure).getText();
	}

	public String getairline() {
		return driver.findElement(airline).getText();
	}

	public WebElement getmoreFilter() {
		return driver.findElement(moreFilter);
	}

	public String getlowestprice() {
		return driver.findElement(lowestprice).getText();
	}

	public String gethighestprice() {
		return driver.findElement(highestprice).getText();
	}

	public WebElement getApply() {
		return driver.findElement(apply);
	}

}
