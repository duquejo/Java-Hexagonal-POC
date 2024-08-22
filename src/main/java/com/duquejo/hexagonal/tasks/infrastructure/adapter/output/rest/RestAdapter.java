package com.duquejo.hexagonal.tasks.infrastructure.adapter.output.rest;

import com.duquejo.hexagonal.tasks.domain.model.AdditionalTaskInfo;
import com.duquejo.hexagonal.tasks.domain.port.output.ExternalRestPort;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestAdapter implements ExternalRestPort {

    private final RestTemplate restTemplate;

    public RestAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;

        ResponseEntity<JsonPlaceholderTodo> response = restTemplate.getForEntity(apiUrl, JsonPlaceholderTodo.class);
        JsonPlaceholderTodo todo = response.getBody();

        if( todo == null ) {
            return null;
        }

        apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceholderUser> userResponse = restTemplate.getForEntity(apiUrl, JsonPlaceholderUser.class);
        JsonPlaceholderUser user = userResponse.getBody();

        if( user == null ) {
            return null;
        }

        return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());
    }

    @Getter
    @Setter
    private static class JsonPlaceholderTodo {
        private Long id;
        private Long userId;
    }

    @Getter
    @Setter
    private static class JsonPlaceholderUser {
        private Long id;
        private String name;
        private String email;
    }
}
