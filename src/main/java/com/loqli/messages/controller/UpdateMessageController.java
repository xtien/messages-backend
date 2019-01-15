package com.loqli.messages.controller;

import com.loqli.messages.Application;
import com.loqli.messages.controller.request.UpdateMessageRequest;
import com.loqli.messages.controller.result.MessageResult;
import com.loqli.messages.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * User: christine
 * Date: 12/29/18 12:41 PM
 */
@Controller
@CrossOrigin(origins = Application.UI_HOST)
public class UpdateMessageController {

    Logger logger = Logger.getLogger(UpdateMessageController.class);

    @Autowired
    private MessageService messageService;

    @CrossOrigin(origins = Application.UI_HOST)
    @PostMapping(value = "/updateMessage/")
    public ResponseEntity<MessageResult> updateMessage(@RequestBody UpdateMessageRequest request) {

        MessageResult result = new MessageResult();
        result.setResult(MessageResult.NOT_OK);

        try {
            messageService.updateMessage(request.getMessage());

        } catch (Exception e) {
           logger.error(e);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
