package cz.upce.cv04.repository;

import cz.upce.cv04.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "userHasProfile")
    Optional<User> findById(Long id);
}
