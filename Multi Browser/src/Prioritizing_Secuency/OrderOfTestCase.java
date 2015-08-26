package Prioritizing_Secuency;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrderOfTestCase {

 public String baseURL = "http://www.google.com";
 public WebDriver driver = new FirefoxDriver();

 @BeforeTest
 public void launchBrowser()
 {
  driver.get(baseURL);
 }

 @AfterTest
 public void closeBrowser()
 {
  driver.quit();
 }

 @BeforeMethod
 public void getTitle()
 {
  System.out.println(driver.getTitle());
 }
 @AfterMethod
 public void goToPreviousPage()
 {
  driver.navigate().back();
 }

 @Test(priority = 2)
 public void images() throws InterruptedException
 {
  driver.findElement(By.linkText("Images")).click();
  Thread.sleep(3000);
  System.out.println(driver.getTitle());
 }

 @Test(priority = 1)
 public void maps() throws InterruptedException
 {
  driver.findElement(By.linkText("Maps")).click();
  Thread.sleep(3000);
  System.out.println(driver.getTitle());
 }

 @Test(priority = 0)
 public void mail() throws InterruptedException
 {
  driver.findElement(By.linkText("Gmail")).click();
  Thread.sleep(3000);
  System.out.println(driver.getTitle());
 }
}
