# Aula do dia 04/08/2025.

### **Classes (Revisão):**
Classes guardam o estado de um cliente e o comportamento (metodos/funções), e quando guardamos algo em uma classe, estamos guardando os dados do cliente.

**Vantagens:**
- Desenvolvimento em paralelo;
- Flexibilidade a mudanças;
- Facilidade de entendimento;

### **Coesão:** 
A classe deve implementar uma única funcionalidade ou serviço, além que está classe não deve inteferir ou impactar nas outras classes.
- Facilita a implementação de uma classe, bem como o seu entendimento e manutenção.
- Um único responsavel por manter um metodo.

Em resumo, a coesão em software é sistema ter o mínimo de código para fazer uma tarefa bem feita.

### **Aclopamento:**
 
- Setas de associação (setas preenchidas): sempre cria uma variavel entre as classe
- Autowired é muito importante : )

**Aclopamento aceitável:** é quando um sistema possui baixo aclopamento, o que permite a substituição do banco de dados ou de outros elementos por um de outro tipo sem haver consequencias no código

**Aclopamento ruim:** Quando um objeto é totalmente dependente/referenciado por outro objeto, que caso mexa em uma parte, a outra vai ser afetada por depender de seus elementos.

### **SOLID:** (Mais detalhes na próxima aula)
Os princípios do SOLID ajudam a criar um código mais limpo, flexível e fácil de manter, sendo um acronomo para:
- **S:** Single Responsibility Principle (Princípio da Responsabilidade Única) - Uma classe deve ter apenas uma razão para mudar.
- **O:** Open/Closed Principle (Princípio Aberto/Fechado) - As entidades de software devem ser abertas para extensão, mas fechadas para modificação.
- **L:** Liskov Substitution Principle (Princípio da Substituição de Liskov) - Objetos de uma classe derivada devem poder substituir objetos da classe base sem alterar o comportamento do programa.
- **I:** Interface Segregation Principle (Princípio da Segregação de Interfaces) - Uma classe não deve ser forçada a implementar interfaces que não utiliza.
- **D:** Dependency Inversion Principle (Princípio da Inversão de Dependência) - Dependa de abstrações, não de classes concretas.

### **Extra:**
**Frase da aula:** Maximize a coesão das classes e minimize o acoplamento entre elas.

**Get Set:** serve para fazer o encapsulamento dos dados, para assim proteger a informação

**Frase motivadora:** Devemos vencer as dificultades na programação, ninguém aprende direto (OO) do dia pra noite. By: Walter Coan.