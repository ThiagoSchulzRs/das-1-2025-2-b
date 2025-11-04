# Aula do dia 16/10/2025.

### **Revisão das aulas passadas (13/10):**

Definição das Características da Arquitetura.

## **Preparando o ambiente:** 
```
https://integrada.minhabiblioteca.com.br/reader/books/9788550819754/epubcfi/6/26[%3Bvnd.vst.idref%3Dcap4.xhtml]!/4/2/20/2%4050:60
```
## Fundamentos

### Retry pattern:

O retry pattern é um padrão no qual ele continua tentando fazer uma requisição que está dando erro, ele também pode integrar diferentes estrategias. Uma delas é que, no caso de erro novamente, ele entra em um time-out chamado *Retry After Delay*, que tenta mais uma vez fazer a mesma requisição.

### Três Camadas:
  
Arquitetura que adciona mais camadas de separação, sendo elas: 
- De banco de dados, ultilizando um servidor de capacidade industrial,
- De aplicação gerenciado por um servidor de aplicação, 
- E de Front-end escrito em HTML gerado, sendo usado cada vez mais com JavaScript devido o avanço das tecnologias. 

Se baseia em dois protocolos de rede:
- CORBA (Common Object Request Broker Architecture);
- DCOM (Distributed Component Object Model).

### Estilos de Arquitetura

### Arquiteturas Monolíticas vs Distribuídas

As arquiteturas de software podem ser divididas em dois grandes estilos: 

**Monolítica**: todo o código em uma única unidade de implementação.
- Arquitetura em camadas;
- Arquitetura de pipeline;
- Arquitetura de microkernel.

**Distribuída**: várias unidades independentes que se comunicam via rede.
- Arquitetura baseada em serviços;
- Arquitetura orientada a eventos;
- Arquitetura baseada em espaços;
- Arquitetura orientada a serviços (SOA);
- Arquitetura de microsserviços.

Arquiteturas distribuídas oferecem melhor desempenho, escalabilidade e disponibilidade, mas apresentam desafios adicionais — principalmente relacionados à rede.

## Falácias da Computação Distribuída

Conjunto de suposições equivocadas feitas sobre redes:

1. **A rede é confiável:** Desenvolvedores e arquitetos pressupõem que a rede é confiável, mas não é. A comunicação falha e por isso, são necessários timeouts e circuit breakers.
2. **A latência é zero:** Chamada remota é muito mais lenta que chamada local, deve-se medir e considerar a latência real, especialmente em microsserviços.
3. **A largura de banda é infinita:** Trocas desnecessárias de dados entre serviços podem consumir muita banda. Evitar *stamp coupling* e retornar apenas os dados necessários.
4. **A rede é segura:** Cada endpoint precisa ser protegido, a superfície de ataque aumenta em sistemas distribuídos.
5. **A topologia da rede nunca muda:** Mudanças na infraestrutura afetam latência e comportamento dos serviços.
6. **Existe apenas um administrador:** Grandes organizações possuem vários administradores de rede, aumentando a complexidade de comunicação.
7. **O custo do transporte é zero:** Comunicações remotas geram custos financeiros e exigem mais infraestrutura.
8. **A rede é homogênea:** A rede pode ter equipamentos de diferentes fornecedores, afetando estabilidade e integração.

## Outros Desafios em Arquiteturas Distribuídas

**Log Distribuído:** Dificulta o rastreamento de erros devido à existência de múltiplos serviços e múltiplos logs.

**Transações Distribuídas:** Em vez de transações ACID, utiliza-se consistência eventual. Uso comum de *Sagas* e abordagem *BASE* (Disponibilidade Básica, Estado Suave, Consistência Eventual).

**Manutenção de Contratos:** Controlar versões e mudanças em APIs é mais complexo, pois serviços são mantidos por equipes diferentes.