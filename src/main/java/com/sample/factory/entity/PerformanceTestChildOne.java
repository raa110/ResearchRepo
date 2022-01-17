package com.sample.factory.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "performance_test_child_one")
public class PerformanceTestChildOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private PerformanceTestChildType type;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id", nullable = false)
    private PerformanceTest performanceTest;

    @Column(name = "value", nullable = false)
    private String value;
}
