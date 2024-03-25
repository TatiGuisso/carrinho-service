<a name="readme-top"></a>

# Introdução

O Carrinho Service é um sistema de gerenciamento de carrinho de compras que oferece aos usuários a capacidade de armazenar produtos e suas respectivas quantidades antes de efetuar o pedido de compra e finalizar o pagamento.


## Sumário
* [Instruções](#instrucoes)
* [Funcionalidades de Carrinho Service](#funcionalidades-de-carrinho-service)
* [Ilustração do MS Carrinho Service](#ilustração-do-ms-carrinho-service)


## Instruções

- Maven: Para build do projeto. **Para buildar:** mvn clean install
- Foi utilizado Lombok, Validation e MySql, portanto é necessário adicionar os plugins na IDE
- Antes de iniciar a instância dos Microserviços, é necessário garantir que os seguintes serviços estejam operacionais para garantir a operação adequada:</br>

	* **Service Discovery** - Inicie o Service Discovery. Execute e verifique se pelo menos uma instância do Service Discovery está operacional.</br></br>
	
	* **API Gateway** - Inicie o API Gateway. Verifique se pelo menos uma instância do API Gateway está em execução.


<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

### Funcionalidades de Carrinho Service

>[ Base URL: http://localhost:porta ] 

`Substitua <porta> pela porta atribuída dinamicamente pelo ambiente.`


Quando um usuário seleciona um produto e especifica a quantidade desejada, utilizamos este endpoint para criar um novo carrinho de compras, contendo os itens selecionados e suas respectivas quantidades. 

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``  
`*Para criar carrinho`

```
	/carrinhos
```
<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:8081/carrinhos/1' \
--header 'Content-Type: application/json' \
--data '[
    {
        "idProduto": 1,
        "quantidade": 2
    },
    {
        "idProduto": 2,
        "quantidade": 3
    },
    {
        "idProduto": 3,
        "quantidade": 5
    }

]'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornado o carrinho com os produtos escolhidos, quantidade, preço unitário e valor total.`

```
{
    "idCarrinho": 31,
    "idUsuario": 1,
    "itens": [
        {
            "idItem": 117,
            "idProduto": 1,
            "quantidade": 2,
            "precoUnitario": 90.0
        },
        {
            "idItem": 118,
            "idProduto": 2,
            "quantidade": 3,
            "precoUnitario": 30.0
        },
        {
            "idItem": 119,
            "idProduto": 3,
            "quantidade": 5,
            "precoUnitario": 15.0
        }
    ],
    "valorTotal": 345.0
}
```

</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para obter carrinho pelo id`

```
	/carrinhos/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:8081/carrinhos/31'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornado o carrinho do usuário`

```
{
    "idCarrinho": 31,
    "idUsuario": 1,
    "itens": [
        {
            "idItem": 117,
            "idProduto": 1,
            "quantidade": 2,
            "precoUnitario": 90.0
        },
        {
            "idItem": 118,
            "idProduto": 2,
            "quantidade": 3,
            "precoUnitario": 30.0
        },
        {
            "idItem": 119,
            "idProduto": 3,
            "quantidade": 5,
            "precoUnitario": 15.0
        }
    ],
    "valorTotal": 345.0
}
```

404 - _Not Found_

```
{
    "code": "carrinho.arrinhoNaoEncontrado",
    "message": "Carrinho não encontrado."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``PUT``
`*Para alteração de dados do carrinho`

Após a criação do carrinho, caso o mesmo ainda esteja em aberto, ou seja, o pagamento ainda não foi efetuado, o usuário consegue alterar itens e quantidade.

```
	/carrinhos/{id}/{idUsuario}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request PUT 'http://localhost:8081/carrinhos/31/1' \
--header 'Content-Type: application/json' \
--data '[
    {
        "idProduto": 1,
        "quantidade": 2
    },
    {
        "idProduto": 3,
        "quantidade": 20
    },
     {
        "idProduto": 4,
        "quantidade": 1
    }
]'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_

</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``PUT``
`*Para inativar carrinho`

Após fechado o pedido e finalizado o pagamento do valor total do carrinho, o carrinho será inativado. 
**Este endpoint é exclusivo do microserviço pedido-service.**

```
	/carrinhos/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request PUT 'http://localhost:8081/carrinhos/31'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_

</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

<a name="tecnologias"></a>
## 📍️ Tecnologias

- A API foi construída em Java 18 utilizando Spring Framework 3.2.3
- Padrão REST na construção das rotas e retornos
- SLF4J para registro de logs
- Utilização de código limpo e princípios **SOLID**
- Boas práticas da Linguagem/Framework
- Clean architecture
- Banco de Dados MySql
- Para facilitar a comunicação entre microserviços, o projeto utiliza o Spring Cloud Feign. 
- Service Discovery
- API Gateway

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

### Ilustração do MS Carrinho Service

![carrinho-service.png](src%2Fmain%2Fjava%2Fdocument%2Fcarrinho-service.png)