package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_register register = new P01_register();
    Select select;
    SoftAssert softAssert = new SoftAssert();

    @Given("user go to register page")
    public void register_page() {
        register.registerBtn.click();
    }

    @When("user chooses gender")
    public void userChoosesGender() {
        if (Hooks.gender.equalsIgnoreCase("male")) {
            register.userGenderMale.click();
        }
        if (Hooks.gender.equalsIgnoreCase("female")) {
            register.userGenderFemale.click();
        }
    }

    @And("user enters first name")
    public void userEntersFirstName() {
        register.userFirstName.clear();
        register.getUserFirstName().sendKeys(Hooks.userFirstName);
    }

    @And("user enters last name")
    public void userEntersLastName() {
        register.userLastName.clear();
        register.getUserLastName().sendKeys(Hooks.userLastName);
    }

    @And("user chooses date of birth")
    public void userChoosesDateOfBirth() {
        select = new Select(register.getDayBirthMenu());
        select.selectByValue("29");
        select = new Select(register.getMonthBirthMenu());
        select.selectByValue("10");
        select = new Select(register.getYearBirthMenu());
        select.selectByValue("1996");
    }

    @And("user enters email address")
    public void userEntersEmail() {
        register.getUserEmail().sendKeys(Hooks.userEmail);
    }

    @And("user enters company name")
    public void userEntersCompanyName() {
        register.getCompanyName().sendKeys(Hooks.companyName);
    }

    @And("user enters password")
    public void userEntersPasswordFields() {
        register.getUserPassword().sendKeys(Hooks.userValidPassword);
    }

    @And("user enters confirm password")
    public void userEntersConfirmPassword() {
        register.getUserConfirmPassword().sendKeys(Hooks.userValidPassword);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.getRegisterBtn().click();
    }

    @Then("success registration message displayed")
    public void successRegistrationMessageDisplayed() {
        softAssert.assertTrue(register.getMessage().getText().contains("Your registration completed"));
        softAssert.assertEquals(register.getMessage().getCssValue("color"),
                "rgba(76, 177, 124, 1)"); // Green
    }

    @And("user clicks on continue button to return to home page")
    public void userClicksOnContinueButton() {
        register.getContinueBtn().click();
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        softAssert.assertAll();
    }

}
