package com.qaprosoft.carina.demo.gui.carrot;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends AbstractPage{

    @FindBy(xpath = "//button[@class='conversations-dropdown-toggle btn btn-sm btn-secondary dropdown-toggle']")
    private ExtendedWebElement conversationBtn;

    @FindBy(css = "cq-radio[value = 'notAssigned']")
    private ExtendedWebElement notAssignedBtn;

    @FindBy(xpath = "//div[@class = 'conversation-list-item-inner flex bordered-bottom']//span[count(span) = 1]")
    private List<ChatPreview> notAssignedChats;

    @FindBy(xpath = "//div[@translate='conversations.conversationList.assignees.mine']")
    private ExtendedWebElement mineChatsBtn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void chooseNotAssigned(){
        conversationBtn.click();
        notAssignedBtn.click();
    }

    public void refreshChats(){
        conversationBtn.click();
        mineChatsBtn.click();
        conversationBtn.click();
        notAssignedBtn.click();
    }

    public List<ChatPreview> getNotAssignedChats(){
        return notAssignedChats;
    }
}
