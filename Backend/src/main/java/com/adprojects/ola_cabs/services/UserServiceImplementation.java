package com.adprojects.ola_cabs.services;

import com.adprojects.ola_cabs.security.JwtUtil;
import com.adprojects.ola_cabs.models.Ride;
import com.adprojects.ola_cabs.models.User;
import com.adprojects.ola_cabs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public User createUser(User user) throws UsernameNotFoundException {

        User emailExist = findUserByEmail(user.getEmail());

        if(emailExist!=null)throw new UsernameNotFoundException("Email Already Used With Another Account");



        return userRepository.save(user);

    }

    @Override
    public User findUserById(Integer userId) throws UsernameNotFoundException {

        Optional<User> opt=userRepository.findById(userId);

        if(opt.isPresent()) {
            return opt.get();
        }
        throw new UsernameNotFoundException("user not found with id "+userId);
    }

    @Override
    public User findUserByEmail(String email) throws UsernameNotFoundException {

        User user=userRepository.findByEmail(email);

        if(user!=null) {
            return user;
        }
        throw new UsernameNotFoundException("user not found with email "+email);
    }

    @Override
    public User getReqUserProfile(String token) throws UsernameNotFoundException {

        String email = jwtUtil.getEmailFromToken(token);
        User user = userRepository.findByEmail(email);

        if(user!=null) {
            return user;
        }

        throw new UsernameNotFoundException("invalid token...");

    }

    @Override
    public User findUserByToken(String token) throws UsernameNotFoundException {
        String email=jwtUtil.getEmailFromToken(token);
        if(email==null) {
            throw new BadCredentialsException("invalid token recived");
        }
        User user=userRepository.findByEmail(email);

        if(user!=null) {
            return user;
        }
        throw new UsernameNotFoundException("user not found with email "+email);
    }

    @Override
    public List<Ride> completedRids(Integer userId) throws UsernameNotFoundException {
        List <Ride> completedRides=userRepository.getCompletedRides(userId);
        return completedRides;
    }

}
