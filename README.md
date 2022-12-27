# <p align="center">Part API</p>

## Tecnologias Utilizadas:

- Java 17
- PostgreSQL
- Spring Boot
- Maven
- Lombok

## Endpoints

- [x] <b>[POST] /api/parts</b> - cadastra uma nova peça.
- [x] <b>[GET] /api/parts/{id}</b> - retorna os dados de uma peça.
- [x] <b>[PUT] /api/parts/{id}</b> - altera os dados de peça. (costPrice, sellPrice e stockQuantity).
- [x] <b>[DELETE] /api/parts/{id}</b> - deleta os dados de uma peça.
- [x] <b>[GET] /api/parts</b> - retorna uma lista de peças.
- [x] <b>[GET] /api/parts/{startName}/start</b> - retorna uma lista de peças com nome iniciado pelo parametro.
- [x] <b>[GET] /api/parts/{modelName}/model</b> - retorna uma lista de peças por modelo de veículo.
- [x] <b>[GET] /api/parts/{category}/category</b> - retorna uma lista de peças por categoria.

### Exemplo de requests:

##### /api/parts POST:
```json
{
  "name": "Drift Coilovers",
  "carModel": "Supra Mk4",
  "sellPrice": 9200.0,
  "stockQuantity": 54,
  "category": "PERFORMANCE"
}
```
##### /api/parts/1 PUT:
```json
{
  "costPrice" : 3212.0,
  "sellPrice" : 6999.0,
  "stockQuantity" : 155
}
```

## Como rodar o projeto?

Baixe o <a href="https://www.postgresql.org/download/">PostgreSQL</a> <br>

Crie uma database para a aplicação normal e uma para o ambiente de testes.

### Configuração do Banco de Dados

No arquivo <b>application.properties</b> <i>(localizado no "src/main/resources")</i>

```properties
spring.datasource.url=jdbc:postgresql://<HOSTNAME>:<PORTA DO BANCO DE DADOS>/<NOME DA DATABASE/SCHEMA>
spring.datasource.username=<USUARIO>
spring.datasource.password=<SENHA>
```

#### Exemplo:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pecas-api
spring.datasource.username=postgres
spring.datasource.password=123
```

onde localhost é o hostname, 5432 a porta do banco de dados, e pecas-api o nome da database.