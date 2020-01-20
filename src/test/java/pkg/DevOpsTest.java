package pkg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DevOpsTest {
    WebDriver driver;
    @Test
    public void openBrowser() throws InterruptedException {
        driver.get("https://login.yahoo.com/account/create?specId=yidReg");    
        
        
        driver.findElement(By.name("firstName")).sendKeys("John");
        
        driver.findElement(By.id("usernamereg-lastName")).sendKeys("doe");
        
        driver.findElement(By.name("yid")).sendKeys("abcde@yahoo.com");
        
        driver.findElement(By.className("phone-no")).sendKeys("9858965667");
        
        Select s= new Select(driver.findElement(By.name("mm")));
        s.selectByVisibleText("March");
        
        Thread.sleep(2000);
        s.selectByIndex(9);
        Thread.sleep(2000);
        s.selectByValue("7");
           
    }

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.ie.driver","src\\test\\resources\\IEDriverServer.exe");
        driver= new InternetExplorerDriver();
        driverNext= new InternetExplorerDriver();
    }
    
    WebDriver driverNext;
    
    @Test
    public void openBrowserNext() throws InterruptedException {
        driverNext.get("https://www.google.com");

 

        Assert.assertEquals(driverNext.getTitle(), "Google");

 

    }

    @AfterTest
    public void afterTest() {
        driver.close();
        driverNext.close();
        
    }

}