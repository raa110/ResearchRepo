package com.sample.factory.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pivot_child")
public class PivotChild {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pivot_parent_id", referencedColumnName = "id")
    private PivotParent pivotParent;

    @Column(name = "address_type")
    private String addressType;

    @Column(name = "city")
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PivotParent getPivotParent() {
        return pivotParent;
    }

    public void setPivotParent(PivotParent pivotParent) {
        this.pivotParent = pivotParent;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PivotChild that = (PivotChild) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
