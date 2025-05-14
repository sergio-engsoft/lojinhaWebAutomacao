package modulos.componentes;

import dataFactory.ComponenteDataFactory;
import dataFactory.ProdutoDataFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.EdicaoDeProdutoPage;

import java.time.Duration;

@DisplayName("Teste Web do Modulo de Componentes")
public class ComponentesTest {
    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();

        this.navegador = new ChromeDriver();
        this.navegador.manage().window().maximize();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.navegador.get("http://165.227.93.41/lojinha-web/v2");
    }

    @Test
    @DisplayName("Validar Registrar Componente após criar Produto")
    public void testValidarRegistrarComponenteAposCriarProduto(){
       ComponenteDataFactory.criarProdutoComComponente(navegador);
       String mensagemApresentada = new EdicaoDeProdutoPage(navegador)
               .capturarMensagemDeComponente();
        Assertions.assertEquals("Componente de produto adicionado com sucesso", mensagemApresentada);
        String idProduto = new EdicaoDeProdutoPage(navegador)
                .capturarIdDoProduto();
        new EdicaoDeProdutoPage(navegador)
                .voltarAListaDeProdutos()
                .apagarProduto(idProduto);
    }

    @Test
    @DisplayName("Validar Registrar Componente com Quantidade Invalida")
    public void testValidarRegistrarComponenteComQuantidadeErrada(){
        ProdutoDataFactory.criarProdutoDataFactory(navegador);
        String mensagemApresentada = new EdicaoDeProdutoPage(navegador)
                .adicionarComponente()
                .informarAQuantidadeDoComponente("0")
                .salvarComponente()
                .capturarMensagemDeComponenteValorInvalido();
        Assertions.assertEquals("A quantidade mínima para o componente não deve ser inferior a 1", mensagemApresentada);
    }

    @Test
    @DisplayName("Validar Remover Componente")
    public void testValidarRemoverComponente(){
        ComponenteDataFactory.criarProdutoComComponente(navegador);
        String mensagemApresentada = new EdicaoDeProdutoPage(navegador)
                .apagarComponenteTeste()
                .capturarMensagemDeRemocaoComponente();
        Assertions.assertEquals("Componente de produto removido com sucesso", mensagemApresentada);
        String idProduto = new EdicaoDeProdutoPage(navegador)
                .capturarIdDoProduto();
        new EdicaoDeProdutoPage(navegador)
                    .voltarAListaDeProdutos()
                    .apagarProduto(idProduto);
    }

    @AfterEach
    public void afterEach(){
        navegador.quit();}
}