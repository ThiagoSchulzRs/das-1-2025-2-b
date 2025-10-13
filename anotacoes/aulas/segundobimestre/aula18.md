# Aula do dia 13/10/2025.

### **Revisão das aulas passadas (09/10):**

Definição das Características da Arquitetura

## **Preparando o ambiente:** 

Link para a documentação da Microsoft
```
https://learn.microsoft.com/en-us/azure/architecture/patterns/cqrs
```
Link para o Livro (Precisa logar no site da Univille): 
```
https://integrada.minhabiblioteca.com.br/reader/books/9788550819754/epubcfi/6/26[%3Bvnd.vst.idref%3Dcap4.xhtml]!/4/2/20/2%4050:60
```

## **DCQRS pattern** 
A Segregação de Responsabilidade de Consulta de Comando (CQRS) é um padrão de design que separa as operações de leitura e gravação de um armazenamento de dados em modelos de dados separados.Essa abordagem permite que cada modelo seja otimizado de forma independente e pode melhorar o desempenho, a escalabilidade e a segurança de um aplicativo.

### **Contexto e problema**

![Imagem de sistema sem DCQRS](https://learn.microsoft.com/en-us/azure/architecture/patterns/_images/command-and-query-responsibility-segregation-cqrs-basic.png "Imagem de um sistema com banco de dados relacional clássico sem o DCQRS")

À medida que os aplicativos crescem, pode se tornar cada vez mais difícil otimizar as operações de leitura e gravação em um único modelo de dados.
- Incompatibilidade de dados;
- Contenção de bloqueio: (Operações paralelas no mesmo conjunto de dados podem causar contenção de bloqueio);
- Problemas de desempenho;
- Desafios de segurança;

### **DeadLock**
Problema que ocorre quando alguém está atualizando o banco de dados e outra pessoa está atualizando ou visualizando o mesmo banco, que da block nos dois.

### **Solução**

![Imagem do DCQRS](https://learn.microsoft.com/en-us/azure/architecture/patterns/_images/command-and-query-responsibility-segregation-cqrs-separate-stores.png#lightbox "Imagem de um sistema com o DCQRS")

Usar o padrão CQRS para separar operações de gravação, ou comandos, de operações de leitura ou consultas. Um banco de dados é responsável pela escrita e outro pela visualização, e o de visualização é atualizado só quando o da escrita estiver terminado de atualizar.

## **Fundamentos** 

### **A Grande Bola de Lama**
```
Uma Grande Bola de Lama é uma confusão de código espaguete mal estruturado, desleixado e unido com fita adesiva e arame. Esses sistemas mostram sinais inequívocos de crescimento desregulado e reparos rápidos e repetidos.
As informações são compartilhadas de modo indiscriminado entre os elementos distantes do sistema, normalmente ao ponto em que quase todas as informações importantes se tornam globais e duplicadas. Talvez a estrutura geral do sistema nunca tenha sido definida. Se foi, pode ter se perdido além do reconhecimento. 
Os programadores com um traço de sensibilidade arquitetural evitam esses atoleiros. Apenas quem não se preocupa com a arquitetura e, talvez, se sente bem com a inércia da obrigação diária de corrigir os furos nesses canais fracassados, fica contente em trabalhar em tais sistemas.
— Brian Foote e Joseph Yoder
```

Em termos modernos, uma grande bola de lama pode descrever uma aplicação de script simples com manipuladores de eventos ligados diretamente às chamadas de banco de dados, sem nenhuma estrutura interna real.

### **Arquitetura Unitária**
No começo, software e hardware eram uma única unidade. Durante as várias épocas de evolução do hardware e do software, os dois iniciaram como uma entidade, então se dividiram conforme aumentava a necessidade de capacidades mais sofisticadas. 
```
Exemplo: mainframes começaram como sistemas únicos e depois dividiram o armazenamento de dados em sistemas próprios. Da mesma forma, com o surgimento dos computadores pessoais, os sistemas inicialmente eram simples, mas a popularização dos PCs em rede levou ao desenvolvimento de sistemas distribuídos, como cliente/servidor.
```
Hoje, arquiteturas unitárias são raras, geralmente restritas a sistemas embarcados ou ambientes muito limitados. Sistemas modernos crescem em funcionalidade e precisam dividir responsabilidades para garantir desempenho e escalabilidade.

**Arquitetura Cliente/Servidor:** Essa é uma das primeiras formas de particionamento, separando o sistema em duas camadas principais — front-end (cliente) e back-end (servidor).

**Desktop + Servidor de Banco de Dados:** As aplicações desktop faziam a interface com o usuário, enquanto o processamento intenso era feito no servidor de banco de dados, que podia ser acessado via rede.

**Navegador + Servidor Web:** Com o avanço da web, o cliente passou a ser o navegador, que acessa o servidor web, que por sua vez se conecta ao banco de dados. Essa arquitetura mantém a separação de responsabilidades e facilita o acesso mais amplo, inclusive além dos firewalls.