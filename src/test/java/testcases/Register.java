package testcases;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utilities;

import java.time.Duration;

public class Register extends Base {

    @Test(priority = 1)
    public void verifyRegisterWithValidCredentials() throws InterruptedException {

        driver.get("http://www.tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Arun");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Motoori");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
        driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).isDisplayed());
        Thread.sleep(2000);
        driver.quit();
    }
}
