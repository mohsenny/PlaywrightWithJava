package resources.config;

import java.nio.file.Paths;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.extension.*;

public class PlaywrightExtension implements BeforeEachCallback, AfterEachCallback {
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        if (browser == null) {
            // Initialize browser only once for all tests
            browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        }
        // Create a new browser context and page for each test
        PlaywrightExtension.context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
        PlaywrightExtension.page = PlaywrightExtension.context.newPage();
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        // Perform actions like taking screenshots here if necessary
        // For example, on test failure:
        if (context.getExecutionException().isPresent()) {
            String testName = context.getRequiredTestMethod().getName();
            PlaywrightExtension.page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/" + testName + ".png")));
        }

        // Close the page and context after each test
        if (PlaywrightExtension.page != null) {
            PlaywrightExtension.page.close();
        }
        if (PlaywrightExtension.context != null) {
            PlaywrightExtension.context.close();
        }
    }

    public static Page getPage() {
        return page;
    }

    public static Browser getBrowser() {
        return browser;
    }
}