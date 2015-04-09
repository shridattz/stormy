package com.stormy.dao;

import com.stormy.model.User;

public interface UserDAO {
	User getUserByCredentials(String username,String password) throws SecurityException;
}
