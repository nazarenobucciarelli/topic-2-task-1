package com.solvd.carina.demo.gui.android.pages;

import com.solvd.carina.demo.gui.common.pages.SignInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignInPageBase.class)
public class SignInPage extends SignInPageBase {

    @FindBy(xpath = "//android.webkit.WebView[@text=\"Sign in or Register | eBay\"]/android.view.View/" +
            "android.view.View[3]/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[2]" +
            "/android.widget.EditText")
    private ExtendedWebElement userId;

    @FindBy(xpath = "//android.webkit.WebView[@text=\"Sign in or Register | eBay\"]/android.view.View/" +
            "android.view.View[3]/android.view.View/android.view.View[2]/android.view.View[1]/" +
            "android.view.View[1]/android.view.View[2]/android.widget.EditText")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//android.widget.Button[@text=\"Continue\"]")
    private ExtendedWebElement signInContinueBtn;

    @FindBy(xpath = "//android.widget.Button[@text=\"Sign in\"]")
    private ExtendedWebElement signInBtn;

    @FindBy(xpath = "//android.view.View[@text=\"This password is incorrect. Try again or reset password .\"]")
    private ExtendedWebElement signInErrorMsg;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void typeUserId(String id) {
        userId.type(id);
    }

    public void clickSignInContinueBtn() {
        signInContinueBtn.click();
        if (getCaptcha().isVisible()) {
            System.out.println("captcha is visible");
            waitUntil(webDriver -> !getCaptcha().isVisible(), 20);
        }
    }

    public void typePassword(String password) {
        passwordInput.type(password);
    }

    public void clickSignInBtn() {
        signInBtn.click();
        pause(15); //to solve captcha
    }

    public boolean isSignInErrorMsgDisplayed() {
        return signInErrorMsg.isVisible();
    }
}