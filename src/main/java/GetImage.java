import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class GetImage {

    public String imageUrl;
    public GetImage() {

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\ELI\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        String facebook = "https://www.facebook.com/";
        String profileName = "profile.php?id=100026765677860";

        String url = facebook+profileName;
        driver.get(url);
        driver.manage().window().maximize();

        List<WebElement> circleClass = driver.findElements(By.tagName("image"));
        WebElement circlePress = circleClass.get(0);

        imageUrl = circlePress.getAttribute("xlink:href");
//        System.out.println("Src attribute is: "+ circlePress.getAttribute("xlink:href"));
        driver.close();
    }

}
