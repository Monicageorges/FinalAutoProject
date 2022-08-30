package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P00_homePage;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P00_homePage homePage = new P00_homePage(Hooks.driver);
    P02_login loginPage = new P02_login(Hooks.driver);
    SoftAssert softAssert = new SoftAssert();

    @Given("User open login page")
    public void user_open_login_page() {
        homePage.getLoginLink().click();
    }

    @When("User enter email and password")
    public void user_enter_email_and_password() {
        loginPage.getEmailTxtField().sendKeys(Hooks.userEmail);
        loginPage.getPasswordTxtField().sendKeys(Hooks.userValidPassword);
    }

    @And("User click on login button")
    public void user_click_on_login_button() {
        loginPage.getLoginBtn().click();
    }

    @Then("User login successfully and return to home page")
    public void user_login_successfully_and_return_to_home_page() {
        softAssert.assertTrue(homePage.getMyAccountLink().isDisplayed());
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        softAssert.assertAll();
    }

    @When("User enter invalid email and password")
    public void user_enter_invalid_email_and_password() {
        loginPage.getEmailTxtField().sendKeys(Hooks.userInvalidEmail);
        loginPage.getPasswordTxtField().sendKeys(Hooks.userValidPassword);
    }

    @Then("User login failed and error message appears")
    public void userLoginFailedAndErrorMessageAppears() {
        softAssert.assertTrue(loginPage.getErrorMessage().getText().contains("Login was unsuccessful"));
        softAssert.assertEquals((Color.fromString(loginPage.getErrorMessage().getCssValue("color")).asHex()),
                "#e4434b");
        softAssert.assertAll();
    }
}
