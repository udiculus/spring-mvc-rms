package com.mitrais.springmvc.service;

import com.mitrais.springmvc.repository.UserRepository;
import com.mitrais.springmvc.model.User;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findUserByUsername(username);
        UserBuilder userBuilder = null;
        if (user != null) {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);
            Hibernate.initialize(user.getRole());
            userBuilder.password(user.getPassword());
            userBuilder.authorities(user.getRole().getAlias());
        } else {
            throw new UsernameNotFoundException("User not found");
        }

        return userBuilder.build();
    }
}
