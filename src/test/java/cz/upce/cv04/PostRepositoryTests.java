package cz.upce.cv04;

import cz.upce.cv04.entity.Post;
import cz.upce.cv04.entity.Profile;
import cz.upce.cv04.entity.ProfileHasPosts;
import cz.upce.cv04.repository.PostRepository;
import cz.upce.cv04.repository.ProfileHasPostsRepository;
import cz.upce.cv04.repository.ProfileRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PostRepositoryTests {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ProfileHasPostsRepository profileHasPostsRepository;

    @Test
    void savePostTest() {
        Profile profile = new Profile();
        profile.setName("Root");
        profile.setDateOfBirth(new Date(1));
        profile.setQuote("I am Root!");

        Post post = new Post();
        post.setHeading("Hello world");
        post.setContent("Lorem impsum");

        Post post2 = new Post();
        post2.setHeading("Hello there");
        post2.setContent("Lorem impsum dolor sit amet");

        profileRepository.save(profile);
        postRepository.save(post);
        ProfileHasPosts profileHasPosts = new ProfileHasPosts();
        profileHasPosts.setProfile(profile);
        profileHasPosts.setPost(post);
        profileHasPostsRepository.save(profileHasPosts);

        postRepository.save(post2);
        ProfileHasPosts profileHasPosts2 = new ProfileHasPosts();
        profileHasPosts2.setProfile(profile);
        profileHasPosts2.setPost(post2);
        profileHasPostsRepository.save(profileHasPosts2);

        List<Post> all = postRepository.findAll();

        Assertions.assertThat(all.size()).isEqualTo(2);
    }

    @Test
    void getPostsOfProfileTest() {
        Profile profile = new Profile();
        profile.setName("Root");
        profile.setDateOfBirth(new Date(1));
        profile.setQuote("I am Root!");

        Post post = new Post();
        post.setHeading("Hello world");
        post.setContent("Lorem impsum");

        Post post2 = new Post();
        post2.setHeading("Hello there");
        post2.setContent("Lorem impsum dolor sit amet");

        profileRepository.save(profile);
        postRepository.save(post);
        ProfileHasPosts profileHasPosts = new ProfileHasPosts();
        profileHasPosts.setProfile(profile);
        profileHasPosts.setPost(post);
        profileHasPostsRepository.save(profileHasPosts);

        postRepository.save(post2);
        ProfileHasPosts profileHasPosts2 = new ProfileHasPosts();
        profileHasPosts2.setProfile(profile);
        profileHasPosts2.setPost(post2);
        profileHasPostsRepository.save(profileHasPosts2);

        List<Post> userPosts = postRepository.findPostByProfileId(profile.getId());

        Assertions.assertThat(userPosts.size()).isEqualTo(2);
    }

}
