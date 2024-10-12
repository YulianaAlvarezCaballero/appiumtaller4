package com.automation.stepdefinitions;

import com.automation.pages.CalculatorPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class StepDefinitions {

    private AndroidDriver<MobileElement> driver;
    private CalculatorPage calculator;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        calculator = new CalculatorPage(driver);
    }

    @Given("The calculator app is open")
    public void the_calculator_app_is_open() {
        // La app está abierta por el método @Before
    }

    @When("I press {int}")
    public void i_press(int number) {
        calculator.pressNumber(number);
    }

    @When("I press plus")
    public void i_press_plus() {
        calculator.pressPlus();
    }

    @When("I press minus")
    public void i_press_minus() {
        calculator.pressMinus();
    }

    @When("I press multiply")
    public void i_press_multiply() {
        calculator.pressMultiply();
    }

    @When("I press divide")
    public void i_press_divide() {
        calculator.pressDivide();
    }

    @When("I press equals")
    public void i_press_equals() {
        calculator.pressEquals();
    }

    @Then("The result should be {int}")
    public void the_result_should_be(int expectedResult) {
        Assert.assertEquals(calculator.getResult(), String.valueOf(expectedResult));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
