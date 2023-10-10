package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatus {
    private WebDriver driver;
    private By elementOrderStatus = By.xpath(".//div/div[2]/div[5]");
    public OrderStatus(WebDriver driver) {
        this.driver = driver;
    }
    public boolean checkOrderReady(){
        return driver.findElement(elementOrderStatus).isDisplayed();
    }

    public boolean checkOrderReadyText(){
        return driver.findElement(elementOrderStatus).getText().contains("Заказ оформлен");
    }

}
