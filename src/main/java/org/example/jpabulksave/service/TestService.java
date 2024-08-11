package org.example.jpabulksave.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jpabulksave.entity.Test;
import org.example.jpabulksave.repository.TestJdbcRepository;
import org.example.jpabulksave.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    private final TestRepository testRepository;
    private final TestJdbcRepository testJdbcRepository;

    @Transactional
    public void save() {
        //5만 건 save
        for (int i = 0; i < 1000; i++) {
            testRepository.save(new Test(UUID.randomUUID().toString(),"테스트네임" + i, "테스트닉네임" + i));
        }
        throw new RuntimeException("롤백 테스트");
    }

    @Transactional
    public void bulkSave() {
        //5만 건 bulkSave
        List<Test> testList = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            testList.add(new Test(UUID.randomUUID().toString(),"key", "테스트닉네임" + i,"nickanme","nickanme","nickanme","nickanme","nickanme","nickanme","nickanme"));
        }
        testRepository.saveAll(testList);
    }

    @Transactional
    public void bulkSave2() {
        List<Test> testList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            testList.add(new Test(UUID.randomUUID().toString(),"key", "테스트닉네임" + i,"nickanme","nickanme","nickanme","nickanme","nickanme","nickanme","nickanme"));
        }
        testJdbcRepository.bulkInsertUsers(testList);
    }

    public void log() {
        log.info("TEST@@@@");
    }

    @Transactional
    public void bulkUpdate(List<Test> tests) {
        tests.forEach(test -> {
            test.updateNickName("SENDED");
        });

    }
}
