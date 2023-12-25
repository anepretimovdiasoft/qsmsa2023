package ru.diasoft.edu.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.diasoft.edu.domain.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Override
    @EntityGraph(attributePaths = "emails")
    List<Person> findAll();

    @Query("SELECT p FROM Person p WHERE p.name = :name")
    List<Person> findByName(@Param("name") String name);

    @Modifying
    @Query("UPDATE Person p SET p.name = :name WHERE p.id = :id")
    void updateNameById(@Param("id") long id, @Param("name") String name);

    List<Person> findByNameLike(String nameLike);

}
