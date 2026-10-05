package entites;

public class DefaultUser implements User {

    private static int userCounter = 0;

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public DefaultUser() {
        this.id = ++userCounter;
    }

    public DefaultUser(String firstName, String lastName, String password, String email) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    @Override
    public String toString() {
        return "First Name: " + this.firstName + ", Last Name: " + this.lastName + ", Email: " + this.email;
    }

    public static void clearState() {
        userCounter = 0;
    }
}