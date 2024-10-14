package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactSuccess {
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

    @Given("que puedo acceder a la URL válidaa1 {string}")
    public void que_puedo_acceder_a_la_url_válidaa1(String url) {
        driver.get(url); // Accede a la URL proporcionada
    }

    @Given("ingreso el correo {string} en el campo de correoo")
    public void ingreso_el_correo_en_el_campo_de_correoo(String correo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")))
                .sendKeys(correo);
    }

    @Given("ingreso la contraseña {string} en el campo de contraseñaa")
    public void ingreso_la_contraseña_en_el_campo_de_contraseñaa(String contraseña) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")))
                .sendKeys(contraseña);
    }

    @Given("hago clic en el botón de aceptarr")
    public void hago_clic_en_el_botón_de_aceptarr() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginSubmitButton\"]")))
                .click();
    }

    @Given("debería ver un mensaje de confirmación que indicaa {string}")
    public void debería_ver_un_mensaje_de_confirmación_que_indicaa(String mensajeExito) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]")));
        String mensajeObtenido = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]")).getText();

        if (mensajeObtenido.trim().equals(mensajeExito)) {
            System.out.println("Mensaje de confirmación correcto");
        } else {
            System.out.println("Mensaje de confirmación incorrecto");
        }
    }

    @Given("me redirige hacia la Uri valida de {string}")
    public void me_redirige_hacia_la_uri_valida_de(String urii) {
        wait.until(ExpectedConditions.urlContains(urii));
    }

    @Given("hago click en el btn de contacto")
    public void hago_click_en_el_btn_de_contacto() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div[1]/a[3]"))).click();
    }


    @Given("usuario completa el campo Correo con {string}")
    public void usuario_completa_el_campo_correo_con(String correo2) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]"))).sendKeys(correo2);
    }

    @Given("usuario completa el campo Celular con {string}")
    public void usuario_completa_el_campo_celular_con(String celular) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"phone\"]"))).sendKeys(celular);
    }

    @Given("usuario completa el campo País con {string}")
    public void usuario_completa_el_campo_país_con(String pais) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"country\"]"))).sendKeys(pais);
    }

    @Given("usuario completa el campo Ciudad con {string}")
    public void usuario_completa_el_campo_ciudad_con(String ciudad) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"city\"]"))).sendKeys(ciudad);
    }

    @Given("usuario completa el campo Comuna con {string}")
    public void usuario_completa_el_campo_comuna_con(String comuna) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"state\"]"))).sendKeys(comuna);
    }

    @Given("usuario hace clic en el botónn Guardar")
    public void usuario_hace_clic_en_el_botónn_guardar() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"contactInfoSubmitButton\"]"))).click();
    }

    @Then("muestra un mensaje de creado indicando {string}")
    public void muestra_un_mensaje_de_creado_indicando(String mensajeValido) {
        // Espera hasta que el mensaje de error sea visible
        By locator = By.xpath("//*[contains(text(), '" + mensajeValido + "')]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));


        String mensajeObtenido = driver.findElement(locator).getText();
        System.out.println("Mensaje obtenido: " + mensajeObtenido); // Imprimir para depuración

        // Verifica si el mensaje obtenido es el esperado
        if (mensajeObtenido.trim().equals(mensajeValido)) {
            System.out.println("Resultado: " + mensajeValido + " visible correctamente");
        } else {
            System.out.println("Resultado: Mensaje esperado no encontrado");
        }

        try {
            Thread.sleep(2000); // Espera 2 segundos (2000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
