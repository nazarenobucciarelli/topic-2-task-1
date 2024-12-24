package com.solvd.carina.demo.gui.common.pages;

import org.openqa.selenium.WebDriver;

public abstract class SignInPageBase extends CaptchaPageBase{

    public SignInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeUserId(String id);

    public abstract void clickSignInContinueBtn();

    public abstract void typePassword(String password);

    public abstract void clickSignInBtn();

    public abstract boolean isSignInErrorMsgDisplayed();
}
