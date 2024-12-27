package com.solvd.carina.demo.gui.desktop.pages;

import com.solvd.carina.demo.gui.common.pages.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {

    @FindBy(id = "userid")
    private ExtendedWebElement userId;

    @FindBy(id = "pass")
    private ExtendedWebElement passwordInput;

    @FindBy(css = "button[data-testid='signin-continue-btn']")
    private ExtendedWebElement signInContinueBtn;

    @FindBy(id = "sgnBt")
    private ExtendedWebElement signInBtn;

    @FindBy(id = "signin-error-msg")
    private ExtendedWebElement signInErrorMsg;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void typeUserId(String id) {
        userId.type(id);
    }

    public void clickSignInContinueBtn() {
        signInContinueBtn.click();
        pause(15); // to solve captcha
    }

    public void typePassword(String password) {
        passwordInput.type(password);
    }

    public void clickSignInBtn() {
        signInBtn.click();
        pause(15); // to solve captcha
    }

    public boolean isSignInErrorMsgDisplayed() {
        return signInErrorMsg.isVisible();
    }
}