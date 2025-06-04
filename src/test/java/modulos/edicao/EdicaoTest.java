package modulos.edicao;

import base.BaseTest;
import dataFactory.ProdutoDataFactory;
import org.junit.jupiter.api.*;
import paginas.EdicaoDeProdutoPage;




@DisplayName("Teste Web do Modulo de Edição")
public class EdicaoTest extends BaseTest {

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
        String idProduto = new EdicaoDeProdutoPage(navegador)
                .capturarIdDoProduto();
               String mensagemApresentado = new EdicaoDeProdutoPage(navegador)
                .informarONovoValorDoProduto("000")
                .salvarAsInformacoesDoProdutoEditado()
                .capturarMensagemDeAlteracaoComErroApresentada();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentado);
    }

    @Test
    @DisplayName("Validar edição do valor do produto para Mais de Sete Mil")
    public void testValidarEdicaoDoValorDoProdutoParaMaisDeSeteMil() {
        ProdutoDataFactory.criarProdutoDataFactory(navegador);
        String idProduto = new EdicaoDeProdutoPage(navegador)
                .capturarIdDoProduto();
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