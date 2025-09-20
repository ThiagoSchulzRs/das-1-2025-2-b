# Aula do dia  08/09/2025 e 11/09/2025.

### **Revisão aula passada (04/09):**

Irei colocar a anotação da aula anterior nesse finde (cheguei atrasado e perdi o conteúdo)

## **Preparando o ambiente:** 

Rodamos o Github workspace e criamos o publisher e subscribers explicados na aula passada, este inicio foi feito em "eventos".

### Trade-offs
Compensação:  é impossivel criar algo totalmente perfeito, normalmente focamos naquilo que é mais importante para o sistema (na maioria das vezes a segurança).Um exemplo é quando abrimos mão da simplicidade para ganhar mais performance mudando a arquitetura no geral.

#### Arquitetura em tópico
Tipo um observer, envia uma mensagem e os inscritos recebem como uma notificação. Porém se o inscrito não estiver disposnivel, a mensagem é perdida. 
- Exemplo: Notificação de promoção, ela ocorre automaticamente após você assinar
- **Um para Muitos**

#### Arquitetura em Fila
Nessa arquitetura o recebedor deve buscar a sua mensagem na fila, que é uma para cada serviço, quando ele buscar o recebedor deve procecessar a sua própria mensagem. Além disso o anunciador envia uma cópia da mensagem para cada um, com a fila para armazenar a ordem da mensagem. O que gera redundancia, mas compensamos com a possibilidade de armazenamento, que evita a perda da mensagem.
- **Um para Um**

#### Diferença entre Tópico e fila
**Tópicos:** existe apenas uma conexão, a escalabilidade é maior, gerando menos impacto. Porém, mesmo não tendo acoplamento, o anunciador tem que enviar uma grande mensagem para suprir os três sistemas acoplados ao tópico. 

**Fila:** precisa mudar e adicionar mais do que um novo sistema, adicionando mais filas, aumentando o aclopamento. Porém, agora podemos enviar mensagens menores e separadas para cada um.

#### Fan-out
Uma arquitetura que mistura, tópicos e filas. Resolve problemas de acoplamento, buffer's e monitoramentos. Mas ainda não é resolvido o envio de mensagens personalizadas, já que ainda estamos usando a arquitetura de tópicos.