package Prioritizing_Secuency;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PrioritizingExample {
	public WebDriver driver;
	
	@Parameters("browser")
	 
	  @BeforeClass
	 
	  // Passing Browser parameter from TestNG xml
	 
	  public void beforeTest(String browser) {
	 
	  // If the browser is Firefox, then do this
	 
	  if(browser.equalsIgnoreCase("firefox")) {
	 
		  driver = new FirefoxDriver();
	 
	  // If browser is IE, then do this	  
	 
	  }else if (browser.equalsIgnoreCase("ie")) { 
	 
		  // Here I am setting up the path for my IEDriver
	 
		  System.setProperty("webdriver.ie.driver", "C:\\Users\\sumaia\\Desktop\\Jars_file\\IEDriverServer_x64_2.46.0\\IEDriverServer.exe");
	 
		  driver = new InternetExplorerDriver();
	 
	  } 
	 
	  // Doesn't the browser type, lauch the Website
	 
	  driver.get("https://www.google.com/");
	 
	  }
	 
	@Test(priority = 0)
	public void logout() throws Exception {
		Thread.sleep(1000);
		 driver.findElement(By.xpath(".//*[@id='gb_70']")).click();

			driver.findElement(By.id("Email")).sendKeys("enamsust@gmail.com");
			driver.findElement(By.id("next")).click();

			Thread.sleep(1000);

			driver.findElement(By.id("Passwd")).sendKeys("2138417273");
			driver.findElement(By.id("signIn")).click();
			Thread.sleep(100);

			driver.findElement(
					By.xpath(".//*[@id='gbw']/div/div/div[2]/div[4]/div[1]/a/span"))
					.click();
			driver.findElement(By.xpath(".//*[@id='gb_71']")).click();
		System.out.println("First register your account");
	}

	@Test(priority = 1)
	public void send() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='lst-ib']")).sendKeys("cheapest computer");
		System.out.println("Send email after login");
	}

	@Test(priority = 2)
	public void login() throws InterruptedException {
		Thread.sleep(1000);
		 driver.findElement(By.xpath(".//*[@id='gb_70']")).click();

			
			

		
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}