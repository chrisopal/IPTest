package com.demo.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

    // Mocking objects
    @InjectMocks
    LoginController loginController;

    @Mock
    LoginService loginService;

    @Test
    void test_login_ok() {

        // Test data
        UserForm userForm = new UserForm("foo", "bar");

        // Setting expectations (stubbing methods)
        when(loginService.login(userForm)).thenReturn(true);

        // Exercise SUT
        String responseLogin = loginController.login(userForm);

        // Verification
        assertEquals("OK", responseLogin);
        verify(loginService).login(userForm);
        verifyNoMoreInteractions(loginService);
    }

    @Test
    void test_login_ko() {

        // Test data
        UserForm userForm = new UserForm("ko", "ok");
        // Setting expectations (stubbing methods)
        when(loginService.login(userForm)).thenReturn(false);

        // Exercise SUT
        String responseLogin = loginController.login(userForm);

        // Verification
        assertEquals("KO", responseLogin);
        verify(loginService).login(userForm);
        verifyZeroInteractions(loginService);
    }

    @Test
    void testLoginException() {

        // Test data
        UserForm userForm = new UserForm("foo", "bar");

        // Expectation
        when(loginService.login(any(UserForm.class)))
                .thenThrow(IllegalArgumentException.class);

        // Exercise
        String response = loginController.login(userForm);

        // Verify
        assertEquals("ERROR", response);
    }
}
