package dataFactory;

import org.openqa.selenium.WebDriver;
import paginas.EdicaoDeProdutoPage;

public class ComponenteDataFactory {
    public static void criarProdutoComComponente(WebDriver navegador) {
       ProdutoDataFactory.criarProdutoDataFactory(navegador);
       new EdicaoDeProdutoPage(navegador)
                .adicionarComponente()
                .informarONomeDoComponente("componenteteste")
                .informarAQuantidadeDoComponente("2")
                .salvarComponente();
    }
}