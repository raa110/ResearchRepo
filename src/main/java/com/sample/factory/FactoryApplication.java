package com.sample.factory;

import com.sample.factory.entity.PerformanceTest;
import com.sample.factory.entity.PivotChild;
import com.sample.factory.entity.PivotParent;
import com.sample.factory.repo.PerformanceTestRepo;
import com.sample.factory.repo.PivotParentRepo;
import com.sample.factory.repo.UserProfileRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class FactoryApplication {

    private static final Logger LOGGER = LogManager.getLogger(FactoryApplication.class);

    @Autowired
    private UserProfileRepo userProfileRepo;

    @Autowired
    private PivotParentRepo pivotParentRepo;

    @Autowired
    private PerformanceTestRepo performanceTestRepo;

    public static void main(String[] args) {
        SpringApplication.run(FactoryApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            LOGGER.info("Started inserting performance test data");
            List<PerformanceTest> performanceTestList = null;
            int sequenceNum = 65;
            for (int i = 0; i < 1000000; i++) {
                if (performanceTestList == null) {
                    performanceTestList = new LinkedList<>();
                }
                if (performanceTestList.size() == 1000) {
                    this.performanceTestRepo.saveAll(performanceTestList);
                    LOGGER.info("Inserted 1000 data... and continuing");
                    performanceTestList = new LinkedList<>();
                }
                if (sequenceNum > 90) {
                    sequenceNum = 65;
                }
                final String name = UUID.randomUUID().toString();
                final int age = (int) (Math.random() * (75 - 18 + 1) + 18);
                final PerformanceTest performanceTest = new PerformanceTest();
                performanceTest.setName(name);
                performanceTest.setAge(age);
                performanceTest.setSequence(String.valueOf((char) sequenceNum));
                performanceTest.setLastUpdatedTime(System.currentTimeMillis());
                performanceTestList.add(performanceTest);
                sequenceNum++;
            }
            LOGGER.info("Completed inserting the performance test data");
        };
    }


    /*@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            LOGGER.info("Started inserting test user profiles");
            for (int i = 0; i < 100; i++) {
                final String s = UUID.randomUUID().toString() + "-" + i;
                final UserProfile userProfile = new UserProfile();
                userProfile.setUsername(s);
                userProfile.setName(s);
                this.userProfileRepo.save(userProfile);
                LOGGER.info("Added user: " + s);
            }
            LOGGER.info("Completed inserting test user profiles");
        };
    }*/

/*    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            LOGGER.info("Started inserting pivoting samples");
            final List<PivotParent> pivotParents = new LinkedList<>();
            pivotParents.add(this.setPivotParent("Velraj", 24, "Tirunelveli", "Chennai"));
            pivotParents.add(this.setPivotParent("Kalla", 24, "Coimbatore", "Tirunelveli"));
            pivotParents.add(this.setPivotParent("Maaran", 25, "Chennai", "Tuticorin"));
            pivotParents.add(this.setPivotParent("Prakash", 24, "Andhra", "Bangalore"));
            this.pivotParentRepo.saveAll(pivotParents);
            LOGGER.info("Completed inserting test user profile");
        };
    }*/

    private PivotParent setPivotParent(final String name, final Integer age, final String permCity, final String currCity) {
        final PivotParent pivotParent = new PivotParent();
        final List<PivotChild> pivotChildList = new LinkedList<>();
        pivotParent.setName(name);
        pivotParent.setAge(age);
        pivotChildList.add(this.setPivotChild(pivotParent, permCity, "PERMANENT"));
        pivotChildList.add(this.setPivotChild(pivotParent, currCity, "CURRENT"));
        pivotParent.setPivotChildList(pivotChildList);
        return pivotParent;
    }

    private PivotChild setPivotChild(final PivotParent pivotParent, final String city, final String type) {
        final PivotChild pivotChild = new PivotChild();
        pivotChild.setPivotParent(pivotParent);
        pivotChild.setAddressType(type);
        pivotChild.setCity(city);
        return pivotChild;
    }

}
