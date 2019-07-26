package com.TCPGroup.project.Services;

import com.TCPGroup.project.Models.Message;
import com.TCPGroup.project.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageService {


    private MessageRepository messageRepository;



    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }

    public List<Message> getMessageByChannel(Integer toChannelId){
        List<Message> messageList;
        Comparator<Message> compareById = Comparator.comparing(Message::getId);
        messageList = messageRepository.getMessagesByToChannelId(toChannelId);
        Collections.sort(messageList, compareById.reversed());
        return messageList;
    }

    public Message postMessage(Message message){
        return messageRepository.save(message);
    }



}
