package com.loqli.messages.test.live;

import com.loqli.messages.controller.result.AddMessageResult;
import com.loqli.messages.controller.AddMessageController;
import com.loqli.messages.controller.GetMessagesController;
import com.loqli.messages.controller.request.AddMessageRequest;
import com.loqli.messages.controller.request.MessagesRequest;
import com.loqli.messages.controller.result.MessagesResult;
import com.loqli.messages.model.Message;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class TestGetMessages {

    @Autowired
    private GetMessagesController getMessagesController;

    @Autowired
    private AddMessageController addMessageController;


    @Test
    public void testGetMessages() {

        AddMessageRequest addMessageRequest = new AddMessageRequest();
        addMessageRequest.setMessage(new Message(1, "test bericht"));
        ResponseEntity<AddMessageResult> addMessageResult = addMessageController.addMessage(addMessageRequest);
        Assert.assertEquals(HttpStatus.OK, addMessageResult.getStatusCode());

        MessagesRequest request = new MessagesRequest();
        ResponseEntity<MessagesResult> response = getMessagesController.getMessages(request);
        MessagesResult result = response.getBody();

        Assert.assertNotNull(result);
    }
}
