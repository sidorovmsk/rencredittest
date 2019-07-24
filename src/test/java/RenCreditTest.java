import org.junit.Test;
import steps.BaseSteps;
import steps.ContributionSteps;
import steps.MainSteps;

public class RenCreditTest extends BaseSteps {

     @Test
    public void Test() throws InterruptedException {

        MainSteps mainSteps = new MainSteps();
        ContributionSteps contributionSteps = new ContributionSteps();

        mainSteps.selectMainOperation("Вклады");
        contributionSteps.selectCurrency("Рубли");
        contributionSteps.selectDepositAmount("300000");
        contributionSteps.selectDepositTerm("6");
        contributionSteps.selectAmountToAddPerMonth("50000");
        contributionSteps.tickCheckboxList("Ежемесячная капитализация");
        contributionSteps.tickCheckboxList("Частичное снятие");
        contributionSteps.checkTheRate("6.30%");
        contributionSteps.checkAccrued("13 427,53");
        contributionSteps.checkTotalAdded("250 000");
        contributionSteps.checkResult("563 427,53");
    }
}
