package bg.softuni.lms.service;

import bg.softuni.lms.model.dto.ReCaptchaResponseDto;

import java.util.Optional;

public interface ReCaptchaService {
    Optional<ReCaptchaResponseDto> verify(String token);
}
