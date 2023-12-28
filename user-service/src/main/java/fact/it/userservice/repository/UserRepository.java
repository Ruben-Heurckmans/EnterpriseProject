package fact.it.userservice.repository;

import jakarta.transaction.Transactional;
import fact.it.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserCodeIn(Collection<String> userCode);
}
