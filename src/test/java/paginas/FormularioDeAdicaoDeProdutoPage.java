package paginas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FormularioDeAdicaoDeProdutoPage {
    private WebDriver navegador;

    public FormularioDeAdicaoDeProdutoPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public FormularioDeAdicaoDeProdutoPage informarONomeDoProduto(String nomeDoProduto) {
        navegador.findElement(By.id("produtonome")).sendKeys(nomeDoProduto);
        return this;
    }

    public FormularioDeAdicaoDeProdutoPage informarOValorDoProduto(String valordoProduto) {
        navegador.findElement(By.id("produtovalor")).sendKeys(valordoProduto);
        return this;
    }

    public FormularioDeAdicaoDeProdutoPage informarAsCoresDoProduto(String coresDoproduto) {
        navegador.findElement(By.id("produtocores")).sendKeys(coresDoproduto);
        return this;
    }

    public ListaDeProdutosPage salvarAsInformacoesDoProdutoComErro(){
        navegador.findElement(By.id("btn-salvar")).click();
        return new ListaDeProdutosPage(navegador);
    }

    public EdicaoDeProdutoPage salvarAsInformacoesDoProduto(){
        navegador.findElement(By.id("btn-salvar")).click();
        return new EdicaoDeProdutoPage(navegador);
    }
}