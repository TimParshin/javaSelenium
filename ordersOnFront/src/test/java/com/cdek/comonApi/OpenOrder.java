package com.cdek.comonApi;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class OpenOrder {
  WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C://Tools/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void openOrder() throws Exception {
    driver.get("https://navfront.qa2.cdek.ru/#/viewLogin");
    //driver.findElement(By.id("login")).click();
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys("tester_nsk");
    //driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("123");
    driver.findElement(By.cssSelector(".btn-success")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Справка'])[1]/preceding::span[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('ООО ', '\"', 'СДЭК-Новоcибирск', '\"', '')])[1]/following::span[2]")).click();driver.findElement(By.id("menuOrder")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Номер заказа'])[1]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Номер заказа'])[1]/following::input[1]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Номер заказа'])[1]/following::input[1]")).sendKeys("1105673653");
    driver.findElement(By.name("vm.filterForm")).submit();
    driver.findElement(By.linkText("1105673653")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
