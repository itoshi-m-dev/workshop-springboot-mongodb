package com.emanuel.workshopmongo.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuel.workshopmongo.domain.User;
import com.emanuel.workshopmongo.dto.UserDTO;
import com.emanuel.workshopmongo.repositories.UserRepository;
import com.emanuel.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();

	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException(id));
		
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(String id, User obj) {
		User entity = repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(id));
		update(entity, obj);
		return repository.save(entity);
	}
	
	
	private void update(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	
}
