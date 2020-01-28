package com.book.room.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.Objects;

@ApiModel
public class User {

    @ApiModelProperty(value = "Auto Generated Id", hidden = true)
    private long id;

    @ApiModelProperty(value = "First Name of User")
    private String firstName;

    @ApiModelProperty(value = "Last Name of User")
    private String lastName;

    @ApiModelProperty(value = "Date of Birth of User", example = "YYYY-MM-DD")
    private Date dob;

    @ApiModelProperty(value = "Email Id of User", example = "email@email.com")
    private String email;

    @ApiModelProperty(value = "Password for User")
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(dob, user.dob) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, dob, email, password);
    }
}
