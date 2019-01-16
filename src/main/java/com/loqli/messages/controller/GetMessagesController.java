package com.loqli.messages.controller;

import com.loqli.messages.controller.result.MessagesResult;
import com.loqli.messages.service.MessageService;
import com.loqli.messages.Application;
import com.loqli.messages.controller.request.MessagesRequest;
import com.loqli.messages.model.Message;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class GetMessagesController {

    Logger logger = Logger.getLogger(GetMessagesController.class);

    @Autowired
    private MessageService messageService;

    @CrossOrigin(origins = {Application.UI_HOST_LOCAL,Application.UI_HOST_REMOTE})
    @GetMapping(value = "/getMessages/")
    public ResponseEntity<MessagesResult> getMessages() {

        MessagesResult result = new MessagesResult();

        try {

            List<Message> messages = messageService.getMessages();
            result.setMessages(messages);
            result.setResult(MessagesResult.OK);

        } catch (Exception e) {
           logger.error(e);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
