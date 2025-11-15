# Aula do dia 10/11/2025.

### **Revisão das aulas passadas (06/11):**

Parte prática sobre arquitetura de Microkernel.

## **Preparando o ambiente:** 

```
https://integrada.minhabiblioteca.com.br/reader/books/9788550819754/epubcfi/6/54[%3Bvnd.vst.idref%3Dcap17.xhtml]!/4/2/2/1:0[%2CCAP]
```
## **Arquitetura de Microsserviços:** 

A arquitetura de microsserviços é fortemente influenciada pelo **DDD** (*Domain-Driven Design*), especialmente pelo conceito de contexto delimitado. Esse conceito ajuda a manter partes do sistema desacopladas.

Em uma arquitetura monolítica, vários módulos compartilham classes, estruturas e bancos de dados, o que cria forte dependência entre eles. Já nos contextos delimitados, cada domínio possui seu próprio código e seu próprio esquema de dados, acoplados apenas internamente. Nada é compartilhado diretamente com outros contextos.

Isso permite que cada parte do sistema defina apenas o que realmente precisa, evitando dependências desnecessárias e aumentando a independência dos módulos, algo fundamental nos microsserviços. o tamanho do serviço nos microsserviços é muito menor que em outras arquiteturas distribuídas, como a arquitetura orientada a serviços e baseada em orquestração.
> O Trade-Offs desta arquitetura é o acoplamento! (Devido a reutilização de Código)

![Exemplo da arquitetura de microsserviços](https://middleware.io/backend/wp-content/uploads/2021/09/How-Microservices-architecture-works.jpg "Exemplo da arquitetura de Microsserviços")

### Distribuida

Os microsserviços formam uma arquitetura distribuída, onde cada serviço roda em seu próprio processo, inicialmente em máquinas físicas, depois em VMs e atualmente em contêineres. Esse isolamento extremo resolve problemas comuns de infraestruturas compartilhadas, como falta de recursos e falhas de isolamento entre aplicações.

Porém, essa natureza distribuída traz **desvantagens**, principalmente relacionadas à **performance**: chamadas remotas são mais lentas que chamadas internas de métodos e exigem verificações de segurança adicionais. Por isso, arquitetos precisam planejar cuidadosamente a **granularidade** dos serviços.

> "Imagine os processos dentro de um computador, cada *serviço* roda dentro de um *processo* um conjunto de *tarefas*"

### Granularidade
Os arquitetos tentam encontrar a granularidade certa para os serviços nos microsserviços e, em geral, cometem o erro de tornar seus **serviços pequenos demais**, requerendo a criação de links de comunicação entre os serviços para fazer um trabalho bem-sucedido. Algumas diretrizes que os arquitetos podem usar para ajudar a encontrar tamanho (limite) certo são:

**Finalidade:** qual a inspiração para o estilo de arquitetura, um domínio. O ideal é que cada microsserviço seja extremamente coeso de modo funcional, contribuindo com um comportamento importante em nome do aplicação em geral.

**Transações:** Os contextos delimitados são fluxos de trabalho corporativos e, muitas vezes, as entidades que precisam cooperar em uma transação mostram aos arquitetos um bom limite de serviço. (Evita-las)

**Coreografia:** Se vários serviços fazem uma grande quantidade de comunicações para funcionar, o arquiteto pode considerar reagrupar esses serviços em um serviço maior para evitar o sobrecarga (*overhead*) de comunicação.

> A definição da granularidade correta geralmente requer iterações e ajustes ao longo do desenvolvimento.

### Isolamento dos Dados

É necessário que cada serviço isole seu próprio banco de dados para evitar esquemas compartilhados, para assim evitar o aclopamento. Porém, esse isolamento leva á alguns problemas, como a ausência de uma fonte única de dados verdadeira e a armadilha da entidade (Capitulo 8).

Logo, o arquitetos precisam decidir qual serviço será a fonte confiável de um determinado dado, ou se devem usar replicação, cache ou outras estratégias de sincronização. Essa independência oferece oportunidades: cada serviço pode escolher o banco de dados ou tecnologia mais adequada, e pode alterar essa escolha sem impactar os demais serviços.

### Camada de API

A maioria das imagens dos microsserviços inclui uma camada da API entre os consumidores do sistema (IUs ou chamadas de outros sistemas), mas **é opcional**. Ela é útil como ponto de indireção para: proxy, roteamento, serviço de nomenclatura e funcionalidades operacionais - mas **não deve ser utilizada como mediador ou orquestrador**, porque:
- Toda a lógica de negócio deve ficar dentro dos contextos delimitados (os serviços),
- Usar a API para orquestrar serviços viola o princípio de particionamento por domínio.

### Reutilização Operacional

Embora microsserviços prefiram duplicação a acoplamento, algumas funcionalidades operacionais precisam ser padronizadas, como monitoramento, logs, *circuit breakers* e observabilidade. Nos microsserviços, separa-se:
- lógica de domínio → não deve ser compartilhada,
- lógica operacional → pode ser compartilhada, desde que sem acoplar o domínio.

> Microsserviços evitam acoplamento, mas precisam padronizar funções operacionais.


**Padrão Sidecar:** Cada microsserviço recebe um componente operacional separado, anexado a ele.Esse sidecar lida com logs, monitoramento, segurança, roteamento, circuit breakers. As suas vantagens são:
- Uma equipe de infraestrutura pode atualizar o sidecar uma vez, e todos os serviços ganham a melhoria.
- Mantém o domínio desacoplado e a operação centralizada.

**Formação de uma Service Mesh:** Quando todos os serviços têm sidecars, eles podem se conectar formando uma malha de serviços (service mesh), onde cada serviço vira um nó da malha, e o service mesh oferece um “console” para administrar tudo isso. A malha oferece uma interface operacional unificada, configuração centralizada, visão global dos serviços, controle sobre logs, monitoramento, segurança e tráfego.

**Descoberta de Serviços** Os arquitetos usam service discovery para escalar e tornar o sistema elástico. Em vez de chamar diretamente um serviço, o cliente consulta a ferramenta de descoberta, verificando quantas instâncias existem, carga atual e a saúde dos serviços.<br>
Se necessário, novas instâncias são ativadas automaticamente (elasticidade). A descoberta de serviços geralmente fica na própria service mesh, ou na camada de API, servindo como ponto único onde consumidores localizam serviços.

### Front-ends

Originalmento os microsserviços incluíam a IU como parte do contexto delimitado, fiel ao princípio no DDD, devido ao desacoplamento, que englobariam de modo ideal as IUs e as preocupações de back-end.

![Exemplo da arquitetura de microsserviços](https://cdn-blog.scalablepath.com/uploads/2022/10/microservices-vs-micr-front-ends-1.png "Exemplo da arquitetura de Microsserviços")

### Comunicação
Microsserviços exigem comunicação escolhida com cuidado, pois está totalmente ligado á granularidade e isolamento dos serviços. A comunicação pode ser síncrona (REST) ou assíncrona (eventos), no geral, as arquiteturas de microsserviços utilizam a interoperabilidade heterogênea com reconhecimento de protocolo.

**Protocolo Reconhecido:** Como os microsserviços normalmente não incluem um hub de integração central para evitar o acoplamento operacional, cada serviço deve saber como chamar os outros. Sendo utilizad: Certos utilizam nível de REST, filas de mensagem etc, nos quais os serviços devem saber (ou descobrir) qual protocolo usar para chamar os outros serviços.

**Heterogênea:** sugere que os microsserviços suportam totalmente ambientes poliglotas, nos quais diferentes serviços usam diferentes plataformas.

**Interoperabilidade:** Descreve serviços que chamam uns aos outros, os serviços normalmente chamam outros serviços via rede para colaborar e enviar/receber informações.

### Coreografia e Orquestração:
É o estilo mais alinhado com a filosofia de microsserviços: desacoplamento máximo. Não existe um coordenador central e os serviços reagem a eventos ou chamam diretamente outros serviços quando necessário. Está alinhada com o padrão EDA (*Event-Driven Architecture*) e com o broker, por isso esses estilos combinam bem.

Há Três formas de comunicação:
- É feito uma chamada para um microserviço que solicita os dados que faltam para outros.
- É feito um orquestrador, que recebe e coleta as informações dos microsserviços.
- Um microserviço é mediador, que faz a comunicação além de suas outras responsabilidades no domínio. (o que respeita mais o padrão EDA)

### Transações e Sagas
Os microsserviços buscam um alto nível de desacoplamento, inclusive no banco de dados. Por isso, transações tradicionais, como as usadas em sistemas monolíticos, tornam-se um problema, pois exigem coordenação e atomicidade entre serviços diferentes, criando forte acoplamento — algo contrário à filosofia dessa arquitetura.

Quando um arquiteto sente necessidade de implementar transações entre serviços, isso geralmente indica que a granularidade foi definida de forma inadequada: os serviços estão pequenos demais ou com limites mal desenhados. O principal conselho é simples: não faça transações distribuídas; ajuste a granularidade dos serviços para que cada transação pertença a um único serviço.

**Padrão Saga:** divide a transação em várias etapas menores, coordenadas geralmente por um mediador. Se todas as etapas forem concluídas com sucesso, o estado final é confirmado. Mas se qualquer etapa falhar, o mediador inicia operações de compensação, que “desfazem” as mudanças feitas anteriormente, garantindo consistência. Esse modelo, no entanto, aumenta significativamente a complexidade, sobretudo porque operações de desfazer são geralmente mais difíceis de implementar do que as operações normais, além de gerar mais tráfego e desafios em situações assíncronas.

![Fluxo de Sagas](https://lentium.io/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fa.ebbfe95d.webp&w=3840&q=75 "Exemplo de fluxo de Sagas, com um orquestrador comunicando os bancos")

###  Classificações das Características da Arquitetura

É notável o alto suporte para as práticas da engenharia moderna, como implementação automática, teste e outras não listadas. Os microsserviços não existiriam sem a revolução DevOps e a marcha incansável para automatizar as preocupações operacionais. Os pontos altos dessa arquitetura são escalabilidade, elasticidade e ser evolutiva.

| Característica | Nível | Observação |
|---|:---:|---|
| Escalabilidade | ⭐⭐⭐⭐⭐ | Arquitetura ideal para escalar horizontalmente com serviços independentes |
| Elasticidade | ⭐⭐⭐⭐⭐ | Funciona muito bem com automação e descoberta de serviços |
| Evolutividade | ⭐⭐⭐⭐⭐ | Mudanças rápidas e localizadas graças ao alto desacoplamento |
| Integração com DevOps / Automação | ⭐⭐⭐⭐⭐ | Altamente compatível com CI/CD, pipelines e monitoramento |
| Tolerância a Falhas | ⭐⭐⭐⭐☆ | Falhas isolam-se por serviço, mas exigem padrões como circuit breaker |
| Modularidade | ⭐⭐⭐⭐☆ | Serviços pequenos, independentes e bem separados por domínio |
| Testabilidade | ⭐⭐⭐⭐☆ | Testes por serviço são fáceis; integração completa é mais complexa |
| Manutenibilidade | ⭐⭐⭐⭐☆ | Atualizações independentes, desde que haja boa governança |
| Simplicidade Operacional | ⭐⭐☆☆☆ | Requer maturidade em DevOps; ambiente distribuído é mais complexo |
| Performance | ⭐⭐☆☆☆ | Muitas chamadas de rede aumentam a latência; mitigável com cache/eventos |
| Confiabilidade | ⭐⭐☆☆☆ | Depende da rede; falhas de comunicação podem impactar processos |
| Coesão por Domínio | ⭐⭐⭐⭐⭐ | Altamente alinhado ao DDD e contextos delimitados |
---