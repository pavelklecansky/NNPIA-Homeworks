package cz.klecansky.spring.controller;

import cz.klecansky.spring.controller.request.AppUserRequest;
import cz.klecansky.spring.entity.AppUser;
import cz.klecansky.spring.service.AppUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static cz.klecansky.spring.Utils.toUserResponse;

@RestController
@RequestMapping("/app-user")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AppUserController {

    @NonNull AppUserService userService;

    @GetMapping("/active")
    public List<AppUser> activeUsers() {
        return userService.getActiveUsers();
    }

    @GetMapping("/admins")
    public List<AppUser> admins() {
        return userService.getAdmins();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
        Optional<AppUser> user = userService.findUserById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(toUserResponse(user.get()));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody AppUserRequest user) {
        Optional<AppUser> appUser = userService.updateUser(id, user);
        if (appUser.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(appUser);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Validated @RequestBody AppUserRequest user) {
        try {
            AppUser appUser = userService.saveUser(user);
            return ResponseEntity.ok(appUser);
        } catch (Exception exception) {
            return new ResponseEntity<>("User was not saved.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id) {
        try {
            userService.deleteUserById(id);
            return ResponseEntity.ok("User was successfully deleted");
        } catch (Exception exception) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
