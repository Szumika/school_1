package pl.coderslab.warsztat3.model;

public class Users {
    private  int id;
    private String username;
    private String email;
    private String pasword;
    private int User_Group_id;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasword() {
        return pasword;
    }

    public int getUser_Group_id() {
        return User_Group_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public void setUser_Group_id(int user_Group_id) {
        User_Group_id = user_Group_id;
        }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", pasword='" + pasword + '\'' +
                ", User_Group_id=" + User_Group_id +
                '}';
    }

    public Users(int id, String username, String email, String pasword, int user_Group_id) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.pasword = pasword;
        this.User_Group_id = user_Group_id;
    }

    public Users() {
    }

    public Users(int id) {
        this.id = id;
    }

    public Users(int id, String username, String email, int user_Group_id) {
        this.id = id;
        this.username = username;
        this.email = email;
        User_Group_id = user_Group_id;
    }

    public Users(String username, String email, int user_Group_id) {
        this.username = username;
        this.email = email;
        User_Group_id = user_Group_id;
    }

    public Users(String username, String email, String pasword, int user_Group_id) {
        this.username = username;
        this.email = email;
        this.pasword = pasword;
        User_Group_id = user_Group_id;
    }
}
