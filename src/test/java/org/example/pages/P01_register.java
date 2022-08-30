package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class P01_register {
    public P01_register() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(className = "ico-register")
    public WebElement registerBtn;
    @FindBy(id = "register-button")
    public WebElement registerBtnFinal;
    @FindBy(id = "gender-male")
    public WebElement userGenderMale;
    @FindBy(id = "gender-female")
    public WebElement userGenderFemale;
    @FindBy(id = "FirstName")
    public WebElement userFirstName;
    @FindBy(id = "LastName")
    public WebElement userLastName;
    @FindBy(id = "Email")
    public WebElement userEmail;
    @FindBy(name = "DateOfBirthDay")
    public WebElement dayBirthMenu;
    @FindBy(name = "DateOfBirthMonth")
    public WebElement monthBirthMenu;
    @FindBy(name = "DateOfBirthYear")
    public WebElement yearBirthMenu;
    @FindBy(id = "Password")
    public WebElement userPassword;
    @FindBy(id = "ConfirmPassword")
    public WebElement userConfirmPassword;
    @FindBy(id = "Company")
    public WebElement companyName;
    @FindBy(css = "div.result")
    public WebElement message; //registration successfully
    @FindBy(xpath = "//div[@class='buttons']")
    public WebElement continueBtn;

    public WebElement getMaleGender() {
        return userGenderMale;
    }

    public WebElement getDayBirthMenu() {
        return dayBirthMenu;
    }

    public WebElement getMonthBirthMenu() {
        return monthBirthMenu;
    }

    public WebElement getYearBirthMenu() {
        return yearBirthMenu;
    }

    public WebElement getUserFirstName() {
        return userFirstName;
    }

    public WebElement getUserLastName() {
        return userLastName;
    }

    public WebElement getUserEmail() {
        return userEmail;
    }

    public WebElement getUserPassword() {
        return userPassword;
    }

    public WebElement getUserConfirmPassword() {
        return userConfirmPassword;
    }

    public WebElement getCompanyName() {
        return companyName;
    }

    public WebElement getRegisterBtn() {
        return registerBtnFinal;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getContinueBtn() {
        return continueBtn;
    }
}


