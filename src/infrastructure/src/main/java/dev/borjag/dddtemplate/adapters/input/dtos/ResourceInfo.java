package dev.borjag.dddtemplate.adapters.input.dtos;

import dev.borjag.dddtemplate.ports.output.dtos.ResourceCreationInfo;

public class ResourceInfo {

    private String name;
    private String date;

    public ResourceInfo(
            String name,
            String date
    ) {
        this.name = name;
        this.date = date;
    }

    public ResourceCreationInfo toResourceCreationInfo() {
        return new ResourceCreationInfo(
                this.name,
                this.date
        );
    }

}
