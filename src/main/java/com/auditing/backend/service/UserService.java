package com.auditing.backend.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auditing.backend.model.User;
import com.auditing.backend.repositories.UserRepository;

@Service
public class UserService {

	@Resource
	private UserRepository urepo;

	public User save(User user) {
		return urepo.save(user);
	}

	public User getUser(String userName) {
		return urepo.findByUsername(userName);
	}

	public List<User> list() {
		return urepo.findAll();
	}
}
