package com.sample.factory.repo;

import com.sample.factory.entity.PerformanceTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceTestRepo extends JpaRepository<PerformanceTest, Long> {
}
