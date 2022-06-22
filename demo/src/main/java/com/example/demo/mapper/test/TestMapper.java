package com.example.demo.mapper.test;

import java.util.List;

import com.example.demo.vo.test.DbTestVo;
import com.example.demo.vo.test.TestVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestMapper {
    List<TestVo> selectTest();
    List<DbTestVo> getTestData();
}