package org.jhalcyon.slacksite;

import com.hubspot.slack.client.SlackClient;
import com.hubspot.slack.client.SlackClientFactory;
import com.hubspot.slack.client.SlackClientRuntimeConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackConfig {

    SlackClientRuntimeConfig runtimeConfig = SlackClientRuntimeConfig.builder()
        .setTokenSupplier(() -> "<xoxb-token-here>")
            .build();

    @Bean
    public SlackClient slackClient() {
        return SlackClientFactory.defaultFactory().build(runtimeConfig);
    }

}
