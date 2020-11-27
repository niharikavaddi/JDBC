package com.service;

import java.util.List;

import com.exception.CustomException;
import com.model.User;

public interface UserCrud {
	List<User> readUser() throws CustomException;
}
