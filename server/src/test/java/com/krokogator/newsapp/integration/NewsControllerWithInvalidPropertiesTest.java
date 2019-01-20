package com.krokogator.newsapp.integration;

import com.krokogator.newsapp.shared.CategoryEnum;
import com.krokogator.newsapp.shared.CountryEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        "api-url=https://newsapi.org/v2/everything",
        "api-key=af8f7e7a092afwagawe5a8a96cdc"})
public class NewsControllerWithInvalidPropertiesTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                // Always print
                .alwaysDo(print())
                .build();
    }

    public ResultActions getNewsPage(String country, String category) throws Exception {
        return mockMvc.perform(
                get("/news/" + country + "/" + category)
        );
    }

    @Test
    public void givenCorrectValues_thenServerError() throws Exception {
        getNewsPage(CountryEnum.pl.toString(), CategoryEnum.technology.toString())
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void givenIncorrectValues_thenBadRequest() throws Exception {
        getNewsPage("badcountryname", "badcategoryname")
                .andExpect(status().isBadRequest());
    }

    //Actually it acts like calling different endpoint
    @Test
    public void givenEmptyValues_thenBadRequest() throws Exception {
        getNewsPage("", "")
                .andExpect(status().isBadRequest());
    }




}
