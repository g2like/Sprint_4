package pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class MainPage {
    private WebDriver driver;
    private By orderButton1 = By.xpath(".//button[1]");
    private By orderButton2 = By.xpath(".//button");
    private By cookie = By.xpath("//*[@id=\"rcc-confirm-button\"]");

    public final String[] ANSWERS = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."};
    public final Object[][] ACCORDIONHEADINGANDINDEX =    {{"accordion__panel-0",0},
            {"accordion__panel-1",1},
            {"accordion__panel-2",2},
            {"accordion__panel-3",3},
            {"accordion__panel-4",4},
            {"accordion__panel-5",5},
            {"accordion__panel-6",6},
            {"accordion__panel-7",7},};

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void order(String button){

        closeCookie();

        if(button == "button1")
            driver.findElement(orderButton1).click();
        else
            driver.findElement(orderButton2).click();
    }

    public void findQuestionFAQ(){
        closeCookie();
        WebElement element = driver.findElement(By.className("accordion"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    public void closeCookie(){
        driver.findElement(cookie).click();
    }

    public String checkFAQ(int index, String heading, WebDriver driver){
        List<WebElement> listOfQuestions = driver.findElements(By.className("accordion__item"));
        listOfQuestions.get(index).click();
        waitSomeTime();
        return driver.findElement(By.id(heading)).getText();
    }

    public void waitSomeTime(){
        new WebDriverWait(driver, Duration.ofSeconds(3));
    }

}
