package bg.softuni.lms.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApplicationInit implements CommandLineRunner {

    private final RestTemplate restTemplate;

    public ApplicationInit(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO
    }
}
