package config;

public class UserModel {
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    private String employeeId;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserModel (String firstname, String lastname, String username, String password){
            this.firstname = firstname;
            this.lastname = lastname;
            this.username = username;
            this.password = password;
    }

    public UserModel(){

    }
}
