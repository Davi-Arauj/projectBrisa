# Recrutamento Brisanet: Desenvolvendo um sistema de gerenciamento de clientes em API REST com Spring Boot

Foi desenvolvido um pequeno sistema para o gerenciamento de clientes,endereços,pontos,contratos e historico de uma empresa através de uma API REST, criada com o Spring Boot.

## Foram desenvolvidos os seguintes tópicos:
 
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de gerenciamento de usuários (Cadastro, leitura, atualização e remoção de clientes,endereços,pontos,contratos e historico de um sistema).
* Implantação do sistema na nuvem através do Heroku

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

### O que foi utilizado para o desenvolvimento:

* Java 11;
* Maven 3.6.3;
* Spring Boot(Web, Data JPA, H2, Lombook, MapeerModel, Hibernate-validator,OpenAPI)
* GitHub
* Heroku
* Banco de Dados POSTGRESQL(Local)

## Observação:
## Com o banco de dados Postegresql devidamente instalado deve-se executar os seguintes comandos:
```
CREATE DATABASE recrutamento;
CREATE USER teste WITH PASSWORD '12345';
GRANT ALL PRIVILEGES ON DATABASE "recrutamento" to teste;
```

### URL da API no Heroku:

[testeBrisa](https://teste-brisa.herokuapp.com/swagger-ui-testebrisa-api.html)


