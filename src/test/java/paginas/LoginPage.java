package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    // O design pattern de Page object deve seguir esse padrao
    private WebDriver navegador;
    public LoginPage(WebDriver navegador) {
        this.navegador = navegador;
    }
    public LoginPage informarUsuario(String usuario) { // nome da pagina destino
        navegador.findElement(By.cssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys(usuario);

        return this;
    }

    public LoginPage informarSenha(String senha) {
        navegador.findElement(By.cssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys(senha);

        return this;
    }

    public ListaProdutosPage clicarEntrar() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListaProdutosPage(navegador);
    }

}
