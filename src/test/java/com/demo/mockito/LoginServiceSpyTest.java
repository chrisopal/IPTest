package com.demo.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class LoginServiceSpyTest {

    @InjectMocks
    LoginService loginService;

    @Spy
    LoginRepository loginRepository;

    @Test
    void test_login_ok() {
        UserForm userOk = new UserForm("user1", "p1");

        assertTrue(loginService.login(userOk));
    }

    @Test
    void test_login_ko() {
        UserForm userKo = new UserForm("foo", "bar");
        assertFalse(loginService.login(userKo));
    }

}
