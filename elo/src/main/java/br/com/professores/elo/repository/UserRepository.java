package br.com.professores.elo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.professores.elo.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	User findByUsername(String username);
}
