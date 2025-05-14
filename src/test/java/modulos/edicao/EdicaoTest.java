package modulos.edicao;

import dataFactory.ProdutoDataFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.EdicaoDeProdutoPage;


import java.time.Duration;

@DisplayName("Teste Web do Modulo de Edição")
public class EdicaoTest {
    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver-win64\\chromedriver.exe");
        this.navegador = new ChromeDriver();
        this.navegador.manage().window().maximize();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.navegador.get("http://165.227.93.41/lojinha-web/v2");
    }

    @Test
    @DisplayName("Validar acesso a lista de produtos após criação")
    public void testValidarAcessoAlistaDeProdutos() {
        ProdutoDataFactory.criarProdutoDataFactory(navegador);
        new EdicaoDeProdutoPage(navegador)
                .voltarAListaDeProdutos();
    }

    @Test
    @DisplayName("Validar edição do nome do  produto")
    public void testValidarEdicaoDoNomeDoProduto() {
        ProdutoDataFactory.criarProdutoDataFactory(navegador);
        String idProduto = new EdicaoDeProdutoPage(navegador)
                .capturarIdDoProduto();
        String mensagemApresentado = new EdicaoDeProdutoPage(navegador)
                .informarONovoNomeDoProduto("editado teste")
                .salvarAsInformacoesDoProdutoEditado()
                .capturarMensagemDeAlteracaoApresentada();
        Assertions.assertEquals("Produto alterado com sucesso", mensagemApresentado);
        new EdicaoDeProdutoPage(navegador)
                .voltarAListaDeProdutos()
                .recarregarPaginaListaProdutos()
                .apagarProduto(idProduto);
    }

    @Test
    @DisplayName("Validar edição do valor do produto")
    public void testValidarEdicaoDoValorDoProduto() {
        ProdutoDataFactory.criarProdutoDataFactory(navegador);
        String idProduto = new EdicaoDeProdutoPage(navegador)
                .capturarIdDoProduto();
        String mensagemApresentado = new EdicaoDeProdutoPage(navegador)
                .informarONovoValorDoProduto("2000")
                .salvarAsInformacoesDoProdutoEditado()
                .capturarMensagemDeAlteracaoApresentada();
        Assertions.assertEquals("Produto alterado com sucesso", mensagemApresentado);
        new EdicaoDeProdutoPage(navegador)
                .voltarAListaDeProdutos()
                .apagarProduto(idProduto);
    }

    @Test
    @DisplayName("Validar edição do valor do produto para zero")
    public void testValidarEdicaoDoValorDoProdutoParaZero() {
        ProdutoDataFactory.criarProdutoDataFactory(navegador);
               String mensagemApresentado = new EdicaoDeProdutoPage(navegador)
                .informarONovoValorDoProduto("0")
                .salvarAsInformacoesDoProdutoEditado()
                .capturarMensagemDeAlteracaoComErroApresentada();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentado);
    }

    @Test
    @DisplayName("Validar edição do valor do produto para Mais de Sete Mil")
    public void testValidarEdicaoDoValorDoProdutoParaMaisDeSeteMil() {
        ProdutoDataFactory.criarProdutoDataFactory(navegador);
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String mensagemApresentado = new EdicaoDeProdutoPage(navegador)
                .informarONovoValorDoProduto("800000")
                .salvarAsInformacoesDoProdutoEditado()
                .capturarMensagemDeAlteracaoComErroApresentada();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentado);
    }

    @AfterEach
   public void afterEach() {
        navegador.quit();
   }
}