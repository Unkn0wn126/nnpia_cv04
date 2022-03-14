package cz.upce.cv04.repository;

import cz.upce.cv04.entity.UserHasProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHasProfileRepository extends JpaRepository<UserHasProfile, Long> {
}
