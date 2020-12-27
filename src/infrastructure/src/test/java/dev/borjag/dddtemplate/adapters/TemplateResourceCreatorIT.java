package dev.borjag.dddtemplate.adapters;

import dev.borjag.dddtemplate.ports.output.ResourceCreator;
import dev.borjag.dddtemplate.ports.output.dtos.ResourceCreationInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DirtiesContext
public class TemplateResourceCreatorIT {

    @Autowired
    ResourceCreator resourceCreator;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void create_a_resource_successfully() {
        String name = "dummyName";
        String date = "01/01/2020";
        ResourceCreationInfo resourceCreationInfo = new ResourceCreationInfo(name, date);

        resourceCreator.execute(resourceCreationInfo);

        assertTrue(resourceIsPersisted());
    }

    private Boolean resourceIsPersisted() {
        String query = "SELECT COUNT(1) " +
                "FROM resources_table " +
                "WHERE resource_id = ?";
        return jdbcTemplate.queryForObject(query, Boolean.class, "dummyId");
    }

}
