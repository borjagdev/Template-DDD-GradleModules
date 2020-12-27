package dev.borjag.dddtemplate.ports.output;

import dev.borjag.dddtemplate.ports.output.dtos.ResourceCreationInfo;

public interface ResourceCreator {
    void execute(ResourceCreationInfo info);
}
