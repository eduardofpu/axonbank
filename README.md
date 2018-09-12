# Descrição do problema 

```sh
Este projeto oferece um serviço de backend para cadastrar cidade e clientes
Acesse o site :

https://customers-challenge.herokuapp.com

e teste as rotas descritas abaixo...

caso deseje baixe o projeto para executar com  o postgres ou o H2 na porta localhot:8080
```
 
## 1. Dependências

Criar o projeto pelo spring.io:

    

//https://spring.io////https://start.spring.io/

Maven Project 1.4.0

org.axonframework.sample.axonbank
axonbank
axonbank
Demo project for Axon Framework
org.axonframework.sample.axonbank
jar
1.8
java

// web, HSQLDB, JPA, Lombok

 
## 2. Definição
 

```sh
$ DEFINE "CORE API"

$ IMPLEMENT GIVEN-WHEN-THEN TEST CASES

$ IMPLEMENT AGGREGATE

$ ST UP RUNTIME COMPONENTS USING CONFIGURATION API

```

 
## 3. Executando o Projeto
 

```sh


OUR CASE

BANK ACCOUNT

  CREATE
    ACCOUNT CREATED
    WITHDRAW MONEY
    ACCOUNT OVERDRAWN (EXCEPTION)
    DEPOSIT MONEY
    MONEY DEPOSITED

//

NOSSO CASO

CONTA BANCÁRIA

   CRIO
     CONTA CRIADA
     SACAR DINHEIRO
     CONTA OVERDRAWN (EXCEÇÃO)
     DEPOSITAR DINHEIRO
     DINHEIRO DEPOSITADO

```
 
## 4. Aggregate 

```sh

@CommandHandler
@EventSourcingHandler
apply()

```
 
## 5. Testes 

```sh

Test Fixtures

Given... when ... then ...

```
 
## 6. Configuration API 

```sh

Pure Java: (Defaut)Configurer
Spring: @EnableAxonAutoConfiguration
JPA Event Store configuration

CommandBus Customization

```