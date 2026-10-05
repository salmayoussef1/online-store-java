package services;

import entites.User;

public interface UserManagementService {

    String registerUser(User user);

    User[] getUsers();

    User getUserByEmail(String userEmail);

}
