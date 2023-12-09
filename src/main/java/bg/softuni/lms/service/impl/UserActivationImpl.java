package bg.softuni.lms.service.impl;

import bg.softuni.lms.model.entity.UserActivationCodeEntity;
import bg.softuni.lms.model.events.UserRegisteredEvent;
import bg.softuni.lms.repository.UserActivationCodeRepository;
import bg.softuni.lms.repository.UserRepository;
import bg.softuni.lms.service.EmailService;
import bg.softuni.lms.service.UserActivation;
import bg.softuni.lms.service.exception.ObjectNotFoundException;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;

@Service
public class UserActivationImpl implements UserActivation {
    private static final String ACTIVATION_CODE_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789";
    private static final int ACTIVATION_CODE_LENGTH = 20;
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final UserActivationCodeRepository userActivationCodeRepository;

    public UserActivationImpl(UserRepository userRepository, EmailService emailService, UserActivationCodeRepository userActivationCodeRepository) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.userActivationCodeRepository = userActivationCodeRepository;
    }

    @Override
    @EventListener(UserRegisteredEvent.class)
    public void userRegistered(UserRegisteredEvent event) {
        String activationCode = createActivationCode(event.getUserEmail());

        emailService.sendRegistrationEmail(
                event.getUserEmail(),
                event.getUserNames(),
                activationCode);
    }

    @Override
    public String createActivationCode(String userEmail) {
        String activationCode = generateActivationCode();

        UserActivationCodeEntity userActivationCode = new UserActivationCodeEntity();
        userActivationCode.setActivationCode(activationCode);
        userActivationCode.setCreated(Instant.now());
        userActivationCode.setUserEntity(userRepository.findByEmail(userEmail).orElseThrow(() -> new ObjectNotFoundException("This user not found")));

        userActivationCodeRepository.save(userActivationCode);

        return activationCode;
    }

    private static String generateActivationCode() {
        StringBuilder activationCode = new StringBuilder();
        Random random = new SecureRandom();

        for (int i = 0; i < ACTIVATION_CODE_LENGTH; i++) {
            int rand = random.nextInt(ACTIVATION_CODE_SYMBOLS.length());
            activationCode.append(ACTIVATION_CODE_SYMBOLS.charAt(rand));
        }

        return activationCode.toString();
    }
}
