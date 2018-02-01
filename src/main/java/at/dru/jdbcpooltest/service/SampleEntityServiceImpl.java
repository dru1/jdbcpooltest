package at.dru.jdbcpooltest.service;

import at.dru.jdbcpooltest.model.SampleEntity;
import at.dru.jdbcpooltest.model.SampleEntityRepository;
import org.apache.wicket.request.http.WebRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class SampleEntityServiceImpl {

    @Autowired
    private SampleEntityRepository sampleEntityRepository;

    @Autowired
    private EnvironmentServiceImpl environmentService;

    @Transactional
    public void runTests(WebRequest origin) {
        SampleEntity testEntity = buildTestEntity(environmentService.resolveOrigin(origin));
        sampleEntityRepository.save(testEntity);
    }

    private SampleEntity buildTestEntity(String origin) {
        SampleEntity testEntity = new SampleEntity();
        testEntity.setRandomString(UUID.randomUUID().toString());
        testEntity.setOriginalHost(origin);
        return testEntity;
    }

    @Scheduled(fixedDelay = 3000)
    public void runAsyncTests() {
        sampleEntityRepository.save(buildTestEntity("Thread: " + Thread.currentThread().getName()));
    }
}
