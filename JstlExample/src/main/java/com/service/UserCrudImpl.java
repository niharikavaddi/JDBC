package com.service;

import java.util.List;

import com.dao.DaoUserCrud;
import com.dao.DaoUserCrudImpl;
import com.exception.CustomException;
import com.model.User;

public class UserCrudImpl implements UserCrud {

	DaoUserCrud daoUserCrud = new DaoUserCrudImpl();

	@Override
	public List<User> readUser() throws CustomException {

		return daoUserCrud.readUser();

	}

}
