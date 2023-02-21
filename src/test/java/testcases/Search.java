package testcases;

import base.Base;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search extends Base {

    @Test(priority = 1)
    public void verifySearchWithValidProduct() throws InterruptedException {

        driver.get("http://www.tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("HP");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']")).isDisplayed());
        Thread.sleep(2000);
        Allure.description("verifySearchWithValidProduct");
    }
    @Test(priority = 2)
    public void verifySearchWithInvalidProduct() throws InterruptedException {

        driver.get("http://www.tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Honda");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).isDisplayed());
        Thread.sleep(2000);
        Allure.description("verifySearchWithInvalidProduct");
    }
}
