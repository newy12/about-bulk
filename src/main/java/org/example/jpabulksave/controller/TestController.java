package org.example.jpabulksave.controller;

import lombok.RequiredArgsConstructor;
import org.example.jpabulksave.entity.Test;
import org.example.jpabulksave.repository.TestJdbcRepository;
import org.example.jpabulksave.repository.TestRepository;
import org.example.jpabulksave.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;
    private final TestRepository testRepository;
    private  final TestJdbcRepository testJdbcRepository;

    @PostMapping("/save")
    public String save() {
        // 시작 시간 기록
        long startTime = System.nanoTime();

        // 성능을 측정하고 싶은 코드 블록
        //testService.save();
        // 끝 시간 기록
        long endTime = System.nanoTime();

        // 실행 시간 계산 (나노초 단위)
        long durationNano = endTime - startTime;

        // 나노초를 초로 변환
        double durationSeconds = (double) durationNano / 1_000_000_000;

        return "실행 시간: " + durationSeconds + " 초";
    }
    @PostMapping("/bulkSave")
    public String bulkSave() {
        // 시작 시간 기록
        long startTime = System.nanoTime();

        // 성능을 측정하고 싶은 코드 블록
        testService.bulkSave();
        testService.log();
        // 끝 시간 기록
        long endTime = System.nanoTime();

        // 실행 시간 계산 (나노초 단위)
        long durationNano = endTime - startTime;

        // 나노초를 초로 변환
        double durationSeconds = (double) durationNano / 1_000_000_000;

        return "실행 시간: " + durationSeconds + " 초";
    }
    @PostMapping("/bulkSave2")
    public String bulkSave2() {
        // 시작 시간 기록
        long startTime = System.nanoTime();

        // 성능을 측정하고 싶은 코드 블록
        testService.bulkSave2();
        testService.log();
        // 끝 시간 기록
        long endTime = System.nanoTime();

        // 실행 시간 계산 (나노초 단위)
        long durationNano = endTime - startTime;

        // 나노초를 초로 변환
        double durationSeconds = (double) durationNano / 1_000_000_000;

        return "실행 시간: " + durationSeconds + " 초";
    }
    @PostMapping("/bulkUpdate")
    public String bulkUpdate() {
        // 시작 시간 기록
        long startTime = System.nanoTime();

        // 성능을 측정하고 싶은 코드 블록
        List<Test> all = testRepository.findAll();
        testJdbcRepository.bulkUpdateUsers(all);
        // 끝 시간 기록
        long endTime = System.nanoTime();

        // 실행 시간 계산 (나노초 단위)
        long durationNano = endTime - startTime;

        // 나노초를 초로 변환
        double durationSeconds = (double) durationNano / 1_000_000_000;

        return "실행 시간: " + durationSeconds + " 초";
    }
    @PostMapping("bulkUpdate2")
    public String bulkUpdate2() {
        // 시작 시간 기록
        long startTime = System.nanoTime();

        // 성능을 측정하고 싶은 코드 블록
        List<Test> all = testRepository.findAll();
        testService.bulkUpdate(all);
        // 끝 시간 기록
        long endTime = System.nanoTime();

        // 실행 시간 계산 (나노초 단위)
        long durationNano = endTime - startTime;

        // 나노초를 초로 변환
        double durationSeconds = (double) durationNano / 1_000_000_000;

        return "실행 시간: " + durationSeconds + " 초";
    }


}
