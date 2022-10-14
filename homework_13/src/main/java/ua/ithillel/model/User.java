package ua.ithillel.model;

import com.github.javafaker.Faker;

public class User {
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User(String userName, String firstName, String lastName, String email, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public static class Builder {
        private String userName;
        private String firstName;
        private String lastName;
        private String email;
        private String password;


        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(userName, firstName, lastName, email, password);
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public static User generateRandomUser() {
        Faker faker = new Faker();
        return new User(faker.name().username(), faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), faker.internet().password());
    }
}