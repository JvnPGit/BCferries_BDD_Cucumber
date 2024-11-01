package com.cucumberbdd.BCFerries_Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumberbdd.automationFramework.base.Base;

public class VehicleSelectionPage_Web extends Base{

	public static By VehicleHeight_Under7ft					= 	By.xpath("//*[@id='under7Height_0']");
	public static By VehicleHeight_Over7ft					= 	By.xpath("//*[@id='over7Height_0']");
	public static By VehicleLength_Under20ft				= 	By.xpath("//*[@id='under20Length_0']");
	public static By VehicleLength_Over20ft					= 	By.xpath("//*[@id='over20Length_0']");
	public static By VehicleContinue_Button					=	By.xpath("//*[@class='btn btn-primary btn-block fareFinderFindButton']");
	public static By DangerousGoods_Chkbx							=	By.xpath("//*[@id='dangerousgoodoutbound']");
	public static By TotalHeight_Above7ft							=	By.xpath("//*[@id='Over7heightboxinft_0']");
	public static By TotalLength_Above20ft							=	By.xpath("//*[@id='Over20lengthboxinft_0']");
	public static By Motorcycle										= 	By.xpath("//*[@id='ui-id-3']");
	public static By TrikeorSideCar									=	By.xpath("//*[@id='sidecarMotorcycle_0']");
	public static By StandardwithTrailer							=	By.xpath("//*[@id='withTrailerMotorcycle_0']");
	public static By Over5000kgGVW									=	By.xpath("//*[@id='ui-id-3']");
	public static By SemiTrailer									=	By.xpath("//*[@id='semiTrailor_0']");
	public static By SemiTrailer_Under9ft							=	By.xpath("//*[@id='under9Ft_0']");
	public static By SemiTrailer_Over9ft							=	By.xpath("//*[@id='over9Ft_0']");
	public static By SemiTrailer_Under9ft_Length					=	By.xpath("//*[@id='Oversizelengthboxinft_0']");
	public static By SemiTrailer_Under9ft_Height					=	By.xpath("//*[@id='Oversizeheightboxinft_0']");
	public static By VehicleHeight_Under7ft_Vacation			    = 	By.xpath("//*[@id='under7HeightPackage_0']");
	public static By VehicleHeight_Above7ft_Vacation				= 	By.xpath("//*[@id='over7HeightPackage_0']");
	public static By VehicleLength_Under20ft_Vacation				= 	By.xpath("//*[@id='under20LengthPackage_0']");
	public static By VehicleLength_Above20ft_Vacation				= 	By.xpath("//*[@id='over20LengthPackage_0']");
	public static By Vacation_Vehicle_Continue_Btn					=	By.xpath("//button[@class='btn btn-primary btn-block fareFinderFindButton margin-top-20']");


	public static RemoteWebDriver driver;

	public VehicleSelectionPage_Web(RemoteWebDriver driver) {
		this.driver = driver;
	}


	/* Choose Vehicle Height - Under 7ft */
	public static void clickOnHeight_Under() throws InterruptedException {
		//Thread.sleep(1000);
		WebElement heightUnder = driver.findElement(VehicleHeight_Under7ft);
		heightUnder.click();
	}

	/* Select and Enter Info for Vehicle Height - Over 7ft */
	public static void selectAndEnterVehilceHeightOver7ft(String Height) throws InterruptedException {
		Thread.sleep(1000);
		WebElement heightOver = driver.findElement(VehicleHeight_Over7ft);
		heightOver.click();
		Thread.sleep(1000);
		WebElement enterheightOver = driver.findElement(TotalHeight_Above7ft);
		enterheightOver.sendKeys(Height);
	}

	/* Choose Vehicle Length - Under 20ft */
	public static void clickOnLength_Under() throws InterruptedException {
		//Thread.sleep(1000);
		WebElement lengthUnder = driver.findElement(VehicleLength_Under20ft);
		lengthUnder.click();
	}

	/* Select and Enter Info for Vehicle Length Over 20ft */
	public static void selectAndEnterVehilceLengthOver20ft(String Length) throws InterruptedException {
		Thread.sleep(1000);
		WebElement lengthOver = driver.findElement(VehicleLength_Over20ft);
		lengthOver.click();
		Thread.sleep(1000);
		WebElement enterLengthOver = driver.findElement(TotalLength_Above20ft);
		enterLengthOver.sendKeys(Length);
	}
	

	/* Click Continue Button in Vehicle Selection Page */
	public static void clickContinueButtonInVehicleSelectionPage() throws InterruptedException {
		//Thread.sleep(1000);
		WebElement vehicleSelectionPageContinueButton = driver.findElement(VehicleContinue_Button);
		vehicleSelectionPageContinueButton.click();
	}

	// Select Vehicle Over5000kgGVW
	public static void clickOnOver5000kgGVW() throws InterruptedException {
		Thread.sleep(1000);
		WebElement selOver5000kgGVW = driver.findElement(Over5000kgGVW);
		selOver5000kgGVW.click();
	}

	// Select Vehicle SemiTrailer
	public static void clickOnSemiTrailer() throws InterruptedException {
		Thread.sleep(1000);
		WebElement selSemiTrailer = driver.findElement(SemiTrailer);
		selSemiTrailer.click();
	}

	// Select Vehicle SemiTrailer-Under 9ft
	public static void clickOnSemiTrailerUnder9ft() throws InterruptedException {
		Thread.sleep(1000);
		WebElement selSemiTrailerUnder9ft = driver.findElement(SemiTrailer_Under9ft);
		selSemiTrailerUnder9ft.click();
	}

	// Select Vehicle SemiTrailer-Under 9ft- Total Length
	public static void EnterOnSemiTrailerUnder9ftLen(String Length) throws InterruptedException {
		Thread.sleep(1000);
		WebElement selSemiTrailerUnder9ftLen = driver.findElement(SemiTrailer_Under9ft_Length);
		selSemiTrailerUnder9ftLen.sendKeys(Length);
	}

	// Select Vehicle SemiTrailer-Under 9ft- Total Height
	public static void EnterOnSemiTrailerUnder9ftHeight(String Height) throws InterruptedException {
		Thread.sleep(1000);
		WebElement selSemiTrailerUnder9ftHeight = driver.findElement(SemiTrailer_Under9ft_Height);
		selSemiTrailerUnder9ftHeight.sendKeys(Height);
	}







	// Click Vacation Continue Button in Vehicle Selection Page
	public static void clickVacationContinueButtonInVehicleSelectionPage() throws InterruptedException {
		Thread.sleep(1000);
		//scrolltoview(Vehicle_Continue_Btn, driver);
		WebElement vacationContinueButton = driver.findElement(Vacation_Vehicle_Continue_Btn);
		vacationContinueButton.click();
	}

	// Click on Dangerous goods
	public static void clickOnDangerousGoods() throws InterruptedException {
		Thread.sleep(1000);
		WebElement dangerousGoods = driver.findElement(DangerousGoods_Chkbx);
		dangerousGoods.click();
	}



	// Select Motorcycle and Trike or SideCar
	public static void selectMotorcycleandTrike() throws InterruptedException {
		Thread.sleep(1000);
		WebElement motorcycleTrike = driver.findElement(Motorcycle);
		motorcycleTrike.click();
		Thread.sleep(1000);
		WebElement trikeorsidecar = driver.findElement(TrikeorSideCar);
		trikeorsidecar.click();


	}

	// Select Motorcycle and Standard with Trailer
	public static void selectMotorcycleannTrailer() throws InterruptedException {
		Thread.sleep(1000);
		WebElement motorcycleTrailer = driver.findElement(Motorcycle);
		motorcycleTrailer.click();
		Thread.sleep(1000);
		WebElement standardTrailer = driver.findElement(StandardwithTrailer);
		standardTrailer.click();


	}

	// Select Vehicle height Vacation - Under 7ft
	public static void clickOnHeightUnder_Vacation() throws InterruptedException {
		Thread.sleep(1000);
		WebElement vacationHeightUnder = driver.findElement(VehicleHeight_Under7ft_Vacation);
		vacationHeightUnder.click();
	}


	// Choose Vehicle Length Vacation- Under 20ft
	public static void clickOnLengthUnder_Vacation() throws InterruptedException {
		Thread.sleep(1000);
		//scrolltoview(VehicleLength_Under20ft_RdBtn, driver);
		WebElement vacationLengthUnder = driver.findElement(VehicleLength_Under20ft_Vacation);
		vacationLengthUnder.click();
	}

	// Select Vehicle height Vacation - Over 7ft
	public static void clickOnHeightOver_Vacation() throws InterruptedException {
		Thread.sleep(1000);
		WebElement vacationHeightOver = driver.findElement(VehicleHeight_Above7ft_Vacation);
		vacationHeightOver.click();
	}


	// Choose Vehicle Length Vacation- Over 20ft
	public static void clickOnLengthOver_Vacation() throws InterruptedException {
		Thread.sleep(1000);
		//scrolltoview(VehicleLength_Under20ft_RdBtn, driver);
		WebElement vacationLengthOver = driver.findElement(VehicleLength_Above20ft_Vacation);
		vacationLengthOver.click();
	}

}
