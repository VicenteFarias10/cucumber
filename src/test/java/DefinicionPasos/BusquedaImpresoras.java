package DefinicionPasos;

import Utilidades.ExcelUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BusquedaImpresoras {

    static String driverPath="./src/test/resources/chrome/chromedriver.exe";
    static String TipoWebdriver="webdriver.chrome.driver";
    static WebDriver driver;
    @Before
    public void setUp() throws Exception {

        ExcelUtils.setExcelFileSheet("testData\\dataTransferFondos.xlsx", "DatosUsuarios");
        System.setProperty(TipoWebdriver,driverPath);
        driver= new ChromeDriver();

    }

    @After
    public void tearDown() throws Exception {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        if (driver !=null)
            driver.quit();
    }

    @Given("que puedo acceder a la url {string}")
    public void que_puedo_acceder_a_la_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }


    @Given("al navegar hasta la url {string}")
    public void al_navegar_hasta_la_url(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @When("hacemos click en el Sign In link")
    public void hacemos_click_en_el_sign_in_link() {
        driver.findElement(By.xpath("//*[@id='LoginLink']/font")).click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @When("coloca en el campo usuario y en el campo password un valor valido  {int}")
    public void coloca_en_el_campo_usuario_y_en_el_campo_password_un_valor_valido(Integer fila) throws Exception {
        driver.findElement(By.xpath("//*[@id='uid']")).click();
        driver.findElement(By.xpath("//*[@id='uid']")).clear();
        driver.findElement(By.xpath("//*[@id='uid']")).sendKeys(ExcelUtils.getCellData(fila, 0).toString());
        driver.findElement(By.xpath("//*[@id='passw']")).click();
        driver.findElement(By.xpath("//*[@id='passw']")).clear();
        driver.findElement(By.xpath("//*[@id='passw']")).sendKeys(ExcelUtils.getCellData(fila, 1).toString());
    }

    @When("hacer click sobre el boton Login")
    public void hacer_click_sobre_el_boton_login() {
        driver.findElement(By.xpath("//*[@id='login']/table/tbody/tr[3]/td[2]/input")).click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @When("hacer click en el link Transfer Funds")
    public void hacer_click_en_el_link_transfer_funds() {
        driver.findElement(By.xpath("//*[@id='MenuHyperLink3']")).click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @When("Indicar la cuenta de cargo en From Account  {int}")
    public void indicar_la_cuenta_de_cargo_en_from_account(Integer fila) throws Exception {
        //Seleccione la cuenta de origen
        driver.findElement(By.xpath("//*[@id='fromAccount']")).sendKeys(ExcelUtils.getCellData(fila, 2).toString());
    }

    @When("Indica la cuenta beneficiaria  en To Account {int}")
    public void indica_la_cuenta_beneficiaria_en_to_account(Integer fila) throws Exception {
        //Seleccione la cuenta destino
        driver.findElement(By.xpath("//*[@id='toAccount']")).sendKeys(ExcelUtils.getCellData(fila, 3).toString());
    }

    @When("Indicar monto a transferir  en Amount TO  {int}")
    public void indicar_monto_a_transferir_en_amount_to(Integer fila ) throws Exception {
        driver.findElement(By.xpath("//*[@id='transferAmount']")).clear();
        driver.findElement(By.xpath("//*[@id='transferAmount']")).sendKeys(ExcelUtils.getCellData(fila,4).toString());
    }

    @When("hacer click en el boton Transfer Money")
    public void hacer_click_en_el_boton_transfer_money() {
        driver.findElement(By.xpath("//*[@id='transfer']")).click();
    }

    @Then("El mensaje de resultados debe contener un mensaje de ingreso {int}")
    public void el_mensaje_de_resultados_debe_contener_un_mensaje_de_ingreso(Integer fila) throws Exception {
        String mensajeObtenido=driver.findElement(By.xpath("//*[@id='_ctl0__ctl0_Content_Main_postResp']/span")).getText();
        String mensajeEsperado=ExcelUtils.getCellData(fila, 5);
        if (mensajeObtenido.contains(mensajeEsperado))
            ExcelUtils.setCellData("Prueba OK", fila, 6);
        else
            ExcelUtils.setCellData("Prueba NO OK", fila, 6);
    }

}
