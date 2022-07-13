package com.carrot.gui;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ChatWindow extends AbstractPage {

    @FindBy(xpath = "//div[@class='flex no-flex-shrink align-items-center'][1]")
    private ExtendedWebElement conversBtn;

    @FindBy(xpath = "//div[@class='text-truncate' and contains(text(), 'Wilson')]")
    private ExtendedWebElement assignToMeBtn;

    @FindBy(xpath = "//div[@data-placeholder='Введите сообщение и нажмите Ctrl+Enter']")
    private ExtendedWebElement messageField;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private ExtendedWebElement submitBtn;

    @FindBy(xpath = "//div[@class='system-message']")
    private List<AssignedUser> assignArray;

    public ChatWindow(WebDriver driver) {
        super(driver);
    }

    public void assignToMe(){
        conversBtn.click();
        assignToMeBtn.click();
    }

    public void reAssign(String name){
        conversBtn.click();
        ExtendedWebElement nameBtn = findExtendedWebElement(By.xpath("//div[@class='text-truncate' and contains(text(), '" + name + "')]"));
        nameBtn.click();

    }

    public String takeName(){
        ExtendedWebElement name = findExtendedWebElement(By.xpath("//div[contains(@class,'user-main-data')]//a"));
        return name.getText();
    }

    public void sayHello(String msg){
        messageField.type(msg);
        submitBtn.click();
    }

    public void checkAssigning(){
        for (int i = assignArray.size() - 1; i > 0 ; i--){
            AssignedUser user = assignArray.get(i);
            AssignedUser prevUser = assignArray.get(i-1);
            if (user.getName().equals("Wilson Monteiro") && user.getCommand().equals("назначил диалог себе")) {
                if (prevUser.getCommand().equals("назначил диалог себе")){
                    reAssign(user.getName());
                } else {
                    return;
                }
            }
        }
    }


}
