package dev.borjag.dddtemplate.adapters.output;

import dev.borjag.dddtemplate.adapters.output.dtos.ResourcePersistenceInfo;
import dev.borjag.dddtemplate.adapters.output.repositories.ResourceRepository;
import dev.borjag.dddtemplate.objects.Resource;
import dev.borjag.dddtemplate.ports.output.ResourcePersister;

public class TemplateResourcePersister implements ResourcePersister {

    private ResourceRepository resourceRepository;

    public TemplateResourcePersister(ResourceRepository jdbcResourceRepository) {
        this.resourceRepository = jdbcResourceRepository;
    }

    @Override
    public void persist(Resource resource) {
        resourceRepository.save(ResourcePersistenceInfo.from(resource));
    }

}
