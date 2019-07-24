package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePage {

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//div")
    WebElement mainOperation;

    public void mainOperation(String name) {
        mainOperation.findElement(By.xpath("//div[@class='service__title-text'][text()='" + name + "']/..")).click();
    }
}
