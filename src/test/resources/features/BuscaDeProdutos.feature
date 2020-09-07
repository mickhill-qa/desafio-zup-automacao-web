#language: pt
@Desafio_Zup_-_Automacao_Web @BuscaDeProdutos
Funcionalidade: Busca de Produtos
  Eu como usuario da pagina do Magazine Luiza
  Quero fazer uma busca por um produto
  Para validar o retorno da busca

  @FluxoBase_BuscaDeProdutos @BuscaProdutoValido
  Esquema do Cenario: Buscar por produto - Valido
    Dados que o usuario acesse o site do Magazine Luiza
    Quando o usuario buscar por <PRODUTO_VALIDO>
    Entao o sistema mostra resultado maior que Zero
    E o sistema mostra a lista de produto(s) encontrado(s)

    Exemplos: 
      | PRODUTO_VALIDO          |
      | "MacBook Pro Retina 13" |
      | "Headphone JBL T500BT"  |
      | "Xbox One S"            |


  @FluxoAlternativo_01_BuscaDeProdutos @BuscaProdutoInvalido
  Esquema do Cenario: Buscar por produto - Invalido
    Dados que o usuario acesse o site do Magazine Luiza
    Quando o usuario buscar por <PRODUTO_INVALIDO>
    Entao o sistema nao mostra resultado de produto(s) encontrado(s)

    Exemplos: 
      | PRODUTO_INVALIDO |
      | "zzzzzzz"        |
      | "123456789"      |
      | "@!@!@!@!@!@!@!" |


  @FluxoAlternativo_02_BuscaDeProdutos @BuscaProdutoNomeAproximado
  Esquema do Cenario: Buscar por produto - Nome aproximado
    Dados que o usuario acesse o site do Magazine Luiza
    Quando o usuario buscar por <NOME_APROXIMADO>
    Entao o sistema mostra resultado maior que Zero
    E o sistema mostra a lista de produto(s) encontrado(s)

    Exemplos: 
      | NOME_APROXIMADO   |
      | "Caixa de som"    |
      | "Computador"      |
      | "Fones de ouvido" |


  @FluxoAlternativo_03_BuscaDeProdutos @BuscaProdutoPesquisaVazia
  Cenario: Buscar por produto - Campo de pesquisa vazio
    Dados que o usuario acesse o site do Magazine Luiza
    Quando buscar sem preencher o campo de pesquisa
    Entao o sistema continuara na mesma pagina
    E o sistema nao fara a busca
