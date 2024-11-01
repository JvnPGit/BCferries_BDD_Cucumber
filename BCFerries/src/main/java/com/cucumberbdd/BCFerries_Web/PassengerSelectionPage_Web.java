package com.cucumberbdd.BCFerries_Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumberbdd.automationFramework.base.Base;

public class PassengerSelectionPage_Web extends Base {

	
	public static By Adults_Plus_Button 							=	By.xpath("//*[@class=' btn btn-plus y_outboundPassengerQtySelectorPlus y_adult']");
	public static By Children_Plus_Button 							=	By.xpath("//*[@class='popoverThis btn btn-plus y_outboundPassengerQtySelectorPlus y_child']");
	public static By Infants_Plus_Button 							=	By.xpath("//*[@class=' btn btn-plus y_outboundPassengerQtySelectorPlus y_infant']");
	public static By BCResidentSeniors_Plus_Button 				    =	By.xpath("//*[@class='popoverThis btn btn-plus y_outboundPassengerQtySelectorPlus y_senior']");
	public static By Continue_Button								= 	By.xpath("//*[@id='proceed_to_vehicle_selection_btn_div']/button");
	public static By Continue_Button_WithoutVehicle					= 	By.xpath("//div[@id='proceed_to_sailing_selection_btn_div']/button");
	public static By CheckBox_AccessibilityNeeds				=	By.xpath("//div[@class='accessibility-need-sec']//child::span");
	public static By Passenger1_AccessibilityOption_DD			=	By.xpath("//div[@id='accordion-accessibility-adult_1_outbound']//child::h3");
	public static By Passenger2_AccessibilityOption_DD			=	By.xpath("//div[@id='accordion-accessibility-adult_2_outbound']//child::h3");
	public static By WithoutVehicle_RdBtn						=	By.xpath("//input[@id='proceed_to_sailing_selection_btn']");
	public static By HearingImpairment							=	By.xpath("(//input[starts-with(@id,'specialServiceRequest_DEAF')])[1]");
	public static By RequestWheelchair							=	By.xpath("(//input[contains(@id,'accessibilityRequestDataList0.selection1')])[1]");
	public static By TravelingWithOwnWheelchair					=	By.xpath("(//input[starts-with(@id,'specialServiceRequest_WCHR')])[2]");
	public static By BaordingAssistance							=	By.xpath("(//input[contains(@id,'accessibilityRequestDataList1.selection2')])[1]");
	
	//public static By Passenger1_AccessibilityOption_Vacation			=	By.xpath("//div[@id='y_accessibility_dropdown_1']//child::h3");
	//public static By Passenger2_AccessibilityOption_Vacation		=	By.xpath("//div[@id='y_accessibility_dropdown_2']//child::h3");
	
	
	public static RemoteWebDriver driver;

	public PassengerSelectionPage_Web(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	
	
	/* Choose Number of Passengers - Adults */
	public static void clickOnIncrement_Adults() throws InterruptedException {
		//Thread.sleep(1000);
		WebElement incrementAdult = driver.findElement(Adults_Plus_Button);
		incrementAdult.click();
	}
	
	/* Choose Number of Passengers - BC Residents Seniors */
		public static void clickOnIncrement_BCResidentSeniors() throws InterruptedException {
			Thread.sleep(1000);
			WebElement incrementBCResidents = driver.findElement(BCResidentSeniors_Plus_Button);
			incrementBCResidents.click();
		}
	
		/* Choose Number of Passengers - Children */
	public static void clickOnIncrement_Children() throws InterruptedException {
		//Thread.sleep(1000);
		WebElement incrementChildren = driver.findElement(Children_Plus_Button);
		incrementChildren.click();
	}
	
	/* Choose Number of Passengers - Infants */
		public static void clickOnIncrement_Infants() throws InterruptedException {
			//Thread.sleep(1000);
			WebElement incrementInfants = driver.findElement(Infants_Plus_Button);
			incrementInfants.click();
		}
		
		/* Click Continue Button in Passengers Page */
	    public static void clickContinueButtonInPassengersPage() throws InterruptedException {
		//Thread.sleep(1000);
		WebElement passengersPageContinueButton = driver.findElement(Continue_Button);
		passengersPageContinueButton.click();
	}
	    
	    /* Click Continue Button in Passengers Page without Vehicle */
	    public static void clickContinueButtonInPassengersPageWhithoutVehicle() throws InterruptedException {
		//Thread.sleep(1000);
		WebElement passengersPageContinueWVButton = driver.findElement(Continue_Button_WithoutVehicle);
		passengersPageContinueWVButton.click();
	}
	    
		
	// Click on CheckBox for Accessibility Needs for Passengers Page
		public static void clickOnCheckBoxAccessibilityNeeds() throws InterruptedException {
			Thread.sleep(1000);
			WebElement passengerPage_AccessibilityChkbox = driver.findElement(CheckBox_AccessibilityNeeds);
			passengerPage_AccessibilityChkbox.click();
		}
		

	// Click on CheckBox for Accessibility Needs for Passengers Page
		public static void passenger1_AccessibilityOptions(String CheckBoxOption, String RadioButtonOption) throws InterruptedException {
			Thread.sleep(1000);
			WebElement passenger1_AccessibilityOption = driver.findElement(Passenger1_AccessibilityOption_DD);
			passenger1_AccessibilityOption.click();
			Thread.sleep(1000);
			
			scrolltoview(Passenger1_AccessibilityOption_DD, driver);
			Thread.sleep(1000);
			WebElement passenger1_AccessibilityOption1 = driver.findElement(HearingImpairment);
			passenger1_AccessibilityOption1.click();
			Thread.sleep(1000);
			WebElement passenger1_AccessibilityOption2 = driver.findElement(RequestWheelchair);
			passenger1_AccessibilityOption2.click();
		}
		
	// Click on CheckBox for Accessibility Needs for Passengers Page
			public static void passenger2_AccessibilityOptions(String CheckBoxOption, String RadioButtonOption) throws InterruptedException {
				Thread.sleep(1000);
				WebElement passenger2_AccessibilityOption = driver.findElement(Passenger2_AccessibilityOption_DD);
				passenger2_AccessibilityOption.click();
				Thread.sleep(1000);
				
			//	scrolltoview(WithoutVehicle_RdBtn, driver);
				//Thread.sleep(1000);
				WebElement passenger2_AccessibilityOption1 = driver.findElement(TravelingWithOwnWheelchair);
				passenger2_AccessibilityOption1.click();
				Thread.sleep(1000);
				WebElement passenger2_AccessibilityOption2 = driver.findElement(BaordingAssistance);
				passenger2_AccessibilityOption2.click();
			}
			
	// Select Traveling without a Vehicle
	public static void withoutVehicle() throws InterruptedException {
		Thread.sleep(1000);
		WebElement noVehicle = driver.findElement(WithoutVehicle_RdBtn);
		noVehicle.click();
	}
	

	
}
