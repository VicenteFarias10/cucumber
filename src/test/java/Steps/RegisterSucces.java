package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterSucces {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver(); // Obtiene la instancia del driver
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver(); // Cierra el driver al final
    }

    @Given("que puedo acceder a la URL de registro {string}")
    public void que_puedo_acceder_a_la_url_de_registro(String url) {
        driver.get(url);
    }

    @When("ingreso el Nombre Completo {string}")
    public void ingreso_el_nombre_completo(String nombre) {
        WebElement nombreCompletoField = driver.findElement(By.xpath("//*[@id=\"fullName\"]"));
        nombreCompletoField.sendKeys(nombre);
    }

    @When("ingreso el Correo Electrónico {string}")
    public void ingreso_el_correo_electrónico(String correo) {
        WebElement correoField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        correoField.sendKeys(correo);
    }

    @When("ingreso el Número de Celular {string}")
    public void ingreso_el_número_de_celular(String celular) {
        WebElement celularField = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        celularField.sendKeys(celular);
    }

    @When("ingreso la Contraseña {string}")
    public void ingreso_la_contraseña(String contraseña) {
        WebElement contraseñaField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        contraseñaField.sendKeys(contraseña);
    }

    @When("hago clic en el botón de registrarme")
    public void hago_clic_en_el_botón_de_registrarme() {
        WebElement registrarseButton = driver.findElement(By.xpath("//*[@id=\"registerSubmitButton\"]"));
        registrarseButton.click();
    }

    @Then("debería ver un mensaje de éxito indicando \"Usuario creado correctamente\"")
    public void debería_ver_un_mensaje_de_éxito_indicando() {
        // Espera hasta que el mensaje de éxito sea visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]")));

        // Obtiene el texto del mensaje de éxito
        String mensajeObtenido = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]")).getText();

        // Imprime el resultado de la verificación
        if (mensajeObtenido.trim().equals("Usuario creado correctamente")) {
            System.out.println("Resultado: Registro Exitoso");
        } else {
            System.out.println("Resultado: Error");
        }

        // Espera un poco más para permitir que el mensaje sea visible antes de cerrar
        try {
            Thread.sleep(2000); // Espera 2 segundos (2000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
