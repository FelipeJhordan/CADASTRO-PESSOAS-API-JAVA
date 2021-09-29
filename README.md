Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot

Neste projeto foi desenvolvido um pequeno sistema para o gestão de pessoas de uma empresa através de uma API REST, criada com o Spring Boot.

## Tópicos Abordados:

- Setup inicial de projeto com o Spring Boot Initializr
- Criação de modelo de dados para o mapeamento de entidades em bancos de dados
- Desenvolvimento de operações de gestão de utilizadores (Cadastro, leitura, atualização e remoção de pessoas de um sistema).
- Relação de cada uma das operações acima com o padrão arquitetural REST, e a explicação de cada um dos conceitos REST envolvidos durante o desenvolvimento do projeto.
- Desenvolvimento de testes unitários para validação das funcionalidades
- Implantação do sistema na nuvem através do Heroku
- Para executar o projeto no terminal, digite o seguinte comando:

`mvn spring-boot:run` 
Necessária instalação do Maven localmente (Windows: ADD Variável de ambiente / PATH)

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

`http://localhost:8080/api/v1/people`


## São necessários os seguintes pré-requisitos para a execução deste projeto:

- Java 8+ ou versões superiores.
- Maven 3.6.3 ou versões superiores.
- IntelliJ IDEA Community Edition ou sua IDE favorita.
- Controle de versão GIT instalado na sua máquina.
- Conta no GitHub para o armazenamento do seu projeto na nuvem.

## Pacotes Utilizados

- jUnit
- Spring Web
- Spring Boot Actuator
- Spring Dev Tools
- Lombok ( Abençoado seja o criador )
- Mapstruct
- H2 database
- spring-boot-validation ( em versões recentes do spring é necessário incluir )
