package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudPlatformPricingCalculatorPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[contains(text(), 'Compute Engine')]/ancestor::md-tab-item[@class='md-tab ng-scope ng-isolate-scope md-ink-ripple md-active']")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//b[contains(text(), 'Total Estimated Cost')]")
    private WebElement totalEstimatedCost;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement frame;

    public GoogleCloudPlatformPricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ComputeEngineForm selectComputeEngine() {
        driver.switchTo().frame(frame);
        computeEngineButton.click();

        return new ComputeEngineForm(driver);
    }

    public String findPrice() {
        String textWithPrice;
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//h2[contains(text(), 'Estimate')]/ancestor::md-card-content[@id='resultBlock']")));
        textWithPrice = totalEstimatedCost.getText();

        return textWithPrice;
    }

}
