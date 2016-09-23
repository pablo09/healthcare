package com.pzeszko.healthcare.repository;

import com.pzeszko.healthcare.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Pawel on 2016-09-22.
 */
@Repository
public interface UserRepository extends CrudRepositoryWithOptionalWrapper<User, Long> {

    Optional<User> findOneByEmail(String email);
}
