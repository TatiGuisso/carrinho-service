<a name="readme-top"></a>

# Introdução

O Carrinho Service é um sistema de gerenciamento de carrinho de compras que oferece aos usuários a capacidade de armazenar produtos e suas respectivas quantidades antes de efetuar o pedido de compra e finalizar o pagamento.


## Sumário
* [Instruções](#instruções)
* [Funcionalidades de Carrinho Service](#funcionalidades-de-carrinho-service)
* [Upload de Video](#upload-de-video)
* [Pesquisa Videos](#pesquisa-videos)
* [Obter Url](#obter-url)
* [Favoritar Video](#favoritar-video)
* [Recomendação de Videos](#recomendacao-de-videos)
* [Estatística](#estatistica)
* [Usuário](#usuario)
* [Tecnologias](#tecnologias)
* [Desafios](#desafios)


## Instruções

- Maven: Para build do projeto. **Para buildar:** mvn clean install
- Foi utilizado Lombok, Validation e MySql, portanto é necessário adicionar os plugins na IDE
- Antes de iniciar a instância do microserviço Carrinho-Service, é necessário garantir que os seguintes serviços estejam operacionais:
	* Service Discovery  &  API Gateway

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

### Funcionalidades de Carrinho Service

>[ Base URL: http://localhost:porta ] 

`Substitua <porta> pela porta atribuída dinamicamente pelo ambiente.`


Quando um usuário seleciona um produto e especifica a quantidade desejada, ele pode utilizar este endpoint para criar um novo carrinho de compras, contendo os itens selecionados e suas respectivas quantidades. 

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
    "idCarrinho": 9,
    "idUsuario": 15,
    "itens": [
        {
            "idItem": 25,
            "idProduto": 67,
            "quantidade": 1,
            "precoUnitario": 31
        },
        {
            "idItem": 26,
            "idProduto": 33,
            "quantidade": 1,
            "precoUnitario": 18
        },
        {
            "idItem": 27,
            "idProduto": 28,
            "quantidade": 1,
            "precoUnitario": 25
        }
    ],
    "valorTotal": 74
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
curl --location 'http://localhost:8081/carrinhos/13'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornado o carrinho do usuário`

```
{
    "id": "65a5b14ba6bf7a1d75bbc83d",
    "titulo": "Robocop",
    "descricao": "Policial fatalmente ferido é usado como cobaia por uma empresa de tecnologia robótica",
    "dataPublicacao": "2024-01-08",
    "quantidadeVisualizacao": 2,
    "categoria": "FICCAO"
}
```

404 - _Not Found_

```
{
    "code": "tc.videoNaoEncontrado",
    "message": "Video não encontrado."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``PUT``
`*Para alteração de dados do carrinho`

```
	/carrinhos/{id}/{idUsuario}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request PUT 'http://localhost:8081/carrinhos/14/1' \
--header 'Content-Type: application/json' \
--data '[
    {
        "idProduto": 10,
        "quantidade": 3
    },
    {
        "idProduto": 20,
        "quantidade": 1
    },
    {
        "idProduto": 30,
        "quantidade": 2
    }
]'
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``PUT``
`*Para inativar carrinho após fechar pedido e finalizar o pagamento`

```
	/carrinhos/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request PUT 'http://localhost:8081/carrinhos/14'
```
</details>


<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>


---------
<a name="tecnologias"></a>
## 📍️ Tecnologias

- As API's foram construídas em Java 17 utilizando Spring Framework 3.2.1
- Padrão REST na construção das rotas e retornos
- SLF4J para registro de logs
- Utilização de código limpo e princípios **SOLID**
- Boas práticas da Linguagem/Framework
- Clean architecture
- Banco de Dados MongoDB
- JUnit e Mockito

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>


