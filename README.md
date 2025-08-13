# Lojinha Web Automação 🛒✅

Este projeto demonstra a implementação de um framework de automação de testes de interface de usuário (UI) para uma aplicação web de e-commerce. Utilizando ferramentas modernas e padrões de projeto robustos, o objetivo é validar funcionalidades críticas da aplicação "Lojinha", garantindo a qualidade e a estabilidade do software.

O projeto foi desenvolvido com base no curso de Automação de Testes Web ministrado por Julio de Lima.

### Demonstração da Execução dos Testes

![Git automação Selenium](https://github.com/user-attachments/assets/3dc022ef-f377-4712-9243-3f69e24ef4e5)

## ✅ Cenários de Teste Cobertos
A suíte de automação valida um total de 18 cenários de teste, cobrindo as seguintes funcionalidades e regras de negócio críticas da aplicação Lojinha:

* **Login de Usuário (5 cenários):**

  *  Validação de login com credenciais válidas.

  *  Validação de mensagens de erro para login com credenciais inválidas (usuário/senha incorretos ou em branco).

* **Cadastro e Gestão de Produtos (5 cenários):**

  *  Validação do cadastro de um novo produto com dados válidos.

  *  Validação da regra de negócio que impede o cadastro de produtos com valor igual a R$ 0,00 ou superior a R$ 7.000,00.

  *  Validação de campos obrigatórios durante o cadastro.

  *  Validação da funcionalidade de exclusão de um produto existente.

* **Edição de Produtos (5 cenários):**

  *  Validação da edição do nome e do valor de um produto.

  *  Validação das regras de negócio ao tentar editar o valor do produto para R$ 0,00 ou mais de R$ 7.000,00.

* **Gestão de Componentes (3 cenários):**

  *  Validação do cadastro de um novo componente a um produto.

  *  Validação da regra de negócio que impede o cadastro de componentes com quantidade inválida (menor que 1).

  *  Validação da funcionalidade de remoção de um componente.
## 🏛️ Arquitetura do Projeto

Para garantir a manutenibilidade, escalabilidade e legibilidade do código, o projeto foi estruturado com base nos seguintes padrões de projeto:

*   **Page Object Model (POM):** Este padrão é a base da nossa arquitetura. Cada página da aplicação web é representada por uma classe Java correspondente (localizadas em `src/test/java/paginas`). Essas classes encapsulam os elementos da UI (WebElements) e os métodos para interagir com eles. Isso desacopla a lógica dos testes da estrutura da página, de modo que, se a UI mudar, apenas a classe de página correspondente precisa ser atualizada, e não os scripts de teste.

*   **Data Factory (Fábrica de Dados):** Para desacoplar os dados de teste da lógica dos testes, utilizamos o padrão Data Factory (localizado em `src/test/java/dataFactory`). Esta abordagem nos permite encapsular a criação de dados e fluxos de configuração complexos (como fazer login ou criar um produto com um componente), tornando os testes mais limpos, flexíveis e fáceis de manter.


 ```bash
LojinhaWebAutomacao/
├──.github/workflows/maven_ci.yml      # Pipeline de Integração Contínua (CI)
├── test/java/
│   ├── base/
│   │   └── BaseTest.java               # Classe base para configuração do WebDriver
│   ├── dataFactory/
│   │   ├── ComponenteDataFactory.java  # Fábricas para desacoplar dados de teste
│   │   ├── LoginDataFactory.java
│   │   └── ProdutoDataFactory.java
│   ├── modulos/
│   │   ├── componentes/
│   │   │   └── ComponentesTest.java    # Suítes de testes organizadas por módulo
│   │   ├── edicao/
│   │   │   └── EdicaoTest.java
│   │   ├── login/
│   │   │   └── LoginTest.java
│   │   └── produtos/
│   │       └── ProdutosTest.java
│   └── paginas/
│       ├── EdicaoDeProdutoPage.java    # Page Objects para abstrair interações com a UI
│       ├── FormularioDeAdicaoDeProdutoPage.java
│       ├── ListaDeProdutosPage.java
│       └── LoginPage.java
├──.gitignore
├── LICENSE.md
└── pom.xml                             # Gerenciador de dependências e build (Maven)
```

## 🛠️ Tecnologias e Ferramentas

A tabela abaixo detalha as tecnologias, frameworks e ferramentas utilizadas neste projeto:

| Componente | Versão | Finalidade |
| :--- | :--- | :--- |
| **Java** | 23 | Linguagem de programação base para o desenvolvimento dos testes. |
| **JUnit 5** | 5.7.1 | Framework para a estruturação e execução dos casos de teste. |
| **Selenium WebDriver** | 4.32.0 | Biblioteca para automação da interação com navegadores web. |
| **Maven** | 3.9.9+ | Ferramenta de gerenciamento de dependências e automação de build. |
| **WebDriverManager** | 5.8.0 | Gerenciamento automático dos drivers de navegador (e.g., chromedriver). |
| **Allure Framework** | 2.14.0+ | Framework para a geração de relatórios de teste detalhados e interativos. |
| **GitHub Actions** | - | Plataforma de CI/CD para automação de build, teste e deploy. |
| **Google Chrome** | - | Navegador utilizado para a execução dos testes de UI. |

## 🧪 Como Executar os Testes

Siga os passos abaixo para clonar e executar a suíte de testes localmente.

### Pré-requisitos

- Java (JDK) 17 ou superior instalado
- Maven instalado
- Git instalado
- Google Chrome instalado

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/sergio-engsoft/lojinhaWebAutomacao.git
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd lojinhaWebAutomacao
    ```

3.  **Execute os testes com o Maven:**
    Este comando irá compilar o projeto, baixar as dependências e executar todos os testes.
    ```bash
    mvn clean test
    ```

4.  **Gere e visualize o relatório Allure (Opcional):**
    Após a execução dos testes, você pode gerar um relatório interativo.
    ```bash
    mvn allure:report
    mvn allure:serve
    ```
    O último comando abrirá o relatório diretamente no seu navegador.

## ⚙️ Integração Contínua (CI/CD)

O projeto está configurado com um pipeline de Integração Contínua (CI) utilizando o GitHub Actions. O workflow, definido em `.github/workflows/maven_ci.yml`, é acionado automaticamente a cada `push` ou `pull request` para a branch `main`.

## 📜 Licença

Este projeto está licenciado sob a Licença Apache 2.0. Veja o arquivo(LICENSE.md) para mais detalhes.

## Links Úteis 🔗

* **Aplicação Lojinha:** [http://165.227.93.41/lojinha-web/v2](http://165.227.93.41/lojinha-web/v2)
* **Repositório no GitHub:** [https://github.com/sergio-engsoft?tab=repositories](https://github.com/sergio-engsoft?tab=repositories)
* **Meu LinkedIn:** [https://www.linkedin.com/in/sergio-dos-santos-soares/](https://www.linkedin.com/in/sergio-dos-santos-soares/)
* **E-mail:** sergiodossantossoares@hotmail.com
