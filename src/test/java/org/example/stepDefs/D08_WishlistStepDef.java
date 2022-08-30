package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P00_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class D08_WishlistStepDef {
    P00_homePage homePage = new P00_homePage(Hooks.driver);
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    SoftAssert softAssert = new SoftAssert();

    @Given("User at the homepage")
    public void user_at_the_homepage() {
        homePage.getHomePageLink().click();
    }

    @When("User click on add to wishlist button of htc phone")
    public void user_click_on_add_to_wishlist_button_of_htc_phone() {
        homePage.getHtcPhoneAddToWishlistBtn().click();
    }

    @And("User click on Wishlist link")
    public void user_click_on_wishlist_link() {
        wait.until(ExpectedConditions.invisibilityOf(homePage.getSuccessNotification()));
        homePage.getWishListLink().click();
    }

    @Then("success message appears which confirm adding of the product")
    public void success_message_appears_which_confirm_adding_of_the_product() {
        softAssert.assertTrue(homePage.getSuccessNotification().isDisplayed());
        softAssert.assertEquals(homePage.getSuccessNotification().
                getCssValue("background-color"), "rgba(75, 176, 122, 1)"); // Green
        softAssert.assertAll();
    }

    @Then("User will navigate to wishlist page which contain htc phone product with its quantity")
    public void user_will_navigate_to_wishlist_page_which_contain_htc_phone_product_with_its_quantity() {
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("wishlist"));
        int productQuantity = Integer.parseInt(homePage.getProductQuantity().getAttribute("value"));
        softAssert.assertTrue(productQuantity > 0);
        softAssert.assertAll();
    }

}


