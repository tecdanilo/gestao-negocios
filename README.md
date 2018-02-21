[![Build Status](https://travis-ci.org/tecdanilo/gestao-negocios.svg?branch=master)](https://travis-ci.org/tecdanilo/gestao-negocios)
[![Sonar Status](https://sonarcloud.io/api/project_badges/measure?project=com.nexxera%3Agestao-negocio&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.nexxera%3Agestao-negocio)

#Avaliação - Gestão Negócio

Projeto de avaliação de skills de programação.

##Técnologias Utilizadas

1. Persistência:
    * Banco de Dados (Mysql)

2. Backend:
    * Springboot(REST, JPA, Lombok)

3. Frontend:
    * AngularJS  1.6 
    * Bootstrap 4
    * Npm
    * Yarn


##Considerações

    1. Não estão contemplados na inplementação:
        * segurança de API;
        * login;
        * validação de campos em tela;
        * minificação de código no frontend.
        * Aplicação de temas
    
    2. Para executar o projeto em IDES como Intellij e Eclipse, é necessária a instalação do plugin do lombok para que seja possível compilar o código.

##Instruções

Para executar a aplicação é necessário que se tenha o executável do npm.

Os passos do Build são:

npm install -g yarn

yarn install

mvn -Dspring.profiles.active=true

Obs.: para alterar os dados de conexão com o banco de dados, edite o arquivo application-local.yml


