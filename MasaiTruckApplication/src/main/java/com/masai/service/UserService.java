package com.masai.service;

import java.util.List;

import com.masai.Exception.TruckException;
import com.masai.Exception.UserException;
import com.masai.model.Truck;
import com.masai.model.User;

public interface UserService {

	public User registerCustomer(User user) throws UserException;

	public String welcomeMessage();
}
