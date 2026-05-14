package ProyectoBanca.Base.StepDefinitions;

import ProyectoBanca.Base.Pages.LoginPage;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("Abro el navegador en la página del login")
    public void abro_el_navegador_en_la_pagina_del_login() {
      
        WebDriverManager.chromedriver().setup(); // descarga y configura automáticamente el driver
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.abrirLogin();
    }

    @When("ingreso el usuario {string} y contraseña {string}")
    public void ingreso_el_usuario_y_contrasena(String usuario, String password) {
        loginPage.ingresarUsuario(usuario);
        loginPage.ingresarPassword(password);
    }

    @And("hago click en ingresar")
    public void hago_click_en_ingresar() {
        loginPage.clickLogin();
        
    }
    
    @Then("ingreso a la página de Saucedemo exitosamente")
    public void ingreso_a_la_pagina_de_saucedemo_exitosamente() {
       //validar por URL
        boolean enProductos = loginPage.estaEnPaginaDeProductosPorURL();

        assertTrue("No se ingresó a la página de productos", enProductos);

    }

    @And("agrego un producto al carro de compras")
    public void agrego_un_producto_al_carro_de_compras() {
    loginPage.clickProducto();
    }

    @And("reviso el producto agregado en el carro")
    public void reviso_el_producto_agregado_en_el_carro() {
     loginPage.carroDeCompras();
     driver.quit();

    }
}


