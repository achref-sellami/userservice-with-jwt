package io.springsecurity.userservice;

import io.springsecurity.userservice.domain.Role;
import io.springsecurity.userservice.domain.User;
import io.springsecurity.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner runner (UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Achref", "achref", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Fabrice", "fabrice", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Mohamed", "mohamed", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Nour", "nour", "1234", new ArrayList<>()));

			userService.addRoleToUser("nour", "ROLE_USER");
			userService.addRoleToUser("fabrice", "ROLE_MANAGER");
			userService.addRoleToUser("mohamed", "ROLE_ADMIN");
			userService.addRoleToUser("achref", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("achref", "ROLE_ADMIN");
			userService.addRoleToUser("achref", "ROLE_USER");
		};
	}

}
