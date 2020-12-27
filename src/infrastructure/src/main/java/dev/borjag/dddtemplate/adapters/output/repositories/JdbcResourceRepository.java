package dev.borjag.dddtemplate.adapters.output.repositories;

import dev.borjag.dddtemplate.adapters.output.dtos.ResourcePersistenceInfo;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcResourceRepository implements ResourceRepository {

    JdbcTemplate jdbcTemplate;

    public JdbcResourceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(ResourcePersistenceInfo resourcePersistenceInfo) {
        String insertQuery = "INSERT INTO resources_table (resource_id, resource_name, resource_date) " +
                             "VALUES (?,?,?)";
        jdbcTemplate.update(insertQuery,
                resourcePersistenceInfo.getId(),
                resourcePersistenceInfo.getName(),
                resourcePersistenceInfo.getDate()
        );
    }

}
