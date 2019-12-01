package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

public class GoogleCloudSearchResultsPage {
    private WebDriver driver;

    @FindBy(xpath = "//b[contains(text(),'Google Cloud Platform Pricing Calculator')]/parent::a[@href='https://cloud.google.com/products/calculator/']")
    private WebElement linkToFoundPage;

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPlatformPricingCalculatorPage openFoundPage() {
        linkToFoundPage.click();
        new WebDriverWait(driver, 10)
                .until(CustomConditions.jQueryAJAXsCompleted());

        return new GoogleCloudPlatformPricingCalculatorPage(driver);
    }
}
