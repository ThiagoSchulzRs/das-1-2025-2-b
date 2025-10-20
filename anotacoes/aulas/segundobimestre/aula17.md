# Aula do dia 09/10/2025.

### **Revisão das aulas passadas (06/10):**

Resumo do capitulo 4 (Definição das Características da Arquitetura)

## **Preparando o ambiente:** 

Link para a documentação da Microsoft
```
https://learn.microsoft.com/en-us/azure/architecture/patterns/circuit-breaker
```
## **Padrão de disjuntor (*Circuit Breaker pattern*)** 

### **Descrição:**
Ajuda a lidar com falhas que podem levar vários períodos de tempo para se recuperar quando um aplicativo se conecta a um serviço ou recurso remoto. 
- Um disjuntor bloqueia temporariamente o acesso a um serviço defeituoso depois de detectar falhas.
- Evita assim tentativas malsucedidas repetitivas para que o sistema possa se recuperar efetivamente. 
- Esse padrão pode melhorar a estabilidade e a resiliência de um aplicativo.

### **Contexto / Problema:**

Em ambientes distribuídos, falhas transitórias (rede lenta, timeouts) e falhas mais longas podem ocorrer.

Repetir indefinidamente operações prováveis de falhar leva a falhas em cascata e exaustão de recursos.

### **Objetivo**

Evitar que o sistema tente repetidamente operações que provavelmente vão falhar, preservando recursos e mantendo resposta rápida.

### Como funciona (máquina de estados)

![Imagem de funcionamento](https://learn.microsoft.com/en-us/azure/architecture/patterns/_images/circuit-breaker-diagram.png#lightbox  "Imagem dos fluxos Closed, Half-Open e Open")

- **Fechado:** operações são roteadas; contador de falhas é monitorado. Se ultrapassar limite → vai para Aberto e inicia temporizador.
- **Aberto:** solicitações falham imediatamente (retornam exceção ou valor padrão).
- **Semi-aberto (*Half-Open*):** permite um número limitado de tentativas - sucesso consecutivo fecha o circuito - falha reabre e reinicia o timeout.

### Notas operacionais
- Contadores são baseados em janela temporal (evitam disparos por falhas esporádicas).
- Pode combinar com retry — mas a lógica de retry precisa respeitar sinais do disjuntor.
- Pode retornar valores padrão em vez de exceção para degradação graciosa.
- Limites tradicionais são estáticos; técnicas adaptativas (ML) podem ajustar limites dinamicamente.

### Problemas e considerações ao implementar

- **Tratamento de exceções:** apps devem degradar ou usar alternativas quando o disjuntor está aberto.
Tipos de exceções: diferentes falhas (timeout vs indisponibilidade) podem exigir limiares distintos.
- **Monitoramento / observabilidade:** essencial (tracing distribuído, logs de estado).
Configuração de limites: ajustar ao padrão de recuperação esperado.
- **Teste de recuperação:** em vez de apenas tempo, pode-se pingar o serviço para checar saúde.
Substituição manual: permitir reset/forçar estado por administrador, se necessário.
- **Concorrência:** implementação deve evitar bloqueios excessivos em cenários com muitas instâncias.
- **Diferenciação de recursos:** cuidado ao usar um único disjuntor para múltiplos provedores/fragmentos.
- **Tempos de timeout inadequados:** timeouts muito longos bloqueiam threads e recursos.

### Use quando:
- Quer evitar falhas em cascata por chamadas a serviços remotos.
- Quer rotear tráfego baseado em sinais de falha em tempo real.
- Quer manter SLAs frente a dependências lentas/intermitentes.

### Não use/evite quando:
- O recurso é local (estruturas em memória) — overhead pode não compensar.
- A infraestrutura já gerencia repetição/recuperação (por ex., malha de serviço, load balancer).
- Sistemas orientados a mensagens já roteiam falhas para filas mortas.
- Aguardar o reset do disjuntor causaria atrasos inaceitáveis.

## Exemplo resumido (Azure Cosmos DB + App Service)
> Cenário: camada gratuita do Cosmos DB pode retornar 429 em picos.

Estratégia: um disjuntor evita sobrecarregar o DB; durante estado aberto, app serve respostas em cache ou padrão e aciona alertas (Azure Monitor).

### Fluxos:
![Imagem dos Fluxos](https://learn.microsoft.com/en-us/azure/architecture/patterns/_images/circuit-breaker-pattern.svg#lightbox  "Imagem dos fluxos Fechado, aberto e semi-aberto")
- **Fluxo A (Fechado):** solicitações normais → tudo ok.
- **Fluxo B (Aberto):** após limiar, respostas são bloqueadas e serve conteúdo degradado; Azure Monitor gera alertas e equipe decide escala.
- **Fluxo C (Semi-aberto):** permite testes limitados; sucesso fecha o circuito; falhas reabrem.

Componentes chave: App Service (aplicação + lógica do disjuntor), Azure Cosmos DB (armazenamento), Azure Monitor (observabilidade + alertas).

## Resumo final:
- Escolher poucas características arquiteturais críticas (em vez de suportar tudo).
- Implementar disjuntores com observabilidade, estratégias de recuperação e limites bem ajustados.
- Considere adaptação dinâmica (ML) e diferenciação caso a caso (multirregião, fragmentos, malha de serviço).
- Testar cenários de falha, definir timeouts realistas e prever mecanismos de reset/manual.