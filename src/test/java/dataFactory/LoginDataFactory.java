package dataFactory;

import org.openqa.selenium.WebDriver;
import paginas.ListaDeProdutosPage;
import paginas.LoginPage;

public class LoginDataFactory{
    public static ListaDeProdutosPage fazerLoginComoAdmin(WebDriver navegador){
        return new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin();
    }
}