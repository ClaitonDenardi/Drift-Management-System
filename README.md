# Sistema com banco de dados Multiparadigma

### Descrição

Sistema de gerenciamento de eventos de Drift.
O objetivo do trabalho era desenvolver um sistema que conseguisse consumir tanto bases de dados relacionais quanto não relacionais.

### Techs

- Java
- HTML + CSS + Js
- Ajax
- Maven
- GlassFish
- MongoDB E MySQL

### Design Patterns

- Data Access Object
- Abstract Factory
- Classes e interfaces comuns aos dois SGBDs

### Como Utilizar

- Importar projeto para uma IDE, preferencialmente no NetBeans (IDE utilizada na implementação)
- Executar o script de criação do bd relacional 'PGBD/src/main/java/banco/relacional/mysql/sql/eventos_dql.sql'
- Configurar as classes 'BdMongo.java' e ' BdMySQL.java' de acordo com sua base de dados
- Para realizar a troca entre bancos altere o arquivo 'DBSwitch.java' localizad juntamente com os outros controllers

OBS: Junto ao código se encontra um PDF utilizado para ajudar na apresentação na época.
