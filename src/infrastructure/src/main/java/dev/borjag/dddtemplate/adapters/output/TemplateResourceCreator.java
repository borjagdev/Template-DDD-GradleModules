package dev.borjag.dddtemplate.adapters.output;

import dev.borjag.dddtemplate.ports.output.ResourceCreator;
import dev.borjag.dddtemplate.ports.output.ResourcePersister;
import dev.borjag.dddtemplate.ports.output.dtos.ResourceCreationInfo;

public class TemplateResourceCreator implements ResourceCreator {

    private final ResourcePersister resourcePersister;

    public TemplateResourceCreator(ResourcePersister templateResourcePersister) {
        resourcePersister = templateResourcePersister;
    }

    @Override
    public void execute(ResourceCreationInfo info) {
        resourcePersister.persist(info.toResource());
    }
}
