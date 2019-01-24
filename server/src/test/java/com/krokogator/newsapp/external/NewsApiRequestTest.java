package com.krokogator.newsapp.external;

import com.krokogator.newsapp.model.newsapi.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.restlet.resource.ResourceException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsApiRequestTest {

    private final Pageable correctPage;
    private final Pageable incorrectPage;

    public NewsApiRequestTest() {
        correctPage = PageRequest.of(0, 10);
        // Cannot create PageRequest.of(x,y) with negative x or y, had to create custom impl
        incorrectPage = new IncorrectPageableImpl();
    }

    @Test
    public void givenCorrectArguments() {
        NewsApiRequest request = getCorrectRequest();
        List<Article> articleList = request.getByCountryAndCategory("pl", "technology", correctPage, null);

        // Given correct values, list must not be null
        assertNotNull(articleList);

        // Given correct values, list must contain elements
        assertTrue(articleList.size() > 0);
    }

    @Test
    public void givenIncorrectCountryAndCategoryArguments() {
        NewsApiRequest request = getCorrectRequest();
        List<Article> articleList = request.getByCountryAndCategory("foo", "bar", correctPage, null);

        // Given incorrect value, list must not be null
        assertNotNull(articleList);

        // Given incorrect value, list should not contain any values
        assertEquals(0, articleList.size());
    }

    @Test
    public void givenIncorrectPageArguments() {
        NewsApiRequest request = getCorrectRequest();
        List<Article> articleList = request.getByCountryAndCategory("pl", "technology", incorrectPage, null);

        // Given incorrect value, list must not be null
        assertNotNull(articleList);

        // Given incorrect value, list should not contain any values
        assertEquals(0, articleList.size());
    }

    @Test
    public void givenCorrectSearchPhrase() {
        NewsApiRequest request = getCorrectRequest();
        List<Article> articleList = request.getByCountryAndCategory("pl", "technology", correctPage, null);

        Optional<Article> articleOptional = articleList.stream().findFirst();
        if (articleOptional.isPresent()) {
            String searchPhrase = articleOptional.get().getTitle().substring(0, 3);

            List<Article> foundArticles = getArticlesBySearchPhrase(searchPhrase);

            // Given correct values, list must not be null
            assertNotNull(foundArticles);

            // Given phrase from existing title, search should contain at least one result
            assertTrue(foundArticles.size() > 0);
        } else {
            fail("Couldn't get any article to perform test");
        }
    }

    private List<Article> getArticlesBySearchPhrase(String searchPhrase) {
        NewsApiRequest request = getCorrectRequest();
        return request.getByCountryAndCategory("pl", "technology", correctPage, searchPhrase);
    }

    @Test(expected = ResourceException.class)
    public void givenIncorrectUrl() {
        NewsApiRequest request = getIncorrectUrlRequest();
        request.getByCountryAndCategory("pl", "technology", correctPage, null);
        }

    @Test(expected = ResourceException.class)
    public void givenIncorrectKey() {
        NewsApiRequest request = getIncorrectKeyRequest();
        request.getByCountryAndCategory("pl", "technology", correctPage, null);
    }

    private NewsApiRequest getCorrectRequest() {
        return new NewsApiRequest("https://newsapi.org/v2/top-headlines", "af8f7e7a09234c869054b3e5a8a96cdc");
    }

    private NewsApiRequest getIncorrectUrlRequest() {
        return new NewsApiRequest("https://newsapi.org/v2/everything", "af8f7e7a09234c869054b3e5a8a96cdc");
    }

    private NewsApiRequest getIncorrectKeyRequest() {
        return new NewsApiRequest("https://newsapi.org/v2/everything", "ba4e2e2a85234lb6a0f2b3ega8a66adi");
    }

}