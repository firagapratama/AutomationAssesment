package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import config.env_target;

import java.security.Key;

public class Apply extends env_target {
    @Given("User click leave menu")
    public void userClickLeaveMenu() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"))
        );

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

        WebDriverWait waitVerif = new WebDriverWait(driver, 10);
        waitVerif.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6"))
        );

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/span")).click();
    }

    @And("User click apply menu")
    public void userClickApplyMenu() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6"))
        );

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a")).click();
    }

    @And("User fill apply leave")
    public void userFillApplyLeave() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/h6"))
        );

        WebElement dropdownContainer = driver.findElement(By.cssSelector("div.oxd-select-wrapper"));
        dropdownContainer.click();

        WebElement optionToSelect = driver.findElement(By.className("oxd-select-text-input"));
        optionToSelect.click();
        optionToSelect.sendKeys(Keys.ARROW_DOWN);
        optionToSelect.sendKeys(Keys.ENTER);

        WebElement dateStartContainer = driver.findElement(By.cssSelector("div.oxd-date-wrapper"));
        dateStartContainer.click();

        WebElement dateToSelect = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/input"));
        dateToSelect.click();
        dateToSelect.sendKeys("2023-12-12");
        dateToSelect.sendKeys(Keys.ENTER);
    }

    @Then("User click apply")
    public void userClickApply() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button")).click();
        driver.close();
    }

}
