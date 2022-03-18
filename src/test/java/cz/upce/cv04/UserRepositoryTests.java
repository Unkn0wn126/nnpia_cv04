package cz.upce.cv04;

import cz.upce.cv04.entity.User;
import cz.upce.cv04.repository.ProfileRepository;
import cz.upce.cv04.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUserTest() {
        User user = new User();
        user.setEmail("email@example.com");
        user.setName("admin");
        user.setPassword("1234");
        userRepository.save(user);

        List<User> all = userRepository.findAll();

        Assertions.assertThat(all.size()).isEqualTo(1);
    }

}
