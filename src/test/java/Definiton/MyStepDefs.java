package Definiton;

import com.google.common.util.concurrent.Uninterruptibles;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
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

    @And("^I sign in \"([^\"]*)\" \"([^\"]*)\"$")
    public void iSignIn(String email, String password) throws Throwable {
        driver.findElement(By.cssSelector("#sign-in-btn")).click();
        driver.findElement(By.cssSelector("#signin-email-input")).click();
        driver.findElement(By.cssSelector("#signin-email-input")).sendKeys(email);
        driver.findElement(By.cssSelector("#signin-password-input")).click();
        driver.findElement(By.cssSelector("#signin-password-input")).sendKeys(password);
        driver.findElement(By.cssSelector("#sign-in-submit-button")).click();
        Thread.sleep(5000);
    }

    @And("^I enter city \"([^\"]*)\"$")
    public void iEnterCity(String city) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".SearchBoxTextEditor")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".SearchBoxTextEditor")).sendKeys(city);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

        Select dropdown1 = new Select(driver.findElement(By.cssSelector(".DropdownInput__box")));
        dropdown1.selectByIndex(3);

        }

    @And("^I click search$")
    public void iClickSearch() throws Throwable {
        driver.findElement(By.cssSelector("button.btn")).click();
        Thread.sleep(5000);
    }

    @And("^I change currency$")
    public void iChangeCurrency() throws Throwable {
        driver.findElement(By.cssSelector(".currency-trigger__text")).click();
        driver.findElement(By.cssSelector("li.header-menu__item:nth-child(46) > a:nth-child(1)")).click();
        Thread.sleep(5000);
    }

    @And("^I set price to max \"([^\"]*)\"$")
    public void iSetPriceToMax(String maxprice) throws Throwable {
        driver.findElement(By.cssSelector("#price_box_0")).click();
        driver.findElement(By.cssSelector("#price_box_0")).clear();
        driver.findElement(By.cssSelector("#price_box_0")).sendKeys("0");
        driver.findElement(By.cssSelector("#price_box_0")).sendKeys(Keys.TAB);
        driver.findElement(By.cssSelector("#price_box_1")).sendKeys(maxprice);
        driver.findElement(By.cssSelector("#price_box_1")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @And("^I select rating$")
    public void iSelectRating() throws Throwable {
        driver.findElement(By.cssSelector(".ficon-star-5")).click();
        Thread.sleep(200);
        driver.findElement(By.cssSelector(".ficon-star-4")).click();
        Thread.sleep(200);
        driver.findElement(By.cssSelector(".ficon-star-3")).click();
        Thread.sleep(200);
    }

    @And("^I select location$")
    public void iSelectLocation() throws Throwable {
        driver.findElement(By.cssSelector("#locationScoreFilterList > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > span:nth-child(1)")).click();
        Thread.sleep(200);
    }

    @And("^I choose \"([^\"]*)\"$")
    public void iChoose(String arg0) throws Throwable {

        if (arg0.equals("Family/child friendly")){
            driver.findElement(By.cssSelector("#facilitiesFilterList > div.filter-items > div > a")).click();
            Thread.sleep(200);
            driver.findElement(By.cssSelector("#facilitiesFilterList > div.filter-items > ul > li:nth-child(7) > span")).click();
            Thread.sleep(500);
            }

        else if (arg0.equals("Free cancellation")){
            driver.findElement(By.cssSelector("#paymentoptionFilterList > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > span:nth-child(1) > span:nth-child(2) > span:nth-child(1)")).click();
            Thread.sleep(1000);

        }else if (arg0.equals("Non-smoking")){
            driver.findElement(By.cssSelector("li.filter-item-react:nth-child(8) > span:nth-child(1)")).click();
            Thread.sleep(1000);
        }

        else {
        }

    }


    @And("^I sort the properties by \"([^\"]*)\"$")
    public void iSortThePropertiesBy(String sortcriteria) throws Throwable {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (sortcriteria.equals("Lowest price first")){

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector(".sort-bar > a:nth-child(4)")).click();
            Thread.sleep(3000);
        }

        else if (sortcriteria.equals("GUEST RATING")){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector(".dropdown-wrapper")).click();
            Thread.sleep(3000);

        }else if (sortcriteria.equals("SECRET DEALS")){
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector(".selected")).click();
            Thread.sleep(3000);
        }

        else {
        }

    }

    @And("^I select the property$")
    public void iSelectTheProperty() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#hotel-43144-container > div:nth-child(1) > div:nth-child(1) > section:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(5000);

        Set <String> st= driver.getWindowHandles();
        Iterator<String> it = st.iterator();
        String parent =  it.next();
        String child =it.next();
        //swtich to parent
        driver.switchTo().window(parent);
        System.out.println("Returned to parent");
        // switch to child
        driver.switchTo().window(child);

        driver.findElement(By.cssSelector("div.RoomGridFilter-filter:nth-child(1)")).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector("div.RoomGridFilter-filter:nth-child(2)")).click();
        Thread.sleep(500);

        driver.findElement(By.cssSelector(".ficon-mmb-inbox")).click();
        Thread.sleep(1000);


        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)", "");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#MasterRoom-3124466 > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div.PaymentOptionsModal-detail:nth-child(3) > button:nth-child(4)")).click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div.form-group:nth-child(4) > div:nth-child(1) > label:nth-child(2)")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(500);
        driver.findElement(By.cssSelector(".btn")).click();
        Thread.sleep(3000);
    }



    @And("^I enter card info \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iEnterCardInfo(String cardtype, String cardno, String holdername, String date, String cvccvv) throws Throwable {

        if (cardtype.equals("My saved cards")) {
            Select dropdown2 = new Select(driver.findElement(By.cssSelector("#paymentMethod")));
            dropdown2.selectByIndex(1);
        } else if (cardtype.equals("Visa / MasterCard / JCB / Amex")) {
            Select dropdown2 = new Select(driver.findElement(By.cssSelector("#paymentMethod")));
            dropdown2.selectByIndex(2);
        } else {
        }

        driver.findElement(By.cssSelector("#cardNumber")).click();
        driver.findElement(By.cssSelector("#cardNumber")).sendKeys(cardno);
        driver.findElement(By.cssSelector("#cardHolderName")).click();
        driver.findElement(By.cssSelector("#cardHolderName")).sendKeys(holdername);
        driver.findElement(By.cssSelector("#cardNumber")).click();
        driver.findElement(By.cssSelector("#expiryDate")).sendKeys(date);
        driver.findElement(By.cssSelector("#cvvCode")).click();
        driver.findElement(By.cssSelector("#cvvCode")).sendKeys(cvccvv);
        driver.findElement(By.cssSelector("#issuingBank")).click();
        driver.findElement(By.cssSelector("#issuingBank")).sendKeys("AKBANK");
        Thread.sleep(500);

        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        jse2.executeScript("window.scrollBy(0,500)", "");

        driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
    }
}