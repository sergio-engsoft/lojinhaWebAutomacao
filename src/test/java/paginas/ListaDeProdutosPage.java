package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ListaDeProdutosPage {
    private WebDriver navegador;
    private String idProdutoCriado;

    public ListaDeProdutosPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public FormularioDeAdicaoDeProdutoPage acessarOFormularioDeAdicaoDeNovoProduto(){
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();
        return new FormularioDeAdicaoDeProdutoPage(navegador);
    }

    public String capturarMensagemDeErroApresentada(){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }

    public String capturarMensagemDeRemocaoProduto() {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(5));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".toast")
        ));
        return toast.getText();
    }

    public ListaDeProdutosPage apagarProduto(String idProduto) {
        String xpath = "//a[contains(@href, '/produto/remover/" + idProduto + "')]";
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(30));
        WebElement linkDeRemover = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        linkDeRemover.click();
        return this;
    }

    public ListaDeProdutosPage recarregarPaginaListaProdutos() {
        navegador.findElement(By.id("logo-container")).click();
        return this;
    }
}