package engine.repos;

import engine.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserDBRepo extends CrudRepository<User, Long> {

     Optional<User> findByEmail(String email);
}
