package dev.borjag.dddtemplate.adapters.input.dtos;

import dev.borjag.dddtemplate.ports.output.dtos.ResourceCreationInfo;

import javax.validation.constraints.NotNull;

public class ResourceInfo {

    @NotNull
    private String name;
    @NotNull
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
