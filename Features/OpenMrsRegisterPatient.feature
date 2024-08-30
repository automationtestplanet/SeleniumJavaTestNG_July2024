Feature: Register Patient
  As a user I want to register the patient so that I can access the patient detials in the future

  @RegisterPatient
  Scenario Outline: Register patient with Name "<Name>" Gender "<Gender>" and PhoneNumber "<PhoneNumber>"
    Given user is on the OpenMrs Home Page
    When user clicks on "Register a patient" Tile
    And user provides patient details name "<Name>" gender "<Gender>" Date of birth "<DateOfBirth>" address "<Address>" and phone number "<PhoneNumber>"
    And user verifies patient details name "<Name>" gender "<Gender>" Date of birth "<DateOfBirth>" and phone number "<PhoneNumber>" and clicks confirm
    Then patient must be registerted with name "<Name>"
    And patient Id must be generated

    Examples: 
      | Name             | Gender | DateOfBirth        | Address                                                        | PhoneNumber |
      | Ramesh Babu, H   | Male   | 26, December, 2000 | Near HDFC bank\n S R Nagar,Hyderabad,Telanagana,India,500033   |  9876543210 |
      | Kishore Kumar, M | Male   | 10, November, 1998 | Near Icici bank\n HitechCity,Hyderabad,Telanagana,India,500033 |  9876543211 |
      | Kumar Raju, Ch   | Male   | 17, July, 2002     | Near SBI bank\n Kukatpally,Hyderabad,Telanagana,India,500033   |  9876543212 |
