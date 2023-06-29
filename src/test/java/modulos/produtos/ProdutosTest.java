package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

@DisplayName("Testes Web do Modulo de Produtos")
public class ProdutosTest {
    private WebDriver navegador;
    @BeforeEach
    public void beforeEach() {
        // Abrir navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver112\\chromedriver.exe");
        this.navegador = new ChromeDriver(); // aqui alteramos os navegadores se necessario

        // Maximizar a tela
        this.navegador.manage().window().maximize();

        // Navegar para a pagina da Lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
    };
    @Test
    @DisplayName("Nao e permitido registrar um produto com valor igual a zero")
    public void testNaoPermitidoValorIgualZero() {

        String mensagemApresentada = new LoginPage(navegador)
                .informarUsuario("admin")
                .informarSenha("admin")
                .clicarEntrar()
                .clicarAddProduto()
                .informarNomeProduto("Toca Fita")
                .informarValorProduto("000")
                .informarCoresProduto("Preto, Azul, Rosa")
                .clicarSubmeterProdutoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }
    @Test
    @DisplayName("Nao e permitido cadastrar produto com valor maior que R$ 7000")
    public void testNaoPermitidoValorMaiorSeteMil() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarUsuario("admin")
                .informarSenha("admin")
                .clicarEntrar()
                .clicarAddProduto()
                .informarNomeProduto("Toca Fita")
                .informarValorProduto("700001") // campo alterado p o novo teste
                .informarCoresProduto("Preto, Azul, Rosa")
                .clicarSubmeterProdutoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("Permitir cadastro de produto no limite de 0,01")
    public void testPermitirValorLimiteDeUmCentavo() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarUsuario("admin")
                .informarSenha("admin")
                .clicarEntrar()
                .clicarAddProduto()
                .informarNomeProduto("Toca Fita")
                .informarValorProduto("001") // campo alterado p o novo teste
                .informarCoresProduto("Preto, Azul, Rosa")
                .clicarSubmeterProdutoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @Test
    @DisplayName("Permitir cadastro de produto no limite de 7000")
    public void testPermitirValorLimitedeSeteMil() {
        String mensagemApresentada = new LoginPage(navegador)
                .informarUsuario("admin")
                .informarSenha("admin")
                .clicarEntrar()
                .clicarAddProduto()
                .informarNomeProduto("Fone de ouvido")
                .informarValorProduto("700000")
                .informarCoresProduto("Peeto")
                .clicarSubmeterProdutoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @AfterEach
    public void afterEach() {
        // Fechar navegador
        navegador.quit();
    }
}
