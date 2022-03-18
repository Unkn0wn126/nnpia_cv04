package cz.upce.cv04;

import cz.upce.cv04.entity.Profile;
import cz.upce.cv04.entity.User;
import cz.upce.cv04.repository.ProfileRepository;
import cz.upce.cv04.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProfileRepositoryTests {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUserProfileTest() {
        User user = new User();
        user.setEmail("email@example.com");
        user.setName("admin");
        user.setPassword("1234");

        Profile profile = new Profile();
        profile.setName("Root");
        profile.setDateOfBirth(new Date(1));
        profile.setQuote("I am Root!");
        profile.setUser(user);

        user.setProfile(profile);
        userRepository.save(user);
        profileRepository.save(profile);

        List<Profile> all = profileRepository.findAll();

        Assertions.assertThat(all.size()).isEqualTo(1);
    }

    @Test
    void findUserProfileTest() {
        User user = new User();
        user.setEmail("email@example.com");
        user.setName("admin");
        user.setPassword("1234");

        Profile profile = new Profile();
        profile.setName("Root");
        profile.setDateOfBirth(new Date(1));
        profile.setQuote("I am Root!");
        profile.setUser(user);

        user.setProfile(profile);
        userRepository.save(user);
        profileRepository.save(profile);

        Profile fetched = profileRepository.findProfileByUserId(user.getId());

        Assertions.assertThat(fetched).isEqualTo(profile);
    }

}
