package dev.borjag.dddtemplate.configurations;

import dev.borjag.dddtemplate.adapters.output.TemplateResourcePersister;
import dev.borjag.dddtemplate.adapters.output.TemplateResourceCreator;
import dev.borjag.dddtemplate.adapters.output.repositories.JdbcResourceRepository;
import dev.borjag.dddtemplate.adapters.output.repositories.ResourceRepository;
import dev.borjag.dddtemplate.ports.output.ResourceCreator;
import dev.borjag.dddtemplate.ports.output.ResourcePersister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SpringContextConfiguration {

    @Bean
    public ResourceCreator templateResourceCreator(ResourcePersister templateResourcePersister) {
        return new TemplateResourceCreator(templateResourcePersister);
    }

    @Bean
    public ResourcePersister templateResourcePersister(ResourceRepository jdbcResourceRepository) {
        return new TemplateResourcePersister(jdbcResourceRepository);
    }

    @Bean
    public ResourceRepository jdbcResourceRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcResourceRepository(jdbcTemplate);
    }

}
