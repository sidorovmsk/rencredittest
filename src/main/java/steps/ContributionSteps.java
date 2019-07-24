package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ContributionPage;

import java.util.concurrent.TimeUnit;

public class ContributionSteps {

    ContributionPage contributionPage = new ContributionPage();
    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);

    @Step("валюта – {сurrency}")
    public void selectCurrency(String сurrency) {
        BaseSteps.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        contributionPage.selectCollectionItem(сurrency, contributionPage.selectCurrency);
    }

    @Step("сумма вклада – {amount}")
    public void selectDepositAmount(String amount) {
        contributionPage.depositAmount.sendKeys(amount);
    }

    @Step("срок вклада - {term}")
    public void selectDepositTerm(String term) {
        Select selectTime = new Select(contributionPage.depositTerm);
        selectTime.selectByValue(term);
    }

    @Step("ежемесячное пополнение на сумму - {addMoney}")
    public void selectAmountToAddPerMonth(String addMoney) {
        wait.until(ExpectedConditions.visibilityOf(contributionPage.totalAddedMoney));
        contributionPage.addMoneyToDeposit.sendKeys(addMoney);
    }

    @Step("отмечаем - {tick}")
    public void tickCheckboxList(String tick) {
        contributionPage.selectCollectionItem(tick, contributionPage.checkBox);
    }

    @Step("ставка - {rate}")
    public void checkTheRate(String rate) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(rate.equalsIgnoreCase(contributionPage.rate.getText()));
    }

    @Step("пополнение - {totalAdded}")
    public void checkTotalAdded(String totalAdded) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(totalAdded.equalsIgnoreCase(contributionPage.totalAddedMoney.getText()));
    }

    @Step("начислено - {accrued}")
    public void checkAccrued(String accrued) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(accrued.equalsIgnoreCase(contributionPage.accrued.getText()));
    }

    @Step("к снятию – {result}")
    public void checkResult(String result) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(result.equalsIgnoreCase(contributionPage.result.getText()));
    }
}
