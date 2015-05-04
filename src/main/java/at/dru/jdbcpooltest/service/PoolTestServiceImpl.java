package at.dru.jdbcpooltest.service;

import at.dru.jdbcpooltest.model.PoolTest;
import at.dru.jdbcpooltest.model.PoolTestRepository;
import org.apache.wicket.request.http.WebRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PoolTestServiceImpl {

    @Autowired
    private PoolTestRepository poolTestRepository;

    @Autowired
    private EnvironmentServiceImpl environmentService;

    @Transactional
    public void runTests(WebRequest origin) {
        PoolTest testEntity = buildTestEntity(environmentService.resolveOrigin(origin));
        poolTestRepository.save(testEntity);
    }

    private PoolTest buildTestEntity(String origin) {
        PoolTest testEntity = new PoolTest();
        testEntity.setRandomString(UUID.randomUUID().toString());
        testEntity.setOriginalHost(origin);
        return testEntity;
    }

    @Scheduled(fixedDelay = 3000)
    public void runAsyncTests() {
        poolTestRepository.save(buildTestEntity("Async"));
    }
}
