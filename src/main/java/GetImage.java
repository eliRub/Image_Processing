import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class GetImage {

    public String imageUrl;
    public GetImage(String Name) {

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Eliyahu toronto\\Dropbox\\PC\\Downloads\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(Name);
        driver.manage().window().maximize();

        List<WebElement> circleClass = driver.findElements(By.tagName("image"));
        WebElement circlePress = circleClass.get(0);

        imageUrl = circlePress.getAttribute("xlink:href");
        driver.close();
    }

}
