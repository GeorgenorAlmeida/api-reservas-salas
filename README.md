Este projeto é parte integrante de um desafio de programação.

Dentro do seu contexto, o principal objetipo é a construção de APIs para uma empresa de aluguel de salas (Coworking).
Na solução que aqui proponho, coloco mais detalhadamente soluções para uma empresa que encontra-se com limitações técnicas por estar com seus 
controles executados através de planilhas manuais e descentralizadas.

Tecnologias Utilizadas
======================
1. Padrão de arquitetura REST para a construção da API;
2. Requisições de envio e recebimento com padrões de dados em JSON;
3. Spring Boot Java JDK 17;
4. Banco de dados H2 embutido no Spring Boot;

Programas utilizados
====================
1. Git-2.54.0-64-bit.exe
2. intellij-idea-2026.1.2.exe
3. OpenJDK17U-jdk_x64_windows_hotspot_17.0.19_10.msi
4. Postman (x64).exe

Contexto do Desenvolvimento
===========================
Utilizei arquitetura em camadas seguindo padrão REST com Spring Boot.
Os códigos de persistência das informações foram separadas de forma a garantir a melhor padronização e estruturação para a codificação das regras de negócio.

Utilizei os padrões Controller (requisições HTTP), Service (Regras de negocio), Repository (acesso ao BD) e Entity (Tabelas de controle).
Além disto, criei especificamente um controle de exception para garantir uma legibilidade melhor na interpretação de execução de regras de negócio oriundas do banco. Isto permite a personalização do JSON de retorno com mensagens mais personalizadas, traduzindo para os desenvolvedores uma validação melhor na interpretação dos dados.

Para a persistência dos dados, simplifiqui conforme solicitado a utilização no banco de dados H2. Assim, tornou desnecessário para testes a utilização de um banco de dados externo.

As nomenclatura das tabelas e seus campos modelei em português para facilitar a legibilidade e entendimento funcional do sistema.
Priorizei a simplicidade para que o objetivo do trabalho fosse concluído de maneira eficiente e também de forma objetiva em alinhamento com todos os requisitos funcionais e não funcionais solicitados no problema.

Classes e Relacionamentos
=========================

**Clientes**                                            
codigoCliente (pk)(inc)                     
nome                                        
sobrenome                                        
cpfCNPJ (uq)                                             
email                                                    
telefone                                                 
tipoPessoa

**Salas**
codigoSala (pk)(inc)
nomeSala (uq)
tipoSala

**Agendamentos**
codigoAgendamento (pk)(inc)
codigoCliente (fk - Clientes)
codigoSala (uq)(fk - Salas)
dataAgendamento (uq)
horaAgendamento (uq)
statusAgendamento

Requisitos Funcionais da API
============================
1. O sistema deve manter um cadastro atualizado de Clientes;
2. O sistema não devera permitir o cadastramento de dois clientes com o mesmo cpfCNPJ;
3. O sistema deve manter um cadastro atualizado de Salas;
4. O sistema não poderá permitir o nome de duas salas em duplicidade;
5. Os tipos de sala a ser mantido são (COLETIVAS, INDIVIDUAIS, AUDITORIO);
6. O sistema deverá manter um cadastro atualizado de agendamentos;
7. Neste cadastro, torna-se obrigatório a inclusão do codigoCliente e codigoSala.

Requisitos Funcionais Especiais da API
======================================
1. Sistema deverá consultar todos os agendamentos de uma sala específica;
2. Sistema deverá consultar a disponibilidade de uma sala específica e também por data e hora (escolhida por um cliente);
3. Sistema deverá consultar todos os horários agendados de uma sala em um determinado dia;
4. Sistema deverá listar clientes através de busca pelo nome;



