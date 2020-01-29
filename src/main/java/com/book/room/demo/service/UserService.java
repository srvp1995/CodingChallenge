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
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) throws Exception{
        UserDTO userDTO = userDtoFromUser(user);
        Optional<UserDTO> existsUser = userRepository.findByEmail(userDTO.getEmail());
        if(existsUser.isPresent()){
            throw new UserExistsException("User already present with Email ID:"+existsUser.get().getEmail());
        }
        else{
            userDTO = userRepository.save(userDTO);
        }
    }

    public User getUser(Long userId) throws Exception{

        Optional<UserDTO> existsUser = userRepository.findById(userId);
        if(!existsUser.isPresent()){
            throw new UserNotFoundException("No user found with  ID"+ userId);
        }
        User outUser = userFromUserDto(existsUser.get());
        return outUser;
    }

    public UserDTO userDtoFromUser(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setDob(user.getDob());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

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
