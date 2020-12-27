package dev.borjag.dddtemplate.adapters.output.repositories;

import dev.borjag.dddtemplate.adapters.output.dtos.ResourcePersistenceInfo;

public interface ResourceRepository {
    void save(ResourcePersistenceInfo resourcePersistenceInfo);
}
