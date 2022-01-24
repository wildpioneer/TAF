package models;

public class UserSimple {
    private String name;
    private String surname;
    private String email;
    private boolean isActive;
    private int age;
    private int id;
    private int role_id;
    private String username;
    private String password;
    private String address;
    private String role;

    public int getRole_id() {
        return role_id;
    }

    public String getRole() {
        return role;
    }

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

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getId() {
        return id;
    }

    public static class Builder {
        private UserSimple newUserSimple;

        public Builder() {
            newUserSimple = new UserSimple();
        }

        public Builder withName(String name) {
            newUserSimple.name = name;
            return this;
        }

        public Builder withEmail(String email) {
            newUserSimple.email = email;
            return this;
        }

        public Builder withIsActive(boolean isActive) {
            newUserSimple.isActive = isActive;
            return this;
        }

        public Builder withID(int id) {
            newUserSimple.id = id;
            return this;
        }

        public Builder withSurname(String surname) {
            newUserSimple.surname = surname;
            return this;
        }

        public Builder withAge(int age) {
            newUserSimple.age = age;
            return this;
        }

        public Builder withUsername(String username) {
            newUserSimple.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            newUserSimple.password = password;
            return this;
        }

        public Builder withAddress(String address) {
            newUserSimple.address = address;
            return this;
        }

        public Builder withRoleId(int role_id) {
            newUserSimple.role_id = role_id;
            return this;
        }

        public Builder withRole(String role) {
            newUserSimple.role = role;
            return this;
        }

        public UserSimple build() {
            return newUserSimple;
        }
    }
}
