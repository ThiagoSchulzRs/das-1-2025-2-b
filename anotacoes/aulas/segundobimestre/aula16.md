# Aula do dia 06/10/2025.

### **Revisão das aulas passadas (02/10):**

Fizemos o Consumer e o Producer para fazer um sistema de fila de mensagens.

## **Preparando o ambiente:** 

Link para o Livro (Precisa logar no site da Univille): 
```
https://integrada.minhabiblioteca.com.br/reader/books/9788550819754/epubcfi/6/26[%3Bvnd.vst.idref%3Dcap4.xhtml]!/4/2/20/2%4050:60
```

## **Definição das Características da Arquitetura (Cap. 4):** 

### **Diferencia entre a arquitetura de software da codificação e do design:**
Preferimos características da arquitetura porque descreve as preocupações críticas com o sucesso da arquitetura, portanto o sistema inteiro, sem descontar a importância, como no caso de `Não Funcional`, ou `Atributos da Qualidade`.

#### **Uma característica da arquitetura atende a três critérios:**
- Especifica uma consideração de design fora do domínio
- Influencia algum aspecto estrutural de design
- É essencial ou importante para o sucesso da aplicação

#### **Especifica uma consideração de design fora do domínio:**
Ao planejar uma aplicação, os requisitos especificam o que ele deve fazer:
- As características da arquitetura especificam os critérios operacionais e de design para o sucesso
- Como implementar os requisitos e por que certas escolhas foram feitas. 
```
Exemplo: Uma característica comum e importante da arquitetura especifica certo nível de desempenho para a aplicação, que normalmente não aparece em um documento de requisitos.”,
```

#### **Influencia um aspecto estrutural do design**
A principal razão para os arquitetos tentarem descrever as características da arquitetura nos projetos envolve as considerações do design:
> "A característica da arquitetura requer uma consideração estrutural especial para ter sucesso?"
```
Exemplo: segurança é uma preocupação real em todo projeto e todos os sistemas devem seguir uma linha de precauções durante o design e a codificação. Contudo, chega ao nível da característica da arquitetura quando o arquiteto precisa projetar algo especial.
```

**Processador de pagamentos terceirizado:**
Se um ponto de integração lida com os detalhes do pagamento, então a arquitetura não deve requerer considerações estruturais especiais. O design deve incorporar uma limpeza padrão de segurança, como *criptografia* e *hash*, mas não requerer uma *estrutura especial*.

**Processamento de pagamentos na aplicação:**
Se a aplicação sendo projetado deve lidar com o processamento de pagamentos, talvez a arquitetura planeje um módulo, um componente ou um serviço específico para essa finalidade, isolando estruturalmente as questões críticas da segurança. Agora, a característica da arquitetura tem um impacto na arquitetura e no design.

**Essencial ou importante para o sucesso da aplicação**
As aplicações podem dar suporte a uma quantidade enorme de características da arquitetura… mas não deveriam. O suporte de cada característica da arquitetura adiciona complexidade ao design. Assim, um trabalho crítico dos arquitetos é escolher menos características da arquitetura, ao invés do máximo possível.

#### **Arquitetura Implícita x Explícita:**

Os arquitetos devem usar seu conhecimento do domínio do problema para revelar essas características da arquitetura durante a fase de análise. As implícitas raramente aparecem nos requisitos, embora sejam necessárias para o sucesso do projeto. (Disponibilidade, Confiabilidade e Segurança...)

```
Exemplo: uma trading pode não precisar especificar uma baixa latência em todo sistema, embora os arquitetos nesse domínio do problema saibam como isso é essencial. As características explícitas da arquitetura aparecem nos documentos de requisitos ou em outras instruções específicas.
```

### Características da Arquitetura Listadas (em Parte)

Cada organização cria sua própria interpretação das características da arquitetura e não existe um padrão universal real (embora já tenham tentado), sempre há novas terminologias, então sempre tem variação e diferentes jeitos das empresas as utilizar.

#### Características Operacionais da Arquitetura:
As características operacionais da arquitetura envolvem capacidades como: 
- Disponibilidade: por quanto tempo o sistema precisa ficar disponível.
- Continuidade: Capacidade de recuperação de desastres.
- Desempenho: Inclui teste de estresse, análise de pico, análise da frequência das funções usadas, capacidade requerida e tempos de resposta.
- Recuperabilidade: Requisitos de continuidade do negócio.
- Confiabilidade/segurança: Avalia se o sistema precisa ser à prova de falhas ou se tem uma missão crítica no modo como afeta a vida das pessoas.
- Robustez: A capacidade de lidar com condições de erro e limites durante a execução, caso a conexão de internet caia ou se há falta de energia ou falha no hardware.
- Escalabilidade: A capacidade de o sistema rodar e operar quando o número de usuários ou requisições aumenta.

#### Características Estruturais da Arquitetura
Os arquitetos devem se preocupar com a estrutura do código, fazendo com que eles tenham uma responsabilidade única ou compartilhada pelas questões de qualidade do código. Questões estas como:<br>
- Configuração: A capacidade dos usuários finais de mudar com facilidade os aspectos de configuração do software (com interfaces úteis).
- Extensão: Como é importante ligar as novas partes da funcionalidade.
- Instabilidade: Facilidade de instalação do sistema em todas as plataformas necessárias.
- Aproveitamento/ reutilização: Capacidade de aproveitar os componentes comuns em vários produtos.
- Localização: Suporte para vários idiomas nas telas de entrada/consulta nos campos de dados; nos relatórios, requisitos de caracteres multibytes e unidades de medidas ou moedas.
- Manutenção: Quão facilmente aplica as alterações e melhora o sistema?
- Portabilidade: O sistema precisa rodar em mais de uma plataforma?
- Suporte: nível de suporte técnico que a aplicação precisa, se o nível de registro e outras facilidades são requeridos para depurar os erros no sistema, entre outros.
- Atualização: A capacidade de atualizar com facilidade/rapidez uma versão prévia dessa aplicação/solução para uma versão mais nova nos servidores e nos clientes.

#### Características Transversais da Arquitetura:
Embora muitas características da arquitetura se classifiquem em categorias fáceis de reconhecer, muitas estão fora ou desafiam a categorização, formando importantes restrições de design e considerações

- Acessibilidade: Acesso a todos os usuários, como com deficiências, daltonismo ou perda auditiva.
- Armazenamento: Em quanto tempo os dados precisarão ser armazenados ou excluídos após um período de tempo.
- Autenticação: Requisitos de segurança para assegurar que os usuários são quem dizem ser.
- Autorização: Requisitos de segurança para assegurar que os usuários possam acessar apenas certas funções na aplicação.
- Legalidade: As restrições legais o sistema opera (proteção de dados, Sarbanes Oxley, GDPR etc.), os direitos de reserva a empresa requer, se possui alguma regulação no modo como a aplicação será criada ou implantada...
- Privacidade: A capacidade de ocultar as transações dos funcionários internos da empresa.
- Segurança: Se os dados precisam ser criptografados: no banco de dados, na comunicação de rede entre os sistemas internos. Se precisa de autenticação para o acesso remoto do usuário...
- Suporte: Qual nível de: suporte técnico a aplicação precisa, registro e outras facilidades são necessários para depurar os erros no sistema.
- Usabilidade/viabilidade: O nível de treinamento requerido para os usuários atingirem seus objetivos com a aplicação/solução.

#### Outros termos:
- Interoperabilidade: Implica a facilidade de integração com outros sistemas, que por sua vez implica em APIs publicadas e documentadas.
- Compatibilidade: se preocupa mais com os padrões do setor e do domínio.
- Aprendizado: pode ser tanto a facilidade dos usuários aprenderem a usar o software ou o nível no qual o sistema pode aprender automaticamente sobre seu ambiente para se tornar autoconfigurado ou auto-otimizado usando algoritmos de aprendizado de máquina(IA).
- Adequação funcional: Representa o grau no qual um sistema fornece funções que atendem as necessidades declaradas e implícitas quando usado sob certas condições. Sendo composta pelas seguintes características secundárias:
> Totalidade funcional: O grau no qual o conjunto de funções cobre todas as tarefas especificadas e objetivos do usuário.<br>
Correção funcional: O grau no qual um produto ou um sistema fornece resultados corretos com o grau de precisão necessário.<br>
Adequação funcional: O grau no qual as funções facilitam a realização de tarefas e objetivos específicos. Não são as características da arquitetura, mas os requisitos motivacionais para criar o software.

### Trade-offs e Arquitetura Menos Pior

Nenhuma aplicação consegue ter todas as boas características de uma arquitetura ao mesmo tempo, pois cada melhoria implica em compromissos (trade-offs). Exemplo: aumentar a segurança pode reduzir o desempenho, já que envolve mais processos de criptografia e proteção.

Por isso, arquitetos não devem buscar a “melhor” arquitetura, mas sim a menos pior, equilibrando requisitos e evitando soluções genéricas que tentam resolver tudo, pois essas tendem a falhar pela complexidade.

A recomendação é que a arquitetura seja iterativa e flexível, permitindo ajustes ao longo do tempo. Assim, errar e melhorar rapidamente é mais eficaz do que tentar acertar tudo de primeira — princípio alinhado ao **desenvolvimento ágil**.