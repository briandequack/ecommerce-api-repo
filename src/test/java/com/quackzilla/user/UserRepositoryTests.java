package com.quackzilla.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import ecommmerce.user.Role;
import ecommmerce.user.User;
import ecommmerce.user.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired UserRepository repo;
	
	@Test
	public void testCreateUser() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "Komkommer,1";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		
		User newUser = new User("customer@gmail.com", encodedPassword);
		
		User savedUser = repo.save(newUser);
		
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test 
	public void testAssignRolesToUser() {
		Integer userId = 2;
		
		User user = repo.findById(userId).get();
		user.addRole(new Role(3));
		
		User updatedUser = repo.save(user);
		
		assertThat(updatedUser.getRoles()).hasSize(1);
	}
} 
