package com.microservices.borrowing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.borrowing.entity.Borrowing;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BorrowingRepoTest {

    @Autowired
    private MockMvc mvc;

    //GET TEST
    @Test
    public void getBorrowing() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("api/borrowing")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.borrowing").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.borrowing[*].borrowingId").isNotEmpty());
    }

    //POST TEST
    @Test
    public void createBorrowing() throws Exception {
        Borrowing b = new Borrowing();
        b.setBookId(12L);
        b.setCustomerId(22L);

        mvc.perform(MockMvcRequestBuilders
                        .post("api/borrowing")
                        .content(asJsonString(b))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.borrowingId").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //PUT TEST
    @Test
    public void updateBorrowing() throws Exception {
        Borrowing b = new Borrowing();
        b.setBookId(44L);
        b.setCustomerId(22L);
        b.setReturned(true);

        mvc.perform(MockMvcRequestBuilders
                        .put("/api/borrowing/{id}")
                        .content(asJsonString(b))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.bookId").value(44L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value(44L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.returned").value(true));
    }

    //DELETE TEST
    @Test
    public void deleteBorrowing() throws Exception{
        mvc.perform(MockMvcRequestBuilders.delete("api/borrowing/{id}", 1))
                .andExpect(status().isAccepted());
    }

}


