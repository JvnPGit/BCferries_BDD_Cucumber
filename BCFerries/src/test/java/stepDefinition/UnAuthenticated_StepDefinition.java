package stepDefinition;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.cucumberbdd.automationFramework.Listeners.ExtentReportListener;
import com.cucumberbdd.automationFramework.base.Base;
import com.cucumberbdd.automationFramework.utilsHelper.ActionEngine;
import com.cucumberbdd.BCFerries_Web.AncillaryPage_Web;
import com.cucumberbdd.BCFerries_Web.FareSelectionPage_Web;
import com.cucumberbdd.BCFerries_Web.FareSelectionReviewPage_Web;
import com.cucumberbdd.BCFerries_Web.HomePage_Web;
import com.cucumberbdd.BCFerries_Web.HotelBookingPage_Web;
import com.cucumberbdd.BCFerries_Web.LoginPage_Web;
import com.cucumberbdd.BCFerries_Web.PassengerSelectionPage_Web;
import com.cucumberbdd.BCFerries_Web.PaymentPage_Web;
import com.cucumberbdd.BCFerries_Web.TravellerDetailsPage_Web;
import com.cucumberbdd.BCFerries_Web.VehicleSelectionPage_Web;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UnAuthenticated_StepDefinition extends ExtentReportListener {
	String featureName ;
	String scenarioName ;
	public ExtentTest logInfo = null;
	/*BackGround_Steps_Android remoteDriver	= new BackGround_Steps_Android();
	RemoteWebDriver driver = remoteDriver.driver;*/
	RemoteWebDriver driver = BackGround_Steps.driver;

	HomePage_Web homePage 						  = new HomePage_Web(driver);
	FareSelectionPage_Web fareSelectPage		  = new FareSelectionPage_Web(driver);
	FareSelectionReviewPage_Web fareReviewPage 	  = new FareSelectionReviewPage_Web(driver);
	PassengerSelectionPage_Web passengerPage	  = new PassengerSelectionPage_Web(driver);
	VehicleSelectionPage_Web vehiclePage		  = new VehicleSelectionPage_Web(driver);
	PaymentPage_Web paymentPage				      = new PaymentPage_Web(driver);
	LoginPage_Web loginPage                       = new LoginPage_Web(driver);
	AncillaryPage_Web ancillaryPage               = new AncillaryPage_Web(driver);
	TravellerDetailsPage_Web travellerDetailsPage = new TravellerDetailsPage_Web(driver);
	HotelBookingPage_Web hotelBookingPage	      = new HotelBookingPage_Web(driver);

	/* Home Page */

	@And("Select From Location")
	public void selectFromLocation() throws Throwable {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			homePage.enterFromLocation();
			System.out.println("From Location is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select From Location");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select From Location in Home page", "User is unable to Select From Location in Home page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: From Location is not Selected");
		}
	}

	@And("Select To Location")
	public void selectToLocation() throws Throwable {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			homePage.enterToLocation();
			System.out.println("To Location is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select To Location");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select To Location in Home page", "User is unable to Select To Location in Home page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: To Location is not Selected");
		}
	}

	@And("Select Date of Travel")
	public void selectDateOfTravel() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			homePage.clickOnDate();
			homePage.enterDate();
			homePage.selectDate();
			System.out.println("Date of Travel is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Date of Travel");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Date of Travel in Home page", "User is unable to Select Date of Travel in Home Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Date of Travel is not Selected");
		}
	}

	@And("Click on Return Trip Booking in Home Page")
	public void clickReturnTrip() throws Throwable {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(5000);			
			homePage.clickReturnTripButtonInHomePage();
			System.out.println("Return Trip Button in Home Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click on Return Trip Booking in Home Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click on Return Trip Booking in Home Page", "User is unable to Click on Return Trip Booking in Home Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Return Trip Button in Home Page is not Clicked");
		}
	}

	@And("Select Date of Depart")
	public void enterDepartDate() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			homePage.clickOnDepartDate();
			homePage.enterDepartDate();
			System.out.println("Date of Depart is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Date of Depart");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Date of Depart in Home page", "User is unable to Select Date of Depart in Home page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Date of Depart is not Selected");
		}
	}

	@And("Select Return Date of Travel")
	public void enterReturnDate() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			homePage.clickOnReturnDate();
			homePage.enterReturnDate();
			System.out.println("Return Date of Travel is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Return Date of Travel");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Return Date of Travel on the Home page", "User is unable to Select Return Date of Travel on the Home page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Return Date of Travel is not Selected");
		}
	}

	@When("Select Vacations Tab in Booking Widget of Home Page")
	public void clickVacationTab() {
		try {
			Thread.sleep(1000);
			homePage.vacationTab();
			System.out.println(" Vacations Tab in Booking Widget of Home Page is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "When", "Select Vacations Tab in Booking Widget of Home Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Vacations Tab in Booking Widget of Home Page", "User is unable to Select Vacations Tab in Booking Widget of Home Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Vacations Tab in Booking Widget of Home Page is not Selected");
		}
	}

	@And("Select Destination Location")
	public void enterDestinationLocation() throws Throwable {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(5000);
			homePage.enterDestination();
			System.out.println("Destination Location is Entered");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Destination Location");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Destination Location", "User is unable to Select Destination Location");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Destination Location is not Entered");
		}
	}

	@And("Select Route Location")
	public void enterRouteLocation() throws Throwable {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(5000);
			homePage.enterRoute();
			System.out.println("Route Location is Entered");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Route Location");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Route Location", "User is unable to Select Route Location");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Route Location is Entered");
		}
	}

	@And("Select Date of Travel Check In in Vacation Tab")
	public void checkInDate() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			homePage.clickOnCheckInDate();
			homePage.enterCheckInDate();
			System.out.println("Date of Travel Check In in Vacation Tab is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Date of Travel Check In in Vacation Tab");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Date of Travel Check In in Vacation Tab", "User is unable to Select Date of Travel Check In in Vacation Tab");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Date of Travel Check In in Vacation Tab is not Selected");
		}
	}

	@And("Select Date of Travel Check Out in Vacation Tab")
	public void checkOutDate() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			homePage.clickOnCheckOutDate();
			homePage.enterCheckOutDate();
			System.out.println("Date of Travel Check Out in Vacation Tab is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Date of Travel Check Out in Vacation Tab");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Date of Travel Check Out in Vacation Tab", "User is unable to Select Date of Travel Check Out in Vacation Tab");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Date of Travel Check Out in Vacation Tab is not Selected");
		}
	}

	@Then("Click on Book a Package Button")
	public void clickBookPackageButton() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			homePage.clickOnBookPackageButton();
			System.out.println("Book a Package Button is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Click on Book a Package Button");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click on Book a Package Button", "User is unable to Click on Book a Package Button");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Book a Package Button is not Clicked");
		}
	}

	@Then("Choose 2x Number of rooms in Vacation Tab")
	public void numberOfRooms() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			homePage.twoNumberOfRooms();
			System.out.println("2x Number of rooms in Vacation Tab is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Choose 2x Number of rooms in Vacation Tab");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose 2x Number of rooms in Vacation Tab", "User is unable to Choose 2x Number of rooms in Vacation Tab");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: 2x Number of rooms in Vacation Tab is not Clicked");
		}
	}

	@Then("Click Continue in Home Page")
	public void clickContinueInHomePage() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			homePage.clickContinueButtonInHomePage();
			System.out.println("Continue Button in Home Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Click Continue in Home Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Continue in Home Page", "User is unable to Click Continue in Home Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Continue Button in Home Page is not Clicked");
		}
	}

	/* Hotel Booking Page */

	@And(" Click on Book now in Robin Hood Inn and Suites")
	public void clickOnRobinHoodBookNowButton() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			hotelBookingPage.clickOnRobinHoodBookNowButton();
			System.out.println("Book Now Button in Robin Hood Inn and Suites is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", " Click on Book now in Robin Hood Inn and Suites");
			ActionEngine.reportStep(driver, logInfo, "User is able to  Click on Book now in Robin Hood Inn and Suites", "User is unable to  Click on Book now in Robin Hood Inn and Suites");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Book Now Button in Robin Hood Inn and Suites is not Clicked");
		}
	}

	@Then("Click on Book now in Quality Inn Downtown Inner Harbour")
	public void clickOnQualityInnBookNowButton() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			hotelBookingPage.clickQualityInnBookNowButton();
			System.out.println("Book now in Quality Inn Downtown Inner Harbour is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", " Click on Book now in Quality Inn Downtown Inner Harbour");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click on Book now in Quality Inn Downtown Inner Harbour", "User is unable to Click on Book now in Quality Inn Downtown Inner Harbour");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Book now in Quality Inn Downtown Inner Harbour is not Clicked");
		}
	}

	@Then(" Click on Book this room button in room types")
	public void clickOnBookThisRoomButton() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			hotelBookingPage.clickBookThisRoomButton();
			System.out.println("Book this room button in room types is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", " Click on Book this room button in room types");
			ActionEngine.reportStep(driver, logInfo, "User is able to  Click on Book this room button in room types", "User is unable to  Click on Book this room button in room types");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Book this room button in room types is not Clicked");
		}
	}

	@Then("Click on View Details in Victoria Butterfly Gardens")
	public void clickVictoriaButterfltGardensViewDetailsButton() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			hotelBookingPage.clickOnVictoriaButterfltGardensViewDetailsButton();
			System.out.println("View Details in Victoria Butterfly Gardens is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", " Click on View Details in Victoria Butterfly Gardens");
			ActionEngine.reportStep(driver, logInfo, "User is able to  Click on View Details in Victoria Butterfly Gardens", "User is unable to Click on View Details in Victoria Butterfly Gardens");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: View Details in Victoria Butterfly Gardens is not Clicked");
		}
	}

	@Then("Choose 2x 18 Puls in Tickets Drop down")
	public void incrementTicketsInDropdown() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			hotelBookingPage.clickTicketsDropDownButton();
			hotelBookingPage.clickIncrementButton_18Plus();
			hotelBookingPage.clickIncrementButton_18Plus();
			System.out.println("2x 18 Puls in Tickets Drop down is Incremented");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", " Choose 2x 18 Puls in Tickets Drop down");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose 2x 18 Puls in Tickets Drop down", "User is unable to Choose 2x 18 Puls in Tickets Drop down");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: 2x 18 Puls in Tickets Drop down is not Incremented");
		}
	}

	@And("Select Check In Date in Hotel Page")
	public void checkInDateHotel() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			hotelBookingPage.clickOnCheckInDate_Hotel();
			hotelBookingPage.enterCheckInDate_Hotel();
			System.out.println("Select Check In Date in Hotel Page is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Check In Date in Hotel Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Check In Date in Hotel Page", "User is unable to Select Check In Date in Hotel Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Select Check In Date in Hotel Page is not Selected");
		}
	}

	@Then("Click Add to Package in Hotel Page")
	public void clickAddToPackageButton() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			hotelBookingPage.clickOnAddToPackageButton();
			System.out.println("Add to Package in Hotel Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", " Click Add to Package in Hotel Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Add to Package in Hotel Page", "User is unable to Click Add to Package in Hotel Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Add to Package in Hotel Page is not Clicked");
		}
	}

	@Then("Click Continue and Review Package in Hotel Page")
	public void clickContinueAndReviewPackageButton() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			hotelBookingPage.clickOnContinueAndReviewPackageButton();
			System.out.println("Continue and Review Package in Hotel Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", " Click Continue and Review Package in Hotel Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Continue and Review Package in Hotel Page", "User is unable to Click Continue and Review Package in Hotel Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Continue and Review Package in Hotel Page is not Clicked");
		}
	}

	/* Passengers Selection Page */

	@And("Choose 1x Adults Passenger in Passengers Page")
	public void oneAdults() {

		try {
			Thread.sleep(1000);
			passengerPage.clickOnIncrement_Adults();
			System.out.println("1x Adults Passenger in Passengers Page is Incremented");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Choose 1x Adults Passenger in Passengers Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose 1x Adults Passenger in Passenger Page", "User is unable to Choose 1x Adults Passenger in Passengers Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: 1x Adults Passenger in Passengers Page is not Incremented");
		}
	}

	@And("Choose 2x Adults Passenger in Passengers Page")
	public void twoAdults() {

		try {
			Thread.sleep(1000);
			passengerPage.clickOnIncrement_Adults();
			passengerPage.clickOnIncrement_Adults();
			System.out.println("2x Adults Passenger in Passengers Page is Incremented");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Choose 2x Adults Passenger in Passengers Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose 2x Adults Passenger in Passengers Page", "User is unable to Choose 2x Adults Passenger in Passengers Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: 2x Adults Passenger in Passengers Page is Incremented");
		}
	}

	@And("Choose 1x Children Passenger in Passengers Page")
	public void oneChildren() {

		try {
			Thread.sleep(1000);
			passengerPage.clickOnIncrement_Children();
			System.out.println("1x Children Passenger in Passengers Page is Incremented");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Choose 1x Children Passenger in Passengers Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose 1x Children Passenger in Passengers Page", "User is unable to Choose 1x Children Passenger in Passengers Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: 1x Children Passenger in Passengers Page is not Incremented");
		}
	}

	@And("Choose 2x Children Passenger in Passengers Page")
	public void twoChildren() {

		try {
			Thread.sleep(1000);
			passengerPage.clickOnIncrement_Children();
			passengerPage.clickOnIncrement_Children();
			System.out.println("2x Children Passenger in Passengers Page is Incremented");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Choose 1x children");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose 2x Children Passenger in Passengers Page", "User is unable to Choose 2x Children Passenger in Passengers Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: 1x Children Passenger in Passengers Page is not Incremented");
		}
	}

	@And("Choose 1x Infants Passenger in Passengers Page")
	public void oneInfants() {

		try {
			Thread.sleep(1000);
			passengerPage.clickOnIncrement_Infants();
			System.out.println("1x Infants Passenger in Passengers Page is Incremented");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Choose 1x Infants Passenger in Passengers Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose 1x Infants Passenger in Passengers Page", "User is unable to Choose 1x Infants Passenger in Passengers Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: 1x Infants Passenger in Passengers Page is not Incremented");
		}
	}

	@And("Choose 1x BC Resident Seniors in Passengers Page")
	public void oneBCResidentSeniors() {

		try {
			Thread.sleep(1000);
			passengerPage.clickOnIncrement_BCResidentSeniors();
			System.out.println("1x BC Resident Seniors in Passengers Page is Incremented");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Choose 1x BC Resident Seniors in Passengers Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose 1x BC Resident Seniors in Passengers Page", "User is unable to Choose 1x BC Resident Seniors in Passengers Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: 1x BC Resident Seniors in Passengers Page is not Incremented");
		}
	}

	@And("Choose 2x BC Resident Seniors in Passengers Page")
	public void twoBCResidentSeniors() {

		try {
			Thread.sleep(1000);
			passengerPage.clickOnIncrement_BCResidentSeniors();
			passengerPage.clickOnIncrement_BCResidentSeniors();
			System.out.println("2x BC Resident Seniors in Passengers Page is Incremented");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Choose 2x BC Resident Seniors in Passengers Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose 2x BC Resident Seniors in Passengers Page", "User is unable to Choose 2x BC Resident Seniors in Passengers Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: 2x BC Resident Seniors in Passengers Page is not Incremented");
		}
	}

	@And("Select - I have accessibility requirements in Passengers Page")
	public void addAccessibilityNeeds() {

		try {
			Thread.sleep(1000);
			passengerPage.clickOnCheckBoxAccessibilityNeeds();
			System.out.println("I have accessibility requirements in Passengers Page is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select - I have accessibility requirements in Passengers Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select - I have accessibility requirements in Passengers Page", "User is unable to Select - I have accessibility requirements in Passengers Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: I have accessibility requirements in Passengers Page is not Selected");
		}
	}

	@And("Select Passenger1 - Hearing Impairment and Request a wheelchair")
	public void passenger1_AddAccessibilityOptions() {
		try {
			Thread.sleep(1000);
			passengerPage.passenger1_AccessibilityOptions("Hearing impairment", "Request a wheelchair");
			System.out.println("Passenger 1 - Hearing Impairment and Request a wheelchair is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Passenger 1 - Hearing Impairment and Request a wheelchair");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Passenger 1 - Hearing Impairment and Request a wheelchair", "User is unable to Select Passenger 1 - Hearing Impairment and Request a wheelchair");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Passenger 1 - Hearing Impairment and Request a wheelchair is not Selected");
		}
	}

	@And("Select Passenger2 - Traveling with own wheelchair and Request boarding assistance")
	public void passenger2_AddAccessibilityOptions() {
		try {
			Thread.sleep(1000);
			passengerPage.passenger2_AccessibilityOptions("Travelling with own wheelchair", "Request wheelchair with boarding assistance");
			System.out.println("Passenger 2 - Traveling with own wheelchair and Request boarding assistance is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Passenger 2 - Traveling with own wheelchair and Request boarding assistance");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Passenger 2 - Traveling with own wheelchair and Request boarding assistance", "User is unable to Select Passenger 2 - Traveling with own wheelchair and Request boarding assistance");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Passenger 2 - Traveling with own wheelchair and Request boarding assistance is not Selected");
		}
	}

	@And("Select - Travelling without a vehicle in Passengers Page")
	public void withoutVehicleOptions() {
		try {
			Thread.sleep(1000);
			passengerPage.withoutVehicle();
			System.out.println("Travelling without a vehicle in Passengers Page is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select - Travelling without a vehicle in Passengers Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select - Travelling without a vehicle in Passengers Page", "User is unable to Select - Travelling without a vehicle in Passengers Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Travelling without a vehicle in Passengers Page is not Selected");
		}
	}

	@Then("Click Continue in Passengers Page")
	public void clickContinueInPassengersPage() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			passengerPage.clickContinueButtonInPassengersPage();
			System.out.println("Continue Button in Passengers Page has been Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Click Continue in Passengers Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Continue in Passengers Page", "User is unable to Click Continue in Passengers Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Clicking Continue in Passengers Page");
		}
	}
	
	@Then("Click Continue in Passengers Page without a vehicle")
	public void clickContinueInPassengersPagewithoutvehicle() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			passengerPage.clickContinueButtonInPassengersPageWhithoutVehicle();
			System.out.println("Continue Button in Passengers Page has been Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Click Continue in Passengers Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Continue in Passengers Page", "User is unable to Click Continue in Passengers Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Clicking Continue in Passengers Page");
		}
	}

	@And("Select Motorcycle and select Trike or sidecar")
	public void SelectMotorcycleTrike() {
		try {
			Thread.sleep(1000);
			vehiclePage.selectMotorcycleandTrike();
			System.out.println("Select Motorcycle and select Trike or sidecar");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Motorcycle and select Trike or sidecar");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Motorcycle and select Trike or sidecar", "User is unable to Select Motorcycle and select Trike or sidecar");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Select Motorcycle and select Trike or sidecar");
		}
	}

	@And("Select Motorcycle and select Standard with Trailer")
	public void SelectMotorcycleTrailer() {
		try {
			Thread.sleep(1000);
			vehiclePage.selectMotorcycleannTrailer();
			System.out.println("Select Motorcycle and select Standard with Trailer");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Motorcycle and select Standard with Trailer");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Motorcycle and select Standard with Trailer", "User is unable to Select Motorcycle and select Standard with Trailer");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Select Motorcycle and select Standard with Trailer");
		}
	}


	@And("Select ‘Over 5,500 kg GVW’ > select ‘Semi-trailer’> select ‘Under 9ft wide’ > total length: 70 ft, Total height: 12 ft")
	public void SelectSemiTrailer_Under9ft() {
		try {
			Thread.sleep(1000);
			vehiclePage.clickOnOver5000kgGVW();
			vehiclePage.clickOnSemiTrailer();
			vehiclePage.clickOnSemiTrailerUnder9ft();
			vehiclePage.EnterOnSemiTrailerUnder9ftLen("70");
			vehiclePage.EnterOnSemiTrailerUnder9ftHeight("12");
			System.out.println("Select ‘Over 5,500 kg GVW’ > select ‘Semi-trailer’> select ‘Under 9ft wide’ > total length: 70 ft, Total height: 12 ft");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Motorcycle and select Standard with Trailer");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select ‘Over 5,500 kg GVW’ > select ‘Semi-trailer’> select ‘Under 9ft wide’ > total length: 70 ft, Total height: 12 ft", "User is unable to Select ‘Over 5,500 kg GVW’ > select ‘Semi-trailer’> select ‘Under 9ft wide’ > total length: 70 ft, Total height: 12 ft");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Select ‘Over 5,500 kg GVW’ > select ‘Semi-trailer’> select ‘Under 9ft wide’ > total length: 70 ft, Total height: 12 ft");
		}
	}


	@And("And Click Continue without amenities")
	public void SelectContinueWithoutAmenities() {
		try {
			Thread.sleep(1000);
			fareReviewPage.clickContinueWithoutAmenities();
			System.out.println("And Click Continue without amenities");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "And Click Continue without amenities");
			ActionEngine.reportStep(driver, logInfo, "User is able to And Click Continue without amenities", "User is unable to And Click Continue without amenities");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: And Click Continue without amenities");
		}
	}


	/* Ancillary Page */

	@And("Select 1x Cabin type 2 Bed Inside Cabin")
	public void selectFourBedInsideCabin() {

		try {
			Thread.sleep(1000);
			ancillaryPage.clickSelectCabinType();
			ancillaryPage.clickOnPlusTwoBedInsideCabin();
			System.out.println("1x Cabin type 4 Bed Inside Cabin is Incremented");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select 1x cabin type 4 Bed Inside Cabin");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select 1x Cabin type 4 Bed Inside Cabin", "User is unable to Select 1x Cabin type 4 Bed Inside Cabin");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: 1x Cabin type 4 Bed Inside Cabin is not Incremented");
		}
	}

	@And("Select cabin type-Bed Outside Cabin")
	public void selectTwoBedOutsideCabin() {

		try {
			Thread.sleep(1000);
			ancillaryPage.clickSelectCabinType();
			ancillaryPage.clickOnPlusTwoBedOutsideCabin();
			System.out.println("1x Cabin type 2 Bed Outside Cabin is Incremented");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select 1x Cabin type 2 Bed Outside Cabin");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select 1x Cabin type 2 Bed Outside Cabin", "User is unable to Select 1x Cabin type 2 Bed Outside Cabin");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: 1x Cabin type 2 Bed Outside Cabin is Incremented");
		}
	}

	
	
	
	
	@Then("Click Continue in Ancillary Page")
	public void clickContinueButtonInAncillaryPage() {

		try {
			Thread.sleep(1000);
			ancillaryPage.clickContinueButtonInAncillaryPage();
			System.out.println("Continue Button in Ancillary Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Click Continue in Ancillary Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Continue in Ancillary Page", "User is unable to Click Continue in Ancillary Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Continue Button in Ancillary Page is not Clicked");
		}
	}

	/* Traveller Details Page */

	@And("Enter Passenger1 Information in Traveller Details Page")
	public void enterPassenger1Information() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(3000);
			travellerDetailsPage.P1_firstName("xyz");
			travellerDetailsPage.P1_lastName("test");
			travellerDetailsPage.P1_email("xyz@test.com");
			travellerDetailsPage.P1_Gender("Male");
			travellerDetailsPage.P1_confirmEmail("xyz@test.com");
			travellerDetailsPage.P1_phone_number("8497583647");
			System.out.println("Passenger 1 Information in Traveller Details Page is Entered");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Enter Passenger 1 Information in Traveller Details Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Enter Passenger 1 Information in Traveller Details Page", "User is unable to Enter Passenger 1 Information in Traveller Details Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Passenger 1 Information in Traveller Details Page is Entered");
		}
	}

	@And("Click Dont know licence plate details Checkbox in Travellers Details Page")
	public void selectDontKnowLicencePlateCheckbox() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(3000);
			travellerDetailsPage.clickonDontknowLicenceplatechkbox();
			System.out.println("Don't know licence plate details Checkbox in Traveller Details Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Don't know licence plate details Checkbox in Traveller Details Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Don't know licence plate details Checkbox in Traveller Details Page", "User is unable to Click Don't know licence plate details Checkbox in Traveller Details Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Don't know licence plate details Checkbox in Traveller Details Page is not Clicked");
		}
	}

	@And("Enter Passenger2 Information in Traveller Details Page")
	public void enterPassenger2Information() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(3000);
			travellerDetailsPage.P2_firstName("xyz");
			travellerDetailsPage.P2_lastName("test");
			travellerDetailsPage.P2_Gender("Male");
			System.out.println("Passenger 2 Information in Traveller Details Page is Entered");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Enter Passenger 2 Information in Traveller Details Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Enter Passenger 2 Information in Traveller Details Page", "User is unable to Enter Passenger 2 Information in Traveller Details Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Passenger 2 Information in Traveller Details Page is not Entered");
		}
	}
	
	@And("Enter Passenger 3 Information in Traveller Details Page")
	public void enterPassenger3Information() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(3000);
			travellerDetailsPage.P3_firstName("xyz");
			travellerDetailsPage.P3_lastName("test");
			travellerDetailsPage.P3_Gender("Male");
			System.out.println("Passenger 3 Information in Traveller Details Page is Entered");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Enter Passenger 3 Information in Traveller Details Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Enter Passenger 3 Information in Traveller Details Page", "User is unable to Enter Passenger 3 Information in Traveller Details Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Passenger 3 Information in Traveller Details Page is not Entered");
		}
	}

	@And("Click Checkout as Guest in Traveller Details Page")
	public void clickCheckoutAsGuestInTravellerDetailsPage() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			travellerDetailsPage.checkoutAsGuestInTravellerDetailsPage();
			System.out.println("Checkout as Guest in Traveller Details Page is clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Checkout as Guest in Traveller Details Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Checkout as Guest in Traveller Details Page", "User is unable to Click Checkout as Guest in Traveller Details Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception:Checkout as Guest in Traveller Details Page is not clicked");
		}
	}

	@And("Click Login & Checkout in Traveller Details Page")
	public void clickLoginAndCheckoutInTravellerDetailsPage() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			travellerDetailsPage.loginAndCheckoutInTravellerDetailsPage();
			System.out.println("Login & Checkout in Traveller Details Page is clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Login & Checkout in Traveller Details Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Login & Checkout in Traveller Details Page", "User is unable to Click Login & Checkout in Traveller Details Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception:Login & Checkout in Traveller Details Page is not clicked");
		}
	}

	@And("Select Round Trip")
	public void selectRoundTrip() {
		try {
			Thread.sleep(1000);
			homePage.clickOnRoundTripBtn();
			System.out.println("Select Round Trip");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select Round Trip");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select Round Trip", "User is unable to Select Round Trip");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Select Round Trip");
		}
	}

	/* Vehicle Selection Page */

	@And("Choose Vehicle Under 7ft Height in Vehicle Selection Page")
	public void selectVehicleHeightUnder() {

		try {
			Thread.sleep(1000);
			vehiclePage.clickOnHeight_Under();
			System.out.println("Vehicle Under 7ft Height in Vehicle Selection Page is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Choose Vehicle Under 7ft Height");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose Vehicle Under 7ft Height in Vehicle Selection Page", "User is unable to Choose Vehicle Under 7ft Height in Vehicle Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Vehicle Under 7ft Height in Vehicle Selection Page is not Selected");
		}
	}

	@And("Choose Vehicle Under 20ft Length in Vehicle Selection Page")
	public void selectVehicleLengthUnder() {

		try {
			Thread.sleep(1000);
			vehiclePage.clickOnLength_Under();
			System.out.println("Vehicle Under 20ft Length in Vehicle Selection Page is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", " Choose Vehicle Under 20ft Length in Vehicle Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to  Choose Vehicle Under 20ft Length in Vehicle Selection Page", "User is unable to  Choose Vehicle Under 20ft Length in Vehicle Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception:  Vehicle Under 20ft Length in Vehicle Selection Page is not Selected");
		}
	}

	@And("Choose Vehicle Over 7ft Height in Vehicle Selection Page")
	public void selectVehicleHeightAbove() {

		try {
			Thread.sleep(1000);
			vehiclePage.selectAndEnterVehilceHeightOver7ft("8");
			System.out.println("Vehicle Over 7ft Height in Vehicle Selection Page is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Choose Vehicle Over 7ft Height in Vehicle Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose Vehicle Over 7ft Height in Vehicle Selection Page", "User is unable to Choose Vehicle Over 7ft Height in Vehicle Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Vehicle Over 7ft Height in Vehicle Selection Page is Selected");
		}
	}

	@And("Choose Vehicle Over 20ft Length in Vehicle Selection Page")
	public void selectVehicleLengthAbove() {

		try {
			Thread.sleep(1000);
			vehiclePage.selectAndEnterVehilceLengthOver20ft("30");
			System.out.println("Vehicle Over 20ft Length is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Choose Vehicle Over 20ft Length in Vehicle Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose Vehicle Over 20ft Length in Vehicle Selection Page", "User is unable to Choose Vehicle Over 20ft Length in Vehicle Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Vehicle Over 20ft Length is not Selected");
		}
	}

	@And("Select - Carrying Dangerous Goods")
	public void selectDangerousGoods() {

		try {
			Thread.sleep(1000);
			vehiclePage.clickOnDangerousGoods();
			System.out.println("Carrying Dangerous Goods is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Select - Carrying Dangerous Goods");
			ActionEngine.reportStep(driver, logInfo, "User is able to Select - Carrying Dangerous Goods", "User is unable to Select - Carrying Dangerous Goods");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Carrying Dangerous Goods is not Selected");
		}
	}

	@Then("Click Continue in Vehicle Selection Page")
	public void clickContinueInVehicleSelectionPage() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			vehiclePage.clickContinueButtonInVehicleSelectionPage();
			System.out.println("Continue Button in Vehicle Selection Page has been Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Click Continue in Vehicle Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Continue in Vehicle Selection Page", "User is unable to Click Continue in Vehicle Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Clicking Continue Button in Vehicle Selection Page");
		}
	}

	@And("Choose Vacation Vehicle Under 7ft Height in Vehicle Selection Page")
	public void selectVehicleHeightUnder_Vacation() {

		try {
			Thread.sleep(1000);
			vehiclePage.clickOnHeightUnder_Vacation();
			System.out.println("Vacation Vehicle Under 7ft Height in Vehicle Selection Page is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Choose Vacation Vehicle Under 7ft Height in Vehicle Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose Vacation Vehicle Under 7ft Height in Vehicle Selection Page", "User is unable to Choose Vacation Vehicle Under 7ft Height in Vehicle Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Vacation Vehicle Under 7ft Height in Vehicle Selection Page is not Selected");
		}
	}

	@And("Choose Vacation Vehicle Under 20ft Length in Vehicle Selection Page")
	public void selectVehicleLengthUnder_Vacation() {

		try {
			Thread.sleep(1000);
			vehiclePage.clickOnLengthUnder_Vacation();
			System.out.println("Vacation Vehicle Under 20ft Length in Vehicle Selection Page is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", " Choose Vacation Vehicle Under 20ft Length in Vehicle Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose Vacation Vehicle Under 20ft Length in Vehicle Selection Page", "User is unable to Choose Vacation Vehicle Under 20ft Length in Vehicle Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception:  Vacation Vehicle Under 20ft Length in Vehicle Selection Page is not Selected");
		}
	}

	@And("Choose Vacation Vehicle Over 7ft Height in Vehicle Selection Page")
	public void selectVehicleHeightOver_Vacation() {

		try {
			Thread.sleep(1000);
			vehiclePage.clickOnHeightOver_Vacation();
			System.out.println("Vacation Vehicle Over 7ft Height in Vehicle Selection Page is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Choose Vacation Vehicle Over 7ft Height in Vehicle Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose Vacation Vehicle Over 7ft Height in Vehicle Selection Page", "User is unable to Choose Vacation Vehicle Over 7ft Height in Vehicle Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Vacation Vehicle Over 7ft Height in Vehicle Selection Page is not Selected");
		}
	}

	@And("Choose Vacation Vehicle Over 20ft Length in Vehicle Selection Page")
	public void selectVehicleLengthOver_Vacation() {

		try {
			Thread.sleep(1000);
			vehiclePage.clickOnLengthOver_Vacation();
			System.out.println("Vacation Vehicle Over 20ft Length in Vehicle Selection Page is Selected");
			logInfo = ActionEngine.getExtentObj(scenario, "And", " Choose Vacation Vehicle Over 20ft Length in Vehicle Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Choose Vacation Vehicle Over 20ft Length in Vehicle Selection Page", "User is unable to Choose Vacation Vehicle Over 20ft Length in Vehicle Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception:  Vacation Vehicle Over 20ft Length in Vehicle Selection Page is not Selected");
		}
	}

	@Then("Click Vacation Continue Button in Vehicle Selection Page")
	public void clickVacationContinueInVehicleSelectionPage() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			vehiclePage.clickVacationContinueButtonInVehicleSelectionPage();
			System.out.println("Vacation Continue Button in Vehicle Selection Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Click Vacation Continue Button in Vehicle Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Vacation Continue Button in Vehicle Selection Page", "User is unable to Click Vacation Continue Button in Vehicle Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Vacation Continue Button in Vehicle Selection Page is not Clicked");
		}
	}

	/* Fare Selection Page */

	@And("Click View Fares in Fare Selection Page")
	public void clickViewFare() {

		try {
			Thread.sleep(1000);
			fareSelectPage.clickOnViewFares();
			System.out.println("View Fares Button in Fare Selection Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click View Fares in Fare Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click View Fares in Fare Selection Page", "User is unable to Click View Fares in Fare Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Clicking View Fares Button in Fare Selection Page");
		}
	}

	@And("Click Select Button in Fare Selection Page")
	public void clickSelectButton() {

		try {
			Thread.sleep(1000);
			fareSelectPage.clickOnSelectButton();
			System.out.println("Select Button in Fare Selection Page has been Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Select Button in Fare Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Select Button in Fare Selection Page", "User is unable to Click Select Button in Fare Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Clicking Select Button in Fare Selection Page");
		}
	}
	
	@And("Click Select Button in Fare Selection Page for North Sailing")
	public void clickSelectButtonNorthSailing() {

		try {
			Thread.sleep(1000);
			fareSelectPage.clickOnSelectButton_NorthSailing();
			System.out.println("Select Button in Fare Selection Page has been Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Select Button in Fare Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Select Button in Fare Selection Page", "User is unable to Click Select Button in Fare Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Clicking Select Button in Fare Selection Page");
		}
	}

	@And("Click Return View Fares in Fare Selection Page")
	public void clickReturnViewFare() {

		try {
			Thread.sleep(1000);
			fareSelectPage.clickOnReturnViewFares();
			System.out.println("Return View Fares Button in Fare Selection Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Return View Fares in Fare Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Return View Fares in Fare Selection Page", "User is unable to Click Return View Fares in Fare Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Clicking Return View Fares Button in Fare Selection Page");
		}
	}

	@And("Click Return Select Button in Fare Selection Page")
	public void clickReturnPrepaidOption() {

		try {
			Thread.sleep(1000);
			fareSelectPage.clickOnReturnSelectFares();
			System.out.println("Return Select Button in Fare Selection Page has been Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Return Select Button in Fare Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Return Select Button in Fare Selection Page", "User is unable to Click Return Select Button in Fare Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Clicking Return Select Button in Fare Selection Page");
		}
	}


	@And("Click Select Button Vacation in Fare Selection Page")
	public void clickSelectButton_Vacation() {

		try {
			Thread.sleep(1000);
			fareSelectPage.clickSelectButton_Vacation_Coastal();
			System.out.println("Select Button Vacation in Fare Selection Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Select Button Vacation in Fare Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Select Button Vacation in Fare Selection Page", "User is unable to Click Select Button Vacation in Fare Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Select Button Vacation in Fare Selection Page is not Clicked");
		}
	}

	@And("Click Return Select Button Vacation in Fare Selection Page")
	public void clickReturnSelectButton_Vacation() {

		try {
			Thread.sleep(1000);
			fareSelectPage.clickOnReturnSelect_Vacation();
			System.out.println("Return Select Button Vacation in Fare Selection Page");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Select Button Vacation in Fare Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Return Select Button Vacation in Fare Selection Page", "User is unable to Click Return Select Button Vacation in Fare Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Return Select Button Vacation in Fare Selection Page is not Clicked");
		}
	}

	/* Fare Selection Review Page */

	@Then("Verify User is on Fare Selection Review Page")
	public void verifyFareSelectionReviewPage() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			fareReviewPage.fareReviewPageIsDisplayed();
			System.out.println("Verified User is on Fare Selection Review Page");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Verify User is on Fare Selection Review Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Verify is on Fare Selection Review Page", "User is unable to Verify is on Fare Selection Review Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Verifying User is on Fare Selection Review Page");
		}
	}

	@And("Click Checkout as Guest in Fare Selection Review Page")
	public void clickCheckoutAsGuest() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			fareReviewPage.checkoutAsGuest();
			System.out.println("Checkout as Guest Button in Fare Selection Review Page has been Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Checkout as Guest in Fare Selection Review Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Checkout as Guest Button in Fare Selection Review Page", "User is unable to Click Checkout as Guest Button in Fare Selection Review Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception:Checkout as Guest Button in Fare Selection Review Page is not Clicked");
		}
	}

	@And("Click Login and Checkout in Fare Selection Review Page")
	public void clickLoginAndCheckoutButton() throws Throwable {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(5000);
			fareReviewPage.loginCheckout();
			System.out.println("Login and Checkout in Fare Selection Review Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Click Login and Checkout in Fare Selection Review Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Login and Checkout in Fare Selection Review Page", "User is unable to Click Login and Checkout in Fare Selection Review Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Login and Checkout in Fare Selection Review Page is not Clicked");
		}
	}

	@Then("Click Continue Button in Fare Selection Review Page")
	public void clickContinueButton() throws Throwable {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(5000);
			fareReviewPage.continueButton();
			System.out.println("Continue Button in Fare Selection Review Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Continue Button in Fare Selection Review Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Continue Button in Fare Selection Review Page", "User is unable to Click Continue Button in Fare Selection Review Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Continue Button in Fare Selection Review Page is not Clicked");
		}
	}

	@And("Click Add cabins & amenities in Fare Selection Page")
	public void selectCabinsandAmenities() {

		try {
			Thread.sleep(1000);
			fareReviewPage.clickOnAddCabins();
			System.out.println("Add cabins & amenities in Fare Selection Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Add cabins & amenities in Fare Selection Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Add cabins & amenities in Fare Selection Page", "User is unable to Click Add cabins & amenities in Fare Selection Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Add cabins & amenities in Fare Selection Page is not Clicked");
		}
	}

	@Then("Click Add Activities Button in Fare Selection Review Page")
	public void clickAddActivitiesButton() throws Throwable {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(5000);
			fareReviewPage.clickOnAddActivities();
			System.out.println("Add Activities Button in Fare Selection Review Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Add Activities Button in Fare Selection Review Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Add Activities Button in Fare Selection Review Page", "User is unable to Click Add Activities Button in Fare Selection Review Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Add Activities Button in Fare Selection Review Page is not Clicked");
		}
	}


	/* Login Page */

	@Then("Enter Login Credentials in Login Page")
	public void enterLoginCredentials() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(5000);
			loginPage.email("testcase5@uat.com");
			loginPage.password("J8CC7S2d!");				
			System.out.println("Login Credentials in Login Page is Entered");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Enter Login Credentials in Login Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Enter Login Credentials in Login Page", "User is unable to Enter Login Credentials in Login Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Login Credentials in Login Page is not Entered");
		}
	}

	@And("Click Login Button in Login Page")
	public void clickLoginButton() throws Throwable {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(5000);
			loginPage.loginButton();
			System.out.println("Login Button in Login Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click Login Button in Login Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Login Button in Login Page", "User is unable to Click Login Button in Login Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Login Button in Login Page is not Clicked");
		}
	}

	/* Payment Page */

	@Then("Enter Guest Checkout Information in Payment Page")
	public void enterGuestCheckoutInformation() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			paymentPage.firstName("test");
			paymentPage.lastName("test");
			paymentPage.email("test@xyz.com");
			paymentPage.confirmEmail("test@xyz.com");
			paymentPage.phoneNumber("9992226537");			
			System.out.println("Guest Checkout Information in Payment Page is Entered");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Enter Guest Checkout Information in Payment Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Enter Guest Checkout Information in Payment Page", "User is unable to Enter Guest Checkout Information in Payment Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Guest Checkout Information in Payment Page is not Entered");
		}
	}

	@And("Enter Payment Method Information in Payment Page")
	public void enterPaymentMethodInformation() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			paymentPage.nameOnCard("Test test");
			paymentPage.cardNumber("4444777755552222");
			paymentPage.expiryDate("12/29");
			paymentPage.cvvNumber("123");
			System.out.println("Payment Method Information in Payment Page is Entered");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Enter Payment Method Information in Payment Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Enter Payment Method Information in Payment Page", "User is unable to Enter Payment Method Information in Payment Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Payment Method Information in Payment Page is not Entered");
		}
	}

	@And("Enter Billing Address Information in Payment Page")
	public void billingAddressInformation() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(1000);
			paymentPage.streetNumberForAddress("101");
			paymentPage.streetNameForAddress("vancouver");
			paymentPage.cityName("Quebec");
			paymentPage.countryName("Canada");
			paymentPage.provinceName("Alberta");
			paymentPage.postlCode("V8L3S2");
			System.out.println("Billing Address Information is Entered");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Enter Billing Address Information in Payment Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Enter Billing Address Information in Payment Page", "User is unable to Enter Billing Address Information in Payment Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception: Billing Address Information is not Entered");
		}
	}

	@Then("Click Complete Booking in Payment Page")
	public void clickCompleteBooking() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(2000);
			paymentPage.checkBox();
			//paymentPage.completeBooking();
			System.out.println("Complete Booking in Payment Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "Then", "Click Complete Booking in Payment Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click Complete Booking in Payment Page", "User is unable to Click Complete Booking in Payment Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception:Complete Booking in Payment Page not Clicked");
		}
	}	

	@And("Click  Saved Card Radio Button in Payment Page")
	public void clickSavedCardRadioButton() {
		ExtentTest logInfo = null;

		try {
			Thread.sleep(2000);
			paymentPage.clickSavedCardRadioButton();
			System.out.println("Saved Card Radio Button in Payment Page is Clicked");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Click  Saved Card Radio Button in Payment Page");
			ActionEngine.reportStep(driver, logInfo, "User is able to Click  Saved Card Radio Button in Payment Page", "User is unable to Click  Saved Card Radio Button in Payment Page");

		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception:Saved Card Radio Button in Payment Page is not Clicked");
		}
	}

	@And("Verifying Booking Confirmation Screen")	
	public void isBookingSuccessful() throws InterruptedException {	
		ExtentTest logInfo = null;	

		try {
			Thread.sleep(3000);
			paymentPage.bookingConfirmation();
			System.out.println("Booking Confirmation Screen is Verified");
			logInfo = ActionEngine.getExtentObj(scenario, "And", "Verifying Booking Confirmation Screen");
			ActionEngine.reportStep(driver, logInfo, "User is able to Verifying Booking Confirmation Screen","User is unable to Verifying Booking Confirmation Screen");
		} catch (Exception e) {
			Base.Log4j.info(e.getMessage());
			Base.Log4j.info("Exception:Booking Confirmation Screen is not Verified");
		}
	}


	@After("@Scenario1")
	public void closeNativeApp() {
		Base.Log4j.info("Closing the Application");
		driver.quit();

	}
}
