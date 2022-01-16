package com.sample.factory.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
public class ApplicationScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationScheduler.class);

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Scheduled(fixedDelay = 60000L)
    public void sampleProcedureCall() {
        this.entityManager.createNativeQuery("call sample_proc()").executeUpdate();
        LOGGER.info("Sample proc call 2");
    }
}
