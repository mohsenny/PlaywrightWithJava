package org.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.util.TranslationReader;

public class SearchPage {
    private final Page page;
    TranslationReader reader = new TranslationReader();

    public SearchPage(Page page) {
        this.page = page;
    }

    // Selectors
    public Locator getCookieSelector() {
         return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(
            reader.getTranslation("cookie.accept")
         ));
    }

    public Locator getSearchField() {
        return page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName(
            reader.getTranslation("search")
        ));
    }

    public Locator getMainSearchField() {
        return page.getByLabel(
            reader.getTranslation("search"),
            new Page.GetByLabelOptions().setExact(true)
        );
    }

    public Locator getSearchButton() {
        return page.getByRole(
            AriaRole.BUTTON,
            new Page.GetByRoleOptions().setName(
                reader.getTranslation("google.search")
        ));
    }

    public Locator getImageResultsButton() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(
            reader.getTranslation("google.results.images")
        ).setExact(true));
    }

    public Locator getVideoResultsButton() {
        return page.locator("#bqHHPb").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(
            reader.getTranslation("google.results.videos")
        ));
    }

    public Locator getAllResultsButton() {
        return page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(
                reader.getTranslation("google.results.all")
        ).setExact(true));
    }


    // Methods
    public void clickCookieAcceptButton(){
        getCookieSelector().click();
    }

    public void search(String searchKeyword) {
        getMainSearchField().fill(searchKeyword);
        getSearchButton().click();
    }

    public void navigateToImageResults() {
        getImageResultsButton().click();
    }

    public void navigateToAllResults() {
        getAllResultsButton().click();
    }

    public void navigateToVideoResults() {
        getVideoResultsButton().click();
    }
}
