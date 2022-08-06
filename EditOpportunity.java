package week1.SaturnSprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditOpportunity {

	public static void main(String[] args) throws InterruptedException {
		String keyWord = "param";
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//div[@class = 'slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		//to scroll until sales option using js executor
		WebElement element = driver.findElement(By.xpath("//p[text()='Sales']"));
	    JavascriptExecutor js= (JavascriptExecutor) driver;
	    //using js click method
	    js.executeScript("arguments[0].click();",element);
	   WebElement Oppt = driver.findElement(By.xpath("//span[text()='Opportunities']"));
	   js.executeScript("arguments[0].click();",Oppt);
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Param",Keys.ENTER);
	 	//driver.findElement(By.xpath("//div[@data-aura-class= 'forceVirtualAction']/a/span")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//table/tbody/tr/td[8]/span/div/a/span/span)[1]")).click();
	    //driver.findElement(By.xpath("//a[contains(@class,'rowActionsPlaceHolder')]/span/span")).click();
	    driver.findElement(By.xpath("//a[@title='Edit']")).click();
	    WebElement Date = driver.findElement(By.xpath("//input[@name='CloseDate']"));
	    Date.clear();
	    Date.sendKeys("8/7/2022");
	    driver.findElement(By.xpath("//label[text()='Stage']/following-sibling::div")).click();
	    driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
	    //scrollinto the element using JS
	    WebElement delivery = driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']"));
	    js.executeScript("arguments[0].scrollIntoView();",delivery);
	    driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']/following-sibling::div")).click();
	   //to use Java script click
	    WebElement progress = driver.findElement(By.xpath("//span[text()='In progress']"));
	    js.executeScript("arguments[0].click();",progress);
	    //save
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    //WebElement save = driver.findElement(By.xpath("//li[@class='slds-button-group-item visible'][3]/runtime_platform_actions-action-renderer"));
	    //js.executeScript("arguments[0].click();",save);
	   //selenium wait to verfify Edit opportunities
	    WebElement verify = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
	    WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.visibilityOf(verify));
	    //verify the task created message
	    String verifymessage = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
	    System.out.println("verify message is =" + verifymessage);
	    if (verifymessage.contains("param")) {
	    	System.out.println("Edit opportunity is verified");
			
		}else {
			System.out.println("Edit opportunity is not verified");
			
		}
	    Thread.sleep(3000);
	    driver.close();
	    	    		    	
	}

}
