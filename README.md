Projeto de Gestão de Usuários e Investimentos

Este projeto é uma API RESTful desenvolvida em Spring Boot para gerenciamento de usuários e investimentos.
O sistema permite o cadastro, atualização, consulta e remoção de usuários e investimentos, 
oferecendo uma estrutura organizada para simular o controle de ativos financeiros.

Funcionalidades principais:
.Usuários (/user)
    GET /user → Lista todos os usuários.

    POST /user → Cria um novo usuário.

    GET /user/{id} → Busca um usuário pelo seu ID.

    PUT /user → Atualiza os dados de um usuário existente.

    DELETE /user/remove → Remove um usuário pelo ID.

.Investimentos (/investments)

    GET /investments → Lista todos os investimentos cadastrados.

    GET /investments/{type} → Lista os investimentos filtrando por tipo (ex: CRIPTO, ACAO).

    POST /investments → Cria um novo investimento vinculado a um usuário.

    PUT /investments/{id} → Atualiza as informações de um investimento existente.

    DELETE /investments/{id} → Remove um investimento pelo seu ID.

Objetivo

O projeto foi desenvolvido com foco didático para praticar a criação de APIs REST, 
manipulação de dados com Spring Data JPA e integração com banco de dados relacional. 
Ele pode ser facilmente expandido para cenários reais de controle de investimentos.
