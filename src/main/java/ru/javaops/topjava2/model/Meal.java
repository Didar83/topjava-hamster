package ru.javaops.topjava2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="meals", uniqueConstraints = {@UniqueConstraint
        (columnNames = {"date_of_visit", "restaurant_id"}, name = "date_of_visit_restaurant")})
@Getter
@Setter
public class Meal extends NamedEntity{
    @Column(name="date_of_visit")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateOfVisit;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    @OrderBy("name")
    @ManyToMany(fetch = FetchType.EAGER)
    @NotNull
    @JoinTable(name = "meals_dishes",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private Set<Dish> dishes;

    public Meal() {
    }

    public Meal(@NotBlank @Size(min = 2, max = 100) String name, LocalDate date, Restaurant restaurant, Set<Dish> dishes) {
        super(name);
        dateOfVisit = date;
        this.restaurant = restaurant;
        this.dishes.addAll(dishes);
    }
    public Meal(@NotBlank @Size(min = 2, max = 100) String name, Integer id, LocalDate date, Restaurant restaurant, Set<Dish> dishes) {
        super(id, name);
        dateOfVisit = date;
        this.restaurant = restaurant;
        this.dishes.addAll(dishes);
    }
    public Meal(LocalDate date, Restaurant restaurant, Set<Dish> dishe) {
        dateOfVisit = date;
        this.restaurant = restaurant;
        this.dishes.addAll(dishes);
    }

}
