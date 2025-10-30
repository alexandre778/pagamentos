AGMSOFTWARE - Sistema de Pagamentos

Sistema web desenvolvido com Spring Boot, Thymeleaf, Spring Data JPA e MySQL para gerenciar pagamentos de empresas.

Funcionalidades

Cadastro de novos pagamentos

Lista de pagamentos registrados

Edição e exclusão de pagamentos

Mensagem de pagamento realizado com sucesso

Navegação simples entre telas

Estrutura de Telas
1. Tela Inicial (index.html)

Opções principais:

➕ Novo Pagamento

📋 Ver Lista de Pagamentos

2. Formulário de Pagamento (form-pagamento.html)

Campos principais:

Nome da Empresa

Tipo de Imposto (PIS ou IPI)

PIS Débito

PIS Crédito

Valor Calculado

Botões: Salvar e Cancelar

3. Lista de Pagamentos (lista-pagamentos.html)

Exibe todos os pagamentos cadastrados com opções:

✏️ Editar

🗑️ Excluir

➕ Novo Pagamento

🏠 Voltar ao Início

4. Confirmação de Pagamento (pagamento-sucesso.html)

Mensagem de sucesso após salvar um pagamento, com botões para:

Voltar ao Início

Ver Lista de Pagamentos

Navegação

Início: /

Lista de Pagamentos: /pagamentos

Novo Pagamento: /pagamentos/novo

Edição de Pagamento: /pagamentos/editar/{id}

Exclusão de Pagamento: /pagamentos/excluir/{id}

Tecnologias Utilizadas

Java 21

Spring Boot 3.2

Spring Data JPA / Hibernate

Thymeleaf

Bootstrap 5.3

MySQL
© 2025 AGMSOFTWARE - Todos os direitos reservados
