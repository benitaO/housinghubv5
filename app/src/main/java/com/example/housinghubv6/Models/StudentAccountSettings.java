package com.example.housinghubv6.Models;

public class StudentAccountSettings {

        private int year;
        private String bio;
        private String course;
        private String email;
        private String firstname;
        private int gbp_month;
        private boolean isStudent;
        private String lastName;
        private int number_of_houses;
        private String profile_photo;
        private String username;

    public StudentAccountSettings( int year, String bio, String email, String firstname, int gbp_month,
                                   boolean isStudent, String lastname, int no_of_housemates, String profile_photo, String username) {
        this.year = year;
        this.bio = bio;
        this.course = course;
        this.email = email;
        this.firstname = firstname;
        this.gbp_month = gbp_month;
        this.isStudent = isStudent;
        this.lastName = lastName;
        this.number_of_houses = number_of_houses;
        this.profile_photo = profile_photo;
        this.username = username;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getGbp_month() {
        return gbp_month;
    }

    public void setGbp_month(int gbp_month) {
        this.gbp_month = gbp_month;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumber_of_houses() {
        return number_of_houses;
    }

    public void setNumber_of_houses(int number_of_houses) {
        this.number_of_houses = number_of_houses;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "StudentAccountSettings{" +
                "year=" + year +
                ", bio='" + bio + '\'' +
                ", course='" + course + '\'' +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", gbp_month=" + gbp_month +
                ", isStudent=" + isStudent +
                ", lastName='" + lastName + '\'' +
                ", number_of_houses=" + number_of_houses +
                ", profile_photo='" + profile_photo + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

