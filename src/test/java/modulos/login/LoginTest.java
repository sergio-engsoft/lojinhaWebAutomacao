package modulos.login;

import base.BaseTest;
import dataFactory.LoginDataFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import paginas.LoginPage;
import java.time.Duration;

@DisplayName("Teste Web do Modulo de Login")
public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Validar login com sucesso")
    public void testvalidarLoginComSucesso() {
        LoginDataFactory.fazerLoginComoAdmin(navegador);
        new WebDriverWait(navegador, Duration.ofSeconds(5))
        .until(ExpectedConditions.urlToBe("http://165.227.93.41/lojinha-web/v2/produto"));
        String urlAtual = navegador.getCurrentUrl();
        Assertions.assertEquals("http://165.227.93.41/lojinha-web/v2/produto", urlAtual);
    }

    @Test
    @DisplayName("Validar login inserindo Senha Incorreta")
    public void testvalidarLoginComSenhaIncorreta() {
        String menssagemFalhaLogin = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("senha errada")
                .submeterFormularioDeLoginComErro()
                .capturarMensagemDeFalhaLogin();
        Assertions.assertEquals("Falha ao fazer o login", menssagemFalhaLogin);
    }

    @Test
    @DisplayName("Validar login inserindo Usuario Incorreta")
    public void testvalidarLoginComUsuarioIncorreta() {
    String menssagemFalhaLogin = new LoginPage(navegador)
            .informarOUsuario("usuario errado")
            .informarASenha("admin")
            .submeterFormularioDeLoginComErro()
            .capturarMensagemDeFalhaLogin();
    Assertions.assertEquals("Falha ao fazer o login", menssagemFalhaLogin);
    }
    @Test
    @DisplayName("Validar login sem preencher campo usuario")
    public void testvalidarLoginSemCampoUsuario() {
        String menssagemFalhaLogin = new LoginPage(navegador)
                .informarOUsuario("")
                .informarASenha("admin")
                .submeterFormularioDeLoginComErro()
                .capturarMensagemDeFalhaLogin();
        Assertions.assertEquals("Falha ao fazer o login", menssagemFalhaLogin);
    }

    @Test
    @DisplayName("Validar login sem preencher campo senha")
    public void testvalidarLoginSemCampoSenha() {
        String menssagemFalhaLogin = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("")
                .submeterFormularioDeLoginComErro()
                .capturarMensagemDeFalhaLogin();
        Assertions.assertEquals("Falha ao fazer o login", menssagemFalhaLogin);
    }

    @AfterEach
    public void afterEach(){
        navegador.quit();}
}