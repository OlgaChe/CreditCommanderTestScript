package Pages;

import Data.MainMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Olga Cherniak on 9/5/2016.
 */
public class MainAppPage extends MainMethods{

    @FindBy(name = "AccessCodeID")
    public WebElement accessCodeID;

    @FindBy(name = "Bureau")
    public WebElement bureau;

    @FindBy(name = "Product")
    public WebElement product;

    @FindBy(name="AppSocial")
    public WebElement ssn;

    @FindBy(id="fbSubmit")
    public WebElement submitButton;

    @FindBy(xpath = ".//*[@id='MainApp']/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td")
    public WebElement mainTable;

    public ResultPage clickSubmitButton(WebDriver driver) {
        clickElement(submitButton, driver);
        return PageFactory.initElements(driver, ResultPage.class);
    }
}
