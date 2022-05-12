package com.myserver.person;

import com.myserver.portfolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, Long> {

}
