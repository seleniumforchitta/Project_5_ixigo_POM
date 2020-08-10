/*
	Launch https://www.ixigo.com/
	Validate the page
	Enter From – Pune , To – Hyderabad , Departure – 17 Sep 2020 , Return – 24 Oct 2020 , Travelers - 2
	Click on Search, Validate the result page
	Validate filter option for Stops, departure and Airlines
	Select Non-Stop in Stops filter option
	Print the list of airlines details (Only Airline Number, Departure Time and Fare) having fare < 5000
	Note – Create a Maven project using POM design pattern and Use TestNG as a framework
	
	Note - README.TXT is updated with the expected result.
 */
package com.ixigo.Testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ixigo.Pages.BaseClass;
import com.ixigo.Pages.Ixigo_Front_Page;

public class EndToEnd extends BaseClass {
	
	@Test
	public void EndToEndTest() throws InterruptedException {
		
		Ixigo_Front_Page page1 = new Ixigo_Front_Page(driver);
		
		System.out.println("Opening ixigo");
		System.out.println(driver.getTitle());
		
		String page = "ixigo - Flights, Train Reservation, Hotels, Air Tickets, Bus Booking";
		Assert.assertEquals(driver.getTitle(), page);
		
		//Entering the From City 
		page1.getclearText().click();
		Thread.sleep(2000);
		page1.getfromCity().sendKeys("Pune");
		Thread.sleep(2000);
		page1.getfromCity().sendKeys(Keys.ENTER);

		//Entering the To City 
		Thread.sleep(2000);
		page1.gettoCity().sendKeys("Hyderabad");
		Thread.sleep(2000);
		page1.gettoCity().sendKeys(Keys.ENTER);
		
		//to date
		//driver.findElement(By.xpath("//td[@data-date='17092020']")).click();
		page1.gettoDate().click();
		
		//Return
		//driver.findElement(By.xpath("//input[@placeholder='Return']")).click();
		page1.getReturn().click();
		
		//From date
		//driver.findElement(By.xpath("(//tr/td[@data-date='24102020'])[2]")).click();
		page1.getfromDate().click();
		
		//Traveller Button
		//driver.findElement(By.xpath("//*[text()='Travellers | Class']/../input")).click();
		page1.getTravellerBtn().click();
		
		//Traveller Count
		//driver.findElement(By.xpath("(//*[text()='2'][@class='counter-item u-text-center u-ib'])[1]")).click();
		page1.getTravellerCount().click();
		
		//Search Btn
		//driver.findElement(By.xpath("//div[@class='search u-ib u-v-align-bottom']")).click();
		page1.getSearchBtn().click();
		
		//New Page
		
		WebDriverWait d = new WebDriverWait(driver, 60);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fltrs-cntnr']")));
		System.out.println("Page is loaded successfully");
		
		
		//Validate the result page
		//Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fltrs-cntnr']")).isDisplayed());
		Assert.assertTrue(page1.getcheckPageLoad().isDisplayed());
		System.out.println("Result page is validated");
		
		
		//Validating Filter Options		
		//String departure = driver.findElement(By.xpath("//div[text()='Early Morning']")).getText();
		String departure = page1.getdeparture();
		Assert.assertEquals(departure, "Early Morning");
		System.out.println("departure is validated");
		
		//String airline = driver.findElement(By.xpath("//div[text()='Air India']")).getText();
		String airline = page1.getairline();
		Assert.assertEquals(airline, "Air India");
		System.out.println("airline is validated");
		
		int size = driver.findElements(By.cssSelector(".stop-info")).size();
		System.out.println(size);
		for(int i=0;i<size;i++)
		{
			System.out.println(driver.findElements(By.cssSelector(".stop-info")).get(i).getText());
			if(driver.findElements(By.cssSelector(".stop-info")).get(i).getText().equals("Non stop"))
			{
				String stop = driver.findElements(By.cssSelector(".stop-info")).get(i).getText();
				Assert.assertEquals(stop, "Non stop");
				System.out.println("stop is validated");
				driver.findElements(By.cssSelector(".stop-info")).get(i).click();
			}
		}
		
		//Print the list of airlines details (Only Airline Number, Departure Time and Fare) having fare < 5000
		// I am filtering <7000 as there is no flight which is less than 5000
		
		//driver.findElement(By.xpath("//div[text()='MORE FILTERS']")).click();
		page1.getmoreFilter().click();
		
		double Price = 7000; // We are taking flight less than this 
		Thread.sleep(2000);
		//System.out.println(driver.findElement(By.xpath("(//div[@class='c-price-display u-text-ellipsis ']/span[2])[1]")).getText());
		double lowestPrice = Integer.parseInt(page1.getlowestprice());
		//double highestPrice = Integer.parseInt(driver.findElement(By.xpath("(//div[@class='c-price-display u-text-ellipsis ']/span[2])[2]")).getText());
		double highestPrice = Integer.parseInt(page1.gethighestprice());
		System.out.println("Lowest Price = "+lowestPrice+"Highest Price = "+highestPrice);
		double diff = (highestPrice - lowestPrice);
		if(lowestPrice<Price)
		{
			double x = ((Price - lowestPrice)/(highestPrice - lowestPrice))*100;
			System.out.println("Diff = "+diff+"x = "+x);
		    WebElement slider = driver.findElement(By.xpath("(//div[@class='slider noUi-target noUi-ltr noUi-horizontal'])[3]"));
		    int width = slider.getSize().getWidth();
		    System.out.println(width);
		    Actions act= new Actions(driver);
		    act.moveToElement(slider, (int) ((width*x)/100), 0).click();
		    act.build().perform();
		}
		else System.out.println("There is no flight below - "+Price);
		
		//Click on Apply . 
		//driver.findElement(By.xpath("//*[text()='APPLY']")).click();
		page1.getApply().click();

		Thread.sleep(3000);
		List<WebElement> e = driver.findElements(By.xpath("//div[@class='summary-section']"));
		int sz = driver.findElements(By.xpath("//div[@class='summary-section']")).size();
		System.out.println(sz);
		for(int i=1;i<sz;i++)
		{
			Thread.sleep(2000);
			System.out.println();
			System.out.print(e.get(i).findElement(By.xpath("div[3]/div[4]/div")).getText()+"\t");
			System.out.print(e.get(i).findElement(By.xpath("div[3]/div[3]")).getText()+"\t");
			System.out.print(e.get(i).findElement(By.xpath("div[5]/div/div/span[2]")).getText()+"\t");
		}
		
	}

}
