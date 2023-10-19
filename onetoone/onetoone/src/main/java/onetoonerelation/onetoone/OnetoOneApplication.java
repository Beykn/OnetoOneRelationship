package onetoonerelation.onetoone;

import onetoonerelation.onetoone.entity.Gender;
import onetoonerelation.onetoone.entity.User;
import onetoonerelation.onetoone.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import onetoonerelation.onetoone.repository.UserProfileRepository;
import onetoonerelation.onetoone.repository.UserRepository;

import java.time.LocalDate;

@SpringBootApplication
public class OnetoOneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OnetoOneApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;
	@Override
	public void run(String... args) throws Exception {
		//user object
		User user = new User();
		user.setName("Beyhan");
		user.setEmail("kandemirbeyhan1999@gmail.com");

		UserProfile userProfile = new UserProfile();
		userProfile.setAddress("Ankara");
		userProfile.setBirthOfDate(LocalDate.of(1999,12,15));
		userProfile.setGender(Gender.FEMALE);
		userProfile.setPhoneNumber("01111111111");

		user.setUserProfile(userProfile);
		userProfile.setUser(user);

		userRepository.save(user);

	}
}
