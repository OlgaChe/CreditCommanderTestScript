package Data;

import Pages.ResultPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainMethods extends ConfigProperties {

    public WebDriver driver;

    public void waitForElement(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public ResultPage clickElement(WebElement button, WebDriver driver) {
        waitForElement(button, driver);
        button.click();
        return null;
    }

    public void printTextField(WebElement element, String text, WebDriver driver) {
        waitForElement(element, driver);
        element.sendKeys(text);
    }


    public void hoverOverElement(WebElement element, WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void dragToClick(WebElement drag, WebElement click, WebDriver driver) {
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(drag)
                .moveToElement(click)
                .release(click)
                .build();
        dragAndDrop.perform();
        click.click();
    }

    public void switchToFrame(WebElement frame, WebDriver driver) {
        driver.switchTo().frame(frame);
    }

    public void selectDropdown(WebElement dropDown, String text) {
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void assertByPresence(WebElement expected, String text){
        try {
            Assert.assertTrue(expected.isDisplayed());
        }catch (NoSuchElementException e) {
            System.out.println(text);
            throw e;
        }
    }

    public void assertByAbsence(WebElement expected, String text){
        try {
            text = expected.getText();
            Assert.assertTrue(!expected.isDisplayed(), text);
        }catch (NoSuchElementException e) {

        }
    }

}
