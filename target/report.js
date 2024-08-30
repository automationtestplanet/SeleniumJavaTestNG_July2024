$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/OpenMrsRegisterPatient.feature");
formatter.feature({
  "name": "Register Patient",
  "description": "  As a user I want to register the patient so that I can access the patient detials in the future",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Register patient with Name \"\u003cName\u003e\" Gender \"\u003cGender\u003e\" and PhoneNumber \"\u003cPhoneNumber\u003e\"",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegisterPatient"
    }
  ]
});
formatter.step({
  "name": "user is on the OpenMrs Home Page",
  "keyword": "Given "
});
formatter.step({
  "name": "user clicks on \"Register a patient\" Tile",
  "keyword": "When "
});
formatter.step({
  "name": "user provides patient details name \"\u003cName\u003e\" gender \"\u003cGender\u003e\" Date of birth \"\u003cDateOfBirth\u003e\" address \"\u003cAddress\u003e\" and phone number \"\u003cPhoneNumber\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "user verifies patient details name \"\u003cName\u003e\" gender \"\u003cGender\u003e\" Date of birth \"\u003cDateOfBirth\u003e\" and phone number \"\u003cPhoneNumber\u003e\" and clicks confirm",
  "keyword": "And "
});
formatter.step({
  "name": "patient must be registerted with name \"\u003cName\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "patient Id must be generated",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Name",
        "Gender",
        "DateOfBirth",
        "Address",
        "PhoneNumber"
      ]
    },
    {
      "cells": [
        "Ramesh Babu, H",
        "Male",
        "26, December, 2000",
        "Near HDFC bank\n S R Nagar,Hyderabad,Telanagana,India,500033",
        "9876543210"
      ]
    },
    {
      "cells": [
        "Kishore Kumar, M",
        "Male",
        "10, November, 1998",
        "Near Icici bank\n HitechCity,Hyderabad,Telanagana,India,500033",
        "9876543211"
      ]
    },
    {
      "cells": [
        "Kumar Raju, Ch",
        "Male",
        "17, July, 2002",
        "Near SBI bank\n Kukatpally,Hyderabad,Telanagana,India,500033",
        "9876543212"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Register patient with Name \"Ramesh Babu, H\" Gender \"Male\" and PhoneNumber \"9876543210\"",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegisterPatient"
    }
  ]
});
formatter.step({
  "name": "user is on the OpenMrs Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userIsOnTheOpenMrsHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"Register a patient\" Tile",
  "keyword": "When "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userClicksOnTile(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user provides patient details name \"Ramesh Babu, H\" gender \"Male\" Date of birth \"26, December, 2000\" address \"Near HDFC bank\n S R Nagar,Hyderabad,Telanagana,India,500033\" and phone number \"9876543210\"",
  "keyword": "And "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userProvidesPatientDetailsNameGenderDateOfBirthAddressAndPhoneNumber(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"#next\\-button\"}\n  (Session info: chrome\u003d128.0.6613.85)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027LENOVO\u0027, ip: \u0027172.20.10.6\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002721.0.3\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 128.0.6613.85, chrome: {chromedriverVersion: 127.0.6533.88 (a2d0cb026721..., userDataDir: C:\\Users\\RAJUCH~1\\AppData\\L...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:51920}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nSession ID: 6c8cf794e40da0793509f1918671340c\n*** Element info: {Using\u003did, value\u003dnext-button}\r\n\tat java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:62)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:502)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:486)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:372)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openms.demo.pageobjects.RegistrationPage.clickNextButton(RegistrationPage.java:24)\r\n\tat org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userProvidesPatientDetailsNameGenderDateOfBirthAddressAndPhoneNumber(RegisterPatientStepDefinitions.java:42)\r\n\tat ✽.user provides patient details name \"Ramesh Babu, H\" gender \"Male\" Date of birth \"26, December, 2000\" address \"Near HDFC bank\n S R Nagar,Hyderabad,Telanagana,India,500033\" and phone number \"9876543210\"(file:///E:/TESTING/SELENIUM/CoreJava-July-2024/SeleniumJavaTestNGProject/Features/OpenMrsRegisterPatient.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "user verifies patient details name \"Ramesh Babu, H\" gender \"Male\" Date of birth \"26, December, 2000\" and phone number \"9876543210\" and clicks confirm",
  "keyword": "And "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userVerifiesPatientDetailsNameGenderDateOfBirthAndPhoneNumberAndClicksConfirm(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "patient must be registerted with name \"Ramesh Babu, H\"",
  "keyword": "Then "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.patientMustBeRegistertedWithName(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "patient Id must be generated",
  "keyword": "And "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.patientIdMustBeGenerated()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Register patient with Name \"Kishore Kumar, M\" Gender \"Male\" and PhoneNumber \"9876543211\"",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegisterPatient"
    }
  ]
});
formatter.step({
  "name": "user is on the OpenMrs Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userIsOnTheOpenMrsHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"Register a patient\" Tile",
  "keyword": "When "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userClicksOnTile(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user provides patient details name \"Kishore Kumar, M\" gender \"Male\" Date of birth \"10, November, 1998\" address \"Near Icici bank\n HitechCity,Hyderabad,Telanagana,India,500033\" and phone number \"9876543211\"",
  "keyword": "And "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userProvidesPatientDetailsNameGenderDateOfBirthAddressAndPhoneNumber(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"#next\\-button\"}\n  (Session info: chrome\u003d128.0.6613.85)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027LENOVO\u0027, ip: \u0027172.20.10.6\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002721.0.3\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 128.0.6613.85, chrome: {chromedriverVersion: 127.0.6533.88 (a2d0cb026721..., userDataDir: C:\\Users\\RAJUCH~1\\AppData\\L...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:51920}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nSession ID: 6c8cf794e40da0793509f1918671340c\n*** Element info: {Using\u003did, value\u003dnext-button}\r\n\tat java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:62)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:502)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:486)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:372)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openms.demo.pageobjects.RegistrationPage.clickNextButton(RegistrationPage.java:24)\r\n\tat org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userProvidesPatientDetailsNameGenderDateOfBirthAddressAndPhoneNumber(RegisterPatientStepDefinitions.java:42)\r\n\tat ✽.user provides patient details name \"Kishore Kumar, M\" gender \"Male\" Date of birth \"10, November, 1998\" address \"Near Icici bank\n HitechCity,Hyderabad,Telanagana,India,500033\" and phone number \"9876543211\"(file:///E:/TESTING/SELENIUM/CoreJava-July-2024/SeleniumJavaTestNGProject/Features/OpenMrsRegisterPatient.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "user verifies patient details name \"Kishore Kumar, M\" gender \"Male\" Date of birth \"10, November, 1998\" and phone number \"9876543211\" and clicks confirm",
  "keyword": "And "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userVerifiesPatientDetailsNameGenderDateOfBirthAndPhoneNumberAndClicksConfirm(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "patient must be registerted with name \"Kishore Kumar, M\"",
  "keyword": "Then "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.patientMustBeRegistertedWithName(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "patient Id must be generated",
  "keyword": "And "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.patientIdMustBeGenerated()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Register patient with Name \"Kumar Raju, Ch\" Gender \"Male\" and PhoneNumber \"9876543212\"",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegisterPatient"
    }
  ]
});
formatter.step({
  "name": "user is on the OpenMrs Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userIsOnTheOpenMrsHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"Register a patient\" Tile",
  "keyword": "When "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userClicksOnTile(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user provides patient details name \"Kumar Raju, Ch\" gender \"Male\" Date of birth \"17, July, 2002\" address \"Near SBI bank\n Kukatpally,Hyderabad,Telanagana,India,500033\" and phone number \"9876543212\"",
  "keyword": "And "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userProvidesPatientDetailsNameGenderDateOfBirthAddressAndPhoneNumber(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"#next\\-button\"}\n  (Session info: chrome\u003d128.0.6613.85)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027LENOVO\u0027, ip: \u0027172.20.10.6\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002721.0.3\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 128.0.6613.85, chrome: {chromedriverVersion: 127.0.6533.88 (a2d0cb026721..., userDataDir: C:\\Users\\RAJUCH~1\\AppData\\L...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:51920}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nSession ID: 6c8cf794e40da0793509f1918671340c\n*** Element info: {Using\u003did, value\u003dnext-button}\r\n\tat java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:62)\r\n\tat java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:502)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:486)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:372)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openms.demo.pageobjects.RegistrationPage.clickNextButton(RegistrationPage.java:24)\r\n\tat org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userProvidesPatientDetailsNameGenderDateOfBirthAddressAndPhoneNumber(RegisterPatientStepDefinitions.java:42)\r\n\tat ✽.user provides patient details name \"Kumar Raju, Ch\" gender \"Male\" Date of birth \"17, July, 2002\" address \"Near SBI bank\n Kukatpally,Hyderabad,Telanagana,India,500033\" and phone number \"9876543212\"(file:///E:/TESTING/SELENIUM/CoreJava-July-2024/SeleniumJavaTestNGProject/Features/OpenMrsRegisterPatient.feature:8)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "user verifies patient details name \"Kumar Raju, Ch\" gender \"Male\" Date of birth \"17, July, 2002\" and phone number \"9876543212\" and clicks confirm",
  "keyword": "And "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.userVerifiesPatientDetailsNameGenderDateOfBirthAndPhoneNumberAndClicksConfirm(java.lang.String,java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "patient must be registerted with name \"Kumar Raju, Ch\"",
  "keyword": "Then "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.patientMustBeRegistertedWithName(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "patient Id must be generated",
  "keyword": "And "
});
formatter.match({
  "location": "org.openmrs.demo.stepdefinitions.RegisterPatientStepDefinitions.patientIdMustBeGenerated()"
});
formatter.result({
  "status": "skipped"
});
});