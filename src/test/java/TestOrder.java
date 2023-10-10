import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageobject.OrderPageAboutCustomerData;
import pageobject.MainPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.OrderPageAboutRent;
import org.junit.Assert;
import pageobject.OrderStatus;


@RunWith(Parameterized.class)
public class TestOrder {

    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String station;
    private final String number;
    private final String button;
    private final String data;
    private final String period;
    private final String color;
    private final String comment;


    public TestOrder(String name, String surname, String adress, String station, String number, String button, String data, String period, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = adress;
        this.station = station;
        this.number = number;
        this.button = button;
        this.data = data;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] valueFields() {
        return new Object[][]{
                {"Сергей", "Толкачев", "ул.Ленина,д.1", "Сокольники", "89222266622", "button1", "6.10.2023", "пятеро суток", "черный", "Серега"},
                {"Юлия", "Толкачева", "ул.Сталина, д.2", "Черкизовская", "89111122233", "button2", "15.10.2023", "четверо суток", "Любой цвет кроме черного", "Юля"},
        };

    }

    @Before
    public void openBrowser(){
            /*EdgeOptions options = new EdgeOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://qa-scooter.praktikum-services.ru/");*/

           /* ChromeOptions options = new ChromeOptions();
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

    @Test
    public void testOrder(){
        MainPage objHomePageScooter = new MainPage(driver);
        OrderPageAboutCustomerData fillCustomerData = new OrderPageAboutCustomerData(driver);
        OrderPageAboutRent fillAboutRent = new OrderPageAboutRent(driver);
        OrderStatus orderStatus = new OrderStatus(driver);

        objHomePageScooter.order(button);
        fillCustomerData.fillFields(name,surname,address,station,number);
        fillAboutRent.fillPageAboutRent(data,color,period,comment);
        Assert.assertEquals("false",true,orderStatus.checkOrderReady());
        Assert.assertEquals("false",true,orderStatus.checkOrderReadyText());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}

