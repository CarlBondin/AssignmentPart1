Feature: Market Alert Website Functionality

  To understand how the marketalertum website works
  As a user of the same website
  I want to test the functionality of this website

  Scenario: Valid Login
  Given I am a user of marketalertum
  When I login using valid credentials
  Then I should see my alerts

  Scenario: Invalid Login
  Given I am a user of marketalertum
  When I login using invalid credentials
  Then I should see the login screen again

  Scenario: Alert layout
  Given I am an administrator of the website
  And I upload 3 alerts
  Given I am a user of marketalertum
  When I view a list of alerts
  Then each alert should contain an icon
  And each alert should contain a heading
  And each alert should contain a description
  And each alert should contain an image
  And each alert should contain a price
  And each alert should contain a link to the original product website

  Scenario: Alert limit
  Given I am an administrator of the website
  And I upload more than 5 alerts
  Given I am a user of marketalertum
  When I view a list of alerts
  Then I should see 5 alerts

  Scenario Outline: Icon check
  Given I am an administrator of the website
  And I upload an alert of type "<alertType>"
  Given I am a user of marketalertum
  When I view a list of alerts
  Then I should see 1 alerts
  And the icon displayed should be "<fileName>"

  Examples:
  |alertType| fileName              |
  |1        | icon-car.png          |
  |2        | icon-boat.png         |
  |3        | icon-property-rent.jpg|
  |4        | icon-property-sale.jpg|
  |5        | icon-toys.png         |
  |6        | icon-electronics.png  |