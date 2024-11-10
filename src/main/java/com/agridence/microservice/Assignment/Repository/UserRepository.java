package com.agridence.microservice.Assignment.Repository;

import com.agridence.microservice.Assignment.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
