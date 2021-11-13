package com.sample.factory.repo;

import com.sample.factory.entity.PivotParent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PivotParentRepo extends JpaRepository<PivotParent, Long> {
}
