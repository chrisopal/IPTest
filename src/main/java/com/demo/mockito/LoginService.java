package com.demo.mockito;


import java.util.ArrayList;
import java.util.List;

public class LoginService {


    public LoginService(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }

    private LoginRepository loginRepository;
    private List<String> usersLogged = new ArrayList<>();

    public boolean login(UserForm userForm) {
        System.out.println("LoginService.login " + userForm);

        // Preconditions
        checkForm(userForm);

        // Same user cannot be logged twice
        String username = userForm.getUsername();
        if (usersLogged.contains(username)) {
            throw new LoginException(username + " already logged");
        }

        // Call to repository to make logic
        boolean login = loginRepository.login(userForm);

        if (login) {
            usersLogged.add(username);
        }

        return login;
    }

    public void logout(UserForm userForm) {
        System.out.println("LoginService.logout " + userForm);

        // Preconditions
        checkForm(userForm);

        // User should be logged beforehand
        String username = userForm.getUsername();
        if (!usersLogged.contains(username)) {
            throw new LoginException(username + " not logged");
        }

        usersLogged.remove(username);
    }

    public int getUserLoggedCount() {
        return usersLogged.size();
    }

    private void checkForm(UserForm userForm) {
        assert userForm != null;
        assert userForm.getUsername() != null;
        assert userForm.getPassword() != null;
    }
}
