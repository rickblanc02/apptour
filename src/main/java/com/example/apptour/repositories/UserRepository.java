package com.example.apptour.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.apptour.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
