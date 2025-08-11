# Aula do dia 11/08/2025.

### **Revisão aula passada:**
Responsabilidade única:Cada metodo faz somente uma coisa e bem feito.

Princípio da Segregação de Interfaces: No exemplo da aula anterior, uma interface captura o click e a outra o movimento do mouse, ou seja, cada interface tem um objetivo.

## **SOLID (Cap 5.6.3):** 

#### **Pricipio da inversão de Dependência:**  
Uma classe cliente deve estabelecer dependências prioritariamente com abstrações e não com implementações concretas, pois abstrações (isto é, interfaces) são mais estáveis do que implementações concretas (isto é, classes)

**Exemplo:** possuimos uma classe cliente  (controladores) que ela era chamada para justamente abstrair (interface de serviço) para não depender diretamente de implementações concretas (service ...impl.java). Ou seja, dependemos do padrão de comunicação.

#### **Prefira Composição a Herança:**  

O motivo dessa lógica é porque a herança viola o encapsulamento por causo do filho receber tudo do pai. (Fora que em banco de dados relacional é um pesadelo representar)

**Herança de classes** (exemplo: class A extends B), que é aquela que envolve reúso de código.

**Herança de interfaces** (exemplo: interface I extends J), que não envolve reúso de código. Essa forma de herança é mais simples e não suscita preocupações.

#### Herança:
Se usa herança quando os filhos(subclasse) não tem como um virar o outro, ou seja, um não vai substituir o outro.

**Exemplo ruim:**
- Pessoa(Pai) 
- Funcionário e Cliente(Filho)

Na vida real, caso algum sistema tenha esse tipo de herança, o funcionário não pode comprar algum item, porque ele não é um cliente.

#### **Principio de Demeter:**

Também chamado de *"Princípio do Conhecimento Mínimo"*, ele defende que a implementação de um método deve invocar apenas os seguintes outros métodos:
- de sua própria classe
- de objetos passados como parâmetros
- de objetos criados pelo próprio método 
- de atributos da classe do método 

#### **Princípio Aberto/Fechado:**
Uma classe deve estar fechada para modificações e aberta para extensões, para que quando forem mexer, não quebrem o código quando tentarem implementar algo.

*"Não mexemos no código original, mas conseguimos extender o código e editar"*