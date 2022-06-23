package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TestService;
import com.example.demo.vo.test.DbTestVo;
import com.example.demo.vo.test.TestVo;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/paramTest")
    public ResponseEntity<List<DbTestVo>> getParamTest(
        @RequestParam String id,
        @RequestParam Map<String,String> paramMap,
        @RequestParam MultiValueMap<String,String> multiMap        
        ){
        
        log.debug("this is rest api /getParamTest");
        log.debug("id="+id);
        log.debug("paramMap="+paramMap);
        log.debug("multiMap="+multiMap);

        List<DbTestVo> dbTestList = testService.getParamTest(paramMap);

        return ResponseEntity.status(HttpStatus.OK).body(dbTestList);
    }
        
}