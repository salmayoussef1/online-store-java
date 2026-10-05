package services;

import entites.DefaultUser;
import entites.User;

import java.util.Arrays;

public class DefaultUserManagementService implements UserManagementService {

    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
    private static final String NO_ERROR_MESSAGE = "";

    private static final int DEFAULT_USERS_CAPACITY = 10;

    private static DefaultUserManagementService instance;

    private User[] users = new User[DEFAULT_USERS_CAPACITY];
    private int userCount = 0;

    private DefaultUserManagementService() {
    }

    @Override
    public String registerUser(User user) {
        if(user == null){
            return EMPTY_EMAIL_ERROR_MESSAGE;
        }
        if(user.getEmail() == null || user.getEmail().trim().isEmpty()){
            return EMPTY_EMAIL_ERROR_MESSAGE;
        }
        if(getUserByEmail(user.getEmail()) != null){
            return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
        }
        if (userCount >= users.length) {
            users = Arrays.copyOf(users,users.length* 2);
        }
        users[userCount++] = user;
        return NO_ERROR_MESSAGE;
    }

    public static UserManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultUserManagementService();
        }
        return instance;
    }


    @Override
    public User[] getUsers() {
        int nonNullUserCount = 0;
        for (User user : users) {
            if (user != null) {
                nonNullUserCount++;
            }
        }
        User[] result = new User[nonNullUserCount];
        int index = 0;
        for (User user : users) {
            if (user != null) {
                result[index++] = user;
            }
        }
        return result;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        if (userEmail == null) {
            return null;
        }
        for (User u : users) {
            if (u != null && userEmail.equalsIgnoreCase(u.getEmail())) {
                return u;
            }
        }
        return null;
    }

    void clearServiceState() {
        users = new User[DEFAULT_USERS_CAPACITY];
        userCount = 0;
        DefaultUser.clearState();
    }
}
