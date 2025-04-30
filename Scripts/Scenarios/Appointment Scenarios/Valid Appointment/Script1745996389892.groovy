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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String statusLogin = findTestData('users').getValue(3, 1)

String username = findTestData('users').getValue(1, 1)

String password = findTestData('users').getValue(2, 1)

String facility = findTestData('appointments').getValue(1, 1)

String readmission = findTestData('appointments').getValue(2, 1)

String program = findTestData('appointments').getValue(3, 1)

String visitDate = findTestData('appointments').getValue(4, 1)

String comment = findTestData('appointments').getValue(5, 1)

String status = findTestData('appointments').getValue(6, 1)

WebUI.callTestCase(findTestCase('Test Steps/Go To CURA'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Steps/Input Login Credentials'), [('username') : username, ('statusLogin') : statusLogin
        , ('password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Steps/Input Appointment Form'), [('readmission') : readmission, ('comment') : comment
        , ('visitDate') : visitDate, ('program') : program, ('facility') : facility, ('status') : status], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Steps/Go To Logout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.takeFullPageScreenshot()

WebUI.closeBrowser()
