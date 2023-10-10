package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPageAboutRent {
    private WebDriver driver;

    private By dataForm = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentPeriodForm = By.className("Dropdown-root");

    private By blackColorScooter = By.xpath(".//input[@id='black']");
    private By greyColorScooter = By.xpath(".//input[@id='grey']");
    private By commentForm = By.xpath(".//div[4]/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");

    public OrderPageAboutRent(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPageAboutRent(String data, String color, String period, String comment) {
        chooseData(data);
        rendPeriod(period);
        chooseColor(color);
        driver.findElement(commentForm).sendKeys(comment);
        orderClick();
    }

    public void rendPeriod(String period){
        driver.findElement(rentPeriodForm).click();
        switch (period){
            case "сутки": driver.findElement(By.xpath(".//div[2]/div[1][@class='Dropdown-option']")).click();
                break;
            case "двое суток": driver.findElement(By.xpath(".//div[2]/div[2][@class='Dropdown-option']")).click();
                break;
            case "трое суток": driver.findElement(By.xpath(".//div[2]/div[3][@class='Dropdown-option']")).click();
                break;
            case "четверо суток": driver.findElement(By.xpath(".//div[2]/div[4][@class='Dropdown-option']")).click();
                break;
            case "пятеро суток": driver.findElement(By.xpath(".//div[2]/div[5][@class='Dropdown-option']")).click();
                break;
            case "шестеро суток": driver.findElement(By.xpath(".//div[2]/div[6][@class='Dropdown-option']")).click();
                break;
            case "семеро суток": driver.findElement(By.xpath(".//div[2]/div[7][@class='Dropdown-option']")).click();
                break;
            default:
                break;
        }
    }

    public void chooseColor(String color){
        if(color == "черный")
            driver.findElement(blackColorScooter).click();
        else
            driver.findElement(greyColorScooter).click();
    }


    public void chooseData(String data){
        driver.findElement(dataForm).sendKeys(data);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div")).click();
    }

    public void orderClick(){
        //new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.findElement(By.xpath(".//div[2]/div[3]/button[2]")).click();
        driver.findElement(By.xpath(".//div[5]/div[2]/button[2]")).click();
    }

}
