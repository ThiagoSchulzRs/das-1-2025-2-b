# Aula do dia 07/08/2025.

### **Revisão aula passada:**
- Coesão: classe ou metodo que faz uma coisa bem feita;
- Aclopamento: é quando há uma ligação (dependencia) completa entre duas classes; (quanto mais baixo o aclopamento, melhor)

### **SOLID (Cap 5.6):** 
SOLID foi criado por Robert c. Martin, sendo feito para ajuda a criar um código mais limpo, flexível e fácil de manter. "Programar Orientado a Objeto de forma correta"

#### *Single Responsibility Principle:*  
Esse principo é uma aplicação direta da ideia de coesa, pois a ideia dele é que exista um único motivo para modificar qualquer classe em um sistema.

#### *Open/Closed Principle* 
Cada interface deve ser uma interface única.
"Se eu quero ouvir um click de um botão, eu tenho uma interface para isso
Se eu quero ouvir um movimento de um mouse, eu tenho uma outra interface para isso"

#### **Resumo:**
SOLID é um acronomo para:
- **S:** *Single Responsibility Principle* (Princípio da Responsabilidade Única) - Uma classe deve ter apenas uma razão para mudar.
- **O:** *Open/Closed Principle* (Princípio Aberto/Fechado) - As entidades de software devem ser abertas para extensão, mas fechadas para modificação.
- **L:** *Liskov Substitution Principle* (Princípio da Substituição de Liskov) - Objetos de uma classe derivada devem poder substituir objetos da classe base sem alterar o comportamento do programa.
- **I:** *Interface Segregation Principle* (Princípio da Segregação de Interfaces) - Uma classe não deve ser forçada a implementar interfaces que não utiliza.
- **D:** *Dependency Inversion Principle* (Princípio da Inversão de Dependência) - Dependa de abstrações, não de classes concretas.
Em resumo, a coesão em software é sistema ter o mínimo de código para fazer uma tarefa bem feita.

###  **Outros assuntos:**

**Organização do sistema**:
- entity <-- dados
- repository  <-- JPA spring data
- services <-- lógica (use cases)
- controller <-- api rest

**Tipos de Setas**:
- Seta Herança: seta oca inteira;
- Seta de Implementação (Interface): seta oca tracejada;
- Seta de Associação (Variaveis): seta preenchida inteira;

### **Outros Materiais**
Observação: precisa entrar primeiro na biblioteca da Univille.

**Código Limpo: Habilidades Práticas do Agile Software** (2008): livro sobre como padronizar variaveis elementos, como organizar o código, etc. Escrito por Robert c. Martin, um carinha MUITO importante da nossa área. 

```
https://login.vitalsource.com/?redirect_uri=https%3A%2F%2Fintegrada.minhabiblioteca.com.br%2Freader%2Fbooks%2F9788550816043%2Fpageid%2F0&brand=integrada.minhabiblioteca.com.br
```

**Padrões de Projetos(2000):** feito por Erich Gama, é um livro mais complexto que fala sobre arquitetura em projetos. 

```
Link: https://integrada.minhabiblioteca.com.br/reader/books/9788577800469/pageid/0
```