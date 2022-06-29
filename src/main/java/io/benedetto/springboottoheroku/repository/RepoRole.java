package io.benedetto.springboottoheroku.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.benedetto.springboottoheroku.model.ERole;
import io.benedetto.springboottoheroku.model.Role;

@Repository
public interface RepoRole extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}