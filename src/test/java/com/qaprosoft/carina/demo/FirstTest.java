/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.carrot.*;
import org.testng.annotations.Test;
import com.qaprosoft.carina.core.foundation.IAbstractTest;


public class FirstTest implements IAbstractTest {

    @Test()
    public void testModelSpecs() {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.makeLogin();

        MainPage mainPage = new MainPage(getDriver());
        mainPage.chooseNotAssigned();
        pause(3);

        String[] depList = R.TESTDATA.get("dep").split(", ");
        String[] withdList = R.TESTDATA.get("withd").split(", ");
        String[] helloList = R.TESTDATA.get("hi").split(", ");

        String helloMsg = R.TESTDATA.get("hello");
        String depMsg = R.TESTDATA.get("deposit");
        String withdrawalMsg = R.TESTDATA.get("withdrawal");

        String fail = R.TESTDATA.get("failes");

        ChatWindow chatWindow = new ChatWindow(getDriver());


        while(true){
            if (mainPage.getNotAssignedChats().size() != 0) {
                List<ChatPreview> chatList = mainPage.getNotAssignedChats();
                System.out.println("-------------------\n" + chatList.size() + "\n-------------------");
                int index = 0;
                for (ChatPreview chatPreview : chatList) {
                //---------------------------_FAILES--------------------------
//                    for (String question : depList) {
//                        if (chatPreview.getPreviewText().contains(question)) {
//                            System.out.println("-------------------\n" + chatPreview.getPreviewText() + " <====> "
//                                    + question + "\n-------------------");
//                            chatPreview.openChat();
//                            chatWindow.assignToMe();
//                            chatWindow.sayHello(fail);
//                            index = 1;
//                            break;
//                        }
//                    }
//                    if (index == 1) {
//                        break;
//                    }
                    //-----------------------------------------------------------


                    for (String question : withdList) {
                        if (chatPreview.getPreviewText().contains(question)) {
                            System.out.println("-------------------\n" + chatPreview.getPreviewText() + " <====> "
                                    + question + "\n-------------------");
                            chatPreview.openChat();
                            chatWindow.assignToMe();
                            chatWindow.sayHello(withdrawalMsg);
                            index = 1;
                            break;
                        }
                    }
                    if (index == 1) {
                        break;
                    }
                    for (String question : helloList) {
                        if (chatPreview.getPreviewText().contains(question)) {
                            System.out.println("-------------------\n" + chatPreview.getPreviewText() + " <====> "
                                    + question + "\n-------------------");
                            chatPreview.openChat();
                            chatWindow.assignToMe();
                            chatWindow.sayHello(helloMsg);
                            index = 1;
                            break;
                        }
                    }
                    if (index == 1) {
                        break;
                    }
                    for (String question : depList) {
                        if (chatPreview.getPreviewText().contains(question)) {
                            System.out.println("-------------------\n" + chatPreview.getPreviewText() + " <====> "
                                    + question + "\n-------------------");
                            chatPreview.openChat();
                            chatWindow.assignToMe();
                            chatWindow.sayHello(depMsg);
                            index = 1;
                            break;
                        }
                    }
                    if (index == 1) {
                        break;
                    }

                }
                mainPage.refreshChats();
            }
            pause(2);
            mainPage.refreshChats();
        }

    }

}
