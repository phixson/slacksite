package org.jhalcyon.slacksite;

import com.hubspot.algebra.Result;
import com.hubspot.slack.client.SlackClient;
import com.hubspot.slack.client.methods.params.chat.ChatPostMessageParams;
import com.hubspot.slack.client.models.response.SlackError;
import com.hubspot.slack.client.models.response.chat.ChatPostMessageResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final SlackClient slackClient;

    public Controller(SlackClient slackClient) {
        this.slackClient = slackClient;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody Message message) {

        Result<ChatPostMessageResponse, SlackError> result = slackClient.postMessage(
            ChatPostMessageParams.builder()
                .setText(message.getMessage())
                .setChannelId(message.getChannel())
                .build()
        ).join();
        System.out.println(result);
    }


}
