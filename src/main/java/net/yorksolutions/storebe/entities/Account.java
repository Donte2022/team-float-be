package net.yorksolutions.storebe.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;

    private String lastName;

    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @JsonIgnore
    private String password;

    private Integer rank;

//    @OneToOne
//    private Cart cart;

//    @OneToMany
//    public Set<Orders> orders;
//    getOrders() {return orders};

    public Account() {
    }

    public Account(String firstName, String lastName, String email, String username, String password, Integer rank, Set pastOrders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.rank = rank;
//        this.pastOrders = pastOrders;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Number getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}
