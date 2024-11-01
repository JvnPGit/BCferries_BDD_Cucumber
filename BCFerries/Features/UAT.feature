Feature: Book Sailings for Unauthenticated User/Guest User

  Background: 
    Given User launched browser
    Then User enters required URL

  @Scenario1
  Scenario: Core Booking Flow (One-Way Guest)
   	And Select Date of Travel
    And Select From Location
    And Select To Location
    Then Click Continue in Home Page
    And Choose 1x Adults Passenger in Passengers Page
    And Choose 2x Children Passenger in Passengers Page
    And Choose 1x Infants Passenger in Passengers Page
    Then Click Continue in Passengers Page
    And Choose Vehicle Under 7ft Height in Vehicle Selection Page
    And Choose Vehicle Under 20ft Length in Vehicle Selection Page
    Then Click Continue in Vehicle Selection Page
    And Click View Fares in Fare Selection Page
    And Click Select Button in Fare Selection Page
    #Then Verify User is on Fare Selection Review page
    And Click Checkout as Guest in Fare Selection Review Page
    Then Enter Guest Checkout Information in Payment Page
    And Enter Payment Method Information in Payment Page
    And Enter Billing Address Information in Payment Page
    Then Click Complete Booking in Payment Page
    #And Verifying Booking Confirmation Screen

  @Scenario2
  Scenario: Core Booking Flow (Return trip / Guest)
    And Click on Return Trip Booking in Home Page
    And Select From Location
    And Select Date of Depart
    And Select Return Date of Travel
    And Select To Location
    Then Click Continue in Home Page
    And Choose 2x Adults Passenger in Passengers Page
    And Choose 2x Children Passenger in Passengers Page
    And Choose 1x BC Resident Seniors in Passengers Page
    Then Click Continue in Passengers Page
    And Choose Vehicle Under 7ft Height in Vehicle Selection Page
    And Choose Vehicle Under 20ft Length in Vehicle Selection Page
    Then Click Continue in Vehicle Selection Page
    And Click View Fares in Fare Selection Page
    And Click Select Button in Fare Selection Page
    And Click Return View Fares in Fare Selection Page
    And Click Return Select Button in Fare Selection Page
    #Then Verify User is on Fare Selection Review page
    And Click Checkout as Guest in Fare Selection Review Page
    Then Enter Guest Checkout Information in Payment Page
    And Enter Payment Method Information in Payment Page
    And Enter Billing Address Information in Payment Page
    Then Click Complete Booking in Payment Page
    #And Verifying Booking Confirmation Screen

  @Scenario3
  Scenario: Core Booking Flow (One-Way Log in to check out)
    And Select From Location
    And Select Date of Travel
    And Select To Location
    Then Click Continue in Home Page
    And Choose 1x Adults Passenger in Passengers Page
    And Choose 2x Children Passenger in Passengers Page
    And Choose 1x Infants Passenger in Passengers Page
    Then Click Continue in Passengers Page
    And Choose Vehicle Under 7ft Height in Vehicle Selection Page
    And Choose Vehicle Under 20ft Length in Vehicle Selection Page
    Then Click Continue in Vehicle Selection Page
    And Click View Fares in Fare Selection Page
    And Click Select Button in Fare Selection Page
    Then Verify User is on Fare Selection Review page
    And Click Login and Checkout in Fare Selection Review Page
    Then Enter Login Credentials in Login Page
    And Click Login Button in Login Page
    Then Click Continue Button in Fare Selection Review Page
    And Click  Saved Card Radio Button in Payment Page
    Then Click Complete Booking in Payment Page
    And Verifying Booking Confirmation Screen

  @Scenario4
  Scenario: Core Booking Flow (One-Way Guests with Accessibility Needs)
    And Select Date of Travel
    And Select From Location
    And Select To Location
    Then Click Continue in Home Page
    And Choose 2x Adults Passenger in Passengers Page
    And Select - I have accessibility requirements in Passengers Page
    And Select Passenger1 - Hearing Impairment and Request a wheelchair
    And Select Passenger2 - Traveling with own wheelchair and Request boarding assistance
    And Select - Travelling without a vehicle in Passengers Page
    Then Click Continue in Passengers Page without a vehicle
    And Click View Fares in Fare Selection Page
    And Click Select Button in Fare Selection Page
    #Then Verify User is on Fare Selection Review page
    And Click Checkout as Guest in Fare Selection Review Page
    Then Enter Guest Checkout Information in Payment Page
    And Enter Payment Method Information in Payment Page
    And Enter Billing Address Information in Payment Page
    Then Click Complete Booking in Payment Page
    #And Verifying Booking Confirmation Screen

  @Scenario5
  Scenario: Northern Booking Flow (One-Way Guest + Dangerous Goods)
    And Select From Location
    And Select To Location
    And Select Date of Travel
    Then Click Continue in Home Page
    And Choose 2x BC Resident Seniors in Passengers Page
    Then Click Continue in Passengers Page
    And Choose Vehicle Over 7ft Height in Vehicle Selection Page
    And Choose Vehicle Over 20ft Length in Vehicle Selection Page
    And Select - Carrying Dangerous Goods
    Then Click Continue in Vehicle Selection Page
    And Click Select Button in Fare Selection Page for North Sailing
    And Click Add cabins & amenities in Fare Selection Page
    And Select cabin type-Bed Outside Cabin
    Then Click Continue in Ancillary Page
    And Enter Passenger1 Information in Traveller Details Page
    And Click Dont know licence plate details Checkbox in Travellers Details Page
    And Enter Passenger2 Information in Traveller Details Page
    And Click Checkout as Guest in Traveller Details Page
    And Enter Payment Method Information in Payment Page
    And Enter Billing Address Information in Payment Page
    Then Click Complete Booking in Payment Page
    #And Verifying Booking Confirmation Screen

  @Scenario6
  Scenario: Northern Booking Flow (One-way Login to checkout)
    And Select From Location
    And Select To Location
    And Select Date of Travel
    Then Click Continue in Home Page
    And Choose 2x Adults Passenger in Passengers Page
    Then Click Continue in Passengers Page
    And Choose Vehicle Over 7ft Height in Vehicle Selection Page
    And Choose Vehicle Over 20ft Length in Vehicle Selection Page
    And Select - Carrying Dangerous Goods
    Then Click Continue in Vehicle Selection Page
    And Click Select Button in Fare Selection Page for North Sailing
    And Click Add cabins & amenities in Fare Selection Page
    And Select cabin type-Bed Outside Cabin
    Then Click Continue in Ancillary Page
    And Enter Passenger1 Information in Traveller Details Page
    And Click Dont know licence plate details Checkbox in Travellers Details Page
    And Enter Passenger2 Information in Traveller Details Page
    And Click Login & Checkout in Traveller Details Page
    Then Enter Login Credentials in Login Page
    And Click Login Button in Login Page
    Then Click Continue Button in Fare Selection Review Page
    And Click  Saved Card Radio Button in Payment Page
    Then Click Complete Booking in Payment Page
    #And Verifying Booking Confirmation Screen
    
    @Scenario7
  Scenario: Northern Booking Flow (One-way with accessibility needs)
    And Select From Location
    And Select To Location
    And Select Date of Travel
    Then Click Continue in Home Page
    And Choose 2x Adults Passenger in Passengers Page
    And Select - I have accessibility requirements in Passengers Page
    And Select Passenger1 - Hearing Impairment and Request a wheelchair
    And Select Passenger2 - Traveling with own wheelchair and Request boarding assistance
    Then Click Continue in Passengers Page
    And Choose Vehicle Over 7ft Height in Vehicle Selection Page
    And Choose Vehicle Over 20ft Length in Vehicle Selection Page
    And Select - Carrying Dangerous Goods
    Then Click Continue in Vehicle Selection Page
    And Click Select Button in Fare Selection Page
    And Click Add cabins & amenities in Fare Selection Page
    And Enter Passenger1 Information in Traveller Details Page
    And Click Dont know licence plate details Checkbox in Travellers Details Page
    And Enter Passenger2 Information in Traveller Details Page
    And Enter Passenger3 Information in Traveller Details Page
    And Click Checkout as Guest in Traveller Details Page
    And Enter Payment Method Information in Payment Page
    And Enter Billing Address Information in Payment Page
    Then Click Complete Booking in Payment Page
    And Verifying Booking Confirmation Screen
       
  @Scenario8
  Scenario: Vacations Booking Flow (Guest Checkout)
    When Select Vacations Tab in Booking Widget of Home Page
    And Select Destination Location
    And Select Date of Travel Check In in Vacation Tab
    And Select Date of Travel Check Out in Vacation Tab
    And Select Route Location
    Then Click on Book a Package Button
    And Click on Book now in Robin Hood Inn and Suites
    And Click on Book this room button in room types
    And Choose Vacation Vehicle Under 7ft Height in Vehicle Selection Page
    And Choose Vacation Vehicle Under 20ft Length in Vehicle Selection Page
    Then Click Vacation Continue Button in Vehicle Selection Page
    And Click Select Button Vacation in Fare Selection Page
    And Click Return Select Button Vacation in Fare Selection Page
    And Click Add Activities Button in Fare Selection Review Page
    And Click on View Details in Victoria Butterfly Gardens
    And Choose 2x 18 Puls in Tickets Drop down
    Then Select Check In Date in Hotel Page
    And Click Add to Package in Hotel Page
    Then Click Continue and Review Package in Hotel Page
    And Click Checkout as Guest in Fare Selection Review Page
    Then Enter Guest Checkout Information in Payment Page
    And Enter Payment Method Information in Payment Page
    And Enter Billing Address Information in Payment Page
    Then Click Complete Booking in Payment Page
    And Verifying Booking Confirmation Screen

  @Scenario9
  Scenario: Vacations Booking Flow (Log In to Checkout)
    When Select Vacations Tab in Booking Widget of Home Page
    And Select Destination Location
    And Select Route Location
    And Select Date of Travel Check In in Vacation Tab
    And Select Date of Travel Check Out in Vacation Tab
    And Choose 2x Number of rooms in Vacation Tab
    Then Click on Book a Package Button
    And Click on Book now in Quality Inn Downtown Inner Harbour
    And Click on Book this room button in room types
    And Choose Vacation Vehicle Over 7ft Height in Vehicle Selection Page
    And Choose Vacation Vehicle Over 20ft Length in Vehicle Selection Page
    Then Click Vacation Continue Button in Vehicle Selection Page
    And Click Select Button Vacation in Fare Selection Page
    And Click Return Select Button Vacation in Fare Selection Page
    And Click Add Activities Button in Fare Selection Review Page
    And Click on View Details in Royal BC Museum
    #  And Increment number of 19+ years
    # And Increment number of 6-18 years
    Then Select Check In Date in Hotel Page
    And Click Add to Package in Hotel Page
    Then Click Continue and Review Package in Hotel Page
    And Click on Continue button
    And Click Login and Checkout in Fare Selection Review Page
    Then Enter Login Credentials in Login Page
    And Click Login Button in Login Page
    Then Click Continue Button in Fare Selection Review Page
    And Click  Saved Card Radio Button in Payment Page
    Then Click Complete Booking in Payment Page
    And Verifying Booking Confirmation Screen

  @Scenario10
  Scenario: Vacations Booking Flow (Guest with Accessibility Needs Checkout)
    When Select Vacations Tab in Booking Widget of Home Page
    And Select Destination Location
    And Select Route Location
    And Select Date of Travel Check In in Vacation Tab
    And Select Date of Travel Check Out in Vacation Tab
   Then Click on Book a Package Button
    And Click on Book now in Quality Inn Downtown Inner Harbour
    And Click on Book this room button in room types
    And Select - I have accessibility requirements in Passengers Page
    And Select Passenger 1 - Hearing Impairment and Request a wheelchair
    And Select Passenger 2 - Traveling with own wheelchair and Request boarding assistance
    And Choose Vacation Vehicle Under 7ft Height in Vehicle Selection Page
    And Choose Vacation Vehicle Under 20ft Length in Vehicle Selection Page
    Then Click Vacation Continue Button in Vehicle Selection Page
    And Click Select Button Vacation in Fare Selection Page
    And Click Return Select Button Vacation in Fare Selection Page
    And Click Add Activities Button in Fare Selection Review Page
    And Click on View Details in Victoria Butterfly Gardens
    And Choose 2x 18 Puls in Tickets Drop down
    Then Select Check In Date in Hotel Page
    And Click Add to Package in Hotel Page
     Then Click Continue and Review Package in Hotel Page
    And Click Checkout as Guest in Fare Selection Review Page
    Then Enter Guest Checkout Information in Payment Page
    And Enter Payment Method Information in Payment Page
    And Enter Billing Address Information in Payment Page
    Then Click Complete Booking in Payment Page
    And Verifying Booking Confirmation Screen
    
    