package com.sample.factory.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "performance_test_child_type", uniqueConstraints =
@UniqueConstraint(name = "performance_test_child_type_type", columnNames = {"type"}))
public class PerformanceTestChildType {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;
}
