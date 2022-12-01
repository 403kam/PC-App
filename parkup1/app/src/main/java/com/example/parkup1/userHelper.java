package com.example.parkup1;

public class userHelper {

    String name, email, confirmemail, password, confirmpassword;

    public userHelper() {
    }

    public userHelper(String name, String email, String confirmemail, String password, String confirmpassword) {
        this.name = name;
        this.email = email;
        this.confirmemail = confirmemail;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmemail() {
        return confirmemail;
    }

    public void setConfirmemail(String confirmemail) {
        this.confirmemail = confirmemail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
}
