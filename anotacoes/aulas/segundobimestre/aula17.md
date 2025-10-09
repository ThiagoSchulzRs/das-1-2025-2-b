# Aula do dia 09/10/2025. (Não terminado)

### **Revisão das aulas passadas (06/10):**

Resumo do capitulo 4 (Definição das Características da Arquitetura)

## **Preparando o ambiente:** 

Link para a documentação da Microsoft
```
https://learn.microsoft.com/en-us/azure/architecture/patterns/circuit-breaker
```
## **Definição das Características da Arquitetura (Cap. 4):** 

### **Padrão de disjuntor(*Circuit Breaker pattern*)**
Ajuda a lidar com falhas que podem levar vários períodos de tempo para se recuperar quando um aplicativo se conecta a um serviço ou recurso remoto. 
- Um disjuntor bloqueia temporariamente o acesso a um serviço defeituoso depois de detectar falhas.
- Evita assim tentativas malsucedidas repetitivas para que o sistema possa se recuperar efetivamente. 
- Esse padrão pode melhorar a estabilidade e a resiliência de um aplicativo.

