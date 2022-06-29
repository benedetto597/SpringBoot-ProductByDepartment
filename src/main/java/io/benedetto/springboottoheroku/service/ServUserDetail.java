package io.benedetto.springboottoheroku.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.benedetto.springboottoheroku.model.User;
import io.benedetto.springboottoheroku.repository.RepoUser;
import io.benedetto.springboottoheroku.security.UserDetailImpl;
@Service
public class ServUserDetail implements UserDetailsService {
  @Autowired
  RepoUser userRepository;
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    return UserDetailImpl.build(user);
  }
}