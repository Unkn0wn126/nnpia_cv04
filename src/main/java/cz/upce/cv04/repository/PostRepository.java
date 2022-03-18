package cz.upce.cv04.repository;

import cz.upce.cv04.entity.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    @EntityGraph(attributePaths = "postHasReactions")
    Optional<Post> findById(Long id);

    @Query("select p from Post p where p.id between 1 and 2")
    List<Post> findPostByIdBetween(Long start, Long finish);

    // "select p from Post p where p.id = (select pr.post.id from ProfileHasPosts pr where pr.profile.id = 1)"
    @Query("select p from Post p join ProfileHasPosts pr on pr.post.id = p.id where pr.profile.id = 1")
    List<Post> findPostByProfileId(Long id);
}
