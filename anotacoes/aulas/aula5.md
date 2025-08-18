# Aula do dia 18/08/2025.

### **Revisão aula passada:**
Responsabilidade única:Cada metodo faz somente uma coisa e bem feito.

Princípio da Segregação de Interfaces: No exemplo da aula anterior, uma interface captura o click e a outra o movimento do mouse, ou seja, cada interface tem um objetivo.

## **SOLID (Cap 5.6.3):** 

**Criamos a pasta .devcontainer, o .gitignore**

### **Pricipio da inversão de Dependência:**  
Uma classe cliente deve estabelecer dependências prioritariamente com abstrações e não com implementações concretas, pois abstrações (isto é, interfaces) são mais estáveis do que implementações concretas (isto é, classes)

**Exemplo:** possuimos uma classe cliente  (controladores) que ela era chamada para justamente abstrair (interface de serviço) para não depender diretamente de implementações concretas (service ...impl.java). Ou seja, dependemos do padrão de comunicação.
