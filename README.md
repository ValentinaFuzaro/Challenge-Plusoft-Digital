# Solução
Nossa proposta é desenvolver uma plataforma para a Plusotf que tem como objetivo a coleta de feedback dos usuários finais dos produtos que a Plusoft desenvolve em todos seus segmentos. Dessa forma, contribuímos para que a jornada do cliente seja cada vez mais satisfatória e assertiva. A coleta de feedbacks é fundamental na jornada CX porque permite às empresas entenderem melhor como os usuários estão percebendo a experiência e o que pode ser feito para melhorá-la.

# How to
- 1º Acesse o Azure DevOps e vá para Repos para importar o repositório da sua aplicação.
- 2º	Para importar, clique na equipe que você criou, escolha "Import Repository," e adicione o link do repositório do GitHub.
## CI Pipelines (Build)
- 1º	Crie uma pipeline usando o editor clássico.
- 2º	Especifique o repositório e branch para o build.
- 3º	Escolha o template do projeto (por exemplo, Maven) e configure a pipeline com base no <a href="https://github.com/ValentinaFuzaro/Challenge-Plusoft-Digital/blob/main/pipeline.yaml">YAML</a> fornecido no link.
- 4º	Salve e execute o build.
## CD Pipeline (Deploy)
- 1º	Crie uma release clicando em "New Release."
- 2º	Escolha o template "Azure App Service deployment" e dê um nome para o Stage.
- 3º	Adicione o build criado em "Artifacts."
- 4º	Ative o filtro do artefato para a branch principal em "Pre-Deployment Conditions."
- 5º	Configure o Stage 1, adicionando a Assinatura da Azure, o nome do App Service, e outras configurações.
- 6º	Adicione variáveis, como um objeto "Server" com o valor "myserver.com.br."
- 7º	Salve a release e clique em "Create Release" para executá-la.
- 8º	Após o deploy, acesse Logs > Web App Deploy para encontrar a URL da aplicação.


# API feita para coletar feedbacks dos usuarios

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
