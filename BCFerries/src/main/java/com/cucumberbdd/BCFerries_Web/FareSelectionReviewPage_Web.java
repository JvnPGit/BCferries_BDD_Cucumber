package com.cucumberbdd.BCFerries_Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumberbdd.automationFramework.base.Base;

public class FareSelectionReviewPage_Web extends Base {

	//public static By CheckoutAsGuest_Button						=	By.xpath("(//*[@class='btn btn-outline-blue btn-block'])[1]");
	public static By CheckoutAsGuest_Button						=	By.xpath("//div[@class='col-lg-5 col-md-5 col-md-offset-3']/input[@type='submit']");
	public static By CheckoutAsGuest_DepaturePage				= 	By.xpath("//*[@id=\"y_travellerForms\"]/div[4]/div[1]/div[2]/input");
	public static By Login_Btn									=	By.xpath("//*[contains(text(),'Log in')]");
	public static By LoginCheckout_Button					    =	By.xpath("//*[contains(text(),'Log in')]");

	public static By CountinueWithoutAmenities					=	By.xpath("//*[@value='Continue without amenities']");
	public static By Continue_Btn                               =	By.xpath("//input[@class='btn btn-primary btn-block']");
	public static By AddCabinsAmenities						=	By.xpath("//*[@class='col-lg-5 col-md-5 col-md-offset-3 margin-bottom-20']//child::input[@value='Add cabins & amenities']");
	public static By AddActivities                               =	By.xpath("(//*[@class='btn btn-primary btn-block'])[2]");

	public static RemoteWebDriver driver;

	public FareSelectionReviewPage_Web(RemoteWebDriver driver) {
		this.driver = driver;
	}

	// Verify Fare Selection Review Page is Displayed
	public static boolean fareReviewPageIsDisplayed() {
		WebElement fareReviewPage = driver.findElement(Login_Btn);
		return fareReviewPage.isDisplayed();
	}

	/* Click on Checkout as Guest Button */
	public static void checkoutAsGuest() throws InterruptedException {
		//Thread.sleep(1000);
		WebElement checkoutAsGuest = driver.findElement(CheckoutAsGuest_Button);
		checkoutAsGuest.click();
	}

	// Click on ContinueWithoutAmentities button
	public static void clickContinueWithoutAmenities() throws InterruptedException {
		Thread.sleep(1000);
		WebElement withoutAmenities = driver.findElement(CountinueWithoutAmenities);
		withoutAmenities.click();
	}

	/*
	 * // Click on Checkout as a guest button on Departure Info Page public static
	 * void CheckoutasGuest_Deptarture() throws InterruptedException {
	 * Thread.sleep(1000); WebElement DeparturePage_chkoutGuest =
	 * driver.findElement(CheckoutAsGuest_DepaturePage);
	 * DeparturePage_chkoutGuest.click(); }
	 */



	// Click on Login Checkout button
	public static void loginCheckout() throws InterruptedException {
		Thread.sleep(1000);
		WebElement loginCheckout = driver.findElement(LoginCheckout_Button);
		loginCheckout.click();
	}

	// Click Continue Button
	public static void continueButton() throws InterruptedException {
		Thread.sleep(1000);
		WebElement continueButton = driver.findElement(Login_Btn);		
		continueButton.click();

	}

	// Click  Add Cabins and Amenities button
	public static void clickOnAddCabins() throws InterruptedException {
		Thread.sleep(2000);
		WebElement clickAddCabins = driver.findElement(AddCabinsAmenities);
		clickAddCabins.click();
	}
	// Click  Add Activities button in Vacation
	public static void clickOnAddActivities() throws InterruptedException {
		Thread.sleep(2000);
		WebElement clickAddActivities = driver.findElement(AddActivities);
		clickAddActivities.click();
	}
}
