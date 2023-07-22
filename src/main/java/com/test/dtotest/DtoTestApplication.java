package com.test.dtotest;

import com.test.dtotest.model.Location;
import com.test.dtotest.model.User;
import com.test.dtotest.repository.LocationRepository;
import com.test.dtotest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DtoTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DtoTestApplication.class, args);
		System.out.println("<---Server has started--->");
	}

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception{
		Location location=new Location();
		location.setPlace("Delhi");
		location.setDescription("A state of india");
		location.setLatitude(20.3);
		location.setLongitude(30.4);
		locationRepository.save(location);

		User user1=new User();
		user1.setEmail("user1@gmail.com");
		user1.setName("user1");
		user1.setPassword("user1@123");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2=new User();
		user2.setEmail("user2@gmail.com");
		user2.setName("user2");
		user2.setPassword("user2@123");
		user2.setLocation(location);
		userRepository.save(user2);
	}
}
