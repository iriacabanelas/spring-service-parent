package com.github.unqualsevol.spring.repository;

import com.github.unqualsevol.spring.model.Message;
import org.springframework.stereotype.Repository;
import sun.misc.resources.Messages_es;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class MessageRepository {

    private List<Message> messageList = Collections.synchronizedList(new ArrayList<Message>());

    public Message create(Message message){
        //Message newMessage = new Message(message.getName(), message.getValue(), LocalDate.now());
        Message newMessage = new Message(message.getName(), message.getValue());
        //System.out.println("date: " + newMessage.getDate());
        messageList.add(newMessage);
        return newMessage;
    }

    public boolean delete(String name){
        for (Message message : messageList){
            if(message.getName().equals(name)){
                messageList.remove(message);
                return true;
            }
        }
        return false;
    }

    public Message findMessageByName(String name){
        for (Message message : messageList){
            if(message.getName().equals(name)){
                return message;
            }
        }
        return null;
    }

    public Message updateMessageByName(String name, String newValue){
        for (Message message : messageList){
            if(message.getName().equals(name)){
                //Message updatedMessage = new Message(name, newValue,message.getDate());
                Message updatedMessage = new Message(name, newValue);
                messageList.set(messageList.indexOf(message), updatedMessage);
                return updatedMessage;
            }
        }
        return null;
    }
}
