package com.cdek.comonApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class BaseClass {
    public StringBuffer verificationErrors = new StringBuffer();
    WebDriver driver;

    public void initChromedriver() {
      System.setProperty("webdriver.chrome.driver", "C://Tools/chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void clickOrder() {
      driver.findElement(By.linkText("1105673653")).click();
    }

    public void findOrder() {
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Номер заказа'])[1]/following::input[1]")).sendKeys("1105673653");
      driver.findElement(By.name("vm.filterForm")).submit();
    }

    public void openOrderList() {
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Справка'])[1]/preceding::span[3]")).click();
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('ООО ', '\"', 'СДЭК-Новоcибирск', '\"', '')])[1]/following::span[2]")).click();
      driver.findElement(By.id("menuOrder")).click();
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Номер заказа'])[1]/following::input[1]")).click();
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Номер заказа'])[1]/following::input[1]")).clear();
    }

    public void navfrontAuth() {
      driver.get("https://navfront.qa2.cdek.ru/#/viewLogin");
      driver.findElement(By.id("login")).clear();
      driver.findElement(By.id("login")).sendKeys("tester_nsk");
      driver.findElement(By.id("password")).clear();
      driver.findElement(By.id("password")).sendKeys("123");
      driver.findElement(By.id("target")).click();
    }

    public void stopDriver() {
      driver.quit();
      String verificationErrorString = verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
      }
    }
}
