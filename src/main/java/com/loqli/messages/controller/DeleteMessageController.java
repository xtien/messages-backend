package com.loqli.messages.controller;

import com.loqli.messages.controller.request.DeleteMessageRequest;
import com.loqli.messages.controller.result.DeleteMessageResult;
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
public class DeleteMessageController {

    Logger logger = Logger.getLogger(DeleteMessageController.class);

    @Autowired
    private MessageService messageService;

    @CrossOrigin(origins = {Application.UI_HOST_LOCAL,Application.UI_HOST_REMOTE})
    @PostMapping(value = "/deleteMessage/")
    public ResponseEntity<DeleteMessageResult> addMessage(@RequestBody DeleteMessageRequest request) {

        DeleteMessageResult result = new DeleteMessageResult();

        try {

            int i = messageService.deleteMessage(request.getId());
            result.setResult(i == 0 ? MessagesResult.OK : MessagesResult.NOT_OK);

        } catch (Exception e) {
            logger.error(e);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
