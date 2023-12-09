package bg.softuni.lms.service;

import bg.softuni.lms.model.events.UserRegisteredEvent;

public interface UserActivation {

    void userRegistered(UserRegisteredEvent event);

    String createActivationCode(String userEmail);
}
