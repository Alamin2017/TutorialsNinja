package testcases;
import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
public class Login extends Base {

    @Test(priority = 1)
    public void verifyLoginWithValidCredentials() throws InterruptedException, IOException {

        driver.get(prop.getProperty("url"));
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("amotoori9@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']")).isDisplayed());
        Thread.sleep(2000);
        driver.quit();
    }
    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials() throws InterruptedException {

        driver.get("http://www.tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("trimotor3"+generateTimeStamp()+"@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123457677");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
        Thread.sleep(2000);
        driver.quit();
    }
    public String generateTimeStamp()
    {
        Date date=new Date();
        return date.toString().replace(" ","_").replace(":","_");

    }

}
