# Aula do dia 20/10/2025 e 23/10. (NÃO FINALIZADO)

### **Revisão das aulas passadas (17/10):**

Definição das Características da Arquitetura

## **Preparando o ambiente:** 

Link para a documentação da Microsoft
```
https://app.minhabiblioteca.com.br/reader/books/9788550819754/epubcfi/6/40[%3Bvnd.vst.idref%3Dcap10.xhtml]!/4/2/2/1:0[%2CCAP]
```

## Estilo de Arquitetura em Camadas

Estilo de arquitetura *n-tier* (multicamadas): ele é o padrão de fato da maioria das aplicações, basicamente por sua simplicidade, familiaridade e baixo custo. A arquitetura em camadas é particionada tecnicamente (em oposição a uma arquitetura particionada por domínio). 

**Lei de Conway:** determina que as organizações que projetam sistemas estão limitadas a produzir designs que são cópias das estruturas de comunicação dessas organizações.

### Topologia

Os componentes no estilo de arquitetura em camadas são organizados em camadas horizontais lógicas, com cada camada (abstração) tendo uma função específica e responsabilidades específicas dentro da aplicação (como lógica de apresentação ou lógica de negócio). Embora não exista padrão, a maioria das arquiteturas em camadas consiste em quatro camadas padrão:
- Apresentação; 
- Comercial;
- Persistência;
- Banco de dados.

**Separação das preocupações:** no estilo da arquitetura em camadas facilita a criação de funções eficientes e de modelos de responsabilidade dentro da arquitetura. Os componentes em uma camada específica estão limitados em escopo, lidando apenas com a lógica que pertence a essa camada.

Os grupos de componentes, em vez de serem agrupados por domínio (como um cliente), são agrupados por sua função técnica na arquitetura (como de apresentação ou comercial). Como resultado, qualquer domínio comercial em particular se distribui por todas as camadas da arquitetura.
- Componentes de apresentação: só lidam com a lógica de apresentação, 
- Componentes de negócio: só lidam com a lógica de negócio.

> O trade-off desse benefício é uma falta de agilidade geral (a capacidade de responder rápido à mudança).

### Camadas de Isolamento

![Exemplo de camada de isolamento](https://i2.wp.com/blog.askm.com.br/wp-content/uploads/2019/01/layered_architecure_02.png?resize=640%2C436&is-pending-load=1 "Exemplo de camada de isolamento em inglês")

Camadas fechada e abertas: as camada fechadas significa que, conforme uma requisição desce de camada em camada, ela não pode pular nenhuma, mas pode passar pela camada imediatamente abaixo dela para chegar na próxima. Ja nas camadas abertas, não há agente intermediario, um consegue acessar o outro.

### Adicionando Camadas

>>>>> PAREI AQUI