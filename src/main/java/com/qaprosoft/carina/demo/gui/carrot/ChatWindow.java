package com.qaprosoft.carina.demo.gui.carrot;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ChatWindow extends AbstractPage {

    @FindBy(xpath = "//div[@class='flex no-flex-shrink align-items-center'][1]")
    private ExtendedWebElement conversBtn;

    @FindBy(xpath = "//div[@class='text-truncate' and contains(text(), 'Wilson')]")
    private ExtendedWebElement assignToMeBtn;

    @FindBy(xpath = "//div[@data-placeholder='Введите сообщение и нажмите Ctrl+Enter']")
    private ExtendedWebElement messageField;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private ExtendedWebElement submitBtn;

    public ChatWindow(WebDriver driver) {
        super(driver);
    }

    public void assignToMe(){
        conversBtn.click();
        assignToMeBtn.click();
    }

    public void sayHello(String msg){
        messageField.type(msg);
        submitBtn.click();
    }


}
