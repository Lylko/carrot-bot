package com.carrot.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AssignedUser extends AbstractUIObject {

    @FindBy(xpath = "/div/span")
    private ExtendedWebElement name;

    @FindBy(xpath = "/div/span")
    private ExtendedWebElement command;

    public AssignedUser(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getName(){
        return name.getText();
    }

    public String getCommand(){
        return command.getText();
    }
}
