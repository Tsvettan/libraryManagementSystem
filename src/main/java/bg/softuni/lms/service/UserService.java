package bg.softuni.lms.service;

import bg.softuni.lms.model.dto.UserRegistrationDto;
import org.springframework.security.core.Authentication;

public interface UserService {

    void registerUser(UserRegistrationDto userRegistrationDto);

    Authentication login(String email);
}
