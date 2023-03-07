package cz.klecansky.spring.controller.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class AppUserRequest {
    @NotBlank
    @Size(max = 255)
    private String username;
    private String password;
    private boolean active;
    private LocalDate creation_date;
    private LocalDate update_date;
}
