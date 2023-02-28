package cz.klecansky.spring;

import cz.klecansky.spring.entity.AppUser;
import cz.klecansky.spring.repository.AppUserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AppUserController {

    AppUserRepository userRepository;

    @GetMapping("/active")
    public List<AppUser> activeUsers() {
        return userRepository.findByActive(true);
    }

    @GetMapping("/admins")
    public List<AppUser> admins() {
        return userRepository.getAppUserByRoles("Admin");
    }
}
