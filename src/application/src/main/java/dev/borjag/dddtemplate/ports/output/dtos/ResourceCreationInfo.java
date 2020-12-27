package dev.borjag.dddtemplate.ports.output.dtos;

import dev.borjag.dddtemplate.objects.Resource;

public class ResourceCreationInfo {

    private String id;
    private String name;
    private String date;

    public ResourceCreationInfo(
            String name,
            String date
    ) {
        this.id = "dummyId";
        this.name = name;
        this.date = date;
    }

    public String getId() {
        return this.id;
    }

    public Resource toResource() {
        return new Resource(
          this.id,
          this.name,
          this.date
        );
    }

}
