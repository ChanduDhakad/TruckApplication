package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.model.User;
import com.masai.repository.TruckDao;
import com.masai.repository.UserDao;

@Service
public class UserServiceImpl implements  UserService{

	@Autowired
	private UserDao uDao;
	
	@Autowired
	private TruckDao tDao;
	
	
	@Override
	public User registerCustomer(User user)   throws UserException{
     Optional<User> isUserExist=uDao.findByEmail(user.getEmail());
     User newUser=null; 

      if(isUserExist.isPresent()) {
    	  throw new UserException("User Is Already Present with  Given Emai "+user.getEmail());
    	  
      }
      else {
    	  
    	  newUser=uDao.save(user);
    	  
      }
      
	return newUser;
	}

	@Override
	public String welcomeMessage() {
		// TODO Auto-generated method stub
		return "Welcome To Our Masai Truck Application";
	}



}
