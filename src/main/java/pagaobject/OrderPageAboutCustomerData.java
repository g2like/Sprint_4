package pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPageAboutCustomerData {
    private WebDriver driver;
    private By firstNameForm = By.xpath(".//div[2]/div[1]/input");
    private By lastNameForm = By.xpath(".//div[2]/div[2]/input");
    private By addressOrderForm = By.xpath(".//div[2]/div[3]/input");
    private By metroStationForm = By.className("select-search__input");
    private By numberPhoneClientForm = By.xpath(".//div[2]/div[5]/input");

    private By buttonNext = By.xpath(".//div[2]/div[3]/button");

    public OrderPageAboutCustomerData(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFields(String nameClient, String surnameClient, String addressClient, String nameStationClient, String numberClient) {
        driver.findElement(firstNameForm).sendKeys(nameClient);
        driver.findElement(lastNameForm).sendKeys(surnameClient);
        driver.findElement(addressOrderForm).sendKeys(addressClient);
        chooseStation(nameStationClient);
        driver.findElement(numberPhoneClientForm).sendKeys(numberClient);
        driver.findElement(buttonNext).click();
    }

    public void showMetroList(String nameStationClient){
        WebElement element = driver.findElement(metroStationForm);
        element.click();
        element.sendKeys(nameStationClient);
    }
    public void chooseStation(String nameStation){
        showMetroList(nameStation);
        String stationOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        List<WebElement> stationList = driver.findElements(By.xpath(String.format(stationOptionTemplate,nameStation)));
        stationList.get(0).click();
    }
}
