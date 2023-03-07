package cz.klecansky.spring;

import cz.klecansky.spring.controller.response.AppUserResponse;
import cz.klecansky.spring.entity.AppUser;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class Utils {
    public static AppUserResponse toUserResponse(AppUser user) {
        AppUserResponse appUserResponse = new AppUserResponse();
        BeanUtils.copyProperties(user, appUserResponse);
        return appUserResponse;
    }
}
