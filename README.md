Desafio ZUP Automação Web
=======================
Este é um **Projeto Maven** e foi criado conforme requisito abaixo, utilizando os seguintes recursos:

- Java;
- Maven;
- JUnit;
- Selenium;
- Cucumber (BDD);
- Padrão PageObjects;
- Pluguins p/ relatórios automatizados no Jenkins;
- IDE: Eclipse 2020-06;
- Bitbucket (migrado p/ GitHub) - Git (git-flow).


**Avisos Importantes:**

Os teste foram validados no **Google Chrome** e **Mozilla Firefox**, e eu utilizei o WebDriver nas **Variáveis de Ambiente** do meu sistema. Caso você não possua o mesmo setup, eu disponibilizei as versões mais recentes do ChromeDriver e GeckoDriver para Windows dentro do projeto:

```
/src/test/resources/webdrivers/
```

Para utiliza-las localmente no projeto, remova as tags de comentário nas linhas 23 e 24 da classe:

```
/src/main/java/support/BrowserFactory.java
```

E para alternar entre os navegadores, substitua na mesma classe o **Browser Default** na linha 18.

- CHROME
- CHROME_HEADLESS
- FIREFOX
- FIREFOX_HEADLESS

---



## Requisito

Utilizando as ferramentas que preferir crie um teste automatizado que faça o fluxo de ponta a ponta de um cliente que:

*1 - Entre em um grande portal de comércio online*
*(Exemplo: Americanas, Submarino, Magazine Luiza)*

*2 - Faça uma busca por um produto*

*3 - Valide o retorno da busca*

*4 - Escolha um produto na lista*

*5 - Adicione o carrinho*

*6 - Valide o produto no carrinho*


Para a criação dos cenários de testes devem ser considerados casos de sucesso e fluxos alternativos


***O documento completo está na raiz do projeto:
[Desafio Zup - automação Web.pdf](https://github.com/mickhill/desafio_zup_automacao_web/raw/ec74c8e1f20a18ea8a360198320085bced4ebf3a/Desafio%20Zup%20-%20automa%C3%A7%C3%A3o%20Web.pdf)***

---



## Planejamento dos Testes

Baseado nos Steps do Requisito eu criei 2 User Stories, separando o E2E em duas Funcionalidades e possibilitando o reaproveitamento do Cucumber-Steps:

~~~gherkin
Funcionalidade: Busca de Produtos
  Eu como usuario da pagina do Magazine Luiza
  Quero fazer uma busca por um produto
  Para validar o retorno da busca
~~~

~~~gherkin
Funcionalidade: Sacola de Compras
  Eu como usuario da pagina do Magazine Luiza
  Quero adicionar um produto a Sacola de Compras
  Para validar a Sacola de Compras
~~~


**Mapeando Cenários de Teste**

*Funcionalidade: Busca de Produtos*

- Cenário: Buscar por produto - Valido
- Cenário: Buscar por produto - Invalido
- Cenário: Buscar por produto - Nome aproximado
- Cenário: Buscar por produto - Campo de pesquisa vazio

*Funcionalidade: Sacola de Compras*

- Cenário: Sacola de Compras - Adicionar produto
- Cenário: Sacola de Compras - Excluir produto


**Criando as Features de Teste**

Tendo em mãos os Cenários de cada fluxos de teste (fluxo base e alternativos), comecei a escrita das features em **gherkin** tendo como base o **BDD**:

```
/src/test/resources/features/BuscaDeProdutos.feature
```
```
/src/test/resources/features/SacolaDeCompras.feature
```

---



## Setup da IDE e Projeto de Automação

**Criar Projeto no Eclipse**

- File > New > Maven Project



**Instalação de plugin na IDE**

- Help > Eclipse Marketplace > [Cucumber Eclipse Plugin](http://marketplace.eclipse.org/content/cucumber-eclipse-plugin)



**Instalar pacotes na Aplicação via Maven (pom.xml)**

- cucumber-java 1.2.5
- cucumber-junit 1.2.5
- selenium-java 3.141.59

**pom.xml**

```
<dependencies>
	<dependency>
		<groupId>info.cukes</groupId>
		<artifactId>cucumber-java</artifactId>
		<version>1.2.5</version>
	</dependency>
	<dependency>
		<groupId>info.cukes</groupId>
		<artifactId>cucumber-junit</artifactId>
		<version>1.2.5</version>
		<scope>test</scope>
	</dependency>
	<dependency>
		<groupId>org.seleniumhq.selenium</groupId>
		<artifactId>selenium-java</artifactId>
		<version>3.141.59</version>
	</dependency>
</dependencies>
```

'

**Histórico de Implementação - Git-Flow**

[github.com/mickhill/desafio_zup_automacao_web/commits/](https://github.com/mickhill/desafio_zup_automacao_web/commits/)
