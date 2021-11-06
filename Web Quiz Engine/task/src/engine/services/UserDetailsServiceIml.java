package engine.services;

import engine.model.User;
import engine.model.UserDetailsImpl;
import engine.repos.UserDBRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceIml implements UserDetailsService {
    @Autowired
    //UserRepo userRepo;
    UserDBRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email).get();

        if (user == null) {
            throw new UsernameNotFoundException("Not found: " + email);
        }
        return new UserDetailsImpl(user);
    }



}
