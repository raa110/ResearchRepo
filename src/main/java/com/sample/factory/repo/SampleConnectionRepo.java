package com.sample.factory.repo;

import com.sample.factory.entity.SampleConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
public interface SampleConnectionRepo extends JpaRepository<SampleConnection, Long> {
}
