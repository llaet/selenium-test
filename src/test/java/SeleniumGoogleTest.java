import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;

public class SeleniumGoogleTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        // Indica onde está o driver do firefox
        System.setProperty("webdriver.edge.driver", "src\\test\\msedgedriver.exe");

        driver = new EdgeDriver();
    }

    @Test
    public void testAccessToGoogleDoodlesPage() {
        // instrui o driver para "navegar" pelo Google
        driver.navigate().to("http://www.google.com");

        // obtém o elemento "btnI" - Estou com sorte
        WebElement element = driver.findElement(By.className("RNmpXc"));

        element.click();

        //obtém o título da página
        String pageTitle = driver.getTitle();

        assertEquals("Google Doodles", pageTitle);
    }

    @After
    public void closing() throws Exception{
        // Espera 5 segundos e fecha a janela do browser
        Thread.sleep(5000);
        driver.quit();
    }
}
