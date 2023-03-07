package cz.klecansky.spring.service;


import cz.klecansky.spring.controller.request.AppUserRequest;
import cz.klecansky.spring.entity.AppUser;
import cz.klecansky.spring.repository.AppUserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AppUserService {

    @NonNull AppUserRepository userRepository;

    public List<AppUser> getActiveUsers() {
        return userRepository.findByActive(true);
    }

    public List<AppUser> getAdmins() {
        return userRepository.getAppUserByRoles("Admin");
    }

    public Optional<AppUser> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    public AppUser saveUser(AppUserRequest user) {
        AppUser newAppUser = convertAppUserRequestToAppUser(user);
        return userRepository.save(newAppUser);
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    public Optional<AppUser> updateUser(Integer id, AppUserRequest user) {
        return userRepository.findById(id)
                .map(oldUser -> {
                    oldUser.setUsername(user.getUsername());
                    oldUser.setActive(user.isActive());
                    oldUser.setUpdate_date(LocalDate.now());
                    return userRepository.save(oldUser);
                });
    }

    private AppUser convertAppUserRequestToAppUser(AppUserRequest user) {
        AppUser appUser = new AppUser();
        appUser.setUsername(user.getUsername());
        appUser.setPassword(user.getPassword());
        appUser.setActive(user.isActive());
        appUser.setUpdate_date(LocalDate.now());
        appUser.setCreation_date(LocalDate.now());
        return appUser;
    }

}
