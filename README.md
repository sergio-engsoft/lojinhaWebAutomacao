# Lojinha Web Automação 🛒✅

Este é um projeto de automação de testes web desenvolvido com o objetivo de demonstrar dominância sobre automação de testes de interface de usuário (UI), utilizando ferramentas modernas e seguindo boas práticas de desenvolvimento. A aplicação web testada simula um ambiente de e-commerce (Lojinha), permitindo operações como registro de componentes, validação de cadastros e remoção de itens.
O projeto foi baseado em um curso de automação de testes web ministrado por Julio de Lima.

## Tecnologias Utilizadas 🚀

* Java 23 (JDK)
* JUnit 5
* Selenium WebDriver
* Maven 3.9.9
* WebDriverManager
* Allure Framework (Relatórios de Testes)
* GitHub Actions (CI/CD)
* Google Chrome

 ```bash
## Estrutura do Projeto 📁

LojinhaWebAutomacao/
├── .github/workflows/maven_ci.yml     # Pipeline de integração e deploy contínuos
├── src/test/java                      # Testes automatizados
│   ├── base                           # Classe base para configuração do WebDriver
│   ├── dataFactory                    # Geradores de dados para os testes
│   ├── modulos                        # Casos de teste organizados por módulo
│   └── paginas                        # Page Objects
├── pom.xml                            # Gerenciador de dependências e build (Maven)
└── README.md
```

## Como Executar os Testes 🧪

### Pré-requisitos

* Java 23 instalado
* Maven instalado
* Git instalado
* Google Chrome instalado

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [Repositório LojinhaWebAutomacao no GitHub](https://github.com/sergio-engsoft/lojinhaWebAutomacao.git)
    ```

2.  **Navegue até a pasta do projeto:**
    ```bash
    cd lojinhaWebAutomacao
    ```

3.  **Execute os testes com Maven:**
    ```bash
    mvn clean test
    ```

4.  **Gerar e abrir o relatório Allure (opcional):**
    ```bash
    mvn allure:report
    mvn allure:serve
    ```

## Integração Contínua/Entrega Contínua (CI/CD) com GitHub Actions ⚙️

O projeto conta com uma pipeline configurada no GitHub Actions (`.github/workflows/maven_ci.yml`) que executa os testes automaticamente a cada push e pull request para a branch `main`. Além disso, o workflow está preparado para realizar o deploy da aplicação (etapa a ser configurada conforme o ambiente de destino). O status da execução dos testes é exibido diretamente no GitHub por meio de um badge de status no topo do repositório.

## Links Úteis 🔗

* **Aplicação Lojinha:** [http://165.227.93.41/lojinha-web/v2](http://165.227.93.41/lojinha-web/v2)
* **Repositório no GitHub:** [https://github.com/sergio-engsoft?tab=repositories](https://github.com/sergio-engsoft?tab=repositories)
* **Meu LinkedIn:** [https://www.linkedin.com/in/sergio-dos-santos-soares/](https://www.linkedin.com/in/sergio-dos-santos-soares/)
```
