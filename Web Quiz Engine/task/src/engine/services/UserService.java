package engine.services;

import engine.model.User;
import engine.repos.UserDBRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserDBRepo userRepo;

    public int save(User user) {
        int status = 200;
        if (userRepo.findByEmail(user.getEmail()).isPresent()){
            status = 400;
        } else {
            userRepo.save(user);
        }

        return status;

    }
}
