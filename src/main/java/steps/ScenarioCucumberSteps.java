package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ContributionPage;

import java.util.concurrent.TimeUnit;

public class ScenarioCucumberSteps {

    ContributionPage contributionPage = new ContributionPage();
    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);
    MainSteps mainSteps = new MainSteps();

    @When("^пункт меню \"(.+)\"$")
    public void selectMainOperation(String selectedOperation) {
        mainSteps.selectMainOperation(selectedOperation);
    }

    @When("^валюта – \"(.+)\"$")
    public void selectCurrency(String сurrency) {
        BaseSteps.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        contributionPage.selectCollectionItem(сurrency, contributionPage.selectCurrency);
    }

    @When("^сумма вклада – \"(.+)\"$")
    public void selectDepositAmount(String amount) {
        contributionPage.depositAmount.sendKeys(amount);
    }

    @When("^срок вклада - \"(.+)\"$")
    public void selectDepositTerm(String term) {
        Select timeSelect = new Select(contributionPage.depositTerm);
        timeSelect.selectByValue(term);
    }

    @When("^ежемесячное пополнение на сумму - \"(.+)\"$")
    public void selectAmountToAddPerMonth(String addMoney) {
        wait.until(ExpectedConditions.visibilityOf(contributionPage.totalAddedMoney));
        contributionPage.addMoneyToDeposit.sendKeys(addMoney);
    }

    @When("^отмечаем – \"(.*)\"$")
    public void tickCheckboxList(String tick) {
        contributionPage.selectCollectionItem(tick, contributionPage.checkBox);
    }

    @Then("^ставка - \"(.*)\"$")
    public void checkTheRate(String rate) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(rate.equalsIgnoreCase(contributionPage.rate.getText()));
    }

    @Then("^пополнение - \"(.*)\"$")
    public void checkTotalAdded(String totalAdded) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(totalAdded.equalsIgnoreCase(contributionPage.totalAddedMoney.getText()));
    }

    @Then("^начислено - \"(.*)\"$")
    public void checkAccrued(String accrued) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(accrued.equalsIgnoreCase(contributionPage.accrued.getText()));
    }

    @Then("^к снятию – \"(.*)\"$")
    public void checkResult(String result) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(result.equalsIgnoreCase(contributionPage.result.getText()));
    }
}
