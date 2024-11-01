package com.cucumberbdd.BCFerries_Web;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.cucumberbdd.automationFramework.base.Base;
import com.cucumberbdd.automationFramework.utilsHelper.ActionEngine;
import com.cucumberbdd.automationFramework.utilsHelper.ConfigMgr;


public class HomePage_Web extends Base {

	public static By Home_Logo 							=	By.xpath("//*[@title='Home']");
	public static By BookSailings_Tab					=	By.xpath("//*[@role='presentation' and text()='Book sailings']");
	public static By Vacations_Tab						=	By.xpath("//*[@role='presentation' and text()='Vacations']");
	public static By CurrentConditions_Tab				=	By.xpath("//*[@role='presentation' and text()='Current conditions']");
	public static By FromLocation				        =	By.xpath("//*[@id='ui-id-4']");
	public static By ToLocation					        =	By.xpath("//*[@id='ui-id-18']");
	public static By DateSelector			            =	By.xpath("//*[@class='nav-item ui-depart cust-fullwidth']//descendant::span[text()='Date']");
	public static By ContinueButton			            =	By.xpath("//*[@id='y_confirmaddpassenger']");
	public static By SelectActiveDate			        =	By.xpath("//*[@class='ui-state-default ui-state-active']");
	public static By DateEnter			                =	By.xpath("//*[@id='routeInfoForm.departingDateTime']");
	//	public static By ReturnDate_Selector				=	By.xpath("//*[@class='nav-item ui-return']//child::div");
	public static By ReturnDate_Date_Input				=	By.xpath("//*[@id='routeInfoForm.returnDateTime']");
	public static By RoundTrip_RdioBtn					=	By.xpath("//*[@id='y_roundTripRadbtn']");
	public static By ReturnTrip                         =   By.xpath("//*[@id='y_roundTripRadbtn']");
	public static By DepartDate                         =   By.xpath("(//*[@class='vacation-calen-box select-color-change'])[1]");
	public static By BookSailings_DepartDate_Input		=	By.id("routeInfoForm.departingDateTime");
	public static By  ReturnDate                        = By.xpath("(//*[@class='vacation-calen-box select-color-change'])[2]");
	//	public static By BookSailings_ReturnDate_Input			=	By.id("routeInfoForm.returnDateTime");
	public static By Destination_Vacations			    =	By.xpath("//*[@id='ui-id-10']");
	public static By Route_Vacations			        =	By.xpath("//*[@placeholder='Select a route']");
	public static By Vacation_Check_In			        =	By.xpath("//*[@class='tab-links tab-depart']");
	public static By Vacation_Check_Out			        =	By.xpath("//*[@class='tab-links tab-return']");
	public static By VacationCheckInDate_Input			=	By.xpath("//*[@id='accommodationFinderForm.checkInDateTime']");
	public static By VacationCheckOutDate_Input			=	By.xpath("//*[@id='accommodationFinderForm.checkOutDateTime']");
	public static By Vacation_Book_A_Pacakage_Btn       =	By.xpath("(//*[@id='bookAPackage']");
	public static By Vacation_Rooms_Btn                 =	By.xpath("(//*[@class='fa bcf bcf-icon-add btn-number'])[1]");
	//public static By RobinHoodInnAndSuites_BookNow                 =	By.xpath("//h2[contains(text(),'Robin Hood Inn and Suites')]//following::div[12]//a[contains(text(),'Book now')]");
	public static By NumberOfRooms_Vacation			    =	By.xpath("(//*[@class='fa bcf bcf-icon-add btn-number'])[1]");

	public static RemoteWebDriver driver;

	public HomePage_Web(RemoteWebDriver driver) {
		this.driver = driver;
	}

	// Select a Drop down value using Visible Text
	public static void selectByVisibleText(By locator, String visibletext) throws Throwable {
		try {

			Select s = new Select(driver.findElement(locator));
			Thread.sleep(2000);
			s.selectByVisibleText(visibletext);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// Verify Home Page is displayed
	public static boolean isHomePageDisplayed() {
		WebElement homePage = driver.findElement(Home_Logo);
		return homePage.isDisplayed();
	}

	/* Click on From Location Text Box */
	public static void clickOnFromLocation() throws InterruptedException {
		Thread.sleep(5000);
		WebElement fromLocation = driver.findElement(FromLocation);
		fromLocation.click();
	}

	/* Verify From Location Text Box is Displayed */
	public static boolean isFromLocationTextBoxDisplayed() {
		WebElement fromLocation = driver.findElement(FromLocation);
		return fromLocation.isDisplayed();
	}

	/* Enter Required Data for From Location */
	public void enterFromLocation() throws Throwable {
		try {
			String from = ConfigMgr.getProperty("from");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement fromLocation = driver.findElement(FromLocation);
			fromLocation.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement fromSearch = driver.findElement(By.linkText(from));
			fromSearch.click();
		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Entering From Location");
		}	
	}
	
	/* Enter Required Data for destination */
	public void enterDestination() throws Throwable {
		try {
			String dest = ConfigMgr.getProperty("destination");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement destLocation = driver.findElement(Destination_Vacations);
			destLocation.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement destSearch = driver.findElement(By.linkText(dest));
			destSearch.click();
		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Entering From Location");
		}	
	}
	
	/* Enter Required Data for Route */
	public void enterRoute() throws Throwable {
		try {
			String route = ConfigMgr.getProperty("route");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement routeLocation = driver.findElement(Route_Vacations);
			routeLocation.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement routeSearch = driver.findElement(By.linkText(route));
			routeSearch.click();
		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Entering From Location");
		}	
	}

	// Click on Round Trip radio button
	public static void clickOnRoundTripBtn() throws InterruptedException {
		Thread.sleep(5000);
		WebElement roundTrpBtn = driver.findElement(RoundTrip_RdioBtn);
		roundTrpBtn.click();
	}

	/* Click on To Location Text Box */
	public static void clickOnToLocation() throws InterruptedException {
		Thread.sleep(1000);
		WebElement toLocation = driver.findElement(ToLocation);
		toLocation.click();
	}

	/* Verify To Location Text Box is Displayed */
	public static boolean isToLocationTextBoxDisplayed() {
		WebElement toLocation = driver.findElement(ToLocation);
		return toLocation.isDisplayed();
	}

	/* Enter Required Data for To Location */
	public void enterToLocation() throws Throwable{
		try {
			String to = ConfigMgr.getProperty("to");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement toLocation = driver.findElement(ToLocation);
			toLocation.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement toSearch = driver.findElement(By.linkText(to));
			toSearch.click();
		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Entering to Location");
		}
	}

	/* Click on Date Text Box */
	public static void clickOnDate() throws InterruptedException {
		WebElement dateField = driver.findElement(DateSelector);
		dateField.click();
	}

	/* Verify Date Text Box is Displayed */
	public static boolean isDateTextBoxDisplayed() {
		WebElement dateFieldEnter = driver.findElement(DateEnter);
		return dateFieldEnter.isDisplayed();
	}

	/* Enter Required Data for Date */
	public static void enterDate() {
		if (isDateTextBoxDisplayed()) {
			ActionEngine.clearTextBoxContent(driver, DateEnter);
			String date = ConfigMgr.getProperty("date");
			ActionEngine.setTextBoxContent(driver, DateEnter, date);
		}
	}
	
	/* Select Required Data for Date */
	public static void selectDate() {
		if (isDateTextBoxDisplayed()) {
			WebElement selectdate = driver.findElement(SelectActiveDate);
			selectdate.click();
		}
	}

	// Verify if Return Date Text Box is displayed
	public static boolean isReturnDateTextBoxDisplayed() {
		WebElement ReturndateField = driver.findElement(ReturnDate);
		return ReturndateField.isDisplayed();
	}

	// Enter required Data for Return Date
	public static void enterReturnDate() {
		if (isReturnDateTextBoxDisplayed()) {
			ActionEngine.clearTextBoxContent(driver, ReturnDate_Date_Input);
			String Returndate = ConfigMgr.getProperty("date2");
			ActionEngine.setTextBoxContent(driver, ReturnDate_Date_Input, Returndate);
		}
	}


	/* Click Continue Button in Home Page */
	public static void clickContinueButtonInHomePage() throws InterruptedException {
		//Thread.sleep(1000);
		WebElement homePageContinueButton = driver.findElement(ContinueButton);
		homePageContinueButton.click();
	}
	

	// Click Return Trip Button in Home Page
	public static void clickReturnTripButtonInHomePage() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(ReturnTrip).click();
	}

	// Select Depart Date in Home Page
	public static void clickOnDepartDate() throws InterruptedException {
		Thread.sleep(1000);
		WebElement departDate = driver.findElement(DepartDate);
		departDate.click();
	}

	// Verifying Depart Date Field is Displayed in Home Page
	public static boolean verifyingDepartDateFieldIsDisplayed() {
		WebElement departDateField = driver.findElement(DepartDate);
		return departDateField.isDisplayed();
	}

	// Enter Depart Date in Home Page
	public static void enterDepartDate() {
		if (verifyingDepartDateFieldIsDisplayed()) {
			ActionEngine.clearTextBoxContent(driver, BookSailings_DepartDate_Input);
			String date = ConfigMgr.getProperty("date1");
			ActionEngine.setTextBoxContent(driver, BookSailings_DepartDate_Input, date);
		}
	}

	// Click on To Date Text Box
	public static void clickOnReturnDate() throws InterruptedException {
		Thread.sleep(1000);
		WebElement returndate = driver.findElement(ReturnDate);
		returndate.click();
	}

	/*
	 * // Enter required Return Data for Date public static void enterRetutnDate() {
	 * if (isDateTextBoxDisplayed()) { ActionEngine.clearTextBoxContent(driver,
	 * BookSailings_ReturnDate_Input); String date = ConfigMgr.getProperty("date2");
	 * ActionEngine.setTextBoxContent(driver, BookSailings_ReturnDate_Input, date);
	 * } }
	 */

	// Select a Vacations Tab
	public static void vacationTab() throws InterruptedException {
		Thread.sleep(1000);
		WebElement vacationTab = driver.findElement(Vacations_Tab);
		vacationTab.click();
	}

	// Select a Destination location
	public static void destinationLocation() throws Throwable {
		Thread.sleep(1000);
		WebElement destination = driver.findElement(Destination_Vacations);
		destination.click();			
	}

	// Select a Route location
	public static void routeLocation() throws InterruptedException {
		Thread.sleep(1000);
		WebElement routeLocation = driver.findElement(Route_Vacations);
		routeLocation.click();
	}

	// Click on Check in Date
	public static void clickOnCheckInDate() throws InterruptedException {
		Thread.sleep(5000);
		WebElement checkInDate = driver.findElement(Vacation_Check_In);
		checkInDate.click();
	}

	// Verify if Check In Date Text Box is displayed
	public static boolean isCheckInDateTextBoxDisplayed() {
		WebElement checkInDateField = driver.findElement(VacationCheckInDate_Input);
		return checkInDateField.isDisplayed();
	}

	// Enter Check In Date in Vacation Tab
	public static void enterCheckInDate() {
		if (isCheckInDateTextBoxDisplayed()) {
			ActionEngine.clearTextBoxContent(driver, VacationCheckInDate_Input);
			String date = ConfigMgr.getProperty("checkin_date");
			ActionEngine.setTextBoxContent(driver, VacationCheckInDate_Input, date);
		}
	}

	// Click on Check out Date
	public static void clickOnCheckOutDate() throws InterruptedException {
		Thread.sleep(5000);
		WebElement checkOutDate = driver.findElement(Vacation_Check_Out);
		checkOutDate.click();
	}

	// Verify if Check Out Date Text Box is displayed
	public static boolean isCheckOutDateTextBoxDisplayed() {
		WebElement checkOutDateField = driver.findElement(DateEnter);
		return checkOutDateField.isDisplayed();
	}

	// Enter Check Out Date in Vacation Tab
	public static void enterCheckOutDate() {
		if (isCheckInDateTextBoxDisplayed()) {
			ActionEngine.clearTextBoxContent(driver, VacationCheckOutDate_Input);
			String date = ConfigMgr.getProperty("checkout_date");
			ActionEngine.setTextBoxContent(driver, VacationCheckOutDate_Input, date);
		}
	}

	// Click on Book a Package Button
	public static void clickOnBookPackageButton() throws InterruptedException {
		Thread.sleep(5000);
		WebElement bookPackage = driver.findElement(Vacation_Book_A_Pacakage_Btn);
		bookPackage.click();
	}

	// Choose 2x Number of Rooms in Vacation Tab
	public static void twoNumberOfRooms() throws InterruptedException {
		Thread.sleep(5000);
		WebElement numberOfRooms = driver.findElement(NumberOfRooms_Vacation);
		numberOfRooms.click();
	}




}
