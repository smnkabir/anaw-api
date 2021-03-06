package com.vectorit.anaw.repository;

import com.vectorit.anaw.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUserName(String userName);
    User deleteByUserName(String userName);
}
