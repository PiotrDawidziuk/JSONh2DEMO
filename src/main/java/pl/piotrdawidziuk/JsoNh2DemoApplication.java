package pl.piotrdawidziuk;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.type.TypeReference;

import pl.piotrdawidziuk.domain.User;
import pl.piotrdawidziuk.service.UserService;

@SpringBootApplication
public class JsoNh2DemoApplication {

		public static void main(String[] args) {
			SpringApplication.run(JsoNh2DemoApplication.class, args);
		}

		@Bean
		CommandLineRunner runner(UserService userService) {
			return args -> {
				// read json and write to db
				ObjectMapper mapper = new ObjectMapper();
				TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
				InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
				try {
					List<User> users = mapper.readValue(inputStream,typeReference);
					userService.save(users);
					System.out.println("Users Saved!");
				} catch (IOException e){
					System.out.println("Unable to save users: " + e.getMessage());
				}
			};
		}
	}