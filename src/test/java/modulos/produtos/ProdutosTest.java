package modulos.produtos;

import base.BaseTest;
import dataFactory.LoginDataFactory;
import dataFactory.ProdutoDataFactory;
import org.junit.jupiter.api.*;
import paginas.EdicaoDeProdutoPage;

@DisplayName("Teste Web do Modulo de Produtos")
public class ProdutosTest extends BaseTest {


    @Test
    @DisplayName("Validar produto com valor igual a zero")
    public void testValidarProdutoComValorIgualAZero() {
        String mensagemApresentada = LoginDataFactory.fazerLoginComoAdmin(navegador)
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarONomeDoProduto("Macbook")
                .informarOValorDoProduto("0")
                .informarAsCoresDoProduto("preto,branco")
                .salvarAsInformacoesDoProdutoComErro()
                .capturarMensagemDeErroApresentada();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("Validar produto com valor acima de 7000")
    public void testValidarProdutoComValorAcimaDeSeteMil() {
        String mensagemApresentada = LoginDataFactory.fazerLoginComoAdmin(navegador)
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarONomeDoProduto("Macbook")
                .informarOValorDoProduto("700001")
                .informarAsCoresDoProduto("preto,branco")
                .salvarAsInformacoesDoProdutoComErro()
                .capturarMensagemDeErroApresentada();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("Validar Registrar Produtos")
    public void testValidarRegistrarProdutos() {
        ProdutoDataFactory.criarProdutoDataFactory(navegador);
        String mensagemApresentada = new EdicaoDeProdutoPage(navegador)
                .capturarMensagemDeCriacaoApresentada();
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
        String idProduto = new EdicaoDeProdutoPage(navegador)
                .capturarIdDoProduto();
        new EdicaoDeProdutoPage(navegador)
                .voltarAListaDeProdutos()
                .apagarProduto(idProduto)
                .capturarMensagemDeRemocaoProduto();
    }

    @Test
    @DisplayName("Validar produto sem campo obrigatorio valor")
    public void testValidarProdutoSemCampoValor() {
        String mensagemApresentada = LoginDataFactory.fazerLoginComoAdmin(navegador)
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarONomeDoProduto("Macbook")
                .informarOValorDoProduto("")
                .informarAsCoresDoProduto("preto,branco")
                .salvarAsInformacoesDoProdutoComErro()
                .capturarMensagemDeErroApresentada();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @Test
    @DisplayName("Validar Remover um Produto")
    public void testValidarRemoverumProdutos() {
        ProdutoDataFactory.criarProdutoDataFactory(navegador);
        String idProduto = new EdicaoDeProdutoPage(navegador)
                .capturarIdDoProduto();
               String mensagemApresentada = new EdicaoDeProdutoPage(navegador)
                .voltarAListaDeProdutos()
                .apagarProduto(idProduto)
                .capturarMensagemDeRemocaoProduto();
        Assertions.assertEquals("Produto removido com sucesso", mensagemApresentada);
    }

@AfterEach
public void afterEach(){
    navegador.quit();
    }
}



