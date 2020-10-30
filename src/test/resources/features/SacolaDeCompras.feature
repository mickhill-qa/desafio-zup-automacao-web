#language: pt
@Feature_SacolaDeCompras
Funcionalidade: Sacola de Compras
  Eu como usuario da pagina do Magazine Luiza
  Quero adicionar um produto a Sacola de Compras
  Para validar a Sacola de Compras

  Contexto: 
    Dado que o usuario acessa o site do Magazine Luiza
    Quando o usuario busca por "Headphone JBL T500BT"
    Entao o sistema mostra resultado maior que Zero
    E o sistema mostra a lista de produto(s) encontrado(s)



  @Scenario_SacolaDeCompras_FluxoBase_AdicionarProduto
  Cenario: Sacola de Compras - Adicionar produto
    Dado que o usuario escolhe um produto na lista
    Quando o usuario adiciona o produto na Sacola de Compras
    Entao o sistema mostra a Sacola de Compras com o produto adicionado


  @Scenario_SacolaDeCompras_FluxoAlternativo_01_ExcluirProduto
  Cenario: Sacola de Compras - Excluir produto
    Dado que o usuario adiciona um produto na Sacola de Compras
    Quando o usuario exclui o produto da Sacola de Compras
    Entao o sistema mostra a Sacola de Compras sem o produto adicionado
