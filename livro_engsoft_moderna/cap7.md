# Capítulo 7 - Arquitetura

## Capítulo 7.1 – Introdução

A arquitetura de software pode ser vista sob dois prismas complementares. Primeiro, foca-se em componentes de grande porte (pacotes, módulos, subsistemas ou serviços) cujas responsabilidades são essenciais aos objetivos do sistema. Esses componentes reúnem classes relacionadas e, para fazer parte da arquitetura, devem contribuir diretamente para o propósito central da aplicação. Segundo, adota-se a noção de decisões arquiteturais: escolhas de design — como linguagem, banco de dados ou padrões de comunicação — que, uma vez tomadas, são difíceis e custosas de reverter. Assim, arquitetura não é apenas “o desenho” de módulos, mas o conjunto de decisões críticas que moldam a evolução do sistema.

Em seguida, o capítulo apresenta de forma panorâmica os padrões arquiteturais que serão estudados: Camadas, MVC, Microsserviços, Mensagens, Publish/Subscribe, Pipes & Filtros e, por fim, o anti-padrão Big Ball of Mud.

#### Capítulo 7.1.1 – Debate Tanenbaum vs. Torvalds

No início de 1992, Andrew Tanenbaum defendeu microkernels (núcleo mínimo, com serviços isolados) enquanto Linus Torvalds criou o Linux com kernel monolítico. Tanenbaum argumentava que microkernels facilitam manutenção e segurança; Torvalds rebateu apontando a maturidade e desempenho do Linux monolítico. Ken Thompson reforçou que monolitos são fáceis de implementar, mas tendem a virar “bagunça” com o tempo. Em 2009, Linus reconheceu que o kernel Linux cresceu e “inchou”. Esse debate ilustra como decisões arquiteturais, embora adequadas num contexto, podem revelar efeitos adversos décadas depois.

## Capítulo 7.2 – Arquitetura em Camadas
Neste padrão, o sistema é dividido hierarquicamente em camadas (como um bolo), sendo que cada camada só depende da imediatamente inferior. Isso disciplina dependências, facilita a manutenção e permite trocar implementações sem afetar as demais. Como exemplo clássico, protocolos de rede: HTTP (aplicação) → TCP (transporte) → IP (rede) → Ethernet (enlace).

#### Capítulo 7.2.1 – Arquitetura em Três Camadas
Muito comum em sistemas corporativos, divide-se em:
- Apresentação (UI): coleta entradas e exibe informações (desktop ou Web).
- Lógica de Negócio: aplica regras do domínio (validação de dados, envio de e-mail, etc.).
- Banco de Dados: persiste informações.
Geralmente distribuída: UI no cliente, lógica no servidor de aplicação e BD num servidor dedicado. Em arquiteturas de duas camadas, UI e lógica residem juntas no cliente, deixando apenas o BD separado.

## Capítulo 7.3 – MVC (Model-View-Controller)

Proposto no final dos anos 70 para Smalltalk-80, o MVC separa:
- Modelo: dados e lógica de domínio, sem dependência da interface.
- Visão: componentes de apresentação (janelas, botões, menus).
- Controlador: trata eventos de entrada e coordena interações entre Visão e Modelo.

Essa separação favorece especialização (front-end vs. domínio), testabilidade de objetos não-visuais e múltiplas visões sobre o mesmo modelo (analógica, digital, etc.).

**MVC vs. Três Camadas**
MVC foca na apresentação, enquanto em três camadas há distribuição entre cliente, servidor de aplicação e BD. Na Web, frameworks como Rails, Django e Spring adaptam MVC: páginas HTML (Visão), rotas/controladores (Controller) e entidades de persistência (Model), o que gera confusão, mas reflete a evolução histórica.

#### Capítulo 7.3.1 – Single-Page Applications (SPAs)
SPAs carregam todo o código (HTML, CSS, JavaScript) de uma vez e atualizam apenas partes da interface via data binding. Exemplo: Gmail. Frameworks como Vue.js e React propagam alterações de modelo para visão (e vice-versa) sem recarregar a página inteira, aumentando interatividade e sensação de aplicação desktop.

## Capítulo 7.4 – Microsserviços
Monolitos de tempo de execução agrupam todos os módulos num único processo, criando gargalos de deploy e risco de efeitos colaterais. Microsserviços dissolvem o monolito em processos independentes, cada serviço implementando um pequeno conjunto de funcionalidades.

**Vantagens:**
- Deploy e evolução independentes por equipe ágil.
- Escalabilidade fina: replica apenas serviços sobrecarregados.
- Heterogeneidade tecnológica: cada serviço escolhe linguagem, framework e banco de dados.
- Tolerância a falhas parciais: queda de um serviço não derruba todo o sistema.

#### Capítulo 7.4.1 – Gerenciamento de Dados
Em sua forma pura, cada microsserviço possui seu próprio banco de dados, evitando gargalos e burocracia de administradores centrais. Compartilhamento de banco único compromete autonomia e agilidade.

#### Capítulo 7.4.2 – Quando Evitar Microsserviços
Microsserviços introduzem complexidade de sistemas distribuídos: latência de rede, necessidade de mensagens via HTTP/REST, testes e monitoramento distribuídos, além de protocolos para transações atômicas (two-phase commit) quando mais de um banco está envolvido.

## Capítulo 7.5 – Arquitetura Orientada a Mensagens

Comunicação mediada por brokers de mensagens (filas FIFO): produtores escrevem mensagens; consumidores as lêem assincronamente. Isso desacopla espaço (produtores ignoram consumidores) e tempo (produtores continuam mesmo se consumidores estiverem fora). Empresas utilizam soluções prontas (RabbitMQ, Kafka, AWS SQS) para garantir persistência, desempenho e escalabilidade adicionando múltiplos consumidores à mesma fila.

#### Capítulo 7.5.1 – Exemplo em Telecomunicações
Sistemas de vendas produzem mensagens na fila; sistemas de engenharia consumem-nas para provisionar serviços. Diferentemente de lotes diários, filas permitem integração quase em tempo real, com resiliência a picos e falhas.

## Capítulo 7.6 – Publish/Subscribe
Arquitetura orientada a eventos: publicadores emitem eventos que são entregues a todos os assinantes (comunicação 1→N). Assinantes se inscrevem em tópicos de interesse e recebem notificações de forma assíncrona. Enquanto filas são ponto-a-ponto (1→1), publish/subscribe replica eventos para múltiplos consumidores, lembrando o padrão Observador em escala distribuída.

#### Capítulo 7.6.1 – Exemplo em Companhia Aérea
Evento de venda de passagem é publicado e chega simultaneamente aos sistemas de milhagem, marketing e contabilidade, mantendo desacoplamento total entre quem publica e quem consome os eventos.

## Capítulo 7.7 – Outros Padrões Arquiteturais

**Pipes & Filtros:** filtros processam dados em sequência, conectados por pipes que atuam como buffers; executam em paralelo (ex.: comandos Unix).
**Cliente/Servidor:** clientes solicitam serviços a servidores via rede (impressão, arquivos, bancos de dados, Web).
**Peer-to-Peer:** cada nó atua como cliente e servidor, consumindo e fornecendo recursos (ex.: BitTorrent).

## Capítulo 7.8 – Anti-padrão Big Ball of Mud
Sistemas sem estrutura clara resultam num emaranhado de dependências entre módulos — “espaguete” de código — cujo custo de manutenção cresce exponencialmente. Estudos de caso  (sistemas bancários com dezenas de milhões de linhas) mostram aumento no tempo de onboard (de 3 para 7 meses), propagação de bugs e redução de produtividade, mesmo com práticas como revisão de código e pair programming.