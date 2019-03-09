package com.cdek.comonApi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenOrder {
  private final BaseClass baseClass = new BaseClass();
  public boolean acceptNextAlert = true;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    baseClass.initChromedriver();
    baseClass.navfrontAuth();
  }

  @Test
  public void openOrder() throws Exception {
    baseClass.openOrderList();
    baseClass.findOrder("1105673653");
    baseClass.clickOrder();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    baseClass.stopDriver();
  }

  private boolean isElementPresent(By by) {
    try {
      baseClass.driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      baseClass.driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = baseClass.driver.switchTo().alert();
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
