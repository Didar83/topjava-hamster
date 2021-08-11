package ru.javaops.topjava2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="diches")
@Getter
@Setter
public class Dish extends NamedEntity{
    @Column(name="prices")
    private Integer price;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "meals_dishes",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private Set<Meal> meals;


    public Dish() {
        super();
    }

    public Dish(Integer price, Set<Meal> meals) {
        this.price = price;
        this.meals = meals;
    }

    public Dish(Integer id, @NotNull @Size(min = 2, max = 100) String name, Integer price, Set<Meal> meals) {
        super(id, name);
        this.price = price;
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "price=" + price +
                ", name=" + name +
                '}';
    }
}
