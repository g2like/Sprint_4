import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobject.MainPage;
import java.util.List;

@RunWith(Parameterized.class)
public class TestCheckFAQ {
    private static WebDriver driver;
    private final String ACCORDIONHEADING;
    private final int INDEX;

    @Before
    public void openBrowser() {
            /*EdgeOptions options = new EdgeOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://qa-scooter.praktikum-services.ru/");*/

            /*ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://qa-scooter.praktikum-services.ru/");*/

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    @Parameterized.Parameters
    public static Object[] questions(){
        MainPage mainPage = new MainPage(driver);
        return mainPage.ACCORDIONHEADINGANDINDEX;
    }
    public TestCheckFAQ(String accorionHeading, int index){
        this.ACCORDIONHEADING = accorionHeading;
        this.INDEX = index;
    }

    @Test
    public void TestCheckFAQ(){
        MainPage mainPage = new MainPage(driver);
        mainPage.findQuestionFAQ();
        Assert.assertEquals(mainPage.ANSWERS[INDEX],mainPage.checkFAQ(INDEX,ACCORDIONHEADING,driver));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
