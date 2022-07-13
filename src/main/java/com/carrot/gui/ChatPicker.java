package com.carrot.gui;

import java.util.List;

public class ChatPicker{

    public ChatPicker(){
    }

    public static void takeChat(List<ChatPreview> chatList){
        for (ChatPreview chat: chatList) {
//            if (!chat.getPreviewText().contains("How to play")) {
//                System.out.println("nope");
//            }
            System.out.println(chat.getPreviewText());
            chat.openChat();
        }
    }
}
