package cz.klecansky.spring.controller.response;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import cz.klecansky.spring.entity.Role;
import cz.klecansky.spring.entity.Task;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class AppUserResponse {
    private String username;
    private String password;
    private boolean active;
    private LocalDate creation_date;
    private LocalDate update_date;

    @JsonManagedReference
    private Set<Task> items = new HashSet<>();

    @JsonManagedReference
    private Set<Role> roles = new HashSet<>();
}
