package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComputeEngineForm {
    private WebDriver driver;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//label[contains(text(), 'Operating System / Software')]/following-sibling::md-select")
    private WebElement operatingSystemField;

    @FindBy(xpath = "//div[contains(text(), 'Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS')]/parent::md-option")
    private WebElement operatingSystemOption;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']/child::md-select-value")
    private WebElement machineClassField;

    @FindBy(xpath = "//div[contains(text(), 'Regular')]/parent::md-option[@id='select_option_67']")
    private WebElement machineClassOption;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement instanceTypeField;

    @FindBy(xpath = "//div[contains(text(), 'n1-standard-8 (vCPUs: 8, RAM: 30GB)')]/parent::md-option")
    private WebElement instanceTypeOption;

    @FindBy(xpath = "//div[contains(text(), 'Add GPU')]/ancestor::md-checkbox")
    private WebElement addGpuButton;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']/child::md-select-value")
    private WebElement numberOfGpuField;

    @FindBy(xpath = "//div[contains(text(), '1')]/parent::md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]']")
    private WebElement numberOfGpuOption;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']/child::md-select-value")
    private WebElement typeOfGpuField;

    @FindBy(xpath = "//div[contains(text(), 'NVIDIA Tesla P100')]/parent::md-option")
    private WebElement typeOfGpuOption;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']/child::md-select-value")
    private WebElement localSsdField;

    @FindBy(xpath = "//div[contains(text(), '2x375 GB')]/parent::md-option")
    private WebElement localSsdOption;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']/child::md-select-value[@id='select_value_label_51']")
    private WebElement dataCenterLocationField;

    @FindBy(xpath = "//div[contains(text(), 'Frankfurt (europe-west3)')]/parent::md-option[@id='select_option_185']")
    private WebElement dataCenterLocationOption;

    @FindBy(xpath = "//md-select[@id='select_85' and @placeholder='Committed usage']")
    private WebElement committedUsageField;

    @FindBy(xpath = "//div[contains(text(), '1 Year')]/parent::md-option[@id='select_option_83']")
    private WebElement committedUsageOption;

    @FindBy(xpath = "//h2[contains(text(), 'Instances')]/following-sibling::div/button[contains(text(), 'Add to Estimate')]")
    private WebElement addToEstimateButton;

    public ComputeEngineForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ComputeEngineForm inputNumberOfInstances() {
        numberOfInstancesField.sendKeys("4");

        return this;
    }

    public ComputeEngineForm chooseOperatingSystem() {
        operatingSystemField.click();

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(operatingSystemOption));
        operatingSystemOption.click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.invisibilityOf(operatingSystemOption));

        return this;
    }

    public ComputeEngineForm chooseVmClass() {
        machineClassField.click();

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(machineClassOption));
        machineClassOption.click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.invisibilityOf(machineClassOption));

        return this;
    }

    public ComputeEngineForm chooseInstancetype() {
        instanceTypeField.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(instanceTypeOption));
        instanceTypeOption.click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.invisibilityOf(instanceTypeOption));

        return this;
    }

    public ComputeEngineForm addGpu() {
        addGpuButton.click();

        return this;
    }

    public ComputeEngineForm chooseNumberOfGpu() {
        numberOfGpuField.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(numberOfGpuOption));
        numberOfGpuOption.click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.invisibilityOf(numberOfGpuOption));

        return this;
    }

    public ComputeEngineForm chooseTypeOfGpu() {
        typeOfGpuField.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(typeOfGpuOption));
        typeOfGpuOption.click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.invisibilityOf(typeOfGpuOption));

        return this;
    }

    public ComputeEngineForm chooseLocalSsd() {
        localSsdField.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(localSsdOption));
        localSsdOption.click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.invisibilityOf(localSsdOption));

        return this;
    }

    public ComputeEngineForm chooseDataCenterLocation() {
        dataCenterLocationField.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(dataCenterLocationOption));
        dataCenterLocationOption.click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.invisibilityOf(dataCenterLocationOption));

        return this;
    }

    public ComputeEngineForm chooseCommittedUsage() {
        committedUsageField.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(committedUsageOption));
        committedUsageOption.click();
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.invisibilityOf(committedUsageOption));

        return this;
    }

    public GoogleCloudPlatformPricingCalculatorPage addToEstimate() {
        addToEstimateButton.click();

        return new GoogleCloudPlatformPricingCalculatorPage(driver);
    }
}
