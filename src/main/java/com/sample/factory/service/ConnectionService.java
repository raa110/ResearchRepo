package com.sample.factory.service;

import com.sample.factory.entity.SampleConnection;
import com.sample.factory.repo.SampleConnectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;

@Service
public class ConnectionService {

    @Autowired
    private SampleConnectionRepo sampleConnectionRepo;

    @Transactional(rollbackFor = {Exception.class})
    public void saveConnection() throws Exception {
        SampleConnection sampleConnection = new SampleConnection();
        sampleConnection.setName("1_" + new Random().longs());
        this.sampleConnectionRepo.save(sampleConnection);
        selfInjectTransactionalTest();
        final Optional<SampleConnection> optionalSampleConnection = this.sampleConnectionRepo.findById(sampleConnection.getId());
        if (true) {
            throw new Exception("Sample transaction exception");
        }
        if (optionalSampleConnection.isPresent()) {
            sampleConnection = optionalSampleConnection.get();
            sampleConnection.setName("2_" + new Random().longs());
            this.sampleConnectionRepo.save(sampleConnection);
        }
    }

    public void selfInjectTransactionalTest() {
        final SampleConnection sampleConnection = new SampleConnection();
        sampleConnection.setName("3_" + new Random().longs());
        this.sampleConnectionRepo.save(sampleConnection);
    }

}
