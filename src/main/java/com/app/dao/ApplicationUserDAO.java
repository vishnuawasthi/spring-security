package com.app.dao;

import java.util.List;

import com.app.dto.UserDTO;

public interface ApplicationUserDAO {

	UserDTO getUserByName(String username);

	List<UserDTO> getAll();

	Long saveUser(UserDTO entity);

}
