package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class EdicaoDeProdutoPage {
    private WebDriver navegador;

    public EdicaoDeProdutoPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public String capturarMensagemDeCriacaoApresentada() {
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }

    public ListaDeProdutosPage voltarAListaDeProdutos() {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        WebElement linkListaDeProdutos = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LISTA DE PRODUTOS")));
        linkListaDeProdutos.click();
        return new ListaDeProdutosPage(navegador);
    }

    public EdicaoDeProdutoPage informarONovoNomeDoProduto(String novoNomeProduto) {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(15));
        WebElement campoNomeProduto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("produtonome")));
        campoNomeProduto.clear();
        campoNomeProduto.sendKeys(novoNomeProduto);
        return this;
    }

    public EdicaoDeProdutoPage informarONovoValorDoProduto(String valor) {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        WebElement campoValor = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("produtovalor")));
        campoValor.clear();
        campoValor.sendKeys(valor);
        return this;
    }



    public EdicaoDeProdutoPage salvarAsInformacoesDoProdutoEditado() {
        navegador.findElement(By.name("action")).click();
        return new EdicaoDeProdutoPage(navegador);
    }

    public String capturarMensagemDeAlteracaoApresentada() {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Produto alterado com sucesso')]")));
        return mensagem.getText();
    }

    public String capturarMensagemDeAlteracaoComErroApresentada() {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00')]")));
        return mensagem.getText();
    }

    public String capturarMensagemDeComponente() {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Componente de produto adicionado com sucesso')]")));
        return mensagem.getText();
    }

    public String capturarMensagemDeComponenteValorInvalido() {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'A quantidade mínima para o componente não deve ser inferior a 1')]")));
        return mensagem.getText();
    }

    public EdicaoDeProdutoPage adicionarComponente() {
        navegador.findElement(By.linkText("ADICIONAR COMPONENTE")).click();
        return new EdicaoDeProdutoPage(navegador);
    }

    public EdicaoDeProdutoPage informarONomeDoComponente(String nomeDoComponente) {
        navegador.findElement(By.id("componentenomeadicionar")).sendKeys(nomeDoComponente);
        return this;
    }

    public EdicaoDeProdutoPage informarAQuantidadeDoComponente(String quantidadeDoComponente) {
        navegador.findElement(By.id("componentequantidadeadicionar")).sendKeys(quantidadeDoComponente);
        return this;
    }

    public EdicaoDeProdutoPage salvarComponente() {
        navegador.findElement(By.linkText("SALVAR COMPONENTE")).click();
        return new EdicaoDeProdutoPage(navegador);
    }

    public EdicaoDeProdutoPage apagarComponenteTeste() {
        navegador.findElement(By.linkText("delete")).click();
        return this;
    }

    public String capturarIdDoProduto() {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/produto/editar/"));
        String url = navegador.getCurrentUrl();
        String idProduto = url.replaceAll(".*/produto/editar/(\\d+).*", "$1");


        return idProduto;
    }

    public String capturarMensagemDeRemocaoComponente () {
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Componente de produto removido com sucesso')]")));
        return mensagem.getText();
    }
}