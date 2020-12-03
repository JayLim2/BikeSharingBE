package ru.sergei.komarov.bikesharingsupport.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "first_name",
                        "middle_name",
                        "last_name",
                        "passport_series",
                        "passport_number"
                })
        })
public class User implements UserDetails {

    @Id
    private String phone;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "passport_series", nullable = false)
    private int passportSeries;

    @Column(name = "passport_number", nullable = false)
    private int passportNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public String getUsername() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public User setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getPassportSeries() {
        return passportSeries;
    }

    public User setPassportSeries(int passportSeries) {
        this.passportSeries = passportSeries;
        return this;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public User setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", lastName, firstName, middleName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return passportSeries == user.passportSeries &&
                passportNumber == user.passportNumber &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(middleName, user.middleName) &&
                Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, password, firstName, middleName, lastName, passportSeries, passportNumber);
    }
}
