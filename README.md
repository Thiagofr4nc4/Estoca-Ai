# Estoca-Ai

Estoca-Ai é um sistema simples de **controle de estoque de produtos**, desenvolvido para uso interno/local. Ele permite gerenciar produtos, registrar entradas e saídas, e acompanhar transações relacionadas ao estoque.

O projeto foi implementado utilizando **Java (Spring Boot)** no backend e um front-end simples em **HTML, CSS, JavaScript e Bootstrap**.

---

## Funcionalidades

### Produtos

* Listar produtos cadastrados.
* Criar novos produtos.
* Editar produtos existentes.
* Deletar produtos.
* Registrar **entrada** e **saída** de produtos.

### Transações

* Listar todas as transações de estoque.
* Filtrar transações por **responsável** ou **solicitante**.

### Front-end

* Tabelas dinâmicas para produtos e transações.
* Modais para criação/edição de produtos e registro de entradas/saídas.

---

## Estrutura do Projeto

```
src/main/java/com/Estoca_Ai/
├── Controller/          # Endpoints REST
│   ├── ProdutosController.java
│   └── TransacoesController.java
├── Entity/              # Entidades JPA
│   ├── Produto.java
│   └── Transacoes.java
├── Repository/          # Interfaces de acesso ao banco
│   ├── ProdutoRepository.java
│   └── TransacoesRepository.java
├── Services/            # Lógica de negócio
│   ├── ProdutoService.java
│   └── TransacoesService.java
```

Front-end está localizado em `src/main/resources/static/`:

* `index.html` → Tela principal de produtos.
* `transacoes.html` → Tela de transações.

---

## Tecnologias

* **Backend:** Java, Spring Boot, Spring Data JPA.
* **Banco de Dados:** H2 (em memória) ou outro configurável.
* **Frontend:** HTML, CSS, JavaScript, Bootstrap 5.
* **Outros:** Fetch API para comunicação com o backend.

---

## Como usar

1. Clone o repositório:

   ```bash
   git clone <Thiagofr4nc4/Estoca-Ai>
   ```
2. Abra o projeto em uma IDE (IntelliJ, Eclipse) e execute como aplicação Spring Boot.
3. Acesse o sistema no navegador:

   ```
   http://localhost:8080/index.html
   ou
   http://localhost:8080/swagger-ui/index.html para visualizar endpoints
   ```
4. Gerencie produtos e visualize transações diretamente pelas telas.

---

## Observações

* O sistema é **voltado para uso interno/local**, portanto **não possui autenticação**.
* Para produção ou uso em rede, recomenda-se adicionar **login e proteção de rotas**.
* O front-end é simples e responsivo, focado apenas em funcionalidade interna.

---

## Autor

**Thiago França**
