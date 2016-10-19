import Pages.MainAppPage;
import Pages.ResultPage;
import Pages.SignInPage;
import org.omg.CORBA.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.net.smtp.SmtpClient;

import static java.awt.SystemColor.text;

public class TestScript extends MainTestWeb {

    public SignInPage signInPage;
    public MainAppPage mainAppPage;
    public ResultPage resultPage;


    @Test(groups = {"testCH", "testFF"}, priority = 1)
    public void signIn ()  {
        signInPage = new SignInPage(driver);

        assertByPresence(signInPage.frameSignIn, "Failure! Step 0: No ability to sign in");

        switchToFrame(signInPage.frameSignIn, driver);

        assertByPresence(signInPage.signInButton, "Failure! Step 0: No ability to sign in");
        signInPage = new SignInPage(driver);

        signInPage.signInInput(driver);
        signInPage.clickSignInButton(driver);

        assertByAbsence(signInPage.loginError, "Failure! Step 1:" + text);

        mainAppPage = signInPage.clickSignInButton(driver);

        assertByPresence(mainAppPage.mainTable, "Failure! Step 2: Could not access main table in app");
    }


    @Test(groups = {"testCH", "testFF"}, priority = 2, dependsOnMethods = "signIn")
    public void tableApp () {
        selectDropdown(mainAppPage.accessCodeID, getProperty("accessCodeIDValue"));
        selectDropdown(mainAppPage.bureau, getProperty("bureauValue"));
        selectDropdown(mainAppPage.product, getProperty("productValue"));
        printTextField(mainAppPage.ssn, getProperty("ssnValue"), driver);

        resultPage = mainAppPage.clickSubmitButton(driver);
        assertByAbsence(mainAppPage.submitButton, "Failure! Step 3: Table not submitted");
        assertByPresence(resultPage.ssn, "Failure! Step 3: No result recieved");
        Assert.assertTrue(resultPage.ssn.getText().contains(getProperty("ssnValue")));
    }
}


