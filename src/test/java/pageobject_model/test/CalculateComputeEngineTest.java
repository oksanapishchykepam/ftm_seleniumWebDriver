package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.GoogleCloudMainPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateComputeEngineTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup()
    {
        driver = new ChromeDriver();
    }

    @Test(description = "SeleniumWebDriver Hometask 3")
    public void computeEnginePriceIsCorrect() {
        String foundPrice = new GoogleCloudMainPage(driver)
                .openPage()
                .searchByTerm("Google Cloud Platform Pricing Calculator")
                .openFoundPage()
                .selectComputeEngine()
                .inputNumberOfInstances()
                .chooseOperatingSystem()
                .chooseVmClass()
                .chooseInstancetype()
                .addGpu()
                .chooseNumberOfGpu()
                .chooseTypeOfGpu()
                .chooseLocalSsd()
                .chooseDataCenterLocation()
                .chooseCommittedUsage()
                .addToEstimate()
                .findPrice();

        String regex = ".*USD ([0-9,.]*).*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(foundPrice);

        if(matcher.find()) {
            Assert.assertEquals(matcher.group(1), "1,082.77", "Compute Engine Price is correct");
        } else {
            Assert.fail("No Compute Engine Price is found");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
