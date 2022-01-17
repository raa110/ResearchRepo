package com.sample.factory.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "performance_test", uniqueConstraints =
@UniqueConstraint(name = "performance_test_name", columnNames = {"name"}))
public class PerformanceTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sequence", nullable = false)
    private String sequence;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "last_updated_time", nullable = false)
    private Long lastUpdatedTime;

    @OneToMany(mappedBy = "performanceTest", targetEntity = PerformanceTestChildOne.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private List<PerformanceTestChildOne> childOnes;
}
