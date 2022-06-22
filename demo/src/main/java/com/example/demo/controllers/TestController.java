package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TestService;
import com.example.demo.vo.test.DbTestVo;
import com.example.demo.vo.test.TestVo;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@Slf4j
public class TestController {
	
    @Autowired
    TestService testService;

    @GetMapping(value="/test")
    public String getTestData() {
        log.debug("this is rest api /test");
        return "this is rest api /test" ;
    }
    
    @GetMapping(value="/entity")
    public ResponseEntity<String> getTestEntity() {
        log.debug("this is rest api /entity");

        return ResponseEntity.status(HttpStatus.OK).body("myName is jikim") ;
    }


    @GetMapping(value="/dbtest")
    public ResponseEntity<List<TestVo>> getDbTest() {
        log.debug("this is rest api /dbtest");
        List<TestVo> testList = testService.selectTest();

        return ResponseEntity.status(HttpStatus.OK).body(testList) ;
    }

    @GetMapping(value="/getTestData")
    public ResponseEntity<List<DbTestVo>> getDbTestData(){
        log.debug("this is rest api /getTestData");
        List<DbTestVo> dbTestList = testService.getTestData();
        
        dbTestList.forEach((t) -> log.debug(t.getName() + " , " + t.getTitle()));

        return ResponseEntity.status(HttpStatus.OK).body(dbTestList);
    }
}