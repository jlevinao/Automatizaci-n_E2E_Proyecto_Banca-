package ProyectoBanca.Base.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    // Acciones
    public void abrirLogin() {
        driver.get("https://www.saucedemo.com/");
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

}
