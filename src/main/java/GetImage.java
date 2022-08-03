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
    public GetImage(String Name) {

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\\\Users\\\\ELI\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(Name);
        driver.manage().window().maximize();

        List<WebElement> list = driver.findElements(By.tagName("image"));
        WebElement myImage = list.get(0);

        String url1 = driver.getCurrentUrl();

        Actions act = new Actions(driver);
        act.moveToElement(myImage).click().build().perform();

        String url2 = driver.getCurrentUrl();

        if(Objects.equals(url1, url2)) {
            System.out.println("\n \n \nThere is no picture on this profile \n \n \n");   //  כאן במקום להדפיס לקןנסול צריך לפתוח חלון כרפי חדש
            try {
                Thread.sleep(5000);                           //  כאן כתבתי לו לחכות 5 שניות סתם בשביל שיהיה לי יותר ברור שפה אין תמןנה אפשר להוריד את זה
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.close();
            PanelWindow panelWindow = new PanelWindow();
        }

        imageUrl = myImage.getAttribute("xlink:href");
        driver.close();
    }

}
