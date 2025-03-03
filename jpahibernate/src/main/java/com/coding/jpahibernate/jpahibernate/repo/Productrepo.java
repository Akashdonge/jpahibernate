package com.coding.jpahibernate.jpahibernate.repo;

import com.coding.jpahibernate.jpahibernate.Entities.ProductEntity;
import com.coding.jpahibernate.jpahibernate.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface Productrepo extends JpaRepository<ProductEntity, Long> {
      List<ProductEntity> findByCreatedAtAfter(LocalDateTime localDateTime);


}
