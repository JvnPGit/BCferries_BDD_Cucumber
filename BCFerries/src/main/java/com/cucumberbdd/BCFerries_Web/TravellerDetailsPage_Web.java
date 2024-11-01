package com.cucumberbdd.BCFerries_Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumberbdd.automationFramework.base.Base;

public class TravellerDetailsPage_Web extends Base {

	public static By P1_FirstName								=	By.xpath("//*[@id='y_travellerdetails_0_first_name']");
	public static By P1_LastName								=	By.xpath("//*[@id='y_travellerdetails_0_last_name']");
	public static By P1_Gender									= 	By.xpath("//*[@data-id='travellerDataPerJourney0.outboundTravellerData0.travellerInfo.gender']");
	public static By P1_Email									=	By.xpath("//*[@id='email']");
	public static By P1_ConfrimEmail							=	By.xpath("//*[@id='travellerDataPerJourney0.outboundTravellerData0.travellerInfo.checkEmail']");
	public static By P1_Phone									=	By.xpath("//*[@id='y_travellerdetails_0_phone_number']");
	public static By DontKnowLicensePlateDetails				=	By.xpath("//*[@name='travellerDataPerJourney[0].outboundTravellerData[2].travellerInfo.licensePlateNumberNotAvailable']");
	public static By P2_FirstName								=	By.xpath("//*[@id='y_travellerdetails_1_first_name']");
	public static By P2_LastName								=	By.xpath("//*[@id='y_travellerdetails_1_last_name']");
	public static By P2_Gender									=	By.xpath("//*[@data-id='travellerDataPerJourney0.outboundTravellerData1.travellerInfo.gender']");
	public static By CheckoutAsGuest_Btb						=	By.xpath("//*[@class='btn btn-outline-blue btn-block']");
	public static By LoginAndCheckout_Btb						=	By.xpath("//*[@class='btn btn-primary btn-block']");
	public static By P3_FirstName								=	By.xpath("//*[@id='y_travellerdetails_2_first_name']");
	public static By P3_LastName								=	By.xpath("//*[@id='y_travellerdetails_2_last_name']");
	public static By P3_Gender									=	By.xpath("//*[@data-id='travellerDataPerJourney0.outboundTravellerData2.travellerInfo.gender']");

	public static RemoteWebDriver driver;

	public TravellerDetailsPage_Web(RemoteWebDriver driver) {
		this.driver = driver;
	}

	// Select Passenger 1 First name
	public static void P1_firstName(String P1_fname) throws InterruptedException {
		Thread.sleep(1000);
		WebElement P1_firstName = driver.findElement(P1_FirstName);		
		P1_firstName.sendKeys(P1_fname);

	}
	// Select Passenger 1 Last name
	public static void P1_lastName(String P1_lname) throws InterruptedException {
		Thread.sleep(1000);
		WebElement P1_lastName = driver.findElement(P1_LastName);		
		P1_lastName.sendKeys(P1_lname);

	}

	// Select Passenger 1 Email
	public static void P1_email(String P1_useremail) throws InterruptedException {
		Thread.sleep(1000);
		WebElement P1_email = driver.findElement(P1_Email);		
		P1_email.sendKeys(P1_useremail);

	}

	// Select Passenger 1 Gender
	public static void P1_Gender(String P1_gender) throws InterruptedException {
		Thread.sleep(1000);
		WebElement P1_gendr = driver.findElement(P1_Gender);		
		P1_gendr.click();
		Thread.sleep(1000);
		WebElement selgender = driver.findElement(By.linkText(P1_gender));
		selgender.click();

	}

	// Select Passenger 1 Confirm Email
	public static void P1_confirmEmail(String P1_confirmEmail) throws InterruptedException {
		Thread.sleep(1000);
		WebElement P1_EmailConfirmation = driver.findElement(P1_ConfrimEmail);		
		P1_EmailConfirmation.sendKeys(P1_confirmEmail);

	}

	// Select Passenger 1 Phone
	public static void P1_phone_number(String P1_phone) throws InterruptedException {
		Thread.sleep(1000);
		WebElement P1_Phone_number = driver.findElement(P1_Phone);		
		P1_Phone_number.sendKeys(P1_phone);

	}

	// Select Passenger 2 First name
	public static void P2_firstName(String P2_fname) throws InterruptedException {
		Thread.sleep(1000);
		WebElement P2_firstName = driver.findElement(P2_FirstName);		
		P2_firstName.sendKeys(P2_fname);

	}
	// Select Passenger 2 Last name
	public static void P2_lastName(String P2_lname) throws InterruptedException {
		Thread.sleep(1000);
		WebElement P2_lastName = driver.findElement(P2_LastName);		
		P2_lastName.sendKeys(P2_lname);

	}

	// Select Passenger 2 Gender
	public static void P2_Gender(String P2_gender) throws InterruptedException {
		Thread.sleep(1000);
		WebElement P2_gendr = driver.findElement(P2_Gender);		
		P2_gendr.click();
		Thread.sleep(1000);
		WebElement p2selgender = driver.findElement(By.linkText(P2_gender));
		p2selgender.click();

	}

	// Select Don't know Licensce plate checkbox
	public static void clickonDontknowLicenceplatechkbox() throws InterruptedException {
		Thread.sleep(1000);
		WebElement plateChkbox = driver.findElement(DontKnowLicensePlateDetails);		
		plateChkbox.click();

	}

	// Select Passenger 3 First name
	public static void P3_firstName(String P3_fname) throws InterruptedException {
		Thread.sleep(1000);
		WebElement P3_firstName = driver.findElement(P3_FirstName);		
		P3_firstName.sendKeys(P3_fname);

	}
	// Select Passenger 3 Last name
	public static void P3_lastName(String P3_lname) throws InterruptedException {
		Thread.sleep(1000);
		WebElement P3_lastName = driver.findElement(P3_LastName);		
		P3_lastName.sendKeys(P3_lname);

	}

	// Select Passenger 3 Gender
	public static void P3_Gender(String P3_gender) throws InterruptedException {
		Thread.sleep(1000);
		WebElement P3_gendr = driver.findElement(P3_Gender);		
		P3_gendr.click();
		Thread.sleep(1000);
		WebElement p3selgender = driver.findElement(By.linkText(P3_gender));
		p3selgender.click();

	}


	// Click on Checkout as a guest button on Departure Info Page
	public static void checkoutAsGuestInTravellerDetailsPage() throws InterruptedException {
		Thread.sleep(1000);
		WebElement checkoutAsGuestInTrvellerDetailsPage = driver.findElement(CheckoutAsGuest_Btb);
		checkoutAsGuestInTrvellerDetailsPage.click();
	}


	// Click on Checkout as a guest button on Departure Info Page
	public static void loginAndCheckoutInTravellerDetailsPage() throws InterruptedException {
		Thread.sleep(1000);
		WebElement loginCheckoutInTrvellerDetailsPage = driver.findElement(LoginAndCheckout_Btb);
		loginCheckoutInTrvellerDetailsPage.click();
	}

}
