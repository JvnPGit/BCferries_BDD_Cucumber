package com.cucumberbdd.BCFerries_Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumberbdd.automationFramework.utilsHelper.ActionEngine;
import com.cucumberbdd.automationFramework.utilsHelper.ConfigMgr;

public class HotelBookingPage_Web {

	public static By RobinHoodInnAndSuites_BookNow       =	By.xpath("//h2[contains(text(),'Robin Hood Inn and Suites')]//following::div[12]//a[contains(text(),'Book now')]");
	public static By BookThisRoom                        =    By.xpath("//*[@id='bookNow000']");
	public static By VictoriaButterflyGardens            =  By.xpath("//h3[contains(text(),'Victoria Butterfly Gardens')]//following::div[7]//button//span[@class='btn-txt']");
	public static By Tickets_Dropdown                        =    By.xpath("//*[@class='custom-accordion-header manage-custom-accordion-header']");
	public static By Increment_18Plus                        =    By.xpath("//*[@class='fa bcf bcf-icon-add btn-number activity-passenger-selector y_VICBUTTERFLYGARDEN_adult']");
	public static By CheckInDate_Hotel                       =    By.xpath("//*[@class='vacation-calen-box vacation-ui-depart']");
	public static By CheckInDateHotel_Inputs                       =    By.xpath("//*[@name='selectedDate']");
	public static By AddToPackage                       =    By.xpath("//*[@id='addActivityToDealCart']");
	public static By ContinueAndReviewPackage                       =    By.xpath("//*[@class='btn btn-primary btn-block']");
	public static By QualityInnDowntownInnerHarbour_BookNow       =	By.xpath("//h2[contains(text(),'Quality Inn Downtown Inner Harbour')]//following::div[12]//a[contains(text(),'Book now')]");

	public static RemoteWebDriver driver;     

	public HotelBookingPage_Web(RemoteWebDriver driver) {
		this.driver = driver;
	}

	// Click on Robin Hood Inn and Suites Book Now Button
	public static void clickOnRobinHoodBookNowButton() throws InterruptedException {
		Thread.sleep(5000);
		WebElement bookNow = driver.findElement(RobinHoodInnAndSuites_BookNow);
		bookNow.click();
	}

	// Click on Quality Inn Downtown Inner Harbour Book Now Button
	public static void clickQualityInnBookNowButton() throws InterruptedException {
		Thread.sleep(5000);
		WebElement bookNow = driver.findElement(QualityInnDowntownInnerHarbour_BookNow);
		bookNow.click();
	}


	// Click on Book This Room Button
	public static void clickBookThisRoomButton() throws InterruptedException {
		Thread.sleep(5000);
		WebElement bookThisRoom = driver.findElement(BookThisRoom);
		bookThisRoom.click();
	}

	// Click on Victoria Butterfly Gardens View Details Button
	public static void clickOnVictoriaButterfltGardensViewDetailsButton() throws InterruptedException {
		Thread.sleep(5000);
		WebElement viewDetails = driver.findElement(VictoriaButterflyGardens);
		viewDetails.click();
	}

	// Click Tickets Drop down Button
	public static void clickTicketsDropDownButton() throws InterruptedException {
		Thread.sleep(5000);
		WebElement ticketsDropdown = driver.findElement(Tickets_Dropdown);
		ticketsDropdown.click();
	}

	// Click 18 Plus Increment Button
	public static void clickIncrementButton_18Plus() throws InterruptedException {
		Thread.sleep(5000);
		WebElement incrementButton_18Plus = driver.findElement(Increment_18Plus);
		incrementButton_18Plus.click();
	}

	// Click on Check In Date in Hotel Page
	public static void clickOnCheckInDate_Hotel() throws InterruptedException {
		Thread.sleep(5000);
		WebElement checkOutDateHotel = driver.findElement(CheckInDate_Hotel);
		checkOutDateHotel.click();
	}

	// Verify if Check In Date Text Box is displayed in Hotel Page
	public static boolean isCheckInDateHotelTextBoxDisplayed() {
		WebElement checkInDateHotelField = driver.findElement(CheckInDateHotel_Inputs);
		return checkInDateHotelField.isDisplayed();
	}

	// Enter Check Out Date in Vacation Tab
	public static void enterCheckInDate_Hotel() {
		if (isCheckInDateHotelTextBoxDisplayed()) {
			ActionEngine.clearTextBoxContent(driver, CheckInDateHotel_Inputs);
			String date = ConfigMgr.getProperty("CheckInDate");
			ActionEngine.setTextBoxContent(driver, CheckInDateHotel_Inputs, date);
		}
	}

	// Click on Add to Package in Hotel Page
	public static void clickOnAddToPackageButton() throws InterruptedException {
		Thread.sleep(5000);
		WebElement addToPackage = driver.findElement(AddToPackage);
		addToPackage.click();
	}

	// Click on Add to Package in Hotel Page
	public static void clickOnContinueAndReviewPackageButton() throws InterruptedException {
		Thread.sleep(5000);
		WebElement continueAndReviewPackage = driver.findElement(ContinueAndReviewPackage);
		continueAndReviewPackage.click();
	}
}
