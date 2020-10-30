#language: pt
@Feature_BuscaDeProdutos
Funcionalidade: Busca de Produtos
  Eu como usuario da pagina do Magazine Luiza
  Quero fazer uma busca por um produto
  Para validar o retorno da busca

  @Scenario_BuscaDeProdutos_FluxoBase_Valido
  Esquema do Cenario: Buscar por produto - Valido
    Dado que o usuario acessa o site do Magazine Luiza
    Quando o usuario busca por <PRODUTO_VALIDO>
    Entao o sistema mostra resultado maior que Zero
    E o sistema mostra a lista de produto(s) encontrado(s)

    Exemplos: 
      | PRODUTO_VALIDO          |
      | "MacBook Pro Retina 13" |
      | "Headphone JBL T500BT"  |
      | "Xbox One S"            |


  @Scenario_BuscaDeProdutos_FluxoAlternativo_01_Invalido
  Esquema do Cenario: Buscar por produto - Invalido
    Dado que o usuario acessa o site do Magazine Luiza
    Quando o usuario busca por <PRODUTO_INVALIDO>
    Entao o sistema nao mostra resultado de produto(s) encontrado(s)

    Exemplos: 
      | PRODUTO_INVALIDO |
      | "zzzzzzz"        |
      | "123456789"      |
      | "@!@!@!@!@!@!@!" |


  @Scenario_BuscaDeProdutos_FluxoAlternativo_02_NomeAproximado
  Esquema do Cenario: Buscar por produto - Nome aproximado
    Dado que o usuario acessa o site do Magazine Luiza
    Quando o usuario busca por <NOME_APROXIMADO>
    Entao o sistema mostra resultado maior que Zero
    E o sistema mostra a lista de produto(s) encontrado(s)

    Exemplos: 
      | NOME_APROXIMADO   |
      | "Caixa de som"    |
      | "Computador"      |
      | "Fones de ouvido" |


  @Scenario_BuscaDeProdutos_FluxoAlternativo_03_PesquisaVazia
  Cenario: Buscar por produto - Campo de pesquisa vazio
    Dado que o usuario acessa o site do Magazine Luiza
    Quando o usuario busca sem preencher o campo de pesquisa
    Entao o sistema continuara na mesma pagina
    E o sistema nao fara a busca
