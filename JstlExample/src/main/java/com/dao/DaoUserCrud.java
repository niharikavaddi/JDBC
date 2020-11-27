package com.dao;

import java.util.List;

import com.exception.CustomException;
import com.model.User;

public interface DaoUserCrud {

	List<User> readUser() throws CustomException;
}
