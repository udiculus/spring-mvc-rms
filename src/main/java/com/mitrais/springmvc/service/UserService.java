package com.mitrais.springmvc.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails loadByUsername(String username);
}
