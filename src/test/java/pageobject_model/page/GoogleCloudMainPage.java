package pageobject_model.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

public class GoogleCloudMainPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;

    @FindBy(xpath = "//form[@class='devsite-search-form']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@class='devsite-search-field devsite-search-query']")
    private WebElement searchLine;

    public GoogleCloudMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudMainPage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(CustomConditions.jQueryAJAXsCompleted());

        return this;
    }

    public GoogleCloudSearchResultsPage searchByTerm(String term) {
        searchButton.click();
        searchLine.sendKeys(term);
        searchLine.sendKeys(Keys.ENTER);

        return new GoogleCloudSearchResultsPage(driver);
    }

}
