package com.HaneiIslim.BookClub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.HaneiIslim.BookClub.models.LoginUser;
import com.HaneiIslim.BookClub.models.User;
import com.HaneiIslim.BookClub.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepo) {
        this.userRepository = userRepo;
    }
    
    public User registerUser(User newUser, BindingResult result) {
    	Optional<User> user = userRepository.findByEmail(newUser.getEmail());
    	
    	if (user.isPresent()) {
    		User user2 = new User();
    		ObjectError error = new ObjectError("Invalid Email.", "This email does already exist.");
    		result.addError(error);
    		return user2;
    	
    	} else {
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepository.save(newUser);
    	}
    }
    
    public User getUserByEmail(String email) {
    	Optional<User> user = userRepository.findByEmail(email);
    	if(user.isPresent()) {
            return user.get();
    	} else {
    	    return null;
    	}
    }
    
    public User getUserById(Long id) {
    	Optional<User> user = userRepository.findById(id);
    	if(user.isPresent()) {
            return user.get();
    	} else {
    	    return null;
    	}
    }
    
    public User updateUser(User user) {
    	return userRepository.save(user);
    }
 
    public User loginUser(LoginUser newLoginObject, BindingResult result) {
    	Optional<User> user = userRepository.findByEmail(newLoginObject.getEmail());
        //
        if(user.isPresent()) {
        	User loggedUser = user.get();
            if(BCrypt.checkpw(newLoginObject.getPassword(), loggedUser.getPassword())) {
                
            	result.rejectValue("password", "Matches", "Invalid Password.");;
            	return new User();
            } else {
                return loggedUser;
            }
        } else {
        	ObjectError error = new ObjectError("Invalid Email.", "This email does not exist.");
        	result.addError(error);
        	return new User();
            }
        }
}
