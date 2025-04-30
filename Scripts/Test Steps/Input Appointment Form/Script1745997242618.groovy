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

if (status == 'valid') {
    WebUI.selectOptionByLabel(findTestObject('Object Repository/Appointment Page/select-facility'), facility, false)

    if (readmission == 'yes') {
        WebUI.click(findTestObject('Object Repository/Appointment Page/chk-readmission'))
    }
    
    WebUI.setText(findTestObject('Object Repository/Appointment Page/input-visitdate'), visitDate)

    WebUI.click(findTestObject('Object Repository/Appointment Page/rad-healthcareprogram', [('program') : program]))

    WebUI.setText(findTestObject('Object Repository/Appointment Page/txtarea-comment'), comment)
	
    WebUI.click(findTestObject('Object Repository/Appointment Page/btn-bookappointment'))
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Appointment Page/lbl-appointmentconfirmation'), 5)
	
	//Confirmation Page
	
	WebUI.verifyElementText(findTestObject('Object Repository/Confirmation Page/txt-facility'),facility)
	
	WebUI.verifyElementText(findTestObject('Object Repository/Confirmation Page/txt-visitdate'),visitDate)
	
} else if (status == 'invalid') {
    WebUI.selectOptionByLabel(findTestObject('Object Repository/Appointment Page/select-facility'), facility, false)

    if (readmission == 'yes') {
        WebUI.click(findTestObject('Object Repository/Appointment Page/chk-readmission'))
    }
    
    WebUI.click(findTestObject('Object Repository/Appointment Page/rad-healthcareprogram', [('program') : program]))

    WebUI.setText(findTestObject('Object Repository/Appointment Page/txtarea-comment'), comment)
	
    WebUI.click(findTestObject('Object Repository/Appointment Page/btn-bookappointment'))
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Appointment Page/input-visitdate'),5)
}

WebUI.takeScreenshot()