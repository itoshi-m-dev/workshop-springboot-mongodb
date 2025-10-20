package com.emanuel.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.emanuel.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	

}
