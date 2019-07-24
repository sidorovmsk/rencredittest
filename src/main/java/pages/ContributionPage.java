package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class ContributionPage extends BasePage {

    public ContributionPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='calculator__currency-field-text']")
    public List<WebElement> selectCurrency;

    @FindBy(xpath = "//input[@name='amount']")
    public WebElement depositAmount;

    @FindBy(tagName = "select")
    public WebElement depositTerm;

    @FindBy(xpath = "//input[@name='replenish']")
    public WebElement addMoneyToDeposit;

    @FindBy(xpath = "//span[@class='calculator__check-text']")
    public List<WebElement> checkBox;

    @FindBy(xpath = "//span[@class='js-calc-rate']")
    public WebElement rate;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    public WebElement accrued;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    public WebElement totalAddedMoney;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    public WebElement result;

    @Override
    public void selectCollectionItem(String itemName, List<WebElement> collection) {
        super.selectCollectionItem(itemName, collection);
    }
}
