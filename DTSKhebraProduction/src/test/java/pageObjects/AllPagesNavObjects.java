package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllPagesNavObjects {
	WebDriver driver=null; 
	By dashboardLink= By.xpath("//*[@id=\"accordionSidebar\"]/li[1]/a");
	
	By studentsModule= By.xpath("/html[1]/body[1]/div[1]/ul[1]/li[2]/a[1]/span[1]");
	By registerStudent= By.xpath("//a[contains(text(),'Student Registration')]");
	By qid= By.xpath("//input[@id='verifyQIDField']");
	By studentsList= By.xpath("//a[contains(text(),'Student List')]");
	
	By trainersModule= By.xpath("//span[contains(text(),'Trainers')]");
	By trReg= By.xpath("//a[contains(text(),'Trainer Registration')]");
	By trList=By.xpath("//body/div[@id='wrapper']/ul[@id='accordionSidebar']/li[3]/div[1]/div[1]/a[2]");
	By deactivatedTrList= By.xpath("//a[contains(text(),'Deactivated Trainers List')]");
	By terminatedTrList= By.xpath("//a[contains(text(),'Terminated Trainer List')]");
	By performanceReport= By.xpath("//a[contains(text(),'Perfomance Report')]");
	
	By vehicleModule= By.xpath("//span[contains(text(),'Vehicles')]");
	By registerVehicle= By.xpath("//a[contains(text(),'Vehicle Registration')]");
	By vehicleList = By.xpath("//a[contains(text(),'Vehicle List')]");
	By deactivatedVehicles = By.xpath("//a[contains(text(),'Deactivated List')]");
	By terminatedVehicles = By.xpath("//a[contains(text(),'Terminated List')]");
	
	By scheduleModule = By.xpath("//span[contains(text(),'Schedules')]");
	By allSchedules = By.xpath("//a[contains(text(),'All Schedules')]");
	By freeSchedules = By.xpath("//a[contains(text(),'Free Schedules')]");
	By allottedSchedules = By.xpath("//a[contains(text(),'Allotted Schedules')]");
	By unusedSchedules = By.xpath("//a[contains(text(),'Unused Schedules')]");
	By absentSchedules = By.xpath("//a[contains(text(),'Absent Schedules')]");
	By studentSchedules = By.xpath("//a[contains(text(),'Student Schedules')]");
	
	By examModule= By.xpath("//span[contains(text(),'Exam')]");
	By examBooking= By.xpath("//a[contains(text(),'Exam Booking')]");
	By preTestBooking= By.xpath("//a[contains(text(),'Pre-Test Booking')]");
	By exam= By.xpath("//a[contains(text(),'Exam')]");
	By preTest= By.xpath("//a[contains(text(),'Pre-Test')]");
	
	By reportsModule= By.xpath("//span[contains(text(),'Reports')]");
	By invoice= By.xpath("//a[contains(text(),'Invoice')]");
	By cancelledRegistrations= By.xpath("//a[contains(text(),'Cancelled Registration')]");
	By waitingList= By.xpath("//a[contains(text(),'Waiting List')]");
	By learningStatus= By.xpath("//a[contains(text(),'Learning Status')]");
	
	By utilities= By.xpath("//span[contains(text(),'Utilities')]");
	By categories= By.xpath("//a[contains(text(),'Categories')]");
	By courses= By.xpath("//a[contains(text(),'Courses')]");
	By products= By.xpath("//a[contains(text(),'Products')]");
	By commissions= By.xpath("//a[contains(text(),'Commissions')]");
	By generatedPeriods= By.xpath("//a[contains(text(),'Generated Periods')]");
	By generatePeriod= By.xpath("//a[contains(text(),'Generate Period')]");
	By generatedSchedules= By.xpath("//a[contains(text(),'Generated Schedules')]");
	By generateSchedules= By.xpath("//a[contains(text(),'Generate Schedule')]");
	By examConfig= By.xpath("//a[contains(text(),'Exam Configuration')]");
	By preTestConfig= By.xpath("//a[contains(text(),'Pre-Test Configuration')]");
	By examUpload= By.xpath("//a[contains(text(),'Exam Upload')]");
	
	By managementModule= By.xpath("//span[contains(text(),'Management')]");
	By activityLogs= By.xpath("//a[contains(text(),'Activity Logs')]");
	By users= By.xpath("//a[contains(text(),'Users')]");
	By roles= By.xpath("//a[contains(text(),'Roles')]");
	By notifications= By.xpath("//span[contains(text(),'Notifications')]");
			
	public AllPagesNavObjects(WebDriver driver) {
		this.driver=driver;
	}
	public void clickDashboard() {
		driver.findElement(dashboardLink).click();
	}
	public void registerStudent(String text) throws InterruptedException {
		driver.findElement(studentsModule).click();
		driver.findElement(registerStudent).click();
		driver.findElement(qid).sendKeys(text);
	}
	public void studentsList() {
		driver.findElement(studentsModule).click();
		driver.findElement(studentsList).click();
	}
	public void registerTrainer() {
		driver.findElement(trainersModule).click();
		driver.findElement(trReg).click();
	}
	public void trainerList() {
		driver.findElement(trainersModule).click();
		driver.findElement(trList).click();
	}
	public void deactivatedTrainerList() {
		driver.findElement(trainersModule).click();
		driver.findElement(deactivatedTrList).click();
	}
	public void terminatedTrainerList() {
		driver.findElement(trainersModule).click();
		driver.findElement(terminatedTrList).click();
	}
	public void trainerPerformance() {
		driver.findElement(trainersModule).click();
		driver.findElement(performanceReport).click();
	}
	public void registerVehicle() {
		driver.findElement(vehicleModule).click();
		driver.findElement(registerVehicle).click();
	}
	public void vehicleList() {
		driver.findElement(vehicleModule).click();
		driver.findElement(vehicleList).click();
	}
	public void deactivatedVehicles() {
		driver.findElement(vehicleModule).click();
		driver.findElement(deactivatedVehicles).click();
	}
	public void terminatedVehicles() {
		driver.findElement(vehicleModule).click();
		driver.findElement(terminatedVehicles).click();
	}
	public void allSchedules() {
		driver.findElement(scheduleModule).click();
		driver.findElement(allSchedules).click();
	}
	public void freeSchedules() {
		driver.findElement(scheduleModule).click();
		driver.findElement(freeSchedules).click();
	}
	public void allottedSchedules() {
		driver.findElement(scheduleModule).click();
		driver.findElement(allottedSchedules).click();
	}
	public void unusedSchedules() {
		driver.findElement(scheduleModule).click();
		driver.findElement(unusedSchedules).click();
	}
	public void absentSchedules() {
		driver.findElement(scheduleModule).click();
		driver.findElement(absentSchedules).click();
	}
	public void studentSchedules() {
		driver.findElement(scheduleModule).click();
		driver.findElement(studentSchedules).click();
	}
	public void examBooking() {
		driver.findElement(examModule).click();
		driver.findElement(examBooking).click();
	}
	public void preTestBooking() {
		driver.findElement(examModule).click();
		driver.findElement(preTestBooking).click();
	}
	public void examReport() {
		driver.findElement(examModule).click();
		driver.findElement(exam).click();
	}
	public void preTestReport() {
		driver.findElement(examModule).click();
		driver.findElement(preTest).click();
	}
	public void invoice() {
		driver.findElement(reportsModule).click();
		driver.findElement(invoice).click();
	}
	public void cancelledRegistrations() {
		driver.findElement(reportsModule).click();
		driver.findElement(cancelledRegistrations).click();
	}
	public void waitingList() {
		driver.findElement(reportsModule).click();
		driver.findElement(waitingList).click();
	}
	public void learningStatus() {
		driver.findElement(reportsModule).click();
		driver.findElement(learningStatus).click();
	}
	public void categories() {
		driver.findElement(utilities).click();
		driver.findElement(categories).click();
	}
	public void courses() {
		driver.findElement(utilities).click();
		driver.findElement(courses).click();
	}
	public void products() {
		driver.findElement(utilities).click();
		driver.findElement(products).click();
	}
	public void commissions() {
		driver.findElement(utilities).click();
		driver.findElement(commissions).click();
	}
	public void generatedPeriods() {
		driver.findElement(utilities).click();
		driver.findElement(generatedPeriods).click();
	}
	public void generatePeriod() {
		driver.findElement(utilities).click();
		driver.findElement(generatePeriod).click();
	}
	public void generatedSchedules() {
		driver.findElement(utilities).click();
		driver.findElement(generatedSchedules).click();
	}
	public void generateSchedule() {
		driver.findElement(utilities).click();
		driver.findElement(generateSchedules).click();
	}
	public void examConfig() {
		driver.findElement(utilities).click();
		driver.findElement(examConfig).click();
	}
	public void preTestConfig() {
		driver.findElement(utilities).click();
		driver.findElement(preTestConfig).click();
	}
	public void examUpload() {
		driver.findElement(utilities).click();
		driver.findElement(examUpload).click();
	}
	public void activityLogs() {
		driver.findElement(managementModule).click();
		driver.findElement(activityLogs).click();
	}
	public void users() {
		driver.findElement(managementModule).click();
		driver.findElement(users).click();
	}
	public void roles() {
		driver.findElement(managementModule).click();
		driver.findElement(roles).click();
	}
	public void notifications() {
		driver.findElement(notifications).click();
	}
}
