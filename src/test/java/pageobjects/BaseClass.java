package pageobjects;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static helpers.Constant.*;
import static pageobjects.BankAccountsCalculators.ba_sa_summaryTotal;

public abstract class BaseClass {

	public static WebDriver driver;
	public static boolean bResult;

	public BaseClass(WebDriver driver) {
		BaseClass.driver = driver;
		BaseClass.bResult = true;
	}

	private static WebDriver driver() {
		return driver;
	}

	public static void clickLink(final By by) {
		WebElement webElement = null;
		try {
			webElement = (new WebDriverWait(driver(), MAX_WAIT, 1000))
					.until(ExpectedConditions.presenceOfElementLocated(by));

			highlightElement(driver(), webElement);
		} catch (ElementNotFoundException e) {
		}
		webElement.click();
	}

	public static void clickButton(final By by) {
		WebElement webElement = null;
		try {
			webElement = (new WebDriverWait(driver(), MAX_WAIT, 1000))
					.until(ExpectedConditions.presenceOfElementLocated(by));

			highlightElement(driver(), webElement);
		} catch (ElementNotFoundException e) {
		}
		webElement.click();
	}

	public static void enterText(final By by, String text) {
		WebElement webElement = null;
		try {
			webElement = (new WebDriverWait(driver(), MAX_WAIT, 1000))
					.until(ExpectedConditions.presenceOfElementLocated(by));

			highlightElement(driver(), webElement);
		} catch (ElementNotFoundException e) {
		}
//		webElement.clear();
//		webElement.sendKeys(Keys.DELETE);
		webElement.sendKeys(Keys.CONTROL + "a");
		webElement.sendKeys(text);
	}

	public static void selectByVisibleText(final By by, String listItem) {
		WebElement webElement = null;
		try {
			webElement = (new WebDriverWait(driver(), MAX_WAIT, 1000))
					.until(ExpectedConditions.presenceOfElementLocated(by));

			highlightElement(driver(), webElement);
		} catch (ElementNotFoundException e) {
		}
		Select select = new Select(webElement);
		boolean listFlag = false;

		List<WebElement> listElements = select.getOptions();
		for (WebElement element : listElements) {
			if (element.getText().contains(listItem)) {
				select.selectByVisibleText(element.getText());
				listFlag = true;
			}
		}
		if (!listFlag) {
			throw new NoSuchElementException("Cannot locate element with text: " + listItem);
		}
	}

	/*	public static String webTable(final By by, String text, String text){
            WebElement webElement = null;
            try {
                webElement = (new WebDriverWait(driver(), MAX_WAIT, 1000))
                        .until(ExpectedConditions.presenceOfElementLocated(by));

                highlightElement(driver(), webElement);
            }catch (ElementNotFoundException e){
            }
    //		return webTableGetCellData();
            System.out.println("text selected");
        }*/
	public static void hoverAndclick(final By sourceby, final By targetby) {
		WebElement webElement1 = null, webElement2 = null;
		Actions actions = new Actions(driver);
		try {
			webElement1 = (new WebDriverWait(driver(), MAX_WAIT, 1000))
					.until(ExpectedConditions.presenceOfElementLocated(sourceby));

			highlightElement(driver(), webElement1);
		} catch (ElementNotFoundException e) {
		}

		actions.moveToElement(webElement1);
		try {
			webElement2 = (new WebDriverWait(driver(), MAX_WAIT, 1000))
					.until(ExpectedConditions.presenceOfElementLocated(targetby));

			highlightElement(driver(), webElement2);
		} catch (ElementNotFoundException e) {
		}
		actions.moveToElement(webElement1).moveToElement(webElement2).click().perform();
	}

	private static void highlightElement(WebDriver driver, WebElement element) {
		if (driver() != null)
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='1px outset red'", element);
	}

	public static String GetValueWithTextFromTable(final By by, String columText) {
		WebElement webElement = null;
		try {
			webElement = (new WebDriverWait(driver(), MAX_WAIT, 1000))
					.until(ExpectedConditions.presenceOfElementLocated(by));

			highlightElement(driver(), webElement);
		} catch (ElementNotFoundException e) {
		}
		String dataCellData = null;
		//Get number of rows In table.
		int Row_count = webElement.findElements(By.xpath("./tr")).size();

		//Get number of columns In table.
		int Col_count = webElement.findElements(By.xpath("./tr[1]/td")).size();

		//Extract data
		for (int i = 1; i <= Row_count; i++) {
//			for (int j = 1; j <= Col_count; j++) {
			WebElement dataCellT = webElement.findElement(By.xpath("./tr[" + i + "]/td[1]"));
			if (dataCellT.getText().toLowerCase().contains(columText.toLowerCase())) {
				WebElement dataCellA = webElement.findElement(By.xpath("./tr[" + i + "]/td[2]"));
				dataCellData = dataCellA.getText();
//					i = Row_count+1;
				break;
			}
//			}
		}
		return dataCellData;
	}

	public static void switchToFrame(String str) {
		driver().switchTo().frame(str);
	}
	public static void waitForPageToBeReady()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//This loop will rotate for 120 times to check If page Is ready after every 1 second.
		for (int i=0; i<120; i++)
		{
			try
			{
				Thread.sleep(1000);
			}catch (InterruptedException e) {}
			//To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete"))
			{
				break;
			}
		}
	}

	public static String getText(final By by ) {
		WebElement webElement = null;
		try {
			webElement = (new WebDriverWait(driver(), MAX_WAIT, 1000))
					.until(ExpectedConditions.presenceOfElementLocated(by));

			highlightElement(driver(), webElement);
		} catch (ElementNotFoundException e) {
		}
		return webElement.getText();

	}
}
