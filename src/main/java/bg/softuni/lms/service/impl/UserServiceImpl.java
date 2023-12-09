package bg.softuni.lms.service.impl;

import bg.softuni.lms.model.dto.UserRegistrationDto;
import bg.softuni.lms.model.entity.UserEntity;
import bg.softuni.lms.model.events.UserRegisteredEvent;
import bg.softuni.lms.repository.UserRepository;
import bg.softuni.lms.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final LibraryUserDetailsService libraryUserDetailsService;

    public UserServiceImpl(LibraryUserDetailsService libraryUserDetailsService, UserRepository userRepository, PasswordEncoder passwordEncoder, ApplicationEventPublisher applicationEventPublisher) {
        this.libraryUserDetailsService = libraryUserDetailsService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void registerUser(UserRegistrationDto userRegistrationDto) {

        userRepository.save(map(userRegistrationDto));

        applicationEventPublisher.publishEvent(new UserRegisteredEvent(
                "UserService",
                userRegistrationDto.email(),
                userRegistrationDto.fullName()
        ));
    }

    private UserEntity map(UserRegistrationDto userRegistrationDto) {
        return new UserEntity()
                .setActive(false)
                .setUsername(userRegistrationDto.fullName())
                .setEmail(userRegistrationDto.email())
                .setPassword(passwordEncoder.encode(userRegistrationDto.password()));
    }

    @Override
    public Authentication login(String username) {
        UserDetails userDetails = libraryUserDetailsService.loadUserByUsername(username);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return authentication;
    }
}
