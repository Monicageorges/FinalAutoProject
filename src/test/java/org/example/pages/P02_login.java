package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_login {
    public P02_login(WebDriver driver) {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(id = "Email")
    WebElement emailTxtField;
    @FindBy(id = "Password")
    WebElement passwordTxtField;
    @FindBy(css = "button.button-1.login-button")
    WebElement loginBtn;
    @FindBy(css = "div.message-error.validation-summary-errors")
    WebElement errorMessage;

    public WebElement getEmailTxtField() {
        return emailTxtField;
    }

    public WebElement getPasswordTxtField() {
        return passwordTxtField;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}



