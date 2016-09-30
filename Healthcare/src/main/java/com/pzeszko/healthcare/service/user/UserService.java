package com.pzeszko.healthcare.service.user;

import com.pzeszko.healthcare.model.User;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Pawel on 2016-09-22.
 */
public interface UserService {
    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();
}
