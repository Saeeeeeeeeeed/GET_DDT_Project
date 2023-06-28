package Tests;

import Data.JsonDataReader;
import Pages.Registration;
import org.asynchttpclient.util.Assertions;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegistrationTest extends TestBase{

    Registration registrationObject;



    @Test
    public void RegistrationSuccessfully () throws IOException, ParseException {
        JsonDataReader jsonReader = new JsonDataReader();
        jsonReader.JsonReader();

        registrationObject = new Registration(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationObject.EnterFirstName(jsonReader.firstname);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationObject.EnterLastName(jsonReader.lastname);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationObject.SelectCity(jsonReader.cityValue);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationObject.EnterPhone(jsonReader.phone);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationObject.EnterEmail(jsonReader.emailAddress);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationObject.EnterPassword(jsonReader.password);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame(registrationObject.RobotCheckbox);
        registrationObject.ClickOnCheckbox();
        registrationObject.ClickOnSubmit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(registrationObject.RegConfirm.getText().contains("Your account has been created"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationObject.ClickOnAccount();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationObject.ClickOnLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationObject.EnterLoginEmail(jsonReader.emailAddress);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationObject.EnterLoginPassword(jsonReader.password);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registrationObject.ClickOnLoginButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertFalse(registrationObject.LoginConfirm.getText().contains("Login"));
    }
}
