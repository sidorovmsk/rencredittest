package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class BasePage {
    WebDriver driver = BaseSteps.getDriver();

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public void selectCollectionItem(String itemName, List<WebElement> collection) {
        for (WebElement item : collection) {
            if (item.getText().equalsIgnoreCase(itemName)) {
                item.click();
                return;
            }
        }
        Assert.fail("Не найден элемент коллекции - " + itemName);
    }
}
