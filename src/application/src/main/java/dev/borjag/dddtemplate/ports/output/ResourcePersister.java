package dev.borjag.dddtemplate.ports.output;

import dev.borjag.dddtemplate.objects.Resource;

public interface ResourcePersister {
    void persist(Resource from);
}
