package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.exception.CustomException;
import com.model.User;

public class DaoUserCrudImpl implements DaoUserCrud {

	@Override
	public User createUser(User user) throws CustomException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConnection.Connect();
			String query = "insert into logindetails values(?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			throw new CustomException("User already exists, try a different name");
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}

		return user;
	}

	@Override
	public User readUser(String userName) throws CustomException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		User user = null;
		try {
			connection = DatabaseConnection.Connect();
			String query1 = "select * from logindetails where username=?";
			preparedStatement = connection.prepareStatement(query1);
			preparedStatement.setString(1, userName);
			resultset = preparedStatement.executeQuery();
			user = new User();
			if (resultset.next()) {
				user.setUserName(resultset.getString(1));
				user.setPassword(resultset.getString(2));
			} else {
				throw new CustomException("User doesn't exist");
			}
			resultset.close();
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
		return user;
	}

	@Override
	public User updateUser(User user1, User user2) throws CustomException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConnection.Connect();
			String query = "update logindetails set username=?, password=? where username=? and password=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user2.getUserName());
			preparedStatement.setString(2, user2.getPassword());
			preparedStatement.setString(3, user1.getUserName());
			preparedStatement.setString(4, user1.getPassword());
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			throw new CustomException("Wrong username or password, try again");
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
		return user2;
	}

	@Override
	public String deleteUser(User user) throws CustomException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String result = "";
		try {
			connection = DatabaseConnection.Connect();
			if ((readUser(user.getUserName()) != null)) {
				String query = "delete from logindetails where username=? and password=?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, user.getUserName());
				preparedStatement.setString(2, user.getPassword());
				preparedStatement.execute();
				result = "Deleted";
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			throw new CustomException("Wrong username or password, try again");
		}
		return result;
	}
}
