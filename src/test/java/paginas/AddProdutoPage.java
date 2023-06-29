package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProdutoPage {
    private WebDriver navegador;

    public AddProdutoPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public AddProdutoPage informarNomeProduto(String nomeProduto) {
        navegador.findElement(By.id("produtonome")).sendKeys(nomeProduto);

        return this;
    }

    public AddProdutoPage informarValorProduto(String valorProduto) {
        navegador.findElement(By.name("produtovalor")).sendKeys(valorProduto);

        return this;
    }

    public AddProdutoPage informarCoresProduto(String coresProduto) {
        navegador.findElement(By.id("produtocores")).sendKeys(coresProduto);

        return this;
    }

    public ListaProdutosPage clicarSubmeterProdutoComErro() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListaProdutosPage(navegador);
    }

    public EditarProdutoPage clicarSubmeterProdutoComSucesso() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new EditarProdutoPage(navegador);
    }


}
