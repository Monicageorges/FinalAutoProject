package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P00_homePage;
import org.example.pages.P02_login;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class D03_currenciesStepDef {
    P00_homePage homePage = new P00_homePage(Hooks.driver);
    P02_login loginPage = new P02_login(Hooks.driver);
    Select select;

    @Given("User log in with email and password")
    public void user_log_in_with_email_and_password() {
        homePage.getLoginLink().click();
        loginPage.getEmailTxtField().sendKeys(Hooks.userEmail);
        loginPage.getPasswordTxtField().sendKeys(Hooks.userValidPassword);
        loginPage.getLoginBtn().click();
    }

    @When("User select euro currency from drop down menu")
    public void user_select_euro_currency_from_drop_down_menu() {
        select = new Select(homePage.getCurrencyDropDownMenu());
        select.selectByVisibleText("Euro");
    }

    @Then("All items prices change to euro")
    public void all_items_prices_change_to_euro() {
        List<WebElement> prices = homePage.getPrices();
        for (WebElement price : prices) {
            Assert.assertTrue(price.getText().contains("€"));
        }
    }
}
