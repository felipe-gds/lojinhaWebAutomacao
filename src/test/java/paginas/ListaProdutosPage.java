package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaProdutosPage {
    private WebDriver navegador;

    public ListaProdutosPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public AddProdutoPage clicarAddProduto() {
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();// o texto deve ser como o usuario ve

        return new AddProdutoPage(navegador);
    }

    // Validar que a mensagem de erro foi apresentada - Tivemos que copiar o alerta da pagina
    public String capturarMensagemApresentada () {
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
