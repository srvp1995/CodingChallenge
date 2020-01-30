package com.book.room.roombookingmanagement.service;

import com.book.room.demo.dao.UserRepository;
import com.book.room.demo.dto.UserDTO;
import com.book.room.demo.exception.UserExistsException;
import com.book.room.demo.exception.UserNotFoundException;
import com.book.room.demo.model.User;
import com.book.room.demo.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Before
    public void injectDependecies(){
        try {
            Field field = UserServiceImpl.class.getDeclaredField("userRepository");
            field.setAccessible(true);
            field.set(userServiceImpl, userRepository);
        } catch (Exception e) {
            fail();
        }
    }

    @Mock
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepository;

    @Test
    public void addUserTest1(){
        User user = new User(1L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc");
        UserDTO userDTO = new UserDTO(1L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc");
        when(userServiceImpl.userDtoFromUser(user)).thenReturn(userDTO);
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        doCallRealMethod().when(userServiceImpl).addUser(user);
        userServiceImpl.addUser(user);
    }

    @Test(expected = UserExistsException.class)
    public void addUserTest2(){
        User user = new User(1L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc");
        UserDTO userDTO = new UserDTO(1L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc");
        when(userServiceImpl.userDtoFromUser(user)).thenReturn(userDTO);
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(new UserDTO()));
        doCallRealMethod().when(userServiceImpl).addUser(user);
        userServiceImpl.addUser(user);
    }

    @Test(expected = UserNotFoundException.class)
    public void getUserTest1(){
        User user = new User(1L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc");
        when(userRepository.findById(user.getId())).thenReturn(Optional.empty());
        when(userServiceImpl.getUser(1L)).thenCallRealMethod();
        userServiceImpl.getUser(1L);
    }

    @Test
    public void getUserTest2(){
        UserDTO userDTO = new UserDTO(1L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc");
        User user = new User(1L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc");
        when(userRepository.findById(userDTO.getId())).thenReturn(Optional.of(userDTO));
        when(userServiceImpl.userFromUserDto(userDTO)).thenReturn(user);
        when(userServiceImpl.getUser(1L)).thenCallRealMethod();
        userServiceImpl.getUser(1L);
    }

    @Test
    public void userDtoFromUser(){
        UserDTO userDTO = new UserDTO(0L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc");
        User user = new User(0L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc");
        when(userServiceImpl.userDtoFromUser(user)).thenCallRealMethod();
        userServiceImpl.userDtoFromUser(user);
    }

    @Test
    public void userFromUserDto(){
        UserDTO userDTO = new UserDTO(1L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc");
        User user = new User(1L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc");
        when(userServiceImpl.userFromUserDto(userDTO)).thenCallRealMethod();
        userServiceImpl.userFromUserDto(userDTO);
    }
}
