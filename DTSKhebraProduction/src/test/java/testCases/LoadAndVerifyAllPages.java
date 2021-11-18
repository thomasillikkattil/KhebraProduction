package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import pageObjects.AllPagesNavObjects;
import pageObjects.LoginPageObjects;

public class LoadAndVerifyAllPages {
	public static WebDriver driver;
	public static String pageHeader;

	public static void main(String[] args) throws Exception {
		login();
		studentsPages();
		trainerPages();
		vehiclePages();
		schedulePages();
		tearDown();
	}
	
	@BeforeTest
	public static void login() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://khebra.drivingqatar.com/");
		LoginPageObjects loginPageObj=new LoginPageObjects(driver);
		loginPageObj.enterUserName("mohideen");
		loginPageObj.enterPassword("Truen4Love@");
		loginPageObj.clickSubmitBtn();
		String tabHeader= driver.getTitle();
		String loginPageTitle="Login | Qatar Driving Training System";
		String dashboardPageTitle= "Dashboard | Qatar Driving Training System";
		if(tabHeader.equalsIgnoreCase(dashboardPageTitle))
			System.out.println("Logged-in");
		else if(tabHeader.equalsIgnoreCase(loginPageTitle))
			System.out.println("Login failed");
	}
	
	public static boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        System.out.println("Alert found on the page");
	        return true;	        
	    } 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }  
	}
	
	public static boolean isInternalServerErrorPresent() {
		if(driver.getPageSource().contains("Internal Server Error")) {
			driver.navigate().back();
			return true;
		}
		return false;
	}
	
	@Test
	public static void studentsPages() throws Exception {
		AllPagesNavObjects allObjects= new AllPagesNavObjects(driver);
		allObjects.clickDashboard();
		String dasHeader=driver.getTitle();
		String dashboardTitle="Dashboard | Qatar Driving Training System";
		if(dasHeader.equalsIgnoreCase(dashboardTitle))
			System.out.println("Loaded the Dashboard");
		else
			System.out.println("Title difference found on the Dashboard.");

		//verify student registration page
		allObjects.registerStudent("29035640573");
		WebElement verifybtn= driver.findElement(By.xpath("//button[contains(text(),'VERIFY')]"));
		/*if(verifybtn.isEnabled()) 
			System.out.println("Student Registration is loaded successfully");
		else
			System.out.println("Issue in students registration");*/
		verifybtn.click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		System.out.println("Student Registration is loaded successfully");
		Thread.sleep(2000);
		
		//verify students list page
		allObjects.studentsList();
		if(isAlertPresent()==true) {
			System.out.println("studentsPages() method is failed");
		}
		else {
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			String studHead= driver.getTitle();
			String studentsListHeader="Students | Qatar Driving Training System";
			if(studHead.equalsIgnoreCase(studentsListHeader))
				System.out.println("Loaded the Students List");
			else
				System.out.println("Title difference found on the Students List");
			
			Thread.sleep(1000);			
		}
	}
	
	@Test
	public static void trainerPages()throws Exception{
		//verify trainers registration page
		AllPagesNavObjects allObjects= new AllPagesNavObjects(driver);
		allObjects.registerTrainer();
		isAlertPresent();
		String trRegHeader=driver.getTitle();
		String expectedtrRegHeader="Trainer Registration | Qatar Driving Training System";
		AssertJUnit.assertEquals(expectedtrRegHeader, trRegHeader);
		System.out.println("Headers matched on the Trainer Registration page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//verify trainers list page   
		Thread.sleep(1000);
		allObjects.trainerList();
		isAlertPresent();
		String actualTrListHeader= driver.getTitle();
		String expectedTrListheader= "Trainers | Qatar Driving Training System";
		AssertJUnit.assertEquals(expectedTrListheader, actualTrListHeader);
		System.out.println("Headers matched on the Trainer List page");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//verify deactivated trainers list
		Thread.sleep(1000);
		allObjects.deactivatedTrainerList();
		isAlertPresent();
		String actualDeactivatedTrListHeader= driver.getTitle();
		String expectedDeactivatedTrListheader= "Trainers Deactivated | Qatar Driving Training System";
		AssertJUnit.assertEquals(expectedDeactivatedTrListheader, actualDeactivatedTrListHeader);
		System.out.println("Headers matched on the Deactivated Trainer List page");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//verify terminated trainers list
		Thread.sleep(1000);
		allObjects.terminatedTrainerList();
		isAlertPresent();
		String actualTerminatedTrListHeader= driver.getTitle();
		String expectedTerminatedTrListheader= "Terminated Trainers | Qatar Driving Training System";
		AssertJUnit.assertEquals(expectedTerminatedTrListheader, actualTerminatedTrListHeader);
		System.out.println("Headers matched on the  Terminated Trainer List page");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//verify trainers performance page
		Thread.sleep(1000);
		allObjects.trainerPerformance();
		isAlertPresent();
		String actualPerformanceHeader= driver.getTitle();
		String expectedPerformanceHeader= "Perfomance Report | Qatar Driving Training System";
		AssertJUnit.assertEquals(expectedPerformanceHeader, actualPerformanceHeader);
		System.out.println("Headers matched on the Perfomance Report page");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	@Test
	public static void vehiclePages()throws Exception{
		AllPagesNavObjects allObjects= new AllPagesNavObjects(driver);
		allObjects.registerVehicle();
		//verify the vehicle registration
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true) {
			System.out.println("Exception found on registerVehicle");
		}
		else
			System.out.println("Vehicle registration page loaded successfully");
		
		//verify the vehicles list
		allObjects.vehicleList();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true) {
			System.out.println("Exception found on vehicleList");
		}
		else
			System.out.println("Vehicles List page loaded successfully");
		
		//verify the deactivated vehicles list
		allObjects.deactivatedVehicles();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true) {
			System.out.println("Exception found on Deactivated Vehicles List");
		}
		else
			System.out.println("Deactivated Vehicles List page loaded successfully");
		
		//verify the terminated vehicles list
		allObjects.terminatedVehicles();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true) {
			System.out.println("Exception found on Terminated Vehicles List");
		}
		else
			System.out.println("Terminated Vehicles List page loaded successfully");
	}
	
	@Test
	public static void schedulePages()throws Exception{
		AllPagesNavObjects allObjects= new AllPagesNavObjects(driver);
		
		//Verify all schedules page
		allObjects.allSchedules();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true) {
			System.out.println("Exception found on All Schedules Page");
		}
		if(isInternalServerErrorPresent()==true) {
			System.out.println("Inernal Server Error Exception found on All Schedules page");
		}
		else
			System.out.println("All Schedules Page is loaded successfully");
		/*String expectedAllScheduleTitle= "All Schedules | Qatar Driving Training System";
		String actualAllScheduleTitle = driver.getTitle();
		Assert.assertEquals(actualAllScheduleTitle, expectedAllScheduleTitle);*/
		
		//Verify free schedules page
		allObjects.freeSchedules();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true) {
			System.out.println("Exception found on Free Schedules Page");
		}
		if(isInternalServerErrorPresent()==true) {
			System.out.println("Inernal Server Error Exception found on Free Schedules page");
		}
		else
			System.out.println("Free Schedules Page is loaded successfully");
		
		//Verify allotted schedules page
		allObjects.allottedSchedules();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true) {
			System.out.println("Exception found on Allotted Schedules Page");
		}
		if(isInternalServerErrorPresent()==true) {
			System.out.println("Inernal Server Error Exception found on Allotted Schedules page");
		}
		else
			System.out.println("Allotted Schedules Page is loaded successfully");
		
		//Verify Unused schedules page
		allObjects.unusedSchedules();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true) {
			System.out.println("Exception found on Unused Schedules Page");
		}
		if(isInternalServerErrorPresent()==true) {
			System.out.println("Inernal Server Error Exception found on Unused Schedules page");
		}
		
		else
			System.out.println("Unused Schedules Page is loaded successfully");
		
		//Verify Absent schedules page
		allObjects.absentSchedules();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true) {
			System.out.println("Exception found on Absent Schedules Page");
		}
		if(isInternalServerErrorPresent()==true) {
			System.out.println("Inernal Server Error Exception found on Absent Schedules page");
		}
		else
			System.out.println("Absent Schedules Page is loaded successfully");
		
		//Verify Student schedules page
		allObjects.studentSchedules();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true) {
			System.out.println("Exception found on Student Schedules Page");
		}
		if(isInternalServerErrorPresent()==true) {
			System.out.println("Inernal Server Error Exception found on Student Schedules page");
		}
		else
			System.out.println("Student Schedules Page is loaded successfully");
	}
	
	@Test
	//Verify the pages under the Exam module
	public static void exam()throws Exception{
		AllPagesNavObjects allObjects= new AllPagesNavObjects(driver);
		allObjects.examBooking();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Exam Booking");
		else
			System.out.println("Exam Booking loaded succefully");
		
		allObjects.preTestBooking();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isInternalServerErrorPresent()==true) 
			System.out.println("Internal server exception found on Pre-test Booking");
		else
			System.out.println("Pre-test Booking loaded succefully");
		
		allObjects.examReport();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isInternalServerErrorPresent()==true) 
			System.out.println("Internal server exception found on Exam Report");
		else
			System.out.println("Exam Report page loaded succefully");
		
		allObjects.preTestReport();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Pre-test Report");
		else
			System.out.println("Pre-Test Report loaded succefully");
	}
	
	@Test
	public static void reportModule()throws Exception{
		AllPagesNavObjects allObjects= new AllPagesNavObjects(driver);

		//Verify the INVOICE report
		allObjects.invoice();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Invoice Report");
		else
			System.out.println("Invoice Report loaded succefully");
		
		//Verify the Cancelled Registrations report
		allObjects.cancelledRegistrations();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Cancelled Registrations Report");
		else
			System.out.println("Cancelled Registrations Report loaded succefully");
		
		//Verify the Waiting List report
		allObjects.waitingList();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Waiting List Report");
		else
			System.out.println("Waiting List Report loaded succefully");
		
		//Verify the Learning Status report
		allObjects.learningStatus();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Learning Status Report");
		else
			System.out.println("Learning Status Report loaded succefully");
	}
	
	@Test
	public static void categories()throws Exception{
		AllPagesNavObjects allObjects= new AllPagesNavObjects(driver);
		
		allObjects.categories();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Categories Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Categories");
		else
			System.out.println("Categories page loaded succefully");
		
		allObjects.courses();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Courses Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Courses");
		else
			System.out.println("Courses page loaded succefully");
		
		allObjects.products();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Products Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Products");
		else
			System.out.println("Products page loaded succefully");
		
		allObjects.commissions();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Commissions Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Commissions");
		else
			System.out.println("Commissions page loaded succefully");
	
		allObjects.generatedPeriods();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Generated periods Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Generated periods");
		else
			System.out.println("Generated periods page loaded succefully");
		
		allObjects.generatePeriod();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Generate periods Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Generate periods");
		else
			System.out.println("Generate periods page loaded succefully");
		
		allObjects.generatedSchedules();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Generated Schedules Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Generated Schedules");
		else
			System.out.println("Generated Schedules page loaded succefully");
		
		allObjects.generateSchedule();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Generate Schedule Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Generate Schedule");
		else
			System.out.println("Generate Schedule page loaded succefully");
		
		allObjects.examConfig();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Exam Config Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Exam Config");
		else
			System.out.println("Exam Config page loaded succefully");
		
		allObjects.preTestConfig();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Pre-test Config Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Pre-test Config");
		else
			System.out.println("Pre-test page loaded succefully");
		
		allObjects.examUpload();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Exam Upload Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Exam Upload");
		else
			System.out.println("Exam Upload loaded succefully");
	}
	
	@Test
	public static void management() {
		AllPagesNavObjects allObjects= new AllPagesNavObjects(driver);
		allObjects.activityLogs();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Activity logs Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Activity logs");
		else
			System.out.println("Activity logs page loaded succefully");
		
		allObjects.users();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Users Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Users page");
		else
			System.out.println("Users page loaded succefully");
		
		allObjects.roles();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Roles Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Roles page");
		else
			System.out.println("Roles page loaded succefully");
	}
	
	@Test
	public static void notifications() {
		AllPagesNavObjects allObjects= new AllPagesNavObjects(driver);
		allObjects.notifications();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		if(isAlertPresent()==true)
			System.out.println("Exception found on Notifications Page");
		if(isInternalServerErrorPresent()==true)
			System.out.println("Internal server exception found on Notifications page");
		else
			System.out.println("Notifications page loaded succefully");
	}
	
	@AfterTest
	public static void tearDown() throws Exception {
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}
}
