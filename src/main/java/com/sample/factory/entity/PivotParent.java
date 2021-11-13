package com.sample.factory.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pivot_parent")
public class PivotParent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "pivotParent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = PivotChild.class)
    @Fetch(FetchMode.SUBSELECT)
    private List<PivotChild> pivotChildList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<PivotChild> getPivotChildList() {
        return pivotChildList;
    }

    public void setPivotChildList(List<PivotChild> pivotChildList) {
        this.pivotChildList = pivotChildList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PivotParent that = (PivotParent) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
