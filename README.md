# Challenge

Uma API feita para coletar feedbacks dos usuarios

## Endpoints
- Usuarios
    -[Cadastrar](#cadastrar-usuarios)
    - Listar todos
    - Apagar
    - Alterar 
    - [Mostrar detalhes](#)
- Feedbacks
    -[Cadastrar](#cadastrar-feedbacks)
    - Listar todas
    - Apagar
    - Alterar

---

### Cadastrar Usuários
`POST` /api/usuarios

|campo | tipo | obrigatório | descrição
|------|------|-------------|----------
|name_user|texto|sim|é o nome do usuário. deve ter no máximo 255 caracteres
|email_user|texto|sim|é o email do usuário. deve ter no maximo 255 caracteres
|cellphone_user|texto|sim|é o número do usuário. deve ter 9 caracteres
|company_user|texto|sim|é a empresa em que o usuário trabalha
|data_user|data|sim|é a data em que o usuario começou o seu registro

**Exemplo de corpo do request**

```js
{
   "nome_user": "Lorem Ipsum",
   "email_user": "lorem@example.com",
   "cellphone_user": "954557812",
   "company_user": "Lorem Ipsum & Company",
   "date_user": "01/01/2023"
}
```

**Código de Respostas**

|código|descrição
|------|---------
|201|usuário cadastrado com sucesso
|400|erro na validação de dados da requisição

---

### Adicionar Feedbacks
`POST` /api/feedbacks

|campo | tipo | obrigatório | descrição
|------|------|-------------|----------
|description_feedback|texto|sim|é a mensagem de feedback deixado pelo usuário
|date_feedback|date|sim|é a data em que o feedback foi feito

**Exemplo de corpo do request**

```js
{
   "description_feedback": "Lorem Ipsum",
   "date_feedback": "01/01/2023"
}
```

**Código de Respostas**

|código|descrição
|------|---------
|201|feedback cadastrado com sucesso
|400|erro na validação de dados da requisição

---

### Listar Feedbacks
`GET` /api/feedbacks{id}

**Exemplo de corpo do request**

```js
{
   "feeback_id": 1,
   "description_feedback": "Lorem Ipsum",
   "date_feedback": "01/01/2023"
}
```

**Código de Respostas**

|código|descrição
|------|---------
|200|dados retornados no corpo da resposta
|404|não foi encontrado

### Listar Usuarios
`GET` /api/usuarios{id}

**Exemplo de corpo do request**

```js
{
   "id_user": 1,
   "nome_user": "Lorem Ipsum",
   "email_user": "lorem@example.com",
   "cellphone_user": "954557812",
   "company_user": "Lorem Ipsum & Company",
   "date_user": "01/01/2023"
}
```

**Código de Respostas**

|código|descrição
|------|---------
|200|dados retornados no corpo da resposta
|404|não foi encontrado
