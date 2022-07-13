package com.carrot.gui;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends AbstractPage{

    @FindBy(xpath = "//button[@class='conversations-dropdown-toggle d-flex justify-space-between align-items-center btn btn-outline-primary dropdown-toggle']")
    private ExtendedWebElement conversationBtn;

    @FindBy(css = "cq-radio[value = 'notAssigned']")
    private ExtendedWebElement notAssignedBtn;

    @FindBy(xpath = "//div[@class = 'conversation-list-item-inner flex bordered-bottom']//span[count(span) = 1]")
    private List<ChatPreview> notAssignedChats;

    @FindBy(xpath = "//div[@translate='conversations.conversationList.assignees.mine']")
    private ExtendedWebElement mineChatsBtn;

    @FindBy(xpath = "//div[@ng-bind='vm.conversation.user.name']")
    private List<ExtendedWebElement> chatNames;

    public MainPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
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

    public void checkAssignedChat(String name){
        conversationBtn.click();
        mineChatsBtn.click();
        for (ExtendedWebElement chatName : chatNames){
            if (name.equals(chatName.getText())){
                chatName.click();
                break;
            }
        }
        ChatWindow chatWindow = new ChatWindow(driver);
        chatWindow.checkAssigning();
    }

    public List<ChatPreview> getNotAssignedChats(){
        return notAssignedChats;
    }
}
