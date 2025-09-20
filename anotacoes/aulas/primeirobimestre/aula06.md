# Aula do dia 18/08/2025.

#### **Na Aula 5 do dia 14/08 teve uma apagão**

### **Revisão aula passada (14/08):**
- Princípio de Substituição de Liskov: o objetivo dessa lei é que possa substituir um filho por outro sem ter perdas, o código continua funcionando
- Métricas de Código Fonte: tem o objetivo de permitir a avaliação da qualidade de um projeto de forma mais objetiva

## **Preparando o ambiente:** 
Criamos o ambiente da aula no github workspace e criamos algumas pastas e files, que estão sendo adicionadas junto com essa aula em ".devcontainer".
Utilizamos como base o site sobre Design-Patterns:
```
https://refactoring.guru/pt-br/design-patterns
```

**Anotações:**
- Um construtor privado é um tipo de construtor que ninguém consegue chamar para ele ser criado, exceto ele mesmo.
- Tudo que é estático, é carregado primeiro na memória

### Singleton
Singleton é um padrão de projeto criacional, que garante que uma **classe tenha apenas uma instância** em todo o programa fornece um ponto global de acesso a essa instância.  

**Quando usar:** Quando só faz sentido existir um único objeto da classe. Exemplos:
- Gerenciador de configuração
- Logger (registro de logs)
- Conexão com banco de dados

#### Características
1. Construtor privado: impede criar instâncias fora da classe.  
2. Atributo estático: guarda a instância única.  
3. Método público estático: retorna a mesma instância.  

**Exemplo:**
```
java
public class Singleton {
    private static Singleton instancia;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;
    }
}
```