package ru.javaops.topjava2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="restaurants")
@Getter
@Setter
public class Restaurant extends NamedEntity {

    @Column(name="address")
    private String address;

    @Column(name="phone_number")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "restaurant")
    private Set<Meal> meals;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "restaurant")
    private Set<Vote> votes;

    public Restaurant() {
    }

    public Restaurant(@NotBlank @Size(min = 2, max = 100) String name, Integer id) {
        super(id, name);
    }

    public Restaurant(String address, Set<Meal> meals, Set<Vote> votes) {
        this.address = address;
        this.meals = meals;
        this.votes = votes;
    }

    public Restaurant(@NotBlank @Size(min = 2, max = 100) String name, String address, Set<Meal> meals, Set<Vote> votes) {
        super(name);
        this.address = address;
        this.meals = meals;
        this.votes = votes;
    }

    public Restaurant(@NotBlank @Size(min = 2, max = 100) String name, Integer id, String address, Set<Meal> meals, Set<Vote> votes) {
        super(id, name);
        this.address = address;
        this.meals = meals;
        this.votes = votes;
    }
}
