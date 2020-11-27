package com.service;

import com.dao.DaoUserCrud;
import com.dao.DaoUserCrudImpl;
import com.exception.CustomException;
import com.model.User;

public class UserCrudImpl implements UserCrud {

	DaoUserCrud daoUserCrud = new DaoUserCrudImpl();

	@Override
	public User createUser(User user) throws CustomException {
		return daoUserCrud.createUser(user);
	}

	@Override
	public User readUser(String userName) throws CustomException {
		return daoUserCrud.readUser(userName);

	}

	@Override
	public User updateUser(User user1, User user2) throws CustomException {
		return daoUserCrud.updateUser(user1, user2);
	}

	@Override
	public String deleteUser(User user) throws CustomException {
		return daoUserCrud.deleteUser(user);
	}


}
