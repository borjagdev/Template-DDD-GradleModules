package dev.borjag.dddtemplate.dtos;

import dev.borjag.dddtemplate.adapters.output.dtos.ResourcePersistenceInfo;
import dev.borjag.dddtemplate.objects.Resource;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResourcePersistenceInfoShould {

    @Test
    void create_correctly_from_a_given_resource() {
        String id = "dummyId";
        String name = "dummyName";
        String date = "01/01/2020";
        Resource resource = new Resource(id, name, date);

        ResourcePersistenceInfo resourcePersistenceInfo = ResourcePersistenceInfo.from(resource);

        assertThat(resourcePersistenceInfo.getId()).isEqualTo(id);
        assertThat(resourcePersistenceInfo.getName()).isEqualTo(name);
        assertThat(resourcePersistenceInfo.getDate()).isEqualTo(date);

    }

}
