package cz.upce.cv04.repository;

import cz.upce.cv04.entity.PostHasReactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostHasReactionsRepository extends JpaRepository<PostHasReactions, Long> {
}
