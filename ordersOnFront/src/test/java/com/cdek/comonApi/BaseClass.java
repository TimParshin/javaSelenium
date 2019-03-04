package com.cdek.comonApi;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class BaseClass {
    public StringBuffer verificationErrors = new StringBuffer();
    WebDriver driver;

    public void initChromedriver() {
      System.setProperty("webdriver.chrome.driver", "C://Tools/chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickOrder() {
      driver.findElement(By.linkText("1105673653")).click();
    }

    public void findOrder() {
      //driver.findElement(By.xpath("//*[@id=\"filter_field_orderNumber\"]")).sendKeys("1105673653");
      driver.findElement(By.cssSelector("#filter_field_orderNumber")).sendKeys("110567653");
        driver.findElement(By.name("vm.filterForm")).submit();
    }

    public void openOrderList() {
      driver.findElement(By.id("overMainHeader")).click();
      driver.findElement(By.xpath("//*[@id=\"menuDelivery\"]")).click();
        fixCoveredElement("//*[@id=\"menuOrder\"]");
    }

    public void fixCoveredElement(String elementPath) {
        elementPath = elementPath;
        WebElement ele = driver.findElement(By.xpath(elementPath));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", ele);
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
