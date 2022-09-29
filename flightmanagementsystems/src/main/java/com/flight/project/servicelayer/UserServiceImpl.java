package com.flight.project.servicelayer;

import java.util.List;


import org.springframework.stereotype.Service;

import com.flight.project.dao.UserDaoImpl;
import com.flight.project.dto.User;
import com.flight.project.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

   private UserDaoImpl userDao;
     public UserServiceImpl(UserDaoImpl userDao) {
        super();
        this.userDao = userDao;
    }
	@Override
	public User createUser(User nuser) {
		// TODO Auto-generated method stub
		return userDao.save(nuser);
	}
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("User","ID",id));
	}
	@Override
	public User updateUser(User user,long id) {
		        
		        User existingUser = userDao.findById(id).orElseThrow(()->
		        new ResourceNotFoundException("User","Id",id));
		        
		        existingUser.setUserType(user.getUserType());
		       // existingUser.setUserId(user.getUserId());
		        existingUser.setUserName(user.getUserName());
		        existingUser.setUserPassword(user.getUserPassword());
		        existingUser.setUserPhone(user.getUserPhone());
		        existingUser.setUserEmail(user.getUserEmail());
		        userDao.save(existingUser);
		        return existingUser;
	}
	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		userDao.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("User","ID",id));
		userDao.deleteById(id);
		
		
	}
	
	
}