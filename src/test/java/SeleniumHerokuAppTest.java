import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;

public class SeleniumHerokuAppTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        // Indica onde está o driver do firefox
        System.setProperty("webdriver.edge.driver", "src\\test\\msedgedriver.exe");

        driver = new EdgeDriver();
    }

    @Test
    public void testHerokuSuccessfulLogin() {

        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        String successfulLoginMessage = "You logged into a secure area!\n" +
                "×";
        // instrui o driver para "navegar" pelo Google
        driver.navigate().to("http://the-internet.herokuapp.com/login");

        // obtém o elemento "btnI" - Estou com sorte
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("radius"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        loginButton.click();

        assertEquals(successfulLoginMessage, driver.findElement(By.id("flash")).getText());
    }

    @Test
    public void testHerokuFailLogin() {

        String username = "tomsmith";
        String password = "wrongPassword";
        String failLoginMessage = "Your password is invalid!\n" +
                "×";
        // instrui o driver para "navegar" pelo Google
        driver.navigate().to("http://the-internet.herokuapp.com/login");

        // obtém o elemento "btnI" - Estou com sorte
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("radius"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        loginButton.click();

        assertEquals(failLoginMessage, driver.findElement(By.id("flash")).getText());
    }

    @After
    public void closing() throws Exception{
        // Espera 5 segundos e fecha a janela do browser
        Thread.sleep(5000);
        driver.quit();
    }
}
