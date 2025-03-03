package com.coding.jpahibernate.jpahibernate.repo;

import com.coding.jpahibernate.jpahibernate.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface userrepo extends JpaRepository<User, Long> {
    List<User> findTop3ByAgeOrderByLastNameAsc(Integer age);
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
    List<User> findByPriceGreaterThanEqual(Double price);

}
