package bg.softuni.lms.service;

public interface EmailService {
    void sendRegistrationEmail(String userEmail, String userName, String activationCode);
}
