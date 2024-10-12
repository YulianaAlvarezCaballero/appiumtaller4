package com.automation.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorPage {
    private AndroidDriver<MobileElement> driver;

    public CalculatorPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void pressNumber(int number) {
        String elementId = "com.android.calculator2:id/digit_" + number;
        driver.findElementById(elementId).click();
    }

    public void pressPlus() {
        MobileElement plus = driver.findElementByAccessibilityId("plus");
        plus.click();
    }

    public void pressMinus() {
        MobileElement minus = driver.findElementByAccessibilityId("minus");
        minus.click();
    }

    public void pressMultiply() {
        MobileElement multiply = driver.findElementByAccessibilityId("multiply");
        multiply.click();
    }

    public void pressDivide() {
        MobileElement divide = driver.findElementByAccessibilityId("divide");
        divide.click();
    }

    public void pressEquals() {
        MobileElement equals = driver.findElementByAccessibilityId("equals");
        equals.click();
    }

    public String getResult() {
        return driver.findElementById("com.android.calculator2:id/result").getText();
    }
}
