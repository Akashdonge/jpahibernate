package com.coding.jpahibernate.jpahibernate;

import com.coding.jpahibernate.jpahibernate.Entities.ProductEntity;
import com.coding.jpahibernate.jpahibernate.repo.Productrepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class JpahibernateApplicationTests {
@Autowired
	Productrepo productrepo;
	@Test
	void contextLoads() {
	}


}
