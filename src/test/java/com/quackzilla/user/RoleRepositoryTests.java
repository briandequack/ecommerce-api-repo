package com.quackzilla.user;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import ecommmerce.user.Role;
import ecommmerce.user.RoleRepository;
import ecommmerce.user.User;
import ecommmerce.user.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)


public class RoleRepositoryTests {
	
	@Autowired private RoleRepository repo;
	
	@Test
	public void testCreateRoles() {
		Role admin = new Role("ROLE_ADMIN");
		Role editor = new Role("ROLE_EDITOR");
		Role customer = new Role("ROLE_CUSTOMER");
		
		repo.saveAll(List.of(admin, editor, customer));
		
		long numberOfRoles = repo.count();
		assertEquals(3, numberOfRoles);
	}

	@Test
	public void testListRoles() {
		List<Role> listRoles = repo.findAll();
		assertThat(listRoles.size()).isGreaterThan(0);
		
		listRoles.forEach(System.out::println);
	}
}
