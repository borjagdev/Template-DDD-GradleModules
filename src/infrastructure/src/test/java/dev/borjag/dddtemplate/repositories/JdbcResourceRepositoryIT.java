package dev.borjag.dddtemplate.repositories;

import dev.borjag.dddtemplate.adapters.output.dtos.ResourcePersistenceInfo;
import dev.borjag.dddtemplate.adapters.output.repositories.ResourceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DirtiesContext
public class JdbcResourceRepositoryIT {

    @Autowired
    ResourceRepository jdbcResourceRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void persist_a_resource_correctly() {
        String id = "dummyId";
        String name = "dummyName";
        String date = "01/01/2020";
        ResourcePersistenceInfo resourcePersistenceInfo = new ResourcePersistenceInfo(id, name, date);

        jdbcResourceRepository.save(resourcePersistenceInfo);

        assertTrue(resourceIsPersisted());
    }

    private Boolean resourceIsPersisted() {
        String query = "SELECT COUNT(1) " +
                       "FROM resources_table " +
                       "WHERE resource_id = ?";
        return jdbcTemplate.queryForObject(query, Boolean.class, "dummyId");
    }

}
