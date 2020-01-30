package com.book.room.roombookingmanagement.controller;

import com.book.room.demo.controller.UserController;
import com.book.room.demo.exception.PasswordException;
import com.book.room.demo.model.User;
import com.book.room.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Field;
import java.util.Date;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Before
    public void injectDependecies(){
        try {
            Field field = UserController.class.getDeclaredField("userService");
            field.setAccessible(true);
            field.set(controllerMock, userService);
        } catch (Exception e) {
            fail();
        }
    }

    @Mock
    private UserController controllerMock;

    @Mock
    private UserService userService;

    @Test(expected = PasswordException.class)
    public void addUserTest1(){

        User user = new User(1L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc1234567890");
        when(controllerMock.addUser(user)).thenCallRealMethod();
        controllerMock.addUser(user);
    }

    @Test
    public void addUserTest2(){

        User user = new User(1L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc");
        doNothing().when(userService).addUser(user);
        when(controllerMock.addUser(user)).thenCallRealMethod();
        controllerMock.addUser(user);
    }

    @Test
    public void getUserTest(){
        User user = new User(1L, "Sourabh", "Prakash", new Date(), "email@email.com", "abc");
        when(userService.getUser(1L)).thenReturn(user);
        when(controllerMock.getUser("1")).thenCallRealMethod();
        controllerMock.getUser("1");
    }

}
