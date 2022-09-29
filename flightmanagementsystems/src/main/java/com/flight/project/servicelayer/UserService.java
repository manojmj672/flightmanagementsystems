package com.flight.project.servicelayer;

import java.util.List;



import com.flight.project.dto.User;
public interface UserService {
    
   User createUser(User nuser);
   List<User>getAllUsers();
   User getUserById(long id);
   User updateUser(User user ,long id);
   void deleteUser(long id);


 


}