import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeleniumIFMGWebsiteTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        // Indica onde está o driver do firefox
        System.setProperty("webdriver.edge.driver", "src\\test\\msedgedriver.exe");

        driver = new EdgeDriver();
    }

    @Test
    public void testSearchIFMGPage() {
        // instrui o driver para "navegar" pelo Google
        driver.navigate().to("https://www.ifmg.edu.br/sabara");
        String itemBusca = "edital";

        // obtém o elemento "btnI" - Estou com sorte
        WebElement barraBusca = driver.findElement(By.id("nolivesearchGadget"));

        barraBusca.sendKeys(itemBusca);
        barraBusca.submit();

        WebElement textoBusca = driver.findElement(By.className("highlightedSearchTerm"));

        assertTrue(textoBusca.getText().contains(itemBusca));
    }

    @Test
    public void testMeuIFMGPage() {
        // instrui o driver para "navegar" pelo Google
        driver.navigate().to("https://www.ifmg.edu.br/sabara");
        String textoLogin = "Faça o login";

        // obtém o elemento "btnI" - Estou com sorte
        WebElement hrefIrMeuIFMG = driver.findElement(By.id("portalservicos-meu-ifmg"));

        hrefIrMeuIFMG.click();

        WebElement textoBusca = driver.findElement(By.id("lbFacaLogin"));

        assertTrue(textoBusca.getText().contains(textoLogin));
    }

    @Test
    public void testCPAPage() {
        // instrui o driver para "navegar" pelo Google
        driver.navigate().to("https://www.ifmg.edu.br/sabara");
        String textoCPA = "Comissão Própria de Avaliação - CPA";

        // obtém o elemento "btnI" - Estou com sorte
        WebElement hrefIrMeuIFMG = driver.findElement(By.id("portalservicos-cpa-1"));

        hrefIrMeuIFMG.click();

        WebElement textoBusca = driver.findElement(By.id("breadcrumbs-current"));

        assertTrue(textoBusca.getText().equalsIgnoreCase(textoCPA));
    }

    @Test
    public void testWebmailPage() {
        // instrui o driver para "navegar" pelo Google
        driver.navigate().to("https://www.ifmg.edu.br/sabara");
        String textoTitulo = "Webmail";

        // obtém o elemento "btnI" - Estou com sorte
        WebElement hrefIrMeuIFMG = driver.findElement(By.id("portalservicos-webmail"));

        WebElement webMailTitle = hrefIrMeuIFMG.findElement(By.tagName("a"));

        assertTrue(webMailTitle.getText().equalsIgnoreCase(textoTitulo));
    }

    @Test
    public void testContatoPage() {
        // instrui o driver para "navegar" pelo Google
        driver.navigate().to("https://www.ifmg.edu.br/sabara");
        String textoContato = "Contato";

        // obtém o elemento "btnI" - Estou com sorte
        WebElement hrefIrMeuIFMG = driver.findElement(By.id("portalservicos-fale-conosco"));

        hrefIrMeuIFMG.click();

        WebElement textoBusca = driver.findElement(By.id("breadcrumbs-current"));

        assertTrue(textoBusca.getText().equalsIgnoreCase(textoContato));
    }

    @Test
    public void testExAlunosPage() {
        // instrui o driver para "navegar" pelo Google
        driver.navigate().to("https://www.ifmg.edu.br/sabara");
        String textoContatoExAlunos = "Formulário Contato Ex alunos";

        // obtém o elemento "btnI" - Estou com sorte
        WebElement hrefIrMeuIFMG = driver.findElement(By.id("portalservicos-ex-alunos"));

        hrefIrMeuIFMG.click();

        WebElement textoBusca = driver.findElement(By.id("breadcrumbs-current"));

        assertTrue(textoContatoExAlunos.equalsIgnoreCase(textoBusca.getText()));
    }

    @Test
    public void testAcessoSistemasPage() {
        // instrui o driver para "navegar" pelo Google
        driver.navigate().to("https://www.ifmg.edu.br/sabara");
        String textoAcesso = "Acesso a sistemas";

        // obtém o elemento "btnI" - Estou com sorte
        WebElement hrefIrMeuIFMG = driver.findElement(By.id("portalservicos-acesso-a-sistemas"));

        hrefIrMeuIFMG.click();

        WebElement textoBusca = driver.findElement(By.id("breadcrumbs-current"));

        assertTrue(textoBusca.getText().equalsIgnoreCase(textoAcesso));
    }

    @After
    public void closing() throws Exception{
        // Espera 5 segundos e fecha a janela do browser
        Thread.sleep(5000);
        driver.quit();
    }
}
