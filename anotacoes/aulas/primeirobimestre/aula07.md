# Aula do dia 21/08/2025.

### **Revisão aula passada (18/08):**

SingleTron: um tipo de variavel global ÚNICA, pode ser usado para salvar uma senha para utilizar em diferentes partes do sistema (End-Chest).

## **Preparando o ambiente:** 

Criamos o ambiente da aula no github workspace e criamos algumas pastas e files, que estão sendo adicionadas junto com essa aula em ".devcontainer".

Utilizamos como base o site sobre Design-Patterns:
```
https://refactoring.guru/pt-br/design-patterns
```

### Observer
O observer é um padrão de projeto comportamental, que define uma relação um-para-muitos entre objetos. Quando o sujeito (subject) muda de estado, todos os observadores (observers) são notificados automaticamente.  

**Quando usar?** Quando múltiplos objetos precisam ser informados sobre mudanças em outro objeto. Exemplos:
- Atualização automática de interfaces gráficas.
- Notificações de eventos (ex.: sistema de mensagens).
- Modelo *publisher-subscriber* (publicador-assinante).

#### Estrutura
1. Subject (Sujeito): mantém lista de observadores e notifica mudanças.  
2. Observer (Observador): interface/contrato para receber notificações.  
3. ConcreteSubject: implementação real do sujeito.  
4. ConcreteObserver: implementação real dos observadores.  

**Exemplo do código**: Acesse o link ou vá pelo repositório em: "designpatteners➝src➝main➝java/br/univille➝observer"
```
https://github.com/ThiagoSchulzRs/das-1-2025-2-b/tree/main/designpatterns/src/main/java/br/univille/observer
```