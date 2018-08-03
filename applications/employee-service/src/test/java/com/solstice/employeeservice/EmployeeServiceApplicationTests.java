package com.solstice.employeeservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeServiceApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getEmployeesByCourseId() throws Exception {
        this.mockMvc.perform(get("/employees/course/66921076-fdse-458b-9d7d-ce9a227d64a5"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': '66921076-ed1d-458b-9d7d-ce9a227d64a5', 'firstName': 'Josh', 'lastName': 'Sonnenberg', 'employeeNumber': 250, 'office': 'Chicago', 'title': 'Sr. Technical Consultant', 'email': jsonnenberg@solstice.com', 'imageURL': null }"));

    }

}
