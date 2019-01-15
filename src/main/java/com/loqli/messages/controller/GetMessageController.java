package com.loqli.messages.controller;

import com.loqli.messages.controller.request.MessageRequest;
import com.loqli.messages.controller.result.MessageResult;
import com.loqli.messages.controller.result.MessagesResult;
import com.loqli.messages.service.MessageService;
import com.loqli.messages.Application;
import com.loqli.messages.model.Message;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class GetMessageController {

    Logger logger = Logger.getLogger(GetMessageController.class);

    @Autowired
    private MessageService messageService;

    @CrossOrigin(origins = {Application.UI_HOST_LOCAL,Application.UI_HOST_REMOTE})
    @PostMapping(value = "/getMessage/")
    public ResponseEntity<MessageResult> getMessage(@RequestBody MessageRequest request) {

        MessageResult result = new MessageResult();

        try {

            Message message = messageService.getMessageById(request.getId());
            result.setMessage(message);
            result.setResult(MessagesResult.OK);

        } catch (Exception e) {
            logger.error(e);
         }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
