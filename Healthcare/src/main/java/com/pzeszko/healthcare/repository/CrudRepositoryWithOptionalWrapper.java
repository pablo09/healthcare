package com.pzeszko.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * Created by Pawel on 2016-09-15.
 */
@NoRepositoryBean
public interface CrudRepositoryWithOptionalWrapper<T, I extends Serializable> extends JpaRepository<T, I> {

    /**
     * Finds Entity of type T in repository
     * @param id Entity's primary key value
     * @return Entity instance
     */
    default Optional<T> optionalFindOne(@Nullable I id){
        return (id == null) ? Optional.empty() : ofNullable(findOne(id));
    }
}

