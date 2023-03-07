package cz.klecansky.spring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * spring.jpa.hibernate.ddl-auto=create
 * spring.jpa.hibernate.ddl-auto=create-drop
 * spring.jpa.hibernate.ddl-auto=none
 * spring.jpa.hibernate.ddl-auto=update
 * spring.jpa.hibernate.ddl-auto=validate
 */
@Entity
@Getter
@Setter
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private boolean active;
    private LocalDate creation_date;
    private LocalDate update_date;

    @OneToMany(mappedBy = "appUser")
    @JsonManagedReference
    private Set<Task> items = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "app_user_role",
            joinColumns = {@JoinColumn(name = "app_user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    @JsonManagedReference
    private Set<Role> roles = new HashSet<>();
}
