# Pedidos no "Embolados"
=====
*Uma aplicação para ser apresentada na BRAINSTORM da DIGITALBOX*


## <a name='TOC'>Conteúdo</a>

  1. [Problemas e soluções](#types)
  1. [Detalhes da implementação](#implementacao)
  
## <a name='types'>Problemas</a>

  - **Problema1**: JSF Controller não é alcançado nunca!

    + `Faltava o <h:form>`
    + `Pastas com pacote incorretos`
    + `Path de source mal mapeado`

  - **Problema2**: Maven não fazia o Build

    + `Estava apontando para uma versão de uma dependência que não rolava`

  - **Problema3**: A lista de pedidos não está sendo chamada no Datatable

    + `Apanhei 1 hora neste cara`
    + `Testei com outro Bean de exemplo foi numa boa, o problema é meu Bean`
    + `No final o Getter do atributo foi gerado com o L minúsculo, não fazendo bind com o elemento na VIEW`

  - **Problema4**: Ao transportar o projeto para outro computador, o server não sobe corretamente

    + `Estou olhando o build path`
    + `Tentei várias coisas, mas no final, faltava add a pasta webapp no deployment assembly`


    **[[⬆]](#TOC)**
    
## <a name='implementacao'>Detalhes da implementação</a>
  1. *O MVC foi implementado com JSF*
  1. *O MVC foi implementado com JSF*
  1. *Banco de dados MYSQL*
  1. *Persistência com JDBC*
  1. *Controller já aciona a camada DAO*

    **[[⬆]](#TOC)**
