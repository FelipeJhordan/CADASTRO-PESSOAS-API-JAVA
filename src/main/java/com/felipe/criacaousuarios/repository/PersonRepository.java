package com.felipe.criacaousuarios.repository;

import com.felipe.criacaousuarios.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
