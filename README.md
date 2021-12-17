# Recrutamento Brisanet: Desenvolvendo um sistema de gerenciamento de clientes em API REST com Spring Boot

Foi desenvolvido um pequeno sistema para o gerenciamento de clientes,endereços,pontos,contratos e historico de uma empresa através de uma API REST, criada com o Spring Boot.

## Forão desenvolvidos os seguintes tópicos:
 
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de gerenciamento de usuários (Cadastro, leitura, atualização e remoção de clientes,endereços,pontos,contratos e historico de um sistema).
* Implantação do sistema na nuvem através do Heroku

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```
Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/clientes
```
###Com esse ednpoint no metodo GET irá retornar todos os Clientes
```
http://localhost:8080/api/v1/clientes/{id}
```
###Com esse ednpoint no metodo GET irá retornar apenas um Cliente
```
http://localhost:8080/api/v1/clientes/{id}
```
###Com esse ednpoint no metodo DELETE irá APAGAR apenas um Cliente
```
http://localhost:8080/api/v1/clientes/{id}
```
###Com esse ednpoint no metodo PUT irá ATUALIZAR o Cliente referente ao id
###Passando no Content-Type: application/json
###{
###"nome" : "Cliente da Silva",
###"tipo" : "jurídico"
###}

http://localhost:8080/api/v1/enderecos
http://localhost:8080/api/v1/pontos
http://localhost:8080/api/v1/contratos
http://localhost:8080/api/v1/contratos/{id}/historico
```


### O que foi utilizado para o desenvolvimento:

* Java 11;
* Maven 3.6.3;
* Spring Boot(Web, Data JPA, H2, Lombook, MapeerModel, Hibernate-validator,OpenAPI)
* GitHub
* Heroku

### URL da API no Heroku:

[testeBrisa]https://teste-brisa.herokuapp.com/

