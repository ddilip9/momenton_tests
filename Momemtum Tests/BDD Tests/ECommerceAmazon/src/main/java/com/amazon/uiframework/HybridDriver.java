package com.amazon.uiframework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.LogStatus;

public class HybridDriver {

	public static String getPageTitle(WebDriver driver) {
		String pageTitle ="";
		try {
			pageTitle = driver.getTitle();
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Successfully Obtained Page Title - "+pageTitle);
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "getPageTitle")));
			logger.info("Successfully Obtained Page Title - "+pageTitle);
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Extract Page Title  -  "+e.getMessage());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "clickFailed")));
			logger.error("Failed to Obtained Page Title - "+pageTitle);
		}
		return pageTitle;
	}

	
	public void waitForPageLoad() {
		try {
			ExtentTestManager.getTest().log(LogStatus.PASS,"Wait for the Page (" + driver.getTitle() + ") to Load  -  Successfull");
			logger.info("Wait for the Page ( " + driver.getTitle() + ") to Load  -  Successfull");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Wait for the Page (" + driver.getTitle() + ") to Load  -  Failed");
			logger.error("Wait for the Page ( " + driver.getTitle() + ") to Load  -  Failed");
		}
	}
	
	
	public boolean isVisible(WebElement ele) {
		try {
			if (ele.isDisplayed()) {
				//ExtentTestManager.getTest().log(LogStatus.PASS, "Element Visible is Successful : "+elementName(ele));
				//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "isVisible")));
				logger.info("Element Visible is Successful : "+elementName(ele));
				return true;
			} else {
				//ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to Find the element : isVisible : "+elementName(ele));
				//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "isVisibleFailed")));
				logger.error("Unable to Find the element : isVisible : "+elementName(ele));
				return false;
			}
			
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Unable to Find the element : isVisible : "+e.getMessage());
			logger.error("Unable to Find the element : isVisible : "+elementName(ele));
		}
		return false;
	}


	public void switchWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		try {
			for (String windowHandle : windowHandles) {
				if (!windowHandle.equals(parentWindow)) {
					driver.switchTo().window(windowHandle);
				}
			}
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Switch to  window is successful : "+windowHandles.toString());
			logger.info("Switch to  window is successful : "+windowHandles.toString());
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Switch to Window  : "+e.getMessage());
			logger.error("Failed to Switch to Window  : "+e.getMessage());
		}
	}

	public String getParentWindow() {
		String parentWin = "";
		try {
			parentWin = driver.getWindowHandle();
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Switch to Parent window is successful : "+parentWin);
			logger.info("Switch to Parent window is successful : "+parentWin);
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Switch to Parent Window : "+e.getMessage());
			logger.error("Failed to Switch to Parent Window : "+e.getMessage());
		}
		return parentWin;
	}

	public static void closeWindow() {

		try {
			driver.close();
			driver.quit();
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Closed Webdriver instance Successfully");
			logger.info("Closed Webdriver instance Successfully");
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Close WebDriver Instance  "+e.getMessage());
			logger.error("Failed to Close WebDriver Instance  "+e.getMessage());
		}
		

		try {
			driver.quit();;
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Quitting Webdriver instance Successfully");
			logger.info("Quitting Webdriver instance Successfully");
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Close Webdriver Instance "+e.getMessage());
			logger.error("Failed to Close Webdriver Instance "+e.getMessage());
		}
	}

	public void clickElement(WebElement element) {
		try {
			element.click();
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Click on Element : "+elementName(element).toString()+" -  Successfull");
			////ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "clickSuccess")));
			logger.info("Click on Element : "+elementName(element).toString()+" -  Successfull");
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Click on Element : "+elementName(element)+" -  Failed : "+e.getMessage());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "clickFailed")));
			logger.error("Click on Element : "+elementName(element)+" -  Failed : "+e.getMessage());
		}
	}
	
	private String elementName(WebElement element){
		String result = " - - ";
				try {
					String [] a = element.toString().split("->");
					result = a[1].replace("]]", "]");
				} catch (Exception e) {
					//System.out.println("Error while extracting element name -> "+e.getMessage());
					logger.error("Error while extracting element name -> "+e.getMessage());
				}
		return result;
	}
	
	public void explicitWaitForDisplayed(WebElement ele, int time) throws InterruptedException {
		int i = 1;
		try {
			while (i <= time) {
				if (ele.isDisplayed()) {
					break;
				}
				Thread.sleep(1000);
				i = i + 1;
			}
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Explicit Wait for Displayed Element : "+elementName(ele)+" -  Success ");
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "clickSuccess")));
			logger.info("Explicit Wait for Displayed Element : "+elementName(ele)+" -  Success ");
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Click on Element - Failed : "+e.getMessage());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "clickFailed")));
			logger.error("Click on Element - Failed : "+e.getMessage());
		}
	}


	public String getText(WebElement element) {
		String text ="";
		try {
			text = element.getText();
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Element Get Text : "+text +" : "+elementName(element));
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "getTextSuccess")));
			logger.info("Element Get Text : "+text +" : "+elementName(element));
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Element Get Text Failed : "+text +"  : "+e.getMessage());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "getTextFailed")));
			logger.error("Element Get Text Failed : "+text +"  : "+e.getMessage() +" : Stack Trace : "+e.getStackTrace());
		}
		
		return text;
	}

	public void launchURL(String URL) {
		try {
			driver.get(URL);
			//ExtentTestManager.getTest().log(LogStatus.PASS, "URL Launch Successful: "+URL);
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "urlLaunchSuccess")));
			logger.info("URL Launch Successfull: "+URL);
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Launch : "+URL +"  : "+e.getStackTrace());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "urlLaunchFailed")));
			logger.error("Failed to Launch : "+URL +"  : "+e.getMessage() +" : Stack Trace : "+e.getStackTrace());
			e.getStackTrace();
		}
	}

	public static void switchToNextTab(WebDriver driver) {
		try {
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Switch to Next Tab Success: "+driver.switchTo().window(tabs2.get(1)).getTitle());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "switchTabsSuccess")));
			logger.info("Switch to Next Tab Success: "+driver.switchTo().window(tabs2.get(1)).getTitle());
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Switch Tabs :"+e.getMessage());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "switchTabsFailed")));
			logger.error("Failed to Switch Tabs :"+e.getMessage()+": Stack Trace : "+e.getStackTrace());
		}
	}

	public void enterValue(WebElement element, String text) {
		try {
			element.sendKeys(text);
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Text "+text +"  on Element : "+elementName(element) +" : Successfull");
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "enterTextSuccess")));
			logger.info("Enter Text "+text +"  on Element : "+elementName(element) +" : Successfull");
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Enter Text : "+text +"  : on Element : "+elementName(element) +" : Error : "+e.getMessage());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "enterTextFailed")));
			logger.error("Failed to Enter Text : "+text +"  : on Element : "+elementName(element) +" : Error : "+e.getMessage()+": Stack Trace : "+e.getStackTrace());
		}
	}

	public void waitMedium(int wait) {
		try {
			Thread.sleep(wait);
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Medium Wait for Seconds Success: "+wait);
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "waitMedium")));
			logger.info("Medium Wait for Seconds Success: "+wait);
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Medium Wait for Seconds Failed:"+wait +"  :"+e.getMessage());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "waitMedium")));
			logger.error("Medium Wait for Seconds Failed:"+wait +"  :"+e.getMessage()+": Stack Trace : "+e.getStackTrace());
		}
	}

	public static void switchToParentWin(String win) {
		try {
			driver.switchTo().window(win);
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Switch Control to Parent Window Success: "+win);
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "switchParentWindow")));
			logger.info("Switch Control to Parent Window Success: "+win);
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Switch Control to Parent Window Failed: "+win +"  :"+e.getMessage());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "switchParentWindow")));
			logger.error("Switch Control to Parent Window Failed: "+win +"  :"+e.getMessage()+": Stack Trace : "+e.getStackTrace());
		}
	}

	public static void scrollToBottom(WebDriver driver) {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Scroll Window to bottom SuccessFull ");
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "scrollWindow")));
			logger.info("Scroll Window to bottom SuccessFull ");
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Scroll Window to bottom Failed: "+e.getMessage());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "scrollWindow")));
			logger.error("Scroll Window to bottom Failed: "+e.getMessage()+": Stack Trace : "+e.getStackTrace());
		}
	}
	
	public void selectOptionByVisibleText(WebElement element, String option) {
		try {
			Select dropDown = new Select(element);
			dropDown.selectByVisibleText(option);
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Select Option by Visible Text Success on Option : "+option +" : "+elementName(element) );
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "selectByVisibleTextSuccess")));
			logger.info("Select Option by Visible Text Success on Option : "+option +" : "+elementName(element) );
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Select Option by Visible Text Failed : "+option +"  : "+e.getMessage());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "selectByVisibleTextFailed")));
			logger.error("Select Option by Visible Text Failed : "+option +"  : "+e.getMessage()+": StackTrace : "+e.getStackTrace());
		}
	}
	
	public void selectOptionByIndex(WebElement element, String option) {
		try {
			Select dropDown = new Select(element);
			dropDown.selectByIndex(Integer.parseInt(option));
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Select Option by Index Success : "+option +" : "+elementName(element));
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "selectByVisibleIndexSuccess")));
			logger.info("Select Option by Index Success : "+option +" : "+elementName(element));
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Select Option by Index Failed : "+option +"  : "+e.getMessage());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "selectByVisibleIndexFailed")));
			logger.error("Select Option by Index Failed : "+option +"  : "+e.getMessage()+": StackTrace : "+e.getStackTrace());
		}
	}
	
	public void selectOptionByValue(WebElement element, String option) {
		try {
			Select dropDown = new Select(element);
			dropDown.selectByValue(option);
			//ExtentTestManager.getTest().log(LogStatus.PASS, "Select Option by Value Success : "+option );
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "selectByValueSuccess")));
			logger.info("Select Option by Value Success : "+option );
		} catch (Exception e) {
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Select Option by Value Failed : "+option +"  : "+e.getMessage());
			//ExtentTestManager.getTest().log(LogStatus.INFO, //ExtentTestManager.getTest().addScreenCapture(captureHTMLScreenShot(driver, "selectByValueFailed")));
			logger.error("Select Option by Value Failed : "+option +"  : "+e.getMessage()+": StackTrace : "+e.getStackTrace());
		}
	}
	

	@SuppressWarnings("static-access")
	public HybridDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver setDriver() throws InterruptedException {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	        System.setProperty("current.date.time", dateFormat.format(new Date()));
			prop.load(new FileInputStream("./config/config.properties"));
			switch (prop.getProperty("browserType")) {
			case "chrome":
				driver = initChromeDriver();
				break;
			case "firefox":
				driver = initFirefoxDriver();
				break;
			default:
				logger.info("Browser : " + prop.getProperty("browserType")+ " is invalid, Launching Firefox as browser of choice..");
				driver = initFirefoxDriver();
			}
		} catch (FileNotFoundException e) {
			logger.error("Exception while setting Driver - - > > " + e.getMessage()+": StackTrace : "+e.getStackTrace());
		} catch (IOException e) {
			logger.error("Exception while setting Driver - - > > " + e.getMessage()+": Stacktrace : "+e.getStackTrace());
		}
		return driver;
	}

	// below method is used to initiate properties file
/*	public void initPropFile() {
		config = new Properties();
		String fileName = "config" + ".properties";
		InputStream input = null;
		try {
			input = new FileInputStream(
			System.getProperty("user.dir") + File.separator + "config" + File.separator + fileName);
			// load properties file
			config.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

 

	protected String getSreenShotSavePath() {
		String className = this.getClass().getName().toString().trim();
		File dir = new File(System.getProperty("user.dir") + fileSeperator + "screenshots" + fileSeperator + className
				+ fileSeperator);
		if (!dir.exists()) {
			// System.out.println("File created " + dir);
			dir.mkdir();
		}

		return dir.getAbsolutePath();
	}


	protected static String sprintScreenshots() {
		File dir = new File(System.getProperty("user.dir") + fileSeperator + "HTMLReports" + fileSeperator +"ScreenShots"+ fileSeperator);
		if (!dir.exists()) {
			dir.mkdir();
		}
		return dir.getAbsolutePath();
	}

	
	public void captureScreenShot() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String date = sdf.format(new Date());
		String ext = ".png";
		String path = getSreenShotSavePath() + fileSeperator + date + ext;

		try {
			if (driver instanceof TakesScreenshot) {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(path));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static String captureHTMLScreenShot(WebDriver driver, String name) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String date = sdf.format(new Date());
		String ext = ".png";
		String path = sprintScreenshots()+ fileSeperator + date + ext;
		try {
			if (driver instanceof TakesScreenshot) {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File dest =  new File(path);
				FileUtils.copyFile(scrFile, dest);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	
	private static WebDriver initChromeDriver() throws InterruptedException {
		//System.out.println("Launching Chrome browser");
		logger.info("Launching Chrome Browser...,");
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		
		WebDriver driver = new ChromeDriver();
		
		DesiredCapabilities caps = new DesiredCapabilities();
	//	
	
		//WebDriver driver = new RemoteWebDriver("", caps);
		driver.manage().window().maximize();
		return driver;
	}

	private static WebDriver initFirefoxDriver() {
		//System.out.println("Launching Firefox browser..");
		logger.info("Launching Firefox Browser...,");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	@AfterMethod
	public static void afterMethod(ITestResult result) throws FileNotFoundException, IOException {
		if(result.isSuccess()){
			//ExtentTestManager.getTest().log(LogStatus.PASS, "TestCase Passed");
			logger.info("TestCase --> "+result.getTestName() +" Execution Completed : "+result.getStatus());
		}else if(result.getStatus() == ITestResult.FAILURE){
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "TestCase Failed");
			logger.info("TestCase --> "+result.getTestName() +" Execution Completed : "+result.getStatus());
		}else if(result.getStatus() == ITestResult.SKIP){
			//ExtentTestManager.getTest().log(LogStatus.SKIP, "TestCase Skipped");
			logger.info("TestCase --> "+result.getTestName() +" Execution Completed : "+result.getStatus());
		}
		
		//ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	
	@AfterClass
	public static void tearDown() {
		ExtentManager.getInstance().flush();
		logger.info("Execution Completed and Closing the driver");
	}

	public HybridDriver() {
	//	initPropFile();
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	
	@BeforeMethod
	public static void beforeMethod(Method caller) throws FileNotFoundException, IOException {
		//ExtentTestManager.startTest("TestCase Name  --> "+caller.getName());
		logger.info("TestCase  Execution --> "+caller.getName() +": Completed");
	}
	
	
	@BeforeClass
	public static void initializeTestBaseSetup() throws FileNotFoundException, IOException {
	}
	
	protected static WebDriver driver = null;
	static String driverPath = "Drivers/chromedriver.exe";
	static String screenShotPath = "/screenshots";
	static String propFile = "/config/config.properties";
	public static Properties config = null;
	private static String fileSeperator = System.getProperty("file.separator");
	static Properties prop = new Properties();
	final static Logger logger = Logger.getLogger(HybridDriver.class);
}

