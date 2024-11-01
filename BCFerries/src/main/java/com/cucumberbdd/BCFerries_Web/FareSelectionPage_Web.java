package com.cucumberbdd.BCFerries_Web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumberbdd.automationFramework.base.Base;

public class FareSelectionPage_Web extends Base{

	public static By ViewFare_Button						=	By.xpath("(//button[@class='btn btn-primary view-fare-btn sailing-btn'])[1]");
	public static By SelectFare_Button						=	By.xpath("(//*[@class='btn btn-primary js-radio-select active'])[1]");			
	public static By SelectFare_NorthSailing_Button			=	By.xpath("//*[@class='btn btn-primary nrth-sailing-selct-btn btn-block js-radio-select active'][1]");
	public static By ReturnViewFare_Btb						=	By.xpath("(//button[@class='btn btn-primary view-fare-btn sailing-btn'])[1]");
	public static By SelectReturnFare_Btn					=	By.xpath("(//*[@class='btn btn-primary js-radio-select active'])[1]");
	public static By SelectButton_Vacation_Coastal					=	By.xpath("(//*[contains(text(),'Coastal')]//following::div[1]//child::a");
	public static By SelectReturnButton_Vacation			=	By.xpath("(//*[@class='btn-block sailing-btn btn btn-primary y_packageFerryResultSelect'])[1]");

	public static RemoteWebDriver driver;

	public FareSelectionPage_Web(RemoteWebDriver driver) {
		this.driver = driver;
	}

	
	/* Click View Fares Button */
	public static void clickOnViewFares() throws InterruptedException {
		Thread.sleep(1000);
		WebElement viewFares = driver.findElement(ViewFare_Button);
		viewFares.click();
	}

	/* Click View Fares -> Select */
	public static void clickOnSelectButton() throws InterruptedException {
		//Thread.sleep(2000);
		WebElement selectButton = driver.findElement(SelectFare_Button);
		selectButton.click();
	}
	
	/* Click View Fares -> Select */
	public static void clickOnSelectButton_NorthSailing() throws InterruptedException {
		//Thread.sleep(2000);
		WebElement selectButton = driver.findElement(SelectFare_NorthSailing_Button);
		selectButton.click();
	}
	
	// Click Return View Fares
	public static void clickOnReturnViewFares() throws InterruptedException {
		Thread.sleep(5000);
		WebElement ReturnviewFares = driver.findElement(ReturnViewFare_Btb);
		ReturnviewFares.click();

		/*	List<WebElement> a=driver.findElements(By.cssSelector("#btn btn-primary view-fare-btn sailing-btn")) ;
					 a.get(0).click();*/


	}


	// Click  Return View Fares -> Select
	public static void clickOnReturnSelectFares() throws InterruptedException {
		Thread.sleep(2000);
		WebElement selectReturnFares = driver.findElement(SelectReturnFare_Btn);
		selectReturnFares.click();
	}

	// Click  Select -> Vacation for Coastal Renaissance
	public static void clickSelectButton_Vacation_Coastal() throws InterruptedException {
		Thread.sleep(2000);
		//scrolltoview(SelectFare_Btn, driver);
		WebElement selectButton_Vacation = driver.findElement(SelectButton_Vacation_Coastal);
		selectButton_Vacation.click();
	}

	// Click  Return Select -> Vacation
	public static void clickOnReturnSelect_Vacation() throws InterruptedException {
		Thread.sleep(2000);
		WebElement selectReturn_Vacation = driver.findElement(SelectReturnButton_Vacation);
		selectReturn_Vacation.click();
	}

}
