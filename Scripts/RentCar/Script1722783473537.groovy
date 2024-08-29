import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.console.ui.SystemOutputInterceptor as SystemOutputInterceptor
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.text.SimpleDateFormat as SimpleDateFormat

// Define date format
SimpleDateFormat dateFormat = new SimpleDateFormat('dd MMMM yyyy')

// Calculate Pick-up and Drop off Date

Date todayDate = new Date()

startDate = todayDate + 5

String formattedStartDate = dateFormat.format(startDate)

endDate = todayDate + 10

String formattedEndDate = dateFormat.format(endDate)

System.err.println formattedEndDate



// Open the car rental page
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.traveloka.com/en-id')

WebUI.click(findTestObject('Object Repository/TravelokaWeb/Homepage/CarRentalBtn'))

WebUI.verifyElementVisible(findTestObject('Object Repository/TravelokaWeb/CarRental/CarRentalText'))

// Select tab Without Driver
WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarRental/WithoutDriverOption'))

// Select Pick-up Location

WebUI.sendKeys(findTestObject('Object Repository/TravelokaWeb/Homepage/Location'), 'Jakarta')

WebUI.scrollToElement(findTestObject('Object Repository/TravelokaWeb/CarRental/CarRentalTxt'), 0)

WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarRental/JakartaOption'))

// Select Pickup Date & Time
WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarRental/StartDate'))

WebUI.setText(findTestObject('Object Repository/TravelokaWeb/CarRental/StartDate'), formattedStartDate)

WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarRental/RentalStartTIme'))

WebUI.setText(findTestObject('Object Repository/TravelokaWeb/CarRental/RentalStartTIme'), '09:00')

WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarRental/StartTimeDoneBtn'))

// Select Drop-off Date & Time
WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarRental/RentalEndDate'))

WebUI.setText(findTestObject('Object Repository/TravelokaWeb/CarRental/RentalEndDate'), formattedEndDate)

WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarRental/RentalEndTIme'))

WebUI.setText(findTestObject('Object Repository/TravelokaWeb/CarRental/RentalEndTIme'), '11:00')

WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarRental/EndTimeDoneBtn'))

// Click Search Car button
WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarRental/SearchCarBtn'))

WebUI.waitForElementVisible(findTestObject('Object Repository/TravelokaWeb/CarOption/CarRentalWithoutDriver'), 2)

// Select Car
WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarOption/CarOption'))

WebUI.verifyElementVisible(findTestObject('Object Repository/TravelokaWeb/CarOption/SelectRentalProviderText'))

WebUI.delay(3)

// Select car provider
WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarOption/ProviderOption'))

WebUI.waitForElementVisible(findTestObject('Object Repository/TravelokaWeb/CarOption/CarRentalWithoutDriver'), 1)

WebUI.verifyElementVisible(findTestObject('Object Repository/TravelokaWeb/CarOption/CarNameText'))

WebUI.verifyElementVisible(findTestObject('Object Repository/TravelokaWeb/CarOption/CarProviderText'))

// Select Pick-up Location in “Rental Office”
WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarOption/RentalOffice'))

WebUI.waitForElementVisible(findTestObject('Object Repository/TravelokaWeb/CarOption/PickupLocationText'), 2)

WebUI.click(findTestObject('Object Repository/TravelokaWeb/YourBooking/RentalOfficeDropdown'))

WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarOption/ProviderRentalOffice'))

WebUI.delay(2)

//Select Drop-off Location in “Other Location”
WebUI.scrollToElement(findTestObject('Object Repository/TravelokaWeb/YourBooking/DropOffLocationText'), 0)

WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarOption/OtherLocationBtn'))

WebUI.click(findTestObject('Object Repository/TravelokaWeb/YourBooking/DropOffLocationTxtBox'))

WebUI.click(findTestObject('Object Repository/TravelokaWeb/YourBooking/CGKOption'))

WebUI.delay(2)

// Input Pick-up/Drop-off notes is optional
WebUI.sendKeys(findTestObject('Object Repository/TravelokaWeb/CarRental/LocationNoteTxtBox'), 'testing')

// Click continue button
WebUI.click(findTestObject('Object Repository/TravelokaWeb/CarOption/ContinuetoBookingDetail'))

WebUI.delay(3)

// Fill Contact Details
WebUI.setText(findTestObject('Object Repository/TravelokaWeb/YourBooking/ContactNameTextBox'), 'Nadia')

WebUI.setText(findTestObject('Object Repository/TravelokaWeb/YourBooking/PhoneNoTextBox'), '87884398009')

WebUI.setText(findTestObject('Object Repository/TravelokaWeb/YourBooking/EmailTextBox'), 'nadia@makankor.net')

WebUI.scrollToElement(findTestObject('TravelokaWeb/YourBooking/DriverDetailTxt'), 0)

// Fill Driver Details
WebUI.click(findTestObject('Object Repository/TravelokaWeb/YourBooking/TitleDropdown'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/TravelokaWeb/YourBooking/TitleDropdown'), 'Mr.', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/TravelokaWeb/YourBooking/TitleDropdown'), 'Mr.', false, 
    1)

WebUI.setText(findTestObject('Object Repository/TravelokaWeb/YourBooking/DriverNameTxtBox'), 'Iqbal')

WebUI.setText(findTestObject('Object Repository/TravelokaWeb/YourBooking/DriverPhoneTxtBox'), '87884398309')

WebUI.scrollToElement(findTestObject('TravelokaWeb/YourBooking/ContinuetoBookingDetailBtn'), 0)

// Click Continue
WebUI.click(findTestObject('Object Repository/TravelokaWeb/YourBooking/ContinuetoBookingDetailBtn'))

WebUI.scrollToElement(findTestObject('TravelokaWeb/YourBooking/SpecialRequestTxt'), 0)

// Add a special request (optional)
WebUI.sendKeys(findTestObject('Object Repository/TravelokaWeb/YourBooking/SpecialRequestTxtBox'), 'testing')

// Check all rental requirements
WebUI.click(findTestObject('Object Repository/TravelokaWeb/YourBooking/RentalRequirement'))

WebUI.click(findTestObject('Object Repository/TravelokaWeb/YourBooking/CheckAllRequirement'))

//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.CONTROL, Keys.SUBTRACT))
not_run: WebUI.executeJavaScript('document.body.style.zoom=\'90%\'', null)

WebUI.scrollToElement(findTestObject('TravelokaWeb/YourBooking/SaveBtn'), 0)

WebUI.click(findTestObject('Object Repository/TravelokaWeb/YourBooking/SaveBtn'))

WebUI.scrollToElement(findTestObject('TravelokaWeb/YourBooking/PriceDetailTxt'), 0)

WebUI.waitForElementClickable(findTestObject('TravelokaWeb/YourBooking/ContinuetoPaymentBtn'), 0)

// Click Continue to Payment
WebUI.click(findTestObject('TravelokaWeb/YourBooking/ContinuetoPaymentBtn'))

// Click Continue on Confirmation Modal

WebUI.waitForElementClickable(findTestObject('TravelokaWeb/YourBooking/ContinuetoPaymentBtn2'), 0)

WebUI.click(findTestObject('Object Repository/TravelokaWeb/YourBooking/ContinuetoPaymentBtn2'))

WebUI.waitForElementVisible(findTestObject('Object Repository/TravelokaWeb/YourBooking/HowWouldYouLiketoPayTxt'), 2)

WebUI.click(findTestObject('Object Repository/TravelokaWeb/Payment/ConvenienceStoreOption'))

WebUI.scrollToElement(findTestObject('TravelokaWeb/Payment/PayBtn'), 0)

WebUI.verifyElementText(findTestObject('Object Repository/TravelokaWeb/Payment/PayBtn'), 'Pay at Alfamart')

WebUI.click(findTestObject('Object Repository/TravelokaWeb/Payment/PayBtn'))

// Close browser
WebUI.closeBrowser()




/**
 * issues:
 * - click save after check requirement
 * - click continue to payment button
 * - click continue to payment button2
 * 
 * */
