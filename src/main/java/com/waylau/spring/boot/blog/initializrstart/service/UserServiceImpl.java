package com.waylau.spring.boot.blog.initializrstart.service;

import com.waylau.spring.boot.blog.initializrstart.domain.User;
import com.waylau.spring.boot.blog.initializrstart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * User 服务.
 * 
 * @since 1.0.0 2017年3月18日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Transactional
	@Override
	public void removeUser(Long id) {
		userRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void removeUsersInBatch(List<User> users) {
		userRepository.deleteAll(users);
	}
	
	@Transactional
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> listUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public Page<User> listUsersByNameLike(String name, Pageable pageable) {
		// 模糊查询
		name = "%" + name + "%";
		Page<User> users = userRepository.findByNameLike(name, pageable);
		return users;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return (UserDetails) userRepository.findByUsername(username);
	}

}
