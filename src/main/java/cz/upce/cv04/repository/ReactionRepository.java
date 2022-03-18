package cz.upce.cv04.repository;

import cz.upce.cv04.entity.Post;
import cz.upce.cv04.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {
    Optional<Reaction> findById(Long id);

    @Query("select r from Reaction r join PostHasReactions pr on pr.reaction.id = r.id where pr.post.id = 1")
    List<Reaction> findReactionByPostId(Long id);
}
