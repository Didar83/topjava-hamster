package ru.javaops.topjava2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.topjava2.model.Restaurant;

import java.util.List;

@Repository
@Transactional
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> getAll();

}
