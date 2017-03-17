package pageobjects;
        import helpers.LogMessage;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.How;
        import org.openqa.selenium.support.PageFactory;
public class HomePage extends BaseClass{

    public HomePage(WebDriver driver){
        super(driver);
    }
    public static By personal = By.xpath("//a[@class='sw-header-menu-link selected' and text()='Personal']");
    public static By login = By.xpath("//*[@id='login-box-ps']/div/span/button");

    public static class BankAccounts
    {
        public static By bank_accounts = By.xpath("//a[@id='ubermenu-section-link-bank-accounts-ps']");

//        @FindBy(how=How.XPATH, using="//a[@id='ubermenu-section-link-bank-accounts-ps']")
//        public static WebElement bank_accounts;

    }

}
