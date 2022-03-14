package cz.upce.cv04.repository;

import cz.upce.cv04.entity.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @EntityGraph(attributePaths = "profileHasPosts")
    Optional<Profile> findById(Long id);
}
