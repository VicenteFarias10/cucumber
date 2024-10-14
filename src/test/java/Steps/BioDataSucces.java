package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;

public class BioDataSucces {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Given("que puedo acceder a la URL válida1 {string}")
    public void que_puedo_acceder_a_la_url_válida1(String url) {
        driver.get(url);
    }

    @And("ingreso el correo {string} en el campo de correo1")
    public void ingreso_el_correo_en_el_campo_de_correo1(String correo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")))
                .sendKeys(correo);
    }

    @And("ingreso la contraseña {string} en el campo de contraseña1")
    public void ingreso_la_contraseña_en_el_campo_de_contraseña1(String contraseña) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")))
                .sendKeys(contraseña);
    }

    @And("hago clic en el botón de aceptar1")
    public void hago_clic_en_el_botón_de_aceptar1() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginSubmitButton\"]")))
                .click();
    }

    @And("debería ver un mensaje de confirmación que indica1 {string}")
    public void debería_ver_un_mensaje_de_confirmación_que_indica1(String mensajeEsperado) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]")));
        String mensajeObtenido = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]")).getText();

        if (mensajeObtenido.trim().equals(mensajeEsperado)) {
            System.out.println("Mensaje de confirmación correcto");
        } else {
            System.out.println("Mensaje de confirmación incorrecto");
        }
    }

    @And("me redirige hacia la URI {string}")
    public void me_redirige_hacia_la_uri(String uri) {
        wait.until(ExpectedConditions.urlContains(uri));
    }

    @And("lleno el campo Nombre con el valor {string}")
    public void lleno_el_campo_nombre_con_el_valor(String nombre) {
        By locator = By.xpath("//*[@id=\"firstName\"]"); // Ajusta el XPath según sea necesario
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(nombre); // Completa el campo Nombre
    }

    @And("lleno el campo Apellido con el valor {string}")
    public void lleno_el_campo_apellido_con_el_valor(String apellido) {
        By locator = By.xpath("//*[@id=\"lastName\"]"); // Ajusta el XPath según sea necesario
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(apellido); // Completa el campo Apellido
    }

    @And("lleno el campo RUT con el valor {string}")
    public void lleno_el_campo_rut_con_el_valor(String rut) {
        By locator = By.xpath("//*[@id=\"rut\"]"); // Ajusta el XPath según sea necesario
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(rut); // Completa el campo RUT
    }

    @And("lleno el campo Fecha de Nacimiento con el valor {string}")
    public void lleno_el_campo_fecha_de_nacimiento_con_el_valor(String fechaNacimiento) {
        By dateFieldLocator = By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/input[2]");

        wait.until(ExpectedConditions.elementToBeClickable(dateFieldLocator)).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(dateFieldLocator).clear();
        driver.findElement(dateFieldLocator).sendKeys(fechaNacimiento);
        driver.findElement(dateFieldLocator).sendKeys(Keys.ENTER);
    }

    @And("elijo {string} como mi sexo")
    public void elijo_como_mi_sexo(String sexo) {
        String locator;
        if (sexo.equalsIgnoreCase("hombre")) {
            locator = "//*[@id='male']";
        } else if (sexo.equalsIgnoreCase("mujer")) {
            locator = "//*[@id='female']";
        } else {
            throw new IllegalArgumentException("Sexo no reconocido: " + sexo);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();
    }

    @And("hago clic en el botón de guardar1")
    public void hago_clic_en_el_botón_de_guardar1() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bioDataSubmitButton\"]")))
                .click();
    }

    @Then("debería ver un mensaje de aceptación {string}")
    public void debería_ver_un_mensaje_de_aceptación(String mensajeEsperado) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]")));
        String mensajeObtenido = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]")).getText();

        if (mensajeObtenido.trim().equals(mensajeEsperado)) {
            System.out.println("Mensaje de aceptación correcto");
        } else {
            System.out.println("Mensaje de aceptación incorrecto");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}