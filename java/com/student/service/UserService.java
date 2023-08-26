package com.student.service;

import com.student.entity.User;

public interface UserService {

	User login(String userName, String password);
}
