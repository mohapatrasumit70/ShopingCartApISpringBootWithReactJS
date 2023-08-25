package org.jsp.shoppingcartapi.repository;

import java.util.Optional;

import org.jsp.shoppingcartapi.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select m from User m where m.token=?1")
	public User findUserByToken(String token);

	@Query("select m from User m where m.email=?1")
	public User findUserByEmail(String email);

	@Query("select u from User u where u.email=?1 and u.password=?2")
	public Optional<User> verifyUser(String email, String password);
}
