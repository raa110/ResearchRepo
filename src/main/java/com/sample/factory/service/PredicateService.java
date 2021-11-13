package com.sample.factory.service;

import com.sample.factory.entity.PivotParentChildView;
import com.sample.factory.repo.PivotParentChildViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class PredicateService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PivotParentChildViewRepo pivotParentChildViewRepo;

    public void researchPredicate() {
        final List<PivotParentChildView> pivotParentChildViewList = this.pivotParentChildViewRepo.findAll();
    }

}
