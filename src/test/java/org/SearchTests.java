package org;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.pages.SearchPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchTests {
    static Browser browser;
    static SearchPage searchPage;
    static BrowserContext context;
    static Page page;

    @BeforeAll
    public static void launchBrowser() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
    }

    @BeforeEach
    public void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        searchPage = new SearchPage(page);
        page.navigate("https://www.google.com");
    }

    @Test
    public void successfulLoginTest() {
        searchPage.clickCookieAcceptButton();
        searchPage.search("Potato");
        assertThat(searchPage.getSearchField()).containsText("Potato");
        searchPage.navigateToImageResults();
        // more assertions...
        searchPage.navigateToAllResults();
        // more assertions...
        searchPage.navigateToVideoResults();
        // more assertions...
    }

    @AfterAll
    public static void tearDown() {
        page.close();
        browser.close();
    }
}
