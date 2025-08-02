# Aula do dia 31/07/2025.

### **Orientação a objetos(OO):** 
A Orientação a objetos surgiu como paradigma para resolver esses desafios, apoiando-se em quatro pilares: 
- Encapsulamento: agrupa dados e comportamentos numa mesma unidade (classe) e esconde o estado interno.
- Abstração: define interfaces que representam conceitos do domínio, sem expor detalhes.
- Herança: permite criar hierarquias de classes, reaproveitando código e estendendo funcionalidades.
- Polimorfismo: possibilita tratar objetos de diferentes classes de forma uniforme, desde que compartilhem uma interface ou classe-base.

As vantagens da OO incluem modularidade (facilitando testes e manutenção), reuso de código via herança ou interfaces, escalabilidade de aplicações e maior produtividade ao permitir que desenvolvedores se especializem e componham sistemas de forma mais organizada. Ao encapsular lógicas complexas em objetos, erros ficam mais isolados e modificações tornam-se menos propensas a efeitos colaterais 

### **Abstração:**
A Abstração é a ocultação de informação, que protege detalhes suscetíveis a mudanças expondo apenas uma interface estável. Isso permite que partes do sistema evoluam sem afetar o restante — por exemplo, mudar representação de dados interna sem impactar os consumidores do componente. Assim, os softwares tem o objetivo de abstrair a complexidade de problemas reais para criar soluções para estes mesmos problemas para isso o software utiliza diversos tipos de classes, sendo elas: Entidades, repositórios, serviços, controladores, etc..

### **Padrões de código (ou design patterns):** 
Padrões de código formalizam soluções recorrentes para problemas estruturais – como fábrica, fachada, observador, entre outros – promovendo robustez, coerência e reuso sem reinventar a roda. Eles geralmente usam os princípios de abstração e ocultação para fornecer estruturas genéricas que podem ser aplicadas com adaptabilidade.

### **Frameworks:** 
Frameworks fornecem uma estrutura técnica mais rígida do que bibliotecas convencionais, pois eles definem o controle do fluxo da aplicação, estabelecem pontos de extensão e oferecem funcionalidades prontas, tudo com um padrão arquitetural definido que guia o desenvolvimento. Com isso, oferecem produtividade elevada, padronização e facilidade de manutenção.

### **Complexidade:** 

A complexibilidade de um sistema de software geralmente cresce conforme escopo, funcionalidades e interações evoluem. Para torná-la gerenciável, recorre-se à abstração, que consiste em representar entidades complexas por interfaces simplificadas, destacando apenas os aspectos relevantes. Por exemplo, uma classe Carro pode expor apenas métodos públicos como acelerar() e frear(), enquanto detalhes internos do motor ficam ocultos. Esse tipo de abordagem reduz o esforço cognitivo e facilita alterações futuras sem impactar quem usa a classe 

#### Outros Assuntos:
 Progess da DataSul (Um exemplo de Arquitetura "bem" escolhida)