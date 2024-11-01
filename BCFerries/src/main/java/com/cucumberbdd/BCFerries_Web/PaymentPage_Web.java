package com.cucumberbdd.BCFerries_Web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.cucumberbdd.automationFramework.base.Base;

public class PaymentPage_Web extends Base {

	public static By Firstname				   = 	By.id("first-name2");
	public static By Lastname				   = 	By.id("last-name");
	public static By Email				       = 	By.id("email");
	public static By ConfirmEmail			   = 	By.id("confirm-email");
	public static By Phone			    	   = 	By.id("phone-number");
	public static By NameonCard				   = 	By.id("first-name1");
	public static By CardNumber				   = 	By.id("monerisData");
	public static By ExpiryDate				   = 	By.name("cardExpiration");
	public static By CVV			    	   = 	By.name("cardCVNumber");
	public static By StreetNumberoftheAdress   = 	By.id("addressLine1");
	public static By StreetNameoftheAdress	   = 	By.id("addressLine2");
	public static By city			     	   = 	By.id("city");
	public static By Country				   = 	By.xpath("//button[@data-id='country']");
	public static By Province				   =	By.xpath("//button[@data-id='billing-address-regions']");
	public static By PostlCode		    	   = 	By.id("postalcode");
	public static By AgreeCheckbox			   = 	By.xpath("//span[@class='checkmark-checkbox']");
	public static By CompleteBooking		   = 	By.xpath("//button[@type='submit' and @class='btn btn-block btn-primary']");
	public static By FrameMoneris			   =	By.xpath("//*[@id=\"monerisFrame\"]");
	public static By BookingConfirmation       =   By.xpath("//*[contains(text(),'Your booking is confirmed')]");
	public static By SavedCard				   =	By.xpath("(//*[@class='checkmark'])[1]");
	public static By Agree				       =	By.xpath("//*[@class='checkmark-checkbox']");


	public static RemoteWebDriver driver;

	public PaymentPage_Web(RemoteWebDriver driver) {
		this.driver = driver;
	}


	// Select First name
	public static void firstName(String fname) throws InterruptedException {
		//Thread.sleep(1000);
		WebElement firstName = driver.findElement(Firstname);		
		firstName.sendKeys(fname);

	}
	// Select Last name
	public static void lastName(String lname) throws InterruptedException {
		//Thread.sleep(1000);
		WebElement lastName = driver.findElement(Lastname);		
		lastName.sendKeys(lname);

	}

	// Select Email
	public static void email(String useremail) throws InterruptedException {
		//Thread.sleep(1000);
		WebElement email = driver.findElement(Email);		
		email.sendKeys(useremail);

	}

	// Select Email
	public static void confirmEmail(String confirmEmail) throws InterruptedException {
		//Thread.sleep(1000);
		WebElement EmailConfirmation = driver.findElement(ConfirmEmail);		
		EmailConfirmation.sendKeys(confirmEmail);

	}

	// Select Phone
	public static void phoneNumber(String phone) throws InterruptedException {
		//Thread.sleep(1000);
		WebElement phoneNumber = driver.findElement(Phone);		
		phoneNumber.sendKeys(phone);

	}

	// Select NameonCard
	public static void nameOnCard(String nameOnCard) throws InterruptedException {
		//Thread.sleep(1000);
		WebElement cardName = driver.findElement(NameonCard);		
		cardName.sendKeys(nameOnCard);

	}

	// Select CardNumnber
	public static void cardNumber(String cardNum) throws InterruptedException {
		//Thread.sleep(2000);
		/*WebElement cardNumfld = driver.findElement(CardNumber);		
					cardNumfld.click();
					WebElement card_numb = driver.findElement(CardNumber);		
					card_numb.sendKeys(string);*/

		/*WebElement inputField= driver.findElement(CardNumber);

					JavascriptExecutor js= (JavascriptExecutor) driver;
					js.executeScript("arguments[1].value = arguments[0]; ", cardNum, inputField); */

		driver.switchTo().frame("monerisFrame");
		driver.findElement(By.id("monerisDataInput")).sendKeys(cardNum);
		driver.switchTo().defaultContent();


	}


	// Select ExpiryDate
	public static void expiryDate(String expiryDate) throws InterruptedException {
		//Thread.sleep(2000);
		WebElement card_ExpiryDate = driver.findElement(ExpiryDate);		
		card_ExpiryDate.sendKeys(expiryDate);


	}

	// Select CVV number
	public static void cvvNumber(String cvv) throws InterruptedException {
		//Thread.sleep(2000);
		WebElement cvvNumber = driver.findElement(CVV);		
		cvvNumber.sendKeys(cvv);

	}

	// Select StreetNumberoftheAdress
	public static void streetNumberForAddress(String streetnumberoftheadress) throws InterruptedException {
		//Thread.sleep(1000);
		WebElement adress_streetNumber = driver.findElement(StreetNumberoftheAdress);		
		adress_streetNumber.sendKeys(streetnumberoftheadress);

	}

	// Select StreetNameoftheAdress
	public static void streetNameForAddress(String streetnameoftheadress) throws InterruptedException {
		//Thread.sleep(1000);
		WebElement adress_streetName = driver.findElement(StreetNameoftheAdress);		
		adress_streetName.sendKeys(streetnameoftheadress);

	}

	// Select City name
	public static void cityName(String cityname) throws InterruptedException {
		//Thread.sleep(1000);
		WebElement adress_city = driver.findElement(city);		
		adress_city.sendKeys(cityname);

	}

	// Select Country name
	public static void countryName(String countryname) throws InterruptedException {
		//Thread.sleep(1000);

		/*Select country = new Select(driver.findElement(Country));
					country.selectByVisibleText(countryname);*/

		WebElement countryFld = driver.findElement(Country);
		countryFld.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement country = driver.findElement(By.linkText(countryname));
		country.click();

	}

	// Select Province name
	public static void provinceName(String provincename) throws InterruptedException {
		//Thread.sleep(3000);

		/*Select province = new Select(driver.findElement(Province));
					province.selectByVisibleText(provincename);*/

		WebElement provinceFld = driver.findElement(Province);
		provinceFld.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement country = driver.findElement(By.linkText(provincename));
		country.click();

	}

	// Select PostlCode
	public static void postlCode(String postlcode) throws InterruptedException {
		//Thread.sleep(1000);
		WebElement adress_postlcode = driver.findElement(PostlCode);		
		adress_postlcode.sendKeys(postlcode);

	}

	// Select Agree Check box
	public static void checkBox() throws InterruptedException {
		//Thread.sleep(1000);
		WebElement agreecheckbox = driver.findElement(AgreeCheckbox);		
		agreecheckbox.click();

	}

	// Select CompleteBooking
	public static void completeBooking() throws InterruptedException {
		//Thread.sleep(1000);
		WebElement completebooking = driver.findElement(CompleteBooking);		
		completebooking.click();

	}

	/*
	 * // Select PayNow public static void completeBooking() throws
	 * InterruptedException { Thread.sleep(1000); WebElement pay =
	 * driver.findElement(PayNow); pay.click();
	 * 
	 * }
	 */

	// Select PayNow
	public static boolean bookingConfirmation() throws InterruptedException {
		Thread.sleep(1000);
		WebElement confirmbooking = driver.findElement(BookingConfirmation);					

		return confirmbooking.isDisplayed();


	}

	//Saved Card
	public static void clickSavedCardRadioButton() throws InterruptedException {
		Thread.sleep(1000);
		WebElement savedCard = driver.findElement(SavedCard);
		savedCard.click();				
	}



}
