package com.wake.nlkm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wake.nlkm.controller.WordController;
import com.wake.nlkm.entity.Word;
import com.wake.nlkm.service.WordService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

/**
 * @Author Ganty
 * @Date 2020/8/19
 * @Des
 */

//@SpringBootTest(classes = NlkmApplication.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class VocabularyTest extends BaseTest{

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test_get_vacabulary_batch() throws Exception {
        MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/vocabulary/get_list")
                .param("page", "1")
                .param("limit", "10")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse();
        response.setCharacterEncoding("utf-8");
        String responseString = response.getContentAsString();
        System.out.println(responseString);
        JSONObject jsonObject =  JSON.parseObject(responseString);
        Integer code = jsonObject.getInteger("code");
        Assert.assertEquals(code,new Integer(0));
//        System.out.println(responseString);
    }



    public static void main(String[] args) {
//        super.
    }

}
