package com.book.room.demo.service;

import com.book.room.demo.dao.UserRepository;
import com.book.room.demo.dto.UserDTO;
import com.book.room.demo.exception.UserExistsException;
import com.book.room.demo.exception.UserNotFoundException;
import com.book.room.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    //Inject Repository to the Service
    @Autowired
    private UserRepository userRepository;

    //Method implementation to add User to Database
    @Override
    public void addUser(User user) {

            UserDTO userDTO = userDtoFromUser(user);
            Optional<UserDTO> existsUser = userRepository.findByEmail(userDTO.getEmail());
            if(existsUser.isPresent()){
                throw new UserExistsException("User already present with Email ID: "+existsUser.get().getEmail());
            }
            else{
                userDTO = userRepository.save(userDTO);
            }
    }

    //Method implementation to retrieve User from Database using the ID
    @Override
    public User getUser(Long userId)  {

            Optional<UserDTO> existsUser = userRepository.findById(userId);
            if(!existsUser.isPresent()){
                throw new UserNotFoundException("No user found with  ID : "+ userId);
            }
            User outUser = userFromUserDto(existsUser.get());
            return outUser;
    }

    //Method to convert User Model to User DTO
    public UserDTO userDtoFromUser(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setDob(user.getDob());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    //Method to convert UserDTO to User Model
    public User userFromUserDto(UserDTO userDTO){
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setDob(userDTO.getDob());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setId(userDTO.getId());
        return user;
    }

}
