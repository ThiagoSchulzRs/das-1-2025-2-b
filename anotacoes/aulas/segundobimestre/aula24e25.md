# Aula do dia 03/11/2025 e 06/11/2025.

### **Revisão das aulas passadas (30/10):**

Fizemos um exemplo de pipeline no formato de um serviço de Streaming de desenhar.

## **Preparando o ambiente:** 

```
https://integrada.minhabiblioteca.com.br/reader/books/9788550819754/epubcfi/6/44[%3Bvnd.vst.idref%3Dcap12.xhtml]!/4
```

## **Estilo de Arquitetura Microkernel**

Arquitetura de plug-in é um ajuste natural para os aplicativos baseados em produto (empacotados e disponibilizados para download e instalação como uma única implementação monolítica, em geral instalada no site do cliente como um produto de terceiros), mas também é largamente usado em muitos aplicativos comerciais personalizados não de produtos.

**Usar quando:**
- A aplicação precisa ser altamente customizável.
- Regras variam por cliente, localização ou produto.
- O sistema deve permitir extensão sem refatorar o núcleo.

**Exemplos ideais:** Sistemas fiscais, seguros, ERPs configuráveis, IDEs, plugins de navegador.

### Topologia

Estrutura monolítica relativamente simples consistindo em dois componentes da arquitetura: um sistema central e componentes de plug-in.

A lógica do aplicativo é dividida entre componentes de plug-in independentes e o sistema central básico, fornecendo extensão, adaptação e isolamento dos recursos da aplicação e lógica de processamento personalizada.

![Exemplo da arquitetura Microkernel](https://miro.medium.com/v2/resize:fit:691/1*m0qwauaHMuEaS6DYK1NP-g.png "Exemplo de arquitetura Microkernel em camadas")

![Exemplo da arquitetura Microkernel](https://tse2.mm.bing.net/th/id/OIP.FT8oec8TVbJK3qnFc5KzWgHaE6?pid=ImgDet&w=474&h=314&rs=1&o=7&rm=3 "Exemplo da arquitetura Microkernel em bloco monolítico modular")

### **Sistema Central (Kernel)**: 

Contém apenas as funcionalidades mínimas e o fluxo principal. Toda lógica volátil e customizável é movida para *plug-ins*, por isso possui baixa complexidade e não contém regras específicas. Exemplo: no Eclipse, o núcleo é apenas um editor básico; tudo o mais é plug-in.

**Vantagens:**
- Manutenção facilitada: pela menor complexidade no núcleo.
- Testabilidade maior: por causa das regras isoladas.
- Extensibilidade: pela possibilidade de apenas adicionar um novo plug-in para suportar um novo caso.

### **Componentes de Plug-in**: 

Módulos externos que adicionam funcionalidades específicas, podendo ser adicionados, removidos ou modificados sem alterar o núcleo.
- São autônomos e independentes entre si.
- Contêm regras, comportamentos ou funcionalidades específicas.
- Podem ser:
  - Baseados em compilação → requerem redeploy.
  - Carregados em tempo de execução → podem ser ativados/desativados sem parar o sistema.

A camada de apresentação do sistema central pode ser incorporada no sistema central ou implementada como uma interface de usuário separada

![Exemplo da arquitetura Microkerne](https://tse2.mm.bing.net/th/id/OIP.iIvtni91CZxxV9Cgn5616AHaDd?w=1200&h=561&rs=1&pid=ImgDetMain&o=7&rm=3 "Exemplo da arquitetura Microkernel com interface de usuário")

### Armazenamento de Dados

O banco principal geralmente pertence ao sistema central, mas os Plug-ins podem ter bancos próprios para regras específicas, o que evita acoplamento e facilita mudanças.

### Registro e Contratos
O sistema central mantém um registro dos plug-ins disponíveis.
Contratos especificam:
- Dados de entrada/saída
- Comportamento esperado
Podem ser implementados em interfaces, XML, JSON, etc.

**Exemplos Comuns de Uso:**
- IDEs → Eclipse, VS Code, JetBrains
- Ferramentas de build/CI → Jenkins, Jira
- Navegadores → Chrome, Firefox
- Sistemas empresariais com muita customização por cliente (seguros e impostos, onde cada jurisdição → um plug-in))

## Vantagens e Desvantagens

<!-- Gerado pelo Chat GPT essa tabela, normalmente não uso muita coisa mas achei interessante -->

| Característica | Nível | Observação |
|---|:---:|---|
| Simplicidade | ⭐⭐⭐⭐⭐ | Núcleo pequeno e claro |
| Custo de manutenção | ⭐⭐⭐⭐⭐ | Extensões isoladas |
| Modularidade e Extensibilidade | ⭐⭐⭐⭐☆ | Adicionar/remover plug-ins é fácil |
| Testabilidade | ⭐⭐⭐ ☆ ☆ | Testes isolados por plug-in |
| Performance | ⭐⭐⭐ ☆ ☆ | Pode melhorar desativando plug-ins, mas depende do design |
| Escalabilidade e Tolerância a Falhas | ⭐ ☆ ☆ ☆ ☆ | Geralmente monolítico; tudo passa pelo núcleo |
---