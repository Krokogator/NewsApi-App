package com.krokogator.newsapp;

import com.krokogator.newsapp.external.NewsApiRequest;
import com.krokogator.newsapp.external.NewsApiRequestTest;
import com.krokogator.newsapp.integration.NewsControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@SuiteClasses({
        NewsControllerTest.class,
        NewsApiRequestTest.class
})
@SpringBootTest
public class NewsappApplicationTests {

}

