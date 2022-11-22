package com.example.postgresql2.repository;

import com.example.postgresql2.modelo.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
