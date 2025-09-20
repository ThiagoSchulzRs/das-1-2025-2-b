# Resumo completo do Primeiro Bimestre DAS

##### **Glossário:**
> **Classe** - uma parte de código que consiste em elementos e métodos. <br>
**Interface** - não consiste em lógica de código, e sim as referencias de um método, servindo de ponte para um controlador.  <br>
**Classe abstrata** - pense em uma classe “pré-pronta” onde o código fica fechado, mas permitindo a expansão sem mudar a lógica interna.
**"Debugar"** - é percorrer o código parte por parte. Usado para entender o código e descobrir problemas usando um break point em linhas direto no código. <br>

## Introdução

### O que é orientação a objetos?

Surgiu como um modelo ou conjunto de padrões para resolver desafios. Onde se sustentam por quatro pilares:

**Encapsulamento**: que ocorre o agrupamento de dados e comportamentos de uma classe, podendo ocultar ou proteger informações para o resto do código. <br>
**Abstração:** define interfaces que representam conceitos do domínio, sem expor detalhes.<br>
**Herança:** permite criar hierarquias de classes, reaproveitando código e estendendo funcionalidades. <br>
**Polimorfismo:** possibilita tratar objetos de diferentes classes uniformemente, quando compartilharem uma interface ou classe-base.
```
No Polimorfismo você pode chamar o mesmo método em objetos diferentes, e cada um vai responder do seu jeito, respeitando sua própria implementação.
```
**Vantagens de POO:** código organizado e eficiente quando escrito da forma certa, os quais facilitam a realização de testes e manutenções.
- Reutilização de código, utilizando herança e/ou interfaces.
- Escalabilidade, por ser organizado. 
- Encapsulamento, onde lógicas são isoladas e assim, facilitam modificações e são menos propensas a serem atingidas por outros códigos.

### Definindo a abstração:
> Simplificação que permite interação sem conhecer detalhes internos, evitando assim a complexidade ao representar de forma simplificada uma entidade.

Na abstração, conseguimos interagir e utilizar a entidade sem a necessidade de saber todos os detalhes da mesma. Podemos ocultar informações, que são suscetíveis a mudanças, e mostrar somente uma interface estável. Para isso, utilizamos diversos tipos de classes, como: entidades, repositórios, serviços, controladores, e entre outros.

### Padrões de código (*Design patterns*):
São soluções reutilizáveis para problemas recorrentes. Soluções como essa, que já são “pré-definidas” utilizam da abstração e encapsulamento para ser possível de reutilizar da forma mais prática possível (adaptável) - o que promovem a robustez e coerência de um código. Exemplos: fabrica, fachada, observador e outros 

### Frameworks:
Estrutura técnica mais rígida que as bibliotecas convencionais, onde eles controlam o fluxo da aplicação ao estabelecer pontos de extensão e oferecendo funcionalidades já prontas. Tudo com um padrão arquitetural definido que guia o desenvolvimento, oferecem assim produtividade elevada, padronização e facilidade de manutenção.

### Complexidade:
A complexidade evolui conforme o escopo, onde cresce conforme as funcionalidades e interações do sistema aumentam. Por isso, utilizamos da abstração, que quebra a complexidade em pequenos problemas, facilitando a solução. Exemplo: 

> ###### Um carro <br>
> Pode mostrar métodos publicos, como **acelerar** e **freiar**. <br>
> Enquanto isso temos o **motor**, um detalhe oculto do método.

### O que é Coesão?
Código com coesão — ou coeso — significa ter o mínimo de codificação para realizar uma tarefa bem feita. Ele implementa uma única funcionalidade claramente, e não deve interferir em outras classes. Isso facilita a implementação, entendimento e por fim a manutenção. Pois somente um é responsável por manter um método.

### O que é Aclopamento?
_Setas de associação - que cria váriavel entre classes._

O acoplamento ocorre quando uma parte do código está diretamente ligada a outra. 

Quando esse vínculo torna os componentes totalmente dependentes entre si, onde pode gerar problemas futuros: `qualquer alteração em um módulo afetará automaticamente os seus dependentes, já que eles compartilham elementos essenciais.`  Por outro lado, um acoplamento considerado saudável ou aceitável é aquele que `permite modificações ou substituições em seus elementos sem impactar outras áreas do sistema.` Esse tipo de acoplamento favorece a flexibilidade, a manutenção e a evolução do código ao longo do tempo. 

> **_Maximize coesão, e minimine aclopamentos_**

___

## O QUE É SOLID?
> **S**ingle Responsibility Principle.<br> 
**O**pen/Closed Principle.<br>
**L**iskov Substitution Principle.<br>
**I**nterface Segregation Principle.<br>
**D**ependency Inversion Principle.

É um acrônimo criado por Robert Martin para auxiliar programadores a desenvolverem orientação a objetos do “jeito certo”. Ou seja, um código bem construído e escrito que tem o intuito de facilitar tanto o desenvolvimento, mas principalmente a manutenção do mesmo. `Solid é programar, orientado a objetos, do jeito certo.`

### Extras:
##### Tipos de setas:
> - Seta de herança (extends)- seta vazada com linha cheia.
> - Seta de interface/implementação (implements)- seta vazada com linha tracejada.
> - Seta da Associação (dependency) - seta cheia com linha cheia.

### _Single Responsibility Principle_
Diretamente ligado a coesão, onde `toda classe deve ter uma única responsabilidade`. Mas ainda consiste em ter um motivo para modificar qualquer classe em um sistema. Com isso, definimos que cada parte - como entity, repository, service e controller - devem ter sua responsabilidade bem definida. No entity, por exemplo, trabalha com dados. A lógica se aplica ao service, se o controller tiver alguma responsabilidade relacionada à lógica, não está mais sendo aplicado o princípio de responsabilidade única.
> Anotação Responsabilidade Única - Cada classe deve ter uma única razão para mudar. A partir do momento que existem outros motivos para o código ser alterado que não está ligado diretamente a funcionalidade principal da classe, ele irá quebrar esse principio.

### _Interface Segregation Principle_
Cada interface tem uma responsabilidade, ou seja, `classes não utilizam a mesma interface`. Mas fazer código e interface juntos, quebra o primeiro princípio da responsabilidade única. Quando estamos desenvolvendo, devemos criar um controlador, que irá então implementar a interface e observar eventos.
> Anotação Interface Segregada - Cada interface tem uma função única. Controlador implementa e gerencia múltiplas interfaces separadas.

### _Dependency Inversion Principle._
Recomenda-se que se que classes (controladores) dependam de abstrações -interfaces- ao serem mais flexíveis e estáveis. Facilmente testável e extensível. O controlador usa o "@Autowired" para ser possivel a conexão dinamicamente entre ele e a interface (que por sua vez comunica com o service).

> **_Prefira Interfaces a Classes_** onde você não depende de quem tem a lógica e sim, de um padrão de comunicação. Isso reduz aclopamento, já que a lógica do código não está ligada diretamente.

> Resumo: O controlador usa a interface como "contato", usando o polimorfismo e a injeção de dependência. <br>
> Polimorfismo = muitas formas.

###  Prefira Composição a Herança
A herança expõem tudo na classe pai, ou seja, o filho quebra todo o encapsulamento da classe pai. A composição, por outro lado, diferencia cada um, onde eles estão bem separados e não dividem o mesmo problema. <br>

### Princípio de Demeter
Ou principio do menor conhecimento. Onde métodos só devem invocar / chamar somente os seguintes outros métodos:
1. de sua própria classe;
2. de objetos passados como parâmetros;
3. de objetos criados pelo próprio método;
4. de atributos da classe do método.

**“Quer dizer o quê? Cuida da sua vida”** - o método não deve chamar coisas de fora e apenas cuidar de si mesmo
> Anotação Princípio Demeter - Cada método só pode chamar objetos "próximos", ou seja, os quais ele tem relação direta.

### Princípio Aberto/Fechado
> Uma classe deve estar fechada para modificações e aberta para extensões.

Onde se deve ter um controle em cima do código criado, pois uma modificação sem maior conhecimento pode quebrar o que já foi feito. Mas deve ser aberto a extensões, permitindo que outros possam adicionar coisas novas em cima do código existente. 

**_Reutilização de código, onde é preparado para ser utilizado de várias vezes de jeitos diferentes_**.

### _Princípio de Substituição de Liskov._
O objetivo desse principio é a possibilidade de substituição de uma classe sem que ocorra a quebra de código. Por exemplo: a troca de dispositivos diferentes – Mouse e Teclado – que iram funcionar, pois a comunicação entre eles é padrão. _Porta USB_

Se você tem um método que usa uma classe base - herança - ele deve funcionar perfeitamente com qualquer classe derivada dela. Isso mantém o sistema coeso, confiável e fácil de manter.

---

## Singleton
#### **(Ender-chest do minecraft)**

Singleton é um design pattern que guarda uma informação única, usada no sistema inteiro. Por exemplo, guardar uma senha e acessar ela em outras partes do sistema.

**Como fazer?** Cria uma classe que possui um construtor privado. Isso faz com que apenas ele pode criar uma variável com esse construtor, verificando primeiramente se já existe um dado nessa instância.

#### Cliente
É a classe que "usa" o singleton. O Cliente pode salvar uma informação no singleton caso ele esteja nullo. E chamar em qualquer parte do sistema, seja em outra classe ou várias linhas de código entre o set e get do singleton.

## _Observer_
Usa um metodo de **"assinaturas"** para notificar outras classes. Uma clase pode ser inscrita a esse método para receber notificação sobre ocorrências do publicador. Isso permite que a classe inscrita não gaste tempo verificando o publicador por alterações recentes, e também que o publicador não gaste com envios de "spam" para classes não interessadas em seus eventos.

Esse design utiliza uma lista onde classes "inscritas" serão armazenadas. O publicador então percorre essa lista quando vai notificar algum evento. Com isso, a inscrição pode ser removida da lista a qualquer momento e a classe removida deixara de receber mudanças do publicador.

---
## O que é arquitetura?

> É sobre algo importante, sejá lá o que for. <br>

Surgiu com inspiração na arquitetura tradicional (edificios), a qual foi a base que inspirou a arquitetura de software. Montamos uma arquitetura definindo três pontos principais para todo o sistema: **características, decisões e princípios**. 

### Características de Arquiteturas.

É igual a `requisitos não funcionais` sem eles o sistema não funciona. As características definem pontos base de todo o sistema, por exemplo: segurança, desempenho e agilidade. `Nunca é possível conseguir todos 100%`, por isso trocamos algumas partes de desempenho, por exemplo, para conseguir mais segurança.

### Termos:
- Disponibilidade: Capacidade do sistema de estar operacional e acessível quando necessário.
- Confiabilidade: Probabilidade de o sistema funcionar corretamente por um período determinado.
- Testabilidade: Facilidade com que o sistema pode ser testado para verificar se está funcionando como esperado.
- Escalabilidade: Capacidade de o sistema crescer (em usuários, dados ou carga) sem perda de desempenho.
- Segurança: Proteção contra acessos não autorizados, ataques e perda de dados.
- Agilidade: Facilidade e rapidez com que mudanças podem ser feitas no sistema.
- Tolerância a Falhas: Capacidade de continuar operando mesmo quando partes do sistema falham.
- Elasticidade: Habilidade de ajustar recursos automaticamente conforme a demanda aumenta ou diminui.
- Recuperação: Capacidade de restaurar o sistema após uma falha ou desastre.
- Desempenho: Eficiência com que o sistema responde às solicitações e processa dados.
- Implementabilidade: Facilidade de colocar o sistema em funcionamento, incluindo instalação e configuração.
- Capacidade de aprendizagem: Habilidade do sistema de melhorar seu desempenho com o tempo, geralmente associada a sistemas com inteligência artificial.

> Anotação Características de Arquitetura - São requisitos não funcionais essenciais, como segurança, desempenho e escalabilidade, que definem a base do sistema. Nem todas são 100% alcançáveis, por isso há trade-offs entre elas.

**O que é Supply Chain Software?** São softwares livres que fazem outros sistemas terem dependência em cima dele, mesmo não intencionalmente, que podem algum dia criar uma abertura para falhas.

**Decisões da arquitetura:** É quando você define a sua arquitetura através de escolhas estratégicas para suportar todo o seu sistema. Por exemplo, tecnologias que vão ser utilizadas, componentes necessários ou até o estilo de arquitetura que será desenvolvido, exemplo de microsserviços.

### Principio de design.
É uma `boa prática que deve ser seguida` para o sistema permanecer funcionando da melhor forma possível. Evitando, por exemplo, acoplamentos e ainda assim mantendo a eficiência e performance do sistema.

**Troca sincrona**: Quando mensagens são transferidas em tempo real. Mantendo microserviços chamando outros para recolher informações enquanto alguma ação acontece. Isso pode causar uma grande arvore, e dependencias de chamados caso o sistema seja muito grande. <br>

**Troca assincrona**: Quando há uma area ou aplicação separada do sistema que faz esses microserviços agirem como “observers” e guardem cópias de informações relevantes. Isso evita a criação de chamados, por mais que gaste mais espaço (HD) ele entrega performance ao usuario/sistema.

---
## Expectativas de um arquiteto:

#### Um arquiteto deve:
- **Aprender a tomar decisões:** É ele quem vai decidir qual a melhor rota para guiar um projeto ou atitudes a serem tomadas para evitar algum problema atual ou futuro.
- **Analisar e sugerir melhorias:** Sempre procurar a melhoria contínua, sugerindo mudanças que agregarão ao projeto.
- **Se manter atualizado:** Um arquiteto não vai parar de estudar, sempre procurando tendencias.
- **Garantir conformidade com as decisões:** Além de decidir, é preciso garantir que todos sigam as definições de arquitetura e design, evitando desvio que comprometam o projeto.
- Buscar experiências diversas – Um bom arquiteto se expõe a diferentes tecnologias, plataformas e ambientes, ampliando sua visão e capacidade de adaptação.
- **Conhecer o negócio:** Não basta entender de tecnologia. É essencial compreender o domínio do negócio para propor soluções que realmente agreguem valor.
- **Desenvolver habilidades interpessoais:** Saber se comunicar, liderar e trabalhar em equipe é tão importante quanto o conhecimento técnico. O arquiteto precisa ser ponte entre áreas e pessoas.
- **Lidar com o clima político:** Em qualquer empresa existem interesses e dinâmicas internas. O arquiteto deve saber navegar por essas questões com inteligência e equilíbrio.

> Anotação Expectativas de um Arquiteto - Deve tomar decisões estratégicas, propor melhorias, manter-se atualizado, garantir conformidade, entender o negócio, desenvolver habilidades interpessoais e lidar com o ambiente político da empresa.

---
## DevOps

> Técnica que une desenvolvedores (Dev) e Operação (Ops) para montar uma equiepe multdisciplinar. <br>

Entrega valor de forma rápida e continua. Essa técnica promove muita colaboração, além de automação e melhorias constantes. Mas tenha em mente que DevOps não é um caminho com destino, e sim, um processo onde exige muita adaptação e evolução.

![Imagem do Ciclo do DevOps](https://learn.microsoft.com/pt-br/training/wwl-azure/introduction-to-devops/media/devops-cycle-98924900-a8ba6dc4.png "Imagem do Ciclo do DevOps")

#### Práticas do DevOps:
- Planejamento Ágil
- Integração contínua
- Entrega contínua
- Monitoramento constante

#### Ciclo do DevOps
Imagine um símbolo do infinito, o caminho do DevOps não tem um fim. Ele é contínuo, girando em torno de melhorias e operações interligadas. As etapas principais são:

**Desenvolvimento** Planejamento e codificação constantes. <br>
**Integração** O código novo é integrado com frequência ao projeto principal, garantindo que tudo funcione bem e evitando conflitos. <br>
**Teste** Testes automatizados são realizados o tempo todo para detectar falhas rapidamente e evitar retrabalho.<br>
**Entrega** O software é preparado para ser entregue a qualquer momento, com segurança e estabilidade.<br>
**Implantação** As atualizações são lançadas automaticamente em produção, sem afetar o funcionamento do sistema.<br>
**Monitoramento** Tudo é monitorado: desempenho, erros, uso. Isso ajuda a detectar problemas antes que afetem os usuários.<br>
**Feedback** Informações dos usuários e métricas são coletadas para melhorar o produto e ajustar o que for necessário.<br>
**Operações** Automatização de tarefas operacionais para manter o sistema funcionando e liberar tempo para inovação.<br>

> Cada etapa desse ciclo é interligada e automatizada, podendo, se repetir e evoluir conforme o andamento do projeto.

#### Outras informações sobre DevOps:

**Cargo x Cultura:** Em algumas empresas, DevOps é um cargo ou uma equipe específica. Em outras, é parte da cultura, ou seja, todos na equipe precisam ter esse conhecimento e aplicar as práticas no dia a dia.<br>
**Ciclo PDCA (Plan, Do, Check, Act):** É um ciclo de melhoria contínua. Envolve planejar, executar, verificar e agir com base nos resultados. Requer tempo e repetição, mas cada volta no ciclo traz mais maturidade e eficiência.<br>
**Controle de versão**:  Nesse caso o Github. É uma ferramenta essencial para os DevOps.

---

## Arquitetura _vs_ Design

É importante marcar que a diferença entre eles não é rígida, ou seja, não existe uma linha falando onde um acaba e outro termina. Ambos fazem parte de um ciclo e devem estar em sincronia para o projeto ter sucesso. Dito isso, vamos falar da função do arquiteto, ou melhor, sua responsabilidade. Analises de requisitos - tanto comerciais quanto do projeto em si - e definir características da arquitetura do sistema, são algumas dessas atuações que um arquiteto faz em um projeto. Mas com isso temos um problema, comunicação entre arquiteto e desenvolvedor. 

No texto do livro - _Cap.2 Pensamento Arquitetônico_ - Vemos uma imagem que traz um meio tradicional. Que por si gera problemas, não notificando o arquiteto de uma alteração que o próprio desenvolvedor precisou realizar durante o desenvolvimento. Já na segunda imagem temos um ambiente fluido, onde arquiteto e desenvolvedor conseguem manter uma comunicação frequente, que por sua vez, auxiliara na evolução do projeto. Por fim, permite que a implementação da arquitetura seja mais coerente e organizada.

> **Diferença entre os dois:** <br>
A arquitetura define componentes e estratégias, montando a base estrutural para o projeto. Essa base vai para o Desing, onde tem o foco de implementar dentro da arquitetura definida. Focando em tornar o sistema mais legivel, e por isso, nos preocupamos com a comunicação entre eles.

### Modelo T - Amplitude Técnica

Para um arquiteto é muito importante que ele saiba vários pontos importantes - mesmo que seja parcialmente raso - sobre assuntos diferentes. Focando em ampliar o conhecimento, sem aprofundar em algo único. _O que pode levar a outra diferença entre Arquitetura e Design_. Mas isso permite ao arquiteto ter uma visão mais ampla, encontrando soluções, por exemplo, em ferramentas diferentes das que normalmente estão no seu cotidiano.

Claro, deve-se fixar em coisas que você sabe. Afinal elas podem evoluir e atualizar com o tempo. Mas tendo em mente que ela também podem ficar obsoletas, por isso a incessante busca por conhecimento. No livro vemos uma imagem de uma piramide, que simboliza esse “conhecimento”:

> **- O que você sabe** <br>
> **- O que você sabe que não sabe** <br>
> **- O que você não sabe que não sabe**

Resumindo, é mais beneficial que a formação de um arquiteto seja ampla. 

> Anotação Modelo T, Amplitude Técnica - A formação de um arquiteto deve ser ampla e versátil, com conhecimento raso em várias áreas e foco em aprendizado contínuo. Isso permite visão estratégica, adaptação e soluções fora do padrão.

--- 
## Trade-offs
> Compensação - é impossivel criar algo totalmente perfeito.

Um exemplo é o sistema onde abrimos mão da simplicidade para ganhar mais performance - Mudando a arquitetura - como um banco de dados único não consegue aguentar um sistema grande, ele causa a perda de desempenho. Ajustamos então para uma lógica de observer, por exemplo, onde uma mesma mensagem é enviadas para todos os sistemas que precisam dessa informação para o leilão ocorrer.

#### Arquitetura em tópico
Tipo um observer, envia uma mensagem e os inscritos recebem como uma notificação. Porém se o inscrito não estiver disposnivel, a mensagem é perdida. 
Exemplo: _Notificação de promoção, ela ocorre automaticamente após você assinar_
- **Um para Muitos**

#### Arquitetura em Fila
Nessa arquitetura o recebedor deve buscar a sua mensagem na fila, que é uma para cada serviço. Quando ele buscar, o recebedor deve procecessar a sua própria mensagem. Além disso o anunciador envia uma cópia da mensagem para cada um, com a fila para armazenar a ordem da mensagem. O que gera redundancia, mas compensamos com a possibilidade de armazenamento, que evita a perda da mensagem.
- **Um para Um**

### Diferença entre Tópico e fila
Em tópicos existe apenas uma conexão, a escalabilidade é maior, gerando menos impacto. Porém, mesmo não tendo acoplamento, o anunciador tem que enviar uma grande mensagem para suprir os três sistemas acoplados ao tópico.  
Já a Fila, precisamos mudar e adicionar mais do que um novo sistema, adicionando mais filas - Maior aclopamento - Porém, agora podemos enviar mensagens menores e separadas para cada um.

#### Fan-out
Uma arquitetura que mistura, tópicos e filas. Resolve problemas de acoplamento, buffer's e monitoramentos. Mas ainda não é resolvido o envio de mensagens personalizadas, já que ainda estamos usando a arquitetura de tópicos.

> Anotação Resumo: <br>
Toda arquitetura exige compensações: não há solução perfeita.
**Tópico (Um para Muitos)**: envia uma única mensagem para vários inscritos, mas pode perder dados. <br>
**Fila (Um para Um)**: cada serviço busca sua própria mensagem, garantindo armazenamento, mas com mais acoplamento e redundância. <br>
**Fan-out**: mistura tópicos e filas, reduz acoplamento e melhora monitoramento, mas ainda não permite mensagens personalizadas.