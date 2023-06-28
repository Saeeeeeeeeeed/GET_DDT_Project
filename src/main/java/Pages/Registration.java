package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

public class Registration extends PageBase {

    public Registration(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstname")
    WebElement Firstname;

    @FindBy(id = "last_name")
    WebElement Lastname;

    @FindBy(id = "phone")
    WebElement Phone;

    @FindBy(id = "email")
    WebElement Email;

    @FindBy(id = "password")
    WebElement Password;

    @FindBy(xpath = "/html/body/div[1]/form/div/div/div/div[6]/div/div/iframe")
    public WebElement RobotCheckbox;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]")
    WebElement RobotClick;

    @FindBy(id = "submitBTN")
    WebElement SignUpButton;

    @FindBy(name = "phone_country_code")
    WebElement CityDropDown;

    @FindBy(xpath = "/html/body/header/div/div[2]/div[2]/ul/li[3]")
    WebElement LoginDropDown;

    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/div[2]/ul/li[3]/ul/li[1]/a")
    WebElement LoginClick;

    @FindBy(partialLinkText = "Your account has been created")
    public WebElement RegConfirm;

    @FindBy(partialLinkText = "Login")
    public WebElement LoginConfirm;

    @FindBy(id = "email")
    WebElement LoginEmail;

    @FindBy(id = "password")
    WebElement LoginPassword;

    @FindBy(id = "submitBTN")
    WebElement LoginButton;

    Select selectOption = new Select(CityDropDown);

    public void EnterFirstName (String FirstName)
    {
        SetText(Firstname, FirstName);
    }

    public void EnterLastName (String LastName)
    {
        SetText(Lastname, LastName);
    }

    public void SelectCity(String City)
    {
        selectOption.selectByValue(City);
    }

    public void EnterPhone (String PhoneNumber)
    {
        SetText(Phone, PhoneNumber);
    }

    public void EnterEmail (String EmailAddress)
    {
        SetText(Email, EmailAddress);
    }

    public void EnterPassword (String PassWord)
    {
        SetText(Password, PassWord);
    }

    public void ClickOnCheckbox ()
    {
        //ClickButton(RobotCheckbox);

        ClickButton(RobotClick);
    }

    public void ClickOnSubmit ()
    {
        ClickButton(SignUpButton);
    }

    public void ClickOnAccount ()
    {
        ClickButton(LoginDropDown);
    }

    public void ClickOnLogin ()
    {
        ClickButton(LoginClick);
    }

    public void EnterLoginEmail (String LogEmail)
    {
        SetText(LoginEmail, LogEmail);
    }

    public void EnterLoginPassword (String LogPassword)
    {
        SetText(LoginPassword, LogPassword);
    }

    public void ClickOnLoginButton ()
    {
        ClickButton(LoginButton);
    }
}
