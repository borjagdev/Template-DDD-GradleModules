package dev.borjag.dddtemplate.adapters.input.apis;

import dev.borjag.dddtemplate.adapters.input.dtos.ResourceInfo;
import dev.borjag.dddtemplate.ports.output.ResourceCreator;
import dev.borjag.dddtemplate.ports.output.dtos.ResourceCreationInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1")
public class SomeController {

    private final ResourceCreator resourceCreator;

    public SomeController(ResourceCreator templateResourceCreator) {
        resourceCreator = templateResourceCreator;
    }

    @PostMapping(
            value = "/resources",
            produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, String>> createResource(
            @Valid @RequestBody ResourceInfo info
    ) {
        ResourceCreationInfo adaptedInfo = info.toResourceCreationInfo();
        resourceCreator.execute(adaptedInfo);
        return new ResponseEntity<>(formatResponse(adaptedInfo), CREATED);
    }

    private Map<String, String> formatResponse(ResourceCreationInfo info) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("resourceId", info.getId());
        return responseBody;
    }

}
