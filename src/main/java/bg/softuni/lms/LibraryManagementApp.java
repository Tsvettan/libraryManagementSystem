package bg.softuni.lms;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@OpenAPIDefinition(
        info = @Info(
                title = "LibraryManagementSystem",
                version = "0.0.1",
                description = "The REST API of LibraryManagementSystem"
        ),
        servers = {
                @Server(
                        url = "http://localhost:9090",
                        description = "Local server"
                )
        }
)
@EnableCaching
@SpringBootApplication
public class LibraryManagementApp {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApp.class, args);
    }
}