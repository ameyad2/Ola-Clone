package com.adprojects.ola_cabs.services;

import com.adprojects.ola_cabs.models.Ride;
import com.adprojects.ola_cabs.models.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService  {
    public User createUser(User user) throws UsernameNotFoundException
            ;

    public User getReqUserProfile(String token) throws UsernameNotFoundException;

    public User findUserById(Integer Id) throws UsernameNotFoundException;

    public User findUserByEmail(String email) throws UsernameNotFoundException;

    public User findUserByToken(String token) throws UsernameNotFoundException;

    public List<Ride> completedRids(Integer userId) throws UsernameNotFoundException;

}
