package testautomation.common.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EmailFlow {
    WebDriver driver;
    WebDriverWait wait;

    public EmailFlow(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By getEmail = By.xpath("//div[@class='field--value js-email']");
    By responseEmailID = By.xpath("//div[@class='sender--email sender-email-js']");

    public String getMailID() {
        String mailID = driver.findElement(getEmail).getText();
        return mailID;
    }

    public List<WebElement> findEmailIDinResponse() {
        List<WebElement> elementsForResponseEmailID = null;
        try {
            elementsForResponseEmailID = driver.findElements(responseEmailID);
        } catch (Exception e){
            
        }
    
        return elementsForResponseEmailID;
    }
}
