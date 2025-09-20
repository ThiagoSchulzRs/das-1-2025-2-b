# Aula do dia 14/08/2025.
***AULA DO APAGÃO:*** Como foi nessa aula o apagão, atualizei com base no livro e coloquei algumas partes que não vi anotações em outras aulas.

### **Revisão aula passada (11/08):**
- Prefira Composição a Herança: porque a composição reduz o acoplamento e aumenta a flexibilidade.
- Principio de Demeter: a implementação de um método deve invocar apenas certos metodos (mais especificado na aula anterior).
- Princípio Aberto/Fechado: Uma classe deve estar fechada para modificações e aberta para extensões.

## **SOLID (Cap 5.6.7):** 

### **Princípio de Substituição de Liskov:**  

O Princípio de Substituição de Liskov determina as condições — semânticas e não sintáticas — que as subclasses devem atender para que um programa como o anterior funcione.
- Se B herda de A, então B deve poder substituir A sem quebrar o código de A.
- Uma subclasse não pode mudar o contrato da superclasse.

**Ou seja:** Não pode restringir pré-condições (se A aceitava mais casos, B não pode aceitar menos) nem enfraquecer pós-condições (se A garantia algo, B também deve garantir). Além disso, deve manter invariantes (regras e comportamentos essenciais da superclasse).

### **Métricas de Código Fonte:**  

#### Tamanho:
- Mede quantidade de código (linhas, classes, métodos, atributos etc.).
- Códigos muito grandes tendem a ser mais difíceis de entender, testar e manter.
- Não mede “qualidade” diretamente, mas dá uma noção de esforço para manutenção.

#### Coesão:
- Mede o quanto os elementos de uma classe ou módulo estão relacionados entre si.
- Uma classe coesa é aquela em que seus métodos e atributos estão todos voltados para um mesmo propósito.
- Alta coesão = mais clareza, reuso e fácil manutenção.

#### Acoplamento:
- Mede o grau de dependência entre módulos/classes. Classes muito acopladas dependem fortemente umas das outras → mudanças em uma impactam a outra.
- O ideial é o baixo acoplamento, pois reduz dependências desnecessárias.

#### Complexidade:
- Mede o nível de dificuldade de entender e testar o código. Nesse sentido, quanto maior a complexidade, mais difícil testar e garantir a qualidade.
- Uma métrica usada é a complexidade ciclomática, que conta o número de caminhos independentes no código (basicamente, quantos “if/else”, “while”, “for” etc.).