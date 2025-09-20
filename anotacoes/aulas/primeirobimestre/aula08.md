# Aula do dia 28/08/2025.

### **Revisão aula passada (21/08):**

Muicho código. (Observer no designpatterns)

## **Preparando o ambiente:** 

Criamos o ambiente da aula no github workspace e criamos algumas pastas e files, que estão sendo adicionadas junto com essa aula em ".devcontainer"

**Anotações:**

Iniciamos a leitura do livro:"Fundamentos da arquitetura de software: uma abordagem de engenharia". Iniciamos os seguintes 

Link para o Livro (Precisa logar no site da Univille): 
```
https://integrada.minhabiblioteca.com.br/reader/books/9788550819754/epubcfi/06/18[%3Bvnd.vst.idref%3Dcap1.xhtml]!/4/2/32/2%4051:20
```

## Caracteristicas da Arquitetura:

Características da Arquitetura = Requisitos não funcionais;

### Tipos de atributos:
- Disponibilidade: Capacidade do sistema de estar operacional e acessível quando necessário.
- Confiabilidade: Probabilidade de o sistema funcionar corretamente por um período determinado.
- Testabilidade: Facilidade com que o sistema pode ser testado para verificar se está funcionando como esperado.
- Escalabilidade: Capacidade de o sistema crescer (em usuários, dados ou carga) sem perda de desempenho.
- Segurança: Proteção contra acessos não autorizados, ataques e perda de dados.
- Agilidade: Facilidade e rapidez com que mudanças podem ser feitas no sistema.
- Tolerância a Falhas: Capacidade de continuar operando mesmo quando partes do sistema falham.
- Elasticidade: Habilidade de ajustar recursos automaticamente conforme a demanda aumenta ou diminui.
- Recuperação: Capacidade de restaurar o sistema após uma falha ou desastre.
- Desempenho: Eficiência com que o sistema responde às solicitações e processa dados.
- Implementabilidade: Facilidade de colocar o sistema em funcionamento, incluindo instalação e configuração.
- Capacidade de aprendizagem: Habilidade do sistema de melhorar seu desempenho com o tempo, geralmente associada a sistemas com inteligência artificial.

**Observação:** Nunca é possivel possuir 100% dessas caracteristicas, algumas vezes um acaba sendo deixado de lado para conseguir focar em outro (Principal em foco hoje em dia: Segurança).

### Supply Chain Software: 
É quando uma série de bibliotecas/ repositórios são utilizados para integrar novas ferramentas/ fumções no seu código, porém, esse vem sendo o principal problema da Engenharia de Software ultimamente. Como o Supply Chain Software em sua maioria são códigos livres, ele acaba sendo atualizado/ assegurados por pessoa(s) por pura vontade própria e não recebem por isso, que no final acaba que eles não dão continuidade no projeto e pessoas mal intensionadas acabam por se aproveitar do seu sistema para lançar uma atualização com um malware. 

### Cubernite: 
São orquestradores de máquinas (servidores personalizados) em um clusther, melhorando o controle e desempenho. Muito utilizado no Minecraft.

## Decisões da Arquitetura:
Decisões da Arquitetura: É quando você define a sua arquitetura através de escolhas para suportar todo o seu sistema.

> Evitar Aclopamento é sempre muito bom! 

Extra: a maioria dos ERP em Joinville possuem um único banco de dados.

> Sempre que possível, utilize a mensageria assíncrona entre os serviços para aumentar o desempenho

**Comunicação assícrona:** No caso, criamos um sistema de troca de mensagens, que trocam mensagens com informações minimas, e outros serviços eles recebem uma cópia da mensagem (Observer da aula passada).

## Principios da Arquitetura:

Uma decisão (regra) da arquitetura nunca consegue abranger todas as condições e opções para a comunicação entre os serviços, portanto um princípio do design pode ser usado para orientar o método preferido (no caso, a mensageria assíncrona falado anteriormente) e permitir que o desenvolvedor escolha um protocolo de comunicação mais adequado (como REST ou gRPC), dada uma circunstância específica.

**Resumindo:** Principios do design são diretrizes para contruir sistema. 

**Observação: **Princípio difere de uma decisão da arquitetura no sentido de que um princípio do design é uma diretriz, não uma regra rígida.