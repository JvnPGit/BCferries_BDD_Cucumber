Feature: Book Sailings for Unauthenticated User/Guest User

  Background: 
    Given User launched browser
    Then User enters required URL

@Regression1
  Scenario: Core Booking Flow (Southern Gulf Island One-Way Guest Foot Passenger)
    And Select From Location
    And Select To Location
    And Select Date of Travel
    Then Click on Continue for Home Page
    And Increment number of Adults travelling
    And Increment number of Infants travelling
    And Select Travelling without a vehicle
    Then Click on Continue for Passengers Page
    And Select View Fares
    And Select Prepaid option
    And Click on Checkout as a guest
    Then Enter Guest Checkout information
    And Enter Payment method information
    And Enter Billing Address information
    Then Click on PayNow button

 @Scenario1
  Scenario: Core Booking Flow (Southern Gulf Island Return trip / Guest Foot Passenger)
 	 
   And Click on ReturnTripBooking
   And Select From Location
   And Select To Location
   And Select Date of Depart
   And Select Date of Return
   Then Click on Continue for Home Page
   And Increment number of Adults travelling
   And Increment number of Children travelling   
   And Select without a vehicle   
   Then Click on Continue for Passengers Page   
   And Select View Fares
   And Select Prepaid option
   And Select Return View Fares
   And Select Return Prepaid option   
   Then Verify if the User is on Fare Selection Review page
   And Click on Checkout as a guest
   Then Enter Guest Checkout information
   And Enter Payment method information
   And Enter Billing Address information
   Then Click on PayNow button
   And Verify Booking Confirmation screen


 @Scenario13
   Scenario: Core Booking Flow (Southern Gulf Island One-Way Guest Motorcycle with sidecar)
 	 
   And Select From Location
   And Select To Location
   And Select Date of Travel
   Then Click on Continue for Home Page
   And Choose 2x adult passenger
   Then Click on Continue for Passengers Page
   And Select Motorcycle and select Trike or sidecar
   Then Click on Continue for Vehicles Page
   And Select View Fares
   And Select Prepaid option
   Then Verify if the User is on Fare Selection Review page
   And Click on Checkout as a guest
   Then Enter Guest Checkout information
   And Enter Payment method information
   And Enter Billing Address information
   Then Click on PayNow button
   And Verify Booking Confirmation screen
  
   
	@Scenario14
   Scenario: Core Booking Flow (Southern Gulf Island Return trip / Guest Motorcycle standard with trailer)
 	 
 	 And Select Round Trip
   And Select From Location
   And Select To Location
   And Select Date of Travel
   And Select Return Date of Travel
   Then Click on Continue for Home Page
   And Choose 1x adult passenger
   And Choose 1x children
   Then Click on Continue for Passengers Page
   And Select Motorcycle and select Standard with Trailer
   Then Click on Continue for Vehicles Page
   And Select View Fares for Departure
   And Select Prepaid option for Departure
   And Select View Fares for Return
   And Select Prepaid option for Return
   Then Verify if the User is on Fare Selection Review page
   And Click on Checkout as a guest
   Then Enter Guest Checkout information
   And Enter Payment method information
   And Enter Billing Address information
   Then Click on PayNow button
   And Verify Booking Confirmation screen
   
    @Scenario15
  Scenario: Core Booking Flow (Southern Gulf Island One-Way Guest Foot Passenger)
    When Click on login button in Home Page
    And Enter login creadentials
    And Click on login button
    And Select One-way trip
    And Select From Location
    And Select To Location
    And Select Date of Travel
    Then Click on Continue for Home Page
    And Increment number of Adults travelling
    And Increment number of Infants travelling
    And Select Travelling without a vehicle
    Then Click on Continue for Passengers Page
    And Select View Fares
    And Select Prepaid option
    And Click on Checkout as a guest
    Then Enter Guest Checkout information
    And Enter Payment method information
    And Enter Billing Address information
    Then Click on PayNow button
   
    @Scenario16
  Scenario: Core Booking Flow (Southern Gulf Island Return trip / Logged In Foot Passenger)
  
  And Login in Account  
  And Select Different Account  
  And Select Cigniti Testers
  And Click book a sailing   
  And Click on ReturnTripBooking
   And Select From Location
   And Select To Location
   And Select Date of Depart
   And Select Date of Return
   Then Click on Continue for Home Page
   And Increment number of Adults travelling
   And Increment number of Children travelling   
   And Select without a vehicle   
   Then Click on Continue for Passengers Page   
   And Select View Fares
   And Select Prepaid option
   And Select Return View Fares
   And Select Return Prepaid option   
   Then Verify if the User is on Fare Selection Review page
   And Click on Checkout as a guest
   Then Enter Guest Checkout information
   And Enter Payment method information
   And Enter Billing Address information
   Then Click on PayNow button
   And Verify Booking Confirmation screen
   
   @Scenario17
   Scenario: Core Booking Flow (Southern Gulf Island One-Way Logged In Motorcycle with sidecar)
 	 
   And Select From Location
   And Select To Location
   And Select Date of Travel
   Then Click on Continue for Home Page
   And Choose 2x adult passenger
   Then Click on Continue for Passengers Page
   And Select Motorcycle and select Trike or sidecar
   Then Click on Continue for Vehicles Page
   And Select View Fares
   And Select Prepaid option
   Then Verify if the User is on Fare Selection Review page
   And Click on Checkout as a guest
   Then Enter Guest Checkout information
   And Enter Payment method information
   And Enter Billing Address information
   Then Click on PayNow button
   And Verify Booking Confirmation screen
   
   @Scenario18
   Scenario: Core Booking Flow (Southern Gulf Island One-Way Logged In Motorcycle with sidecar)
 	 
 	 And Select Round Trip
   And Select From Location
   And Select To Location
   And Select Date of Travel
   And Select Return Date of Travel
   Then Click on Continue for Home Page
   And Choose 2x adult passenger
   Then Click on Continue for Passengers Page
   And Select Motorcycle and select Trike or sidecar
   Then Click on Continue for Vehicles Page
   And Select View Fares for Departure
   And Select Prepaid option for Departure
   And Select View Fares for Return
   And Select Prepaid option for Return
   Then Verify if the User is on Fare Selection Review page
   And Click on Checkout as a guest
   Then Enter Guest Checkout information
   And Enter Payment method information
   And Enter Billing Address information
   Then Click on PayNow button
   And Verify Booking Confirmation screen
   
    @Scenario19
  Scenario: Core Booking Flow (Commercial Over 5,550 kg SEMI AB Train TSA-DUK Guest round trip)
  
  And Click on ReturnTripBooking
  And Select From Location
   And Select To Location
   And Select Date of Depart
   And Select Date of Return
   Then Click on Continue for Home Page
   And Increment number of Adults travelling
    And Select Different passengers on return trip
    And Increment number of Adults travelling
    Then Click on Continue for Passingers selectionPage
    And Select Over 5,500 kg GVW
    And Select A/BTrain
    And Select Under 9ft Wide
    And Select Total length
    And Select Total Height
    And Click on Continue for VehicleselectionPage
     And Select View Fares
     And Select Prepaid option
    And Select Return View Fares
   And Select Return Prepaid option
   Then Verify if the User is on Fare Selection Review page
   And Click on Checkout as a guest
   Then Enter Guest Checkout information
   And Enter Payment method information
   And Enter Billing Address information
   Then Click on PayNow button
   And Verify Booking Confirmation screen
   
   @Scenario20
   Scenario: Core Booking Flow (Commercial Over 5,550 kg SEMI TSA-DUK Guest round trip)
 	 
 	 And Select Round Trip
   And Select From Location
   And Select To Location
   And Select Date of Travel
   And Select Return Date of Travel
   Then Click on Continue for Home Page
   And Choose 2x adult passenger
   Then Click on Continue for Passengers Page
   And Select ‘Over 5,500 kg GVW’ > select ‘Semi-trailer’> select ‘Under 9ft wide’ > total length: 70 ft, Total height: 12 ft
   And Select - Carrying Dangerous Goods
   Then Click on Continue for Vehicles Page
   And Select View Fares for Departure
   And Select Prepaid option for Departure
   And Select View Fares for Return
   And Select Prepaid option for Return
   Then Verify if the User is on Fare Selection Review page
   And Click on Checkout as a guest
   Then Enter Guest Checkout information
   And Enter Payment method information
   And Enter Billing Address information
   Then Click on PayNow button
   And Verify Booking Confirmation screen
   
    @Scenario21
  Scenario: Core Booking Flow (Commercial Over 5,550 kg Straight Truck/Commercial vehicle TSA-DUK Guest round trip)
  
  And Click on ReturnTripBooking  
  And Select From Location
  And Select To Location
  And Select Date of Depart
  And Select Date of Return
  Then Click on Continue for Home Page
  And Increment number of Adults travelling
  Then Click on Continue for Passingers selectionPage  
  And Select Over 5,500 kg GVW
  And Select Straight truck/commercial vehicle
  And Select Over 9ft Wide
  And Select Total length
  And Select Total Height
  And Click on Continue for VehicleselectionPage
  And Select View Fares
  And Select Prepaid option
  And Select Return View Fares
  And Select Return Prepaid option
  And Click on Checkout as a guest
  Then Enter Guest Checkout information
  And Enter Payment method information
  And Enter Billing Address information
  Then Click on PayNow button
  And Verify Booking Confirmation screen
   
    @Scenario22
  Scenario: Core Booking Flow (Commercial Over 5,550 kg SEMI AB Train TSA-DUK Logged In round trip)
  
  And Click on ReturnTripBooking  
  And Select From Location
  And Select To Location
  And Select Date of Depart
  And Select Date of Return
  Then Click on Continue for Home Page
  And Increment number of Adults travelling
  And Select Different passengers on return trip
  And Increment number of Adults travelling
  Then Click on Continue for Passingers selectionPage  
  And Select Over 5,500 kg GVW
  And Select A/BTrain
  And Select Under 9ft Wide
  And Select Total length
  And Select Total Height
  And Click on Continue for VehicleselectionPage
  And Select View Fares
  And Select Prepaid option
  And Select Return View Fares
  And Select Return Prepaid option
   Then Verify if the User is on Fare Selection Review page
   And Click on Checkout as a guest
   Then Enter Guest Checkout information
   And Enter Payment method information
   And Enter Billing Address information
   Then Click on PayNow button
   And Verify Booking Confirmation screen
   
   @Scenario23
   Scenario: Core Booking Flow (Commercial Over 5,550 kg SEMI TSA-DUK Logged In round trip)
 	 
 	 And Select Round Trip
   And Select From Location
   And Select To Location
   And Select Date of Travel
   And Select Return Date of Travel
   Then Click on Continue for Home Page
   And Choose 2x adult passenger
   Then Click on Continue for Passengers Page
   And Select ‘Over 5,500 kg GVW’ > select ‘Semi-trailer’> select ‘Under 9ft wide’ > total length: 70 ft, Total height: 12 ft
   Then Click on Continue for Vehicles Page
   And Select View Fares for Departure
   And Select Prepaid option for Departure
   And Select View Fares for Return
   And Select Prepaid option for Return
   Then Verify if the User is on Fare Selection Review page
   Then Enter Guest Checkout information
   And Enter Payment method information
   And Enter Billing Address information
   Then Click on PayNow button
   And Verify Booking Confirmation screen
   
    @Scenario24
  Scenario:Core Booking Flow (Commercial Over 5,550 kg Straight Truck/Commercial vehicle TSA-DUK Logged In round trip)
  
  And Click on ReturnTripBooking  
  And Select From Location
  And Select To Location
  And Select Date of Depart
  And Select Date of Return
  Then Click on Continue for Home Page
  And Increment number of Adults travelling
  Then Click on Continue for Passingers selectionPage
  And Select Over 5,500 kg GVW
  And Select Straight truck/commercial vehicle
  And Select Under 9ft Wide
  And Select Total length
  And Select Total Height
  And Click on Continue for VehicleselectionPage
   And Select View Fares
  And Select Prepaid option
  And Select Return View Fares
  And Select Return Prepaid option
  And Click on Checkout as a guest
  Then Enter Guest Checkout information
  And Enter Payment method information
  And Enter Billing Address information
  Then Click on PayNow button
  And Verify Booking Confirmation screen
   
   @Scenario25
   Scenario: Northern Booking Flow (Commercial Over 5,550 kg SEMI Prince Rupert to Port Hardy Logged In user round trip)
   
   And Select Round Trip
   And Select From Location
   And Select To Location
   And Select Date of Travel
   And Select Return Date of Travel
   Then Click on Continue for Home Page
   And Choose 2x adult passenger
   Then Click on Continue for Passengers Page
   And Select ‘Over 5,500 kg GVW’ > select ‘Semi-trailer’> select ‘Under 9ft wide’ > total length: 70 ft, Total height: 12 ft
   Then Click on Continue for Vehicles Page
   And Select View Fares for Departure
   And Select Prepaid option for Departure
   And Select View Fares for Return
   And Select Prepaid option for Return
   And Click Continue without amenities
   Then Enter Guest Checkout information
   And Enter Payment method information
   And Enter Billing Address information
   Then Click on PayNow button
   And Verify Booking Confirmation screen