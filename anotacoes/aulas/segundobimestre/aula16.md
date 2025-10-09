# Aula do dia 06/10/2025. (INCOMPLETO)

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

>>>>>>>>>>>>>>>>>>Parei aqui