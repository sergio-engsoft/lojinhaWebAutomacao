package dataFactory;

import org.openqa.selenium.WebDriver;
import paginas.ListaDeProdutosPage;

public class ProdutoDataFactory {
    public static void criarProdutoDataFactory(WebDriver navegador) {
        LoginDataFactory.fazerLoginComoAdmin(navegador);
        new ListaDeProdutosPage(navegador)
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .informarONomeDoProduto("produtoteste")
                .informarOValorDoProduto("10000")
                .informarAsCoresDoProduto("preto,branco")
                .salvarAsInformacoesDoProduto();
    }
}