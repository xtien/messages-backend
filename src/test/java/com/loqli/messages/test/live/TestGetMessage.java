package com.loqli.messages.test.live;

import com.loqli.messages.controller.result.MessageResult;
import com.loqli.messages.controller.AddMessageController;
import com.loqli.messages.controller.GetMessageController;
import com.loqli.messages.controller.request.AddMessageRequest;
import com.loqli.messages.controller.request.MessageRequest;
import com.loqli.messages.controller.request.MessagesRequest;
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
public class TestGetMessage {

    @Autowired
    private GetMessageController getMessageController;

    @Autowired
    private AddMessageController addMessageController;

    @Test
    public void testGetMessage() {

        AddMessageRequest addMessageRequest1 = new AddMessageRequest();
        addMessageRequest1.setMessage(new Message(1, "test bericht 1"));
         Assert.assertEquals(HttpStatus.OK, addMessageController.addMessage(addMessageRequest1).getStatusCode());
        AddMessageRequest addMessageRequest2 = new AddMessageRequest();
        addMessageRequest2.setMessage(new Message(2, "test bericht 2"));
        Assert.assertEquals(HttpStatus.OK, addMessageController.addMessage(addMessageRequest2).getStatusCode());

        MessagesRequest request = new MessagesRequest();
        ResponseEntity<MessageResult> response = getMessageController.getMessage(new MessageRequest(2));
        MessageResult result = response.getBody();

        Assert.assertNotNull(result);
    }
}
