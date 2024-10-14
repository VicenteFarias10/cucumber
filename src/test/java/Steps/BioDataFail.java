package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BioDataFail {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver(); // Obtiene la instancia del WebDriver
        wait = new WebDriverWait(driver, 10); // Espera explícita de 10 segundos
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver(); // Cierra el WebDriver al finalizar
    }


    @Given("que puedo ir a la URL de onboarding {string}")
    public void que_puedo_ir_a_la_url_de_onboarding(String url) {
        driver.get(url); // Accede a la URL proporcionada
    }

    @When("completo el campo Nombre con {string}")
    public void completo_el_campo_nombre_con(String nombre) {
        By locator = By.xpath("//*[@id=\"firstName\"]"); // Ajusta el XPath según sea necesario
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(nombre); // Completa el campo Nombre
    }

    @When("completo el campo Apellido con {string}")
    public void completo_el_campo_apellido_con(String apellido) {
        By locator = By.xpath("//*[@id=\"lastName\"]"); // Ajusta el XPath según sea necesario
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(apellido); // Completa el campo Apellido
    }

    @When("completo el campo RUT con {string}")
    public void completo_el_campo_rut_con(String rut) {
        By locator = By.xpath("//*[@id=\"rut\"]"); // Ajusta el XPath según sea necesario
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(rut); // Completa el campo RUT
    }

    @When("completo el campo Fecha de Nacimiento con {string}")
    public void completo_el_campo_fecha_de_nacimiento_con(String fechaNacimiento) {
        // Localizador para el campo de fecha
        By dateFieldLocator = By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/div[1]/div[4]/div/div/div/input[2]");

        // Abrir el date picker
        wait.until(ExpectedConditions.elementToBeClickable(dateFieldLocator)).click();

        // Esperar un poco para asegurarse de que el datepicker esté abierto
        try {
            Thread.sleep(500); // Ajusta el tiempo si es necesario
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Escribir la fecha en el formato correcto
        driver.findElement(dateFieldLocator).clear(); // Limpia el campo antes de escribir
        driver.findElement(dateFieldLocator).sendKeys(fechaNacimiento); // Escribe la fecha
        driver.findElement(dateFieldLocator).sendKeys(Keys.ENTER); // Opcional: enviar Enter para confirmar
    }

    @When("selecciono {string} como sexo")
    public void selecciono_como_sexo(String sexo) {
        String locator;
        if (sexo.equalsIgnoreCase("hombre")) {
            locator = "//*[@id='male']";
        } else if (sexo.equalsIgnoreCase("mujer")) {
            locator = "//*[@id='female']";
        } else {
            throw new IllegalArgumentException("Sexo no reconocido: " + sexo);
        }

        // Asegúrate de esperar que el elemento sea visible y hacer clic en él
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();
    }




    @When("hago clic en el botón de guardar")
    public void hago_clic_en_el_botón_de_guardar() {
        By locator = By.xpath("//*[@id=\"bioDataSubmitButton\"]"); // Ajusta el XPath según sea necesario
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click(); // Hace clic en el botón de guardar
    }


    @Then("debería ver un mensaje de error {string}")
    public void debería_ver_un_mensaje_de_error(String mensajeError) {
        // Crea un XPath para localizar el mensaje de error basado en el texto proporcionado
        By locator = By.xpath("//*[contains(text(), '" + mensajeError + "')]");

        // Espera hasta que el mensaje de error sea visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // Obtiene el texto del mensaje de error
        String mensajeObtenido = driver.findElement(locator).getText();
        System.out.println("Mensaje obtenido: " + mensajeObtenido); // Imprimir para depuración

        // Verifica si el mensaje obtenido es el esperado
        if (mensajeObtenido.trim().equals(mensajeError)) {
            System.out.println("Resultado: " + mensajeError + " visible correctamente");
        } else {
            System.out.println("Resultado: Mensaje esperado no encontrado");
        }

        // Espera un poco más para permitir que el mensaje sea visible antes de cerrar
        try {
            Thread.sleep(2000); // Espera 2 segundos (2000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}



