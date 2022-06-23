package com.example.demo.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
// import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// import com.example.demo.DemoApplication;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Slf4j
// @WebMvcTest(controllers = TestController.class)
// @ContextConfiguration(classes = DemoApplication.class)
@AutoConfigureMockMvc
@DisplayName("특수한 케이스 테스트")
public class TestControllerTests {
    
    @Autowired
    private MockMvc mvc;

    @Disabled("#Test 끝날떄 까지 중지")
    @Test
    void getTestData() {
        log.debug("Test getTestData()");
        
    }

    @DisplayName(value="Junit5 api /test 테스트😭 ")
    @Test
    public void apiTest() throws Exception{
        String message = "this is rest api /test";
        RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/test");
        MvcResult result = mvc.perform(reqBuilder).andReturn();

        MockHttpServletResponse res = result.getResponse();
        int status = res.getStatus();
        String resultMessage = res.getContentAsString();
       log.debug("status : "+status);
       log.debug("res getContentAsString: "+resultMessage);
       assertEquals(message, resultMessage);

    }
    @DisplayName(value="Junit5 api /entity 테스트😭 ")
    @Test
    public void apiEntityTest() throws Exception{
        String message = "myName is jikim";
        RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/entity");
        MvcResult result = mvc.perform(reqBuilder).andReturn();

        MockHttpServletResponse res = result.getResponse();
        int status = res.getStatus();
        String resultMessage = res.getContentAsString();
       log.debug("status : "+status);
       log.debug("res getContentAsString: "+resultMessage);
       assertEquals(message, resultMessage);

    }
    
    @DisplayName(value="Junit5 api /dbtest 테스트😭 ")
    @Test
    public void apiDbTest() throws Exception{
        
        RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/dbtest");
        MvcResult result = mvc.perform(reqBuilder).andReturn();

        MockHttpServletResponse res = result.getResponse();
        int status = res.getStatus();
        String resultMessage = res.getContentAsString();
       log.debug("status : "+status);
       log.debug("res getContentAsString: "+resultMessage);
       

    }

    @DisplayName(value="Junit5 api /getTestData 테스트😭 ")
    @Test
    public void getDbTestData() throws Exception{
        
        RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/getTestData");
        MvcResult result = mvc.perform(reqBuilder).andReturn();

        MockHttpServletResponse res = result.getResponse();
        int status = res.getStatus();
        String resultMessage = res.getContentAsString();
       log.debug("status : "+status);
       log.debug("res getContentAsString: "+resultMessage);
       assertEquals(200,status);
       assertFalse(resultMessage.isEmpty()); 

    }

    @DisplayName(value="Junit5 api /paramTest 테스트😭 ")
    @Test
    public void paramTest() throws Exception{
        
        RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/paramTest").param("name", "TEST").param("id", "1");
        
        MvcResult result = mvc.perform(reqBuilder).andReturn();

        MockHttpServletResponse res = result.getResponse();
        int status = res.getStatus();
        String resultMessage = res.getContentAsString();
       log.debug("status : "+status);
       log.debug("res getContentAsString: "+resultMessage);
       assertEquals(200,status);
       assertFalse(resultMessage.isEmpty()); 

    }

}
