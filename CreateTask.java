package week1.SaturnSprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.command.WaitContainerResultCallback;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateTask {

	private static Object duration;

	public static void main(String[] args) throws InterruptedException {
		String actResult = "Bootcamp";
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class = 'slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		//to scroll until sales option using js executor
		WebElement element = driver.findElement(By.xpath("//p[text()='Sales']"));
	    JavascriptExecutor js= (JavascriptExecutor) driver;
	    //using js click method
	    js.executeScript("arguments[0].click();",element);
	    driver.findElement(By.xpath("//a[@title='Tasks']/following-sibling::one-app-nav-bar-item-dropdown/div/one-app-nav-bar-menu-button/a")).click();
	    driver.findElement(By.xpath("//div[@class='menuItemsWrapper']/slot/one-app-nav-bar-menu-item")).click();
	    driver.findElement(By.xpath("//label[text()='Subject']/following-sibling::div[contains(@class,'control')]/div/lightning-base-combobox/div/div[contains(@class,'slds-input-has-icon')]/input")).sendKeys(actResult);
	    driver.findElement(By.xpath("(//div[@class='autocompleteWrapper slds-grow'])[2]")).click();
	    driver.findElement(By.xpath("//div[@class='slds-m-left--smalllabels slds-truncate slds-media__body']/div")).click();
	    driver.findElement(By.xpath("//a[text()='Not Started']")).click();
	    driver.findElement(By.xpath("//ul[@class='scrollable']/li[5]/a")).click();
	    driver.findElement(By.xpath("//button[@title='Save']/span")).click();
	    
	    //selenium wait to verfify task creation
	   WebElement Task = driver.findElement(By.xpath("//div[@data-key='success']"));
	   WebDriverWait wait= new WebDriverWait(driver,5);
  	   wait.until(ExpectedConditions.visibilityOf(Task)); 
  	   //verify the task created message
  	   String verifyMessage = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]/a")).getAttribute("title");
	   System.out.println(" Message = " +verifyMessage);
	   if (verifyMessage.contains(actResult)) {
	    	System.out.println("Task is created");
			}
	    else {
	    	System.out.println("Task is not created");
				};
				driver.close();
	
  	   
				/*
				 * if (Task.isDisplayed()) { System.out.println("Verified"); } else {
				 * System.out.println("Not verified"); }
				 */
		 
	 	    
	   
	}
}

	

	
	


