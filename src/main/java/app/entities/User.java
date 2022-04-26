package app.entities;

import java.util.Objects;

public class User {
    private String name;
    private String numberGroup;

    public User() {
    }

    public User(String name, String numberGroup) {
        this.name = name;
        this.numberGroup = numberGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(String numberGroup) {
        this.numberGroup = numberGroup;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + numberGroup + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(numberGroup, user.numberGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberGroup);
    }
}
