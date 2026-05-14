package ProyectoBanca.Base.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Localizadores de Saucedemo
    private By usuarioInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By tituloProductos = By.className("title"); // aparece en la página de productos
    private By clickProductoCarro = By.id("add-to-cart-sauce-labs-backpack");
    private By carroCompras = By.className("shopping_cart_link");
    {
		
	}

    // Acciones
    public void abrirLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }
    
    public void ingresarUsuario(String usuario) {
        driver.findElement(usuarioInput).sendKeys(usuario);
    }

    public void ingresarPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Validación por URL
    public boolean estaEnPaginaDeProductosPorURL() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

    // Validación por título
    public boolean estaEnPaginaDeProductosPorTitulo() {
        return driver.findElement(tituloProductos).getText().equals("Products");
    }


    // Método genérico para cerrar pop-ups
    public void cerrarPopUps() {
        // 1. Manejar alertas nativas del navegador
        try {
            Alert alerta = driver.switchTo().alert();
            alerta.dismiss(); // o alerta.accept() según lo que quieras
            System.out.println("Se cerró un alerta del navegador.");
        } catch (NoAlertPresentException e) {
            // No había alerta
        }

        // 2. Manejar modales HTML (ejemplo genérico)
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement botonCerrar = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".close-button"))
            );
            botonCerrar.click();
            System.out.println("Se cerró un pop-up HTML.");
        } catch (TimeoutException | NoSuchElementException e) {
            // No apareció el modal
        }
    }
        public void clickProducto() {
            driver.findElement(clickProductoCarro).click();
            
        }

            
            public void carroDeCompras() {
                driver.findElement(carroCompras).click();
                driver.quit();
    }
}
