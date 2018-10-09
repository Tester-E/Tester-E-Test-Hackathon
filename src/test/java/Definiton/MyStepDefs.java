package Definiton;

import com.google.common.util.concurrent.Uninterruptibles;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class MyStepDefs {

    static {
        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
    }

    private WebDriver driver;


    @When("^I go to \"([^\"]*)\"$")
    public void iGoTo(String website) {
        driver = new FirefoxDriver();
        driver.get(website);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().refresh();

    }

    @And("^I enter city \"([^\"]*)\"$")
    public void iEnterCity(String city) {
        driver.findElement(By.cssSelector(".SearchBoxTextEditor")).click();
        driver.findElement(By.cssSelector(".SearchBoxTextEditor")).sendKeys(city);
        Uninterruptibles.sleepUninterruptibly(1,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".SearchBoxTextEditor")).sendKeys(Keys.ENTER);
    }

    @And("^I choose dates \"([^\"]*)\" \"([^\"]*)\"$")
    public void iChooseDates(String arg0, String arg1) throws Throwable {

        for (int i = 0; i<5; i++){
            driver.findElement(By.cssSelector("span.DayPicker-NavButton:nth-child(2)")).click();
            Thread.sleep(100);
        }

        driver.findElement(By.cssSelector("div.DayPicker-Month:nth-child(2) > div:nth-child(3) > div:nth-child(3) > div:nth-child(6)")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".DayPicker-Day__label--holiday")).click();



    }

    @And("^I choose guest and room$")
    public void iChooseGuestAndRoom() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[7]/div/section[1]/section[1]/div/div[2]/div[1]/div/div[5]/div/div/div/div[3]/span[4]")).click();
        driver.findElement(By.cssSelector(".DropdownInput__box")).click();
        Thread.sleep(200);

        Select dropdown = new Select(driver.findElement(By.cssSelector(".DropdownInput__box")));
        dropdown.selectByIndex(3);

        }

    @And("^I click search$")
    public void iClickSearch() throws Throwable {
        driver.findElement(By.cssSelector("button.btn")).click();
    }

    @And("^I change currency$")
    public void iChangeCurrency() throws Throwable {
    }

    @And("^I set price to max \"([^\"]*)\"$")
    public void iSetPriceToMax(String arg0) throws Throwable {
    }

    @And("^I select rating$")
    public void iSelectRating() throws Throwable {
    }

    @And("^I choose \"([^\"]*)\"$")
    public void iChoose(String arg0) throws Throwable {
    }

    @And("^I click on neihborhoods$")
    public void iClickOnNeihborhoods() throws Throwable {
    }
}
