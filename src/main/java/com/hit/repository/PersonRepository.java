package com.hit.repository;

import javax.enterprise.context.ApplicationScoped;

import com.hit.entity.Person;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person>{

}
