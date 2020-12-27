package dev.borjag.dddtemplate.configurations;

import dev.borjag.dddtemplate.adapters.output.TemplateResourceCreator;
import dev.borjag.dddtemplate.ports.output.ResourceCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatorConfiguration {

    @Bean
    public ResourceCreator templateResourceCreator() {
        return new TemplateResourceCreator();
    }

}
