package com.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.dto.UserDTO;


@Repository
public class ApplicationUserDAOImpl implements ApplicationUserDAO {

	@Override
	public UserDTO getUserByName(String username) {
		return null;
	}

	@Override
	public List<UserDTO> getAll() {
		return null;
	}

	@Override
	public Long saveUser(UserDTO entity) {
		return null;
	}

}
