package com.github.unqualsevol.spring;

import com.github.unqualsevol.spring.model.Message;
import com.github.unqualsevol.spring.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by agimenez on 19/09/17.
 */
@RestController
@RequestMapping(value = "/helloworld/pair", produces = "application/json")
public class HelloWorldController {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Message> getPairByName(@RequestParam("name") String name) {
        Message message = messageRepository.findMessageByName(name);
        if(message != null){
            return new ResponseEntity<Message>(message, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Message> storeNewPair(@RequestBody Message message){
        Message newMessage = messageRepository.create(message);
        //System.out.println("date: " + newMessage.getDate());
        return new ResponseEntity<Message>(message, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Message> updateExistingPair(@RequestParam("name") String name, @RequestBody Message message){
        Message newMessage = messageRepository.updateMessageByName(name, message.getValue());
        if(newMessage != null){
            return new ResponseEntity<Message>(newMessage, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePair(@RequestParam("name") String name){
        boolean wasDeleted = messageRepository.delete(name);
        HttpStatus responseStatus = wasDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Void>(responseStatus);
    }
}
