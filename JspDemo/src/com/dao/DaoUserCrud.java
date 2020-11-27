package com.dao;

import com.exception.CustomException;
import com.model.User;

public interface DaoUserCrud {
	User createUser(User user) throws CustomException;

	User readUser(String userName) throws CustomException;

	User updateUser(User user1, User user2) throws CustomException;

	String deleteUser(User user) throws CustomException;
}
