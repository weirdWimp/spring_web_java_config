package com.candy.entity;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.StringJoiner;

public class User {

    @Email(message = "{email.invalid}")
    @NotEmpty(message = "{email.empty}")
    private String email;

    @NotEmpty(message = "{firstName.empty}")
    private String firstName;

    @NotEmpty(message = "{lastName.empty}")
    private String lastName;

    @NotEmpty(message = "{username.empty}")
    @Length(min = 4, message = "{username.length}" )
    private String username;

    @Size(min = 8, max = 12, message = "{password.length}")
    private String password;

    public User() {

    }

    public User(String email, String firstName, String lastName, String username, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("email='" + email + "'")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .toString();
    }
}
