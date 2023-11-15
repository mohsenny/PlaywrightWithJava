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
            reader.getTranslation("google.search"),
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

    // Methods
    public void clickCookieAcceptButton(){
        getCookieSelector().click();
    }

    public void search(String searchKeyword) {
        getMainSearchField().fill(searchKeyword);
        getSearchButton().click();
    }

    public void navigateToImageResults() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Bilder").setExact(true)).click();
    }

    public void navigateToAllResults() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("All").setExact(true)).click();
    }

    public void navigateToVideoResults() {
        page.locator("#bqHHPb").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Videos")).click();
    }
}
