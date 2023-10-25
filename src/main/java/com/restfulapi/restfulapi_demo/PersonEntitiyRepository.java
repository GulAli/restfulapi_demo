package com.restfulapi.restfulapi_demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEntitiyRepository extends JpaRepository<Person, Long> {
    // Custom query methods, if needed
}
