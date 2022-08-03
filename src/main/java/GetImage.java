import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class GetImage {
    public String imageUrl;
    public GetImage(String Name) throws InterruptedException {

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\\\Users\\\\User\\\\Downloads\\\\chromedriver\\\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(Name);
        driver.manage().window().maximize();

        Thread.sleep(2000);
        List<WebElement> list = driver.findElements(By.tagName("image"));
        WebElement myImage = list.get(0);

        String url1 = driver.getCurrentUrl();

        Actions act = new Actions(driver);
        act.moveToElement(myImage).click().build().perform();

        String url2 = driver.getCurrentUrl();

        if(Objects.equals(url1, url2)) {
           ErrorWindow errorWindow = new ErrorWindow("There is no picture on this profile");
            driver.close();
        }

        imageUrl = myImage.getAttribute("xlink:href");
        driver.close();
    }

}
