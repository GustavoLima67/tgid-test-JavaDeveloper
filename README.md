**Projeto TGID**

*Descrição*

- O Projeto TGID é um aplicativo Java que simula um sistema de investimentos entre clientes e empresas. O aplicativo permite que um cliente faça um investimento em uma empresa, atualize o saldo do cliente e da empresa, e envie notificações por email e webhook.

**Requisitos**

- JDK 11 ou superior
- Spring Boot
- Estrutura do Projeto
- Pacotes

  
**Classes Principais**

**Cliente**
- Representa um cliente com um CPF e um saldo. Permite depositar dinheiro e investir na empresa.**

*Métodos principais:*
- depositar(double quantia): Adiciona uma quantia ao saldo do cliente.
- investir(double valorInvestido): Subtrai uma quantia do saldo do cliente para investir na empresa.

**Empresa**
- Representa uma empresa com um CNPJ e um saldo. Permite receber investimentos de clientes.

*Métodos principais:*
- receberInvestimento(Cliente cliente, double valor): Adiciona o valor investido ao saldo da empresa e atualiza o saldo do cliente.
- ProjectTgidApplication
- Classe principal que gerencia o fluxo do aplicativo, incluindo a entrada de dados do usuário, criação de instâncias de cliente e empresa, e envio de notificações.

**Como Executar**
*Clone o repositório:*

git clone https://github.com/usuario/project-tgid.git
- Navegue até o diretório do projeto:

cd project-tgid
- Compile e execute o aplicativo:

mvn spring-boot:run
**ou, se preferir, use a IDE de sua escolha para executar a classe ProjectTgidApplication.**

**Funcionalidades**
- Validação de CPF e CNPJ: Verifica se o CPF e o CNPJ fornecidos são válidos.
- Depósito e Investimento: Permite que o cliente deposite dinheiro e faça investimentos na empresa.
- Notificações: Envia notificações de transações por email e webhook.
- Informações: Exibe informações detalhadas sobre o cliente e a empresa.

**Exceções**
*O aplicativo lança exceções personalizadas para gerenciar erros:*
- ExcecaoCliente: Lançada em casos de erro relacionado ao cliente.*
- ExececaoEmpresa: Lançada em casos de erro relacionado à empresa.*
- InformacoesAdicionais: Lançada em casos de erro ao obter informações adicionais.
