package com.coding.jpahibernate.jpahibernate.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users",// Custom table name
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"email"}), // Single-column unique constraint
                @UniqueConstraint(columnNames = {"firstName", "lastName"}) // Multi-column unique constraint
        })

public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(nullable = false)
    private Boolean isActive;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
