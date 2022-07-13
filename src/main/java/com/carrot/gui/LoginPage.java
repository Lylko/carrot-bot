package com.carrot.gui;

import com.carrot.utils.CryptoUtil;
import com.qaprosoft.carina.core.foundation.commons.SpecialKeywords;
import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Pattern;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@type = 'email']")
    private ExtendedWebElement loginField;

    @FindBy(xpath = "//input[@type = 'password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@type = 'submit']")
    private ExtendedWebElement submitBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void makeLogin() {
        this.loginField.type(CryptoUtil.decrypt(R.TESTDATA.get("login")));
        this.passwordField.type(CryptoUtil.decrypt(R.TESTDATA.get("password")));
        this.submitBtn.click();
    }

}
