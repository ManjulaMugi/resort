package com.lara.resort.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lara.resort.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
