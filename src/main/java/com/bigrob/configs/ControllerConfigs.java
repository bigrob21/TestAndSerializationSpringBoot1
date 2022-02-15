package com.bigrob.configs;

import com.bigrob.models.ManagedMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({
        @ComponentScan(basePackages = "com.bigrob.controllers")
})
public class ControllerConfigs {

    @Bean
    public ManagedMessage managedMessage() {
        ManagedMessage msg = new ManagedMessage();
        msg.setMessage1("Big Rob");
        msg.setMessage2("BLAH BLAH");
        return msg;
    }

}
