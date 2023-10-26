package ru.diasoft.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diasoft.edu.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
