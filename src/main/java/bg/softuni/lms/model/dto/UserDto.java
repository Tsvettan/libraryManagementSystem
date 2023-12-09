package bg.softuni.lms.model.dto;

import bg.softuni.lms.validation.FieldMatch;
import bg.softuni.lms.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords should match.")
public record UserDto(@NotEmpty String firstName,
                      @NotEmpty String lastName,
                      @NotNull @Email @UniqueUserEmail String email,
                      String password,
                      String confirmPassword) {

    public String fullName() {
        return firstName + " " + lastName;
    }

}
