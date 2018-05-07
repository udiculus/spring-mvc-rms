package com.mitrais.springmvc.dao;

import com.mitrais.springmvc.model.User;

public interface UserDao {

    User findUserByUsername(String username);

}
