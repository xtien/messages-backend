package com.loqli.messages.controller;

import com.loqli.messages.controller.request.AddMessageRequest;
import com.loqli.messages.controller.result.AddMessageResult;
import com.loqli.messages.controller.result.MessagesResult;
import com.loqli.messages.service.MessageService;
import com.loqli.messages.Application;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin(origins = Application.UI_HOST)
public class AddMessageController {

    Logger logger = Logger.getLogger(AddMessageController.class);

    @Autowired
    private MessageService messageService;

    @CrossOrigin(origins = Application.UI_HOST)
    @PostMapping(value = "/addMessage/")
    public ResponseEntity<AddMessageResult> addMessage(@RequestBody AddMessageRequest request) {

        AddMessageResult result = new AddMessageResult();

        try {

            int i = messageService.addMessage(request.getMessage());
            result.setResult(i == 0 ? MessagesResult.OK : MessagesResult.NOT_OK);

        } catch (Exception e) {
            logger.error(e);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
