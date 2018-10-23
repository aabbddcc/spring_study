package com.example;

import com.example.dao.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseControllerTest {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private WebApplicationContext webContext;
    private MockMvc mvc = null;
    private MockHttpSession session = null;

    @Before
    public void setupMockMvc() {
        logger.info("@Before...");
        mvc = MockMvcBuilders.webAppContextSetup(webContext).build();
        session = new MockHttpSession();
        User user = new User("root", "root");
        session.setAttribute("user", user);
    }

    @After
    public void after() {
        logger.info("@After...");
    }


    /**
     * 新增教程测试用例
     *
     * @throws Exception
     */
    @Test
    public void addCourse() throws Exception {
        String json = "{\"author\":\"HAHAHAA\",\"title\":\"Spring\",\"url\":\"http://www.spring.com\"}";
        mvc.perform(MockMvcRequestBuilders.post("/course/add")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(json.getBytes()) //传json参数
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 获取教程测试用例
     *
     * @throws Exception
     */
    @Test
    public void queryCourse() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/course/resource/1001")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("course author name"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("course tile name"))
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 修改教程测试用例
     *
     * @throws Exception
     */
    @Test
    public void updateCourse() throws Exception {
        String json = "{\"author\":\"测试修改\",\"id\":1031,\"title\":\"Spring教程\",\"url\":\"http://www.spring.com\"}";
        mvc.perform(MockMvcRequestBuilders.post("/course/update")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json.getBytes())//传json参数
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 删除教程测试用例
     *
     * @throws Exception
     */
    @Test
    public void deleteCourse() throws Exception {
        String json = "[1031]";
        mvc.perform(MockMvcRequestBuilders.post("/course/delete")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(json.getBytes())//传json参数
                .session(session)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
