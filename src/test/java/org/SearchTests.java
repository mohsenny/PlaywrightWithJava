package org;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.pages.SearchPage;
import resources.config.PlaywrightExtension;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@ExtendWith(PlaywrightExtension.class)
public class SearchTests {
    static Browser browser;
    static SearchPage searchPage;
    static Page page;

    @BeforeEach
    public void createContextAndPage() {
        page = PlaywrightExtension.getPage();
        searchPage = new SearchPage(page);
        page.navigate("https://www.google.com");
    }

    @Test
    public void shouldSearchAndNavigateToDifferentResultsFormat() {
        searchPage.clickCookieAcceptButton();
        searchPage.search("Potato");
        assertThat(searchPage.getSearchField()).containsText("Potato");
        searchPage.navigateToImageResults();
        Assertions.assertTrue(page.url().matches(".*q=Potato&tbm=isch.*$"));
        searchPage.navigateToAllResults();
        searchPage.navigateToVideoResults();
        Assertions.assertTrue(page.url().matches(".*q=Potato&tbm=vid.*$"));
    }

    @AfterAll
    public static void tearDown() {
        page.close();
        PlaywrightExtension.getBrowser().close();
    }
}
