package com.rekish.backendspanishfool.controller;

import com.rekish.backendspanishfool.model.todelete.Greeting;
import com.rekish.backendspanishfool.model.todelete.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Greeting greeting(Message message) throws InterruptedException {
        Thread.sleep(1000);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
