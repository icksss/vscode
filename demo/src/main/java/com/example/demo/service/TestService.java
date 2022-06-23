package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.test.TestMapper;
import com.example.demo.vo.test.DbTestVo;
import com.example.demo.vo.test.TestVo;

@Service
public class TestService {

    @Autowired
    public TestMapper mapper;

    public List<TestVo> selectTest() {
        return mapper.selectTest();
    }

    public List<DbTestVo> getTestData(){
        return mapper.getTestData();
    }

    public List<DbTestVo> getParamTest(Map<String,String>  paramMap){
        return mapper.getParamTest(paramMap);
    }
}