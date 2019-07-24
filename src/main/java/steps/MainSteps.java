package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {

    @Step("пункт меню - {selectedOperation}")
    public void selectMainOperation(String selectedOperation) {
        new MainPage().mainOperation(selectedOperation);
    }
}
