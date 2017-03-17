package pageobjects;
        import helpers.LogMessage;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.How;
        import org.openqa.selenium.support.PageFactory;
public class BankAccountsCalculators extends BaseClass{

    public BankAccountsCalculators(WebDriver driver){
        super(driver);
    }

    public static By bankaccount_calculator = By.xpath("//a[normalize-space(text())='Calculators']");
    public static By bankaccount_calculator_bestReturn = By.xpath("//a[normalize-space(text())='Which could give the best return?']");
    public static By ba_calculator_savingAccount = By.xpath("//span[normalize-space(text())=\"Savings Account\"]/parent::a[@data-template=\"wpc-savings-calculator-tmpl\"]");
    public static By ba_sa_initialDeposit = By.xpath("//input[contains(@id, 'wpc-amount-to-save-input')]");
    public static By ba_sa_ongoingSavingAmount = By.xpath("//input[contains(@id,'wpc-ongoing-savings-input')]");
    public static By ba_sa_ongoingSavingFrequency = By.xpath("//select[contains(@id,'wpc-ongoing-savings-frequency')]");
    public static By ba_sa_savingPeriodYear = By.xpath("//input[contains(@id,'wpc-investment-term-years-input')]");
    public static By ba_sa_savingPeriodMonth = By.xpath("//input[contains(@id,'wpc-investment-term-months-input')]");
    public static By ba_sa_savingPeriodDay = By.xpath("//input[contains(@id,'wpc-investment-term-days-input')]");
    public static By ba_sa_interestRate = By.xpath("//input[contains(@id,'wpc-interest-rate-input')]");
    public static By ba_sa_interestPaid = By.xpath("//select[contains(@id,'wpc-interest-payment-frequency')]");
    public static By ba_sa_incomeTaxRate = By.xpath("//select[contains(@id,'cl-income-tax-rate')]");
    public static By ba_sa_summaryTotal = By.xpath("//div[@id='wpc-return-summaries']//table[@class='wpc-summary-totals']/tbody");

    public static By ba_sa_howLongWillItTake = By.xpath("//a[normalize-space(text())='How long will it take']");
    public static final String ba_sa_timeToReachGoalFrame = "westpac-iframe";
    public static By ba_sa_targetAmount = By.xpath("//input[@id='TAMT']");
    public static By ba_sa_savedAlreadyAmount = By.xpath("//input[@id='SAMT']");
    public static By ba_sa_putAsideAmount = By.xpath("//input[@id='RAMT']");
    public static By ba_sa_selectHowOftenFrequency = By.xpath("//select[@id='SFREQ']");
    public static By ba_sa_selectYoyrSavingAccount = By.xpath("//select[@id='SACC']");
    public static By ba_sa_selectYourTaxRate = By.xpath("//select[@id='Tax']");
    public static By ba_sa_submit = By.xpath("//input[@id='submit']");
    public static By ba_sa_timeToReachGoalDetails = By.xpath("//*[@id='resultsdiv']/em/strong[3]");
//    By.xpath("//div[@id='resultsdiv']/em");

}
