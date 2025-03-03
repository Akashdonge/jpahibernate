package com.coding.jpahibernate.jpahibernate.repo;

import com.coding.jpahibernate.jpahibernate.Entities.departmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentrepo extends JpaRepository<departmentEntity,Long> {

}
