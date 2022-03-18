package cz.upce.cv04;

import cz.upce.cv04.entity.Post;
import cz.upce.cv04.entity.PostHasReactions;
import cz.upce.cv04.entity.Reaction;
import cz.upce.cv04.entity.ReactionType;
import cz.upce.cv04.repository.PostHasReactionsRepository;
import cz.upce.cv04.repository.PostRepository;
import cz.upce.cv04.repository.ReactionRepository;
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
class ReactionRepositoryTests {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ReactionRepository reactionRepository;

    @Autowired
    PostHasReactionsRepository postHasReactionsRepository;

    @Test
    void saveReactionTest() {
        Post post = new Post();
        post.setHeading("Hello world");
        post.setContent("Lorem impsum");

        Reaction reaction = new Reaction();
        reaction.setReactionType(ReactionType.THUMBS_UP);

        postRepository.save(post);
        reactionRepository.save(reaction);
        PostHasReactions postHasReactions = new PostHasReactions();
        postHasReactions.setPost(post);
        postHasReactions.setReaction(reaction);
        postHasReactionsRepository.save(postHasReactions);

        List<Reaction> userPosts = reactionRepository.findReactionByPostId(post.getId());

        Assertions.assertThat(userPosts.size()).isEqualTo(1);
    }

}
