package step_definitions;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import cucumber.api.DataTable;
 import helpers.Config;
 import helpers.LogMessage;
 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.PageFactory;
 import pageobjects.BankAccountsCalculators;
 import pageobjects.HomePage;
 import cucumber.api.java.en.Given;
 import cucumber.api.java.en.When;
 import cucumber.api.java.en.Then;
 import cucumber.api.java.en.And;
 import static org.testng.AssertJUnit.assertEquals;
 import static pageobjects.BankAccountsCalculators.*;
 import static pageobjects.HomePage.*;
 import static pageobjects.HomePage.BankAccounts.*;
public class BankAccountCalculatorStepDefs {
    public WebDriver driver;
    public String TaxRate=null;
    private Config config;
    public BankAccountCalculatorStepDefs()
    {
        driver = Hooks.driver;
    }

    @Given("^User is on Bank Account calculator page$")
    public void User_is_on_Bank_Account_calculator_page() throws Throwable {
        PageFactory.initElements(driver, HomePage.class);
        config = new Config();
        driver.get(config.getAppurl());
        HomePage.clickLink(personal);
        HomePage.hoverAndclick(bank_accounts,bankaccount_calculator);
    }
    @When("^User clicks on which could give the best return and$")
    public void user_clicks_on_which_could_give_the_best_return() throws Throwable {
        // Write code here that turns the phrase above into concrete action throw new PendingException();
        PageFactory.initElements(driver, BankAccountsCalculators.class);
        BankAccountsCalculators.clickLink(bankaccount_calculator_bestReturn);
    }
    @Then("^User clicks on Saving Account calculator$")
    public void user_clicks_on_Saving_Account() throws Throwable {
        // Write code here that turns the phrase above into concrete actions throw new PendingException();
        PageFactory.initElements(driver, BankAccountsCalculators.class);
        BankAccountsCalculators.clickLink(ba_calculator_savingAccount);
    }

    @And("^Fill below details for best return$")
//    public void fill_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
      public void Fill_below_details_for_best_return(DataTable tableData) throws Throwable {
        String Initial_Deposit=null,Ongoing_SavingAmount=null,Ongoing_SavingFrequency=null;
        String Saving_PeriodYear=null,Saving_PeriodMonth=null,Interest_Rte=null;
        List<Map<String, String>> data = tableData.asMaps(String.class, String.class);
        for (Map map : data) {
            Initial_Deposit = map.get("Initial_Deposit").toString();
            Ongoing_SavingAmount = map.get("Ongoing_SavingAmount").toString();
            Ongoing_SavingFrequency = map.get("Ongoing_SavingFrequency").toString();
            Saving_PeriodYear = map.get("Saving_PeriodYear").toString();
            Saving_PeriodMonth = map.get("Saving_PeriodMonth").toString();
            Interest_Rte = map.get("Interest_Rte").toString();
        }
        BankAccountsCalculators.enterText(ba_sa_initialDeposit,Initial_Deposit);
        BankAccountsCalculators.enterText(ba_sa_ongoingSavingAmount,Ongoing_SavingAmount);
        BankAccountsCalculators.selectByVisibleText(ba_sa_ongoingSavingFrequency,Ongoing_SavingFrequency);
        BankAccountsCalculators.enterText(ba_sa_savingPeriodYear,Saving_PeriodYear);
        BankAccountsCalculators.enterText(ba_sa_savingPeriodMonth,Saving_PeriodMonth);
        BankAccountsCalculators.enterText(ba_sa_savingPeriodDay,"0");
        BankAccountsCalculators.selectByVisibleText(ba_sa_incomeTaxRate,Interest_Rte);
    }

    @Then("^Saving Account earning details are displayed with and without tax$")
    public void saving_Account_earning_details_are_displayed_with_and_without_tax(DataTable tabledata) throws Throwable {
        String Tax_On_Interest=null,Dep_Plus_In_BeforeTAx=null,Dep_Plus_In_AfterTAx=null;
        // Write code here that turns the phrase above into concrete actions throw new PendingException();
        PageFactory.initElements(driver, BankAccountsCalculators.class);
        String Dep_Int_Bef_Tax=null,Tax_On_In=null,Dep_Int_Aft_Tax=null;
        List<Map<String, String>> data = tabledata.asMaps(String.class, String.class);
        for (Map map : data) {
            Dep_Int_Bef_Tax = map.get("Dep_Int_Bef_Tax").toString();
            Tax_On_In = map.get("Tax_On_In").toString();
            Dep_Int_Aft_Tax = map.get("Dep_Int_Aft_Tax").toString();
        }
        Dep_Plus_In_BeforeTAx=BankAccountsCalculators.GetValueWithTextFromTable(ba_sa_summaryTotal,"Deposits Plus Interest Before Tax:");
        Tax_On_Interest=BankAccountsCalculators.GetValueWithTextFromTable(ba_sa_summaryTotal,"Tax On Interest");
        Dep_Plus_In_AfterTAx=BankAccountsCalculators.GetValueWithTextFromTable(ba_sa_summaryTotal,"Deposits Plus Interest After Tax:");
        LogMessage.info("Before Tax Amount " + Dep_Plus_In_BeforeTAx  );
        assertEquals("Deposit Plus Interest Before Tax",Dep_Int_Bef_Tax,Dep_Plus_In_BeforeTAx);
        assertEquals("Tax on Interest",Tax_On_In,Tax_On_Interest);
        assertEquals("Deposit Plus Interest After Tax",Dep_Int_Aft_Tax,Dep_Plus_In_AfterTAx);
    }
    @When("^User clicks on How long will it take you to reach your goal$")
    public void user_clicks_on_How_long_will_it_take_you_to_reach_your_goal() throws Throwable {
        // Write code here that turns the phrase above into concrete actions throw new PendingException();
        PageFactory.initElements(driver, BankAccountsCalculators.class);
        BankAccountsCalculators.clickLink(ba_sa_howLongWillItTake);
    }
    @And("^Fill below details for goal$")
    public void fill_below_details_for_goal(DataTable tabledata) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc) throw new PendingException();
        PageFactory.initElements(driver, BankAccountsCalculators.class);
        String Target_Amount=null,Saved_Already=null,Put_Aside_Regularly=null;
        String Frequency=null,Saving_Account=null,Tax_Rte=null;
        List<Map<String, String>> data = tabledata.asMaps(String.class, String.class);
        for (Map map : data) {
            Target_Amount = map.get("Target_Amount").toString();
            Saved_Already = map.get("Saved_Already").toString();
            Put_Aside_Regularly = map.get("Put_Aside_Regularly").toString();
            Frequency = map.get("Frequency").toString();
            Saving_Account = map.get("Saving_Account").toString();
            Tax_Rte = map.get("Tax_Rte").toString();
        }
        BankAccountsCalculators.waitForPageToBeReady();
        BankAccountsCalculators.switchToFrame(ba_sa_timeToReachGoalFrame);
//        driver.switchTo().frame("westpac-iframe");
        BankAccountsCalculators.enterText(ba_sa_targetAmount,Target_Amount);
        BankAccountsCalculators.enterText(ba_sa_savedAlreadyAmount,Saved_Already);
        BankAccountsCalculators.enterText(ba_sa_putAsideAmount,Put_Aside_Regularly);
        BankAccountsCalculators.selectByVisibleText(ba_sa_selectHowOftenFrequency,Frequency);
        BankAccountsCalculators.selectByVisibleText(ba_sa_selectYoyrSavingAccount,Saving_Account);
        BankAccountsCalculators.selectByVisibleText(ba_sa_selectYourTaxRate,Tax_Rte);
        BankAccountsCalculators.clickButton(ba_sa_submit);
    }
    @Then("^Time to reach goal calculated details are displayed$")
    public void Time_to_reach_goal_calculated_details_are_displayed(DataTable tabledata) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc) throw new PendingException();
        String Time_To_Reach_Goal=null;
        List<Map<String, String>> data = tabledata.asMaps(String.class, String.class);
        for (Map map : data) {
            Time_To_Reach_Goal = map.get("Time_To_Reach_Goal").toString();
        }
        LogMessage.info( "Time to Reach Goal " + BankAccountsCalculators.getText(ba_sa_timeToReachGoalDetails));
        assertEquals("Time To Reach Goal", Time_To_Reach_Goal,BankAccountsCalculators.getText(ba_sa_timeToReachGoalDetails));
    }

}