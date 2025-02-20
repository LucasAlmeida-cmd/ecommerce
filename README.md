# API RESTful - Ecommerce 

## Diagrama de Classe:

```mermaid
classDiagram
    class Pedido {
        -User User
        -List~Produto~ produtos
    }

    class User {
        -Long id
        -String nome
        -String email
    }

    class Produto {
        -Long id
        -String nome
        -Double preco
    }

    Pedido "1" --> "1" User : User
    Pedido "1" --> "*" Produto : produtos
```
