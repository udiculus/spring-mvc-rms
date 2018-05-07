package com.mitrais.springmvc.service;

import com.mitrais.springmvc.dao.UserDao;
import com.mitrais.springmvc.model.User;
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
    private UserDao userDao;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = userDao.findUserByUsername(username);
        UserBuilder userBuilder = null;
        if (user != null) {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);
            userBuilder.password(user.getPassword());
            userBuilder.authorities(String.valueOf(user.getRoleId()));

            System.out.println(String.valueOf(user.getRoleId()));
        } else {
            throw new UsernameNotFoundException("User not found");
        }

        return userBuilder.build();
    }
}
