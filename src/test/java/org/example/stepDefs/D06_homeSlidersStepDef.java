package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P00_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D06_homeSlidersStepDef {
    P00_homePage homePage = new P00_homePage(Hooks.driver);
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    @Given("User at home page")
    public void user_at_home_page() {
        homePage.getHomePageLink().click();
    }

    @When("User click on first slider nokia image")
    public void user_click_on_first_slider_nokia_image() {
        homePage.getNokiaImgLink().click();
    }

    @Then("User navigate to nokia product details page")
    public void user_navigate_to_nokia_product_details_page() {
        wait.until(ExpectedConditions.urlToBe(Hooks.nokiaProductDetailsPageUrl));
        System.out.println(Hooks.driver.getCurrentUrl());
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), Hooks.nokiaProductDetailsPageUrl);
    }

    @When("User click on second slider iphone image")
    public void user_click_on_second_slider_iphone_image() throws InterruptedException {
        homePage.getIphoneSelector().click();
        Thread.sleep(2000);
        homePage.getIphoneImgLink().click();
    }

    @Then("User navigate to iphone product details page")
    public void user_navigate_to_iphone_product_details_page() {
        wait.until(ExpectedConditions.urlToBe(Hooks.iphoneProductDetailsPageUrl));
        System.out.println(Hooks.driver.getCurrentUrl());
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), Hooks.iphoneProductDetailsPageUrl);
    }
}


