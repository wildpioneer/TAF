package models;

public class User {
    private String name;
    private String surname;
    private int age;
    private String username;
    private String password;
    private String address;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {
        private User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder withName(String name) {
            newUser.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            newUser.surname = surname;
            return this;
        }

        public Builder withAge(int age) {
            newUser.age = age;
            return this;
        }

        public Builder withUsername(String username) {
            newUser.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            newUser.password = password;
            return this;
        }

        public Builder withAddress(String address) {
            newUser.address = address;
            return this;
        }

        public User build() {
            return newUser;
        }
    }
}
