package com.cucumberbdd.BCFerries_Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumberbdd.automationFramework.base.Base;

public class AncillaryPage_Web extends Base {
	
	public static By CabinType_Box							=	By.xpath("//*[@id='ui-id-1']");
	public static By Lounge_Box								=	By.xpath("//*[@id='ui-id-3']");
	public static By TwoBedInsideCabin_Plus					=	By.xpath("//label[contains(text(),'2 Bed Inside Cabin')]//following::button[2]");	
	public static By TwoBedOutsideCabin_Plus				=	By.xpath("//label[contains(text(),'2 Bed Outside Cabin')]//following::button[2]");
	public static By ContinueButton				         	=	By.xpath("//*[@id='ancillary-page-submit']");
	
	
	
	public static RemoteWebDriver driver;

	public AncillaryPage_Web(RemoteWebDriver driver) {
		this.driver = driver;
	}

	/* Click Select Cabin Type */
	public static void clickSelectCabinType() throws InterruptedException {
		Thread.sleep(2000);
		WebElement cabinType = driver.findElement(CabinType_Box);
		cabinType.click();
	}
	
	/* Click Lounge */
	public static void clickLounge() throws InterruptedException {
		Thread.sleep(2000);
		WebElement loungeType = driver.findElement(Lounge_Box);
		loungeType.click();
	}
	
	
	/* Click 2 Bed Inside Cabin */
	public static void clickOnPlusTwoBedInsideCabin() throws InterruptedException {
		Thread.sleep(2000);
		WebElement selectTwoBedInside = driver.findElement(TwoBedInsideCabin_Plus);
		selectTwoBedInside.click();
	}

	
	/* Click 2 Bed Outside Cabin */
	public static void clickOnPlusTwoBedOutsideCabin() throws InterruptedException {
		Thread.sleep(2000);
		WebElement selectTwoBedOutside = driver.findElement(TwoBedOutsideCabin_Plus);
		selectTwoBedOutside.click();
	}

	/* Click Continue Button */
	public static void clickContinueButtonInAncillaryPage() throws InterruptedException {
		Thread.sleep(2000);
		WebElement continueButton = driver.findElement(ContinueButton);
		continueButton.click();
	}
}
