package cz.upce.cv04.repository;

import cz.upce.cv04.entity.ProfileHasPosts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileHasPostsRepository extends JpaRepository<ProfileHasPosts, Long> {
}
