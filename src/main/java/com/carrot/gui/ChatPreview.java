package com.carrot.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ChatPreview extends AbstractUIObject {

    @FindBy(xpath = "./span")
    private ExtendedWebElement previewText;

    @FindBy(xpath = ".")
    private ExtendedWebElement chatBtn;

    public ChatPreview(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getPreviewText(){
        return previewText.getText();
    }

    public void openChat(){
        chatBtn.click();
    }
}
