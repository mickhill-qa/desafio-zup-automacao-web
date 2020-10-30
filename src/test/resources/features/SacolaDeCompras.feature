#language: pt
@Desafio_Zup_-_Automacao_Web @SacolaDeCompras
Funcionalidade: Sacola de Compras
  Eu como usuario da pagina do Magazine Luiza
  Quero adicionar um produto a Sacola de Compras
  Para validar a Sacola de Compras

  Contexto: 
    Dado que o usuario acesse o site do Magazine Luiza
    Quando o usuario buscar por "Headphone JBL T500BT"
    Entao o sistema mostra resultado maior que Zero
    E o sistema mostra a lista de produto(s) encontrado(s)



  @FluxoBase_SacolaDeCompras @AdicionarProdutoASacolaDeCompras
  Cenario: Sacola de Compras - Adicionar produto
    Dado que o usuario escolha um produto na lista
    Quando o usuario adicionar o produto a Sacola de Compras
    Entao o sistema mostra a Sacola de Compras com o produto


  @FluxoAlternativo_01_SacolaDeCompras @ExcluirProdutoDaSacolaDeCompras
  Cenario: Sacola de Compras - Excluir produto
    Dado que o usuario adicione um produto a Sacola de Compras
    Quando o usuario excluir este produto
    Entao o sistema mostra a Sacola de Compras sem o produto
