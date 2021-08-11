package ru.javaops.topjava2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.topjava2.model.Meal;

import java.util.List;

@Repository
@Transactional
public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> getAll();
}
