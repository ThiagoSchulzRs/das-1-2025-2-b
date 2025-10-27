# Aula do dia 27/10/2025.

### **Revisão das aulas passadas (23/10):**

Anotar aqui

## **Preparando o ambiente:** 

Link para a documentação da Microsoft
```
https://integrada.minhabiblioteca.com.br/reader/books/9788550819754/epubcfi/6/42[%3Bvnd.vst.idref%3Dcap11.xhtml]!/4/2/2/1:0[%2CCAP]
```

## **Estilo de Arquitetura Pipeline**

Arquitetura de Pipes: todos programas tem uma entrada de dados (sdtin) enviam sua uma saida de dados (sdtout). <br>
Assim, a arquiterua de pipes conecta um programa com outro fazendo que um envie a sua saida para a entrada do outro.

### **Canais:** 
Conecta um programa com o outro, que entra a questões de possuir Filtros.

### **Filtros:** 
Os filtros são autônomos e independentes dos outros filtros, em geral sem estado. Os filtros realizam apenas uma tarefa, as tarefas compostas devem ser lidadas por uma sequência de filtros, não por um. Os quatro tipos de filtros são:
- Produtor(Origem): ponto de partida de um processo, de saída apenas.
- Transformadores: pegam as informações e transformam em algo. (tudo em maiusculo etc)
- Verificadores: testa, checa e procura as informações
- Consumidor: no final pega as informações e gravar elas, chamar na intenet... (faz algo com ela)

## **Preparando o ambiente:** 

**Node-RED:** programa em Java-Script que ele mostra como codar com caixas (tipo o Scrath só que muito mais poderoso). Link para ver mais sobre o: [Node-RED](https://nodered.org/).

**Comando para instalar:** (precisa ter o Docker baixado)
> docker run -it -p 1880:1880 -v node_red_data:/data --name mynodered nodered/node-red

**Comando para desinstalar:**
> docker ps -a <br>
> docker rm mynodered

## **Extras:** 
### **Comandos:**
- **ps ax:** comando para verificar o que está rodando no Visual Studio.
- **tail:** verifica só as últimas linhas.
- **ps ax | grep -i java | tail:** lista todos os programas em execução, faz um filtro com todas as linhas que possuam java, e pega só os últimos.
- **more:** pega mais e mais linhas (se coloca no lugar do tail)
- **curl:** faz consulta pela internet. (chamada HTTP)
- **curl https://www.univille.br:** pega o código da Univille.
- **curl https://www.univille.br | tr a-z A-Z | tail:** pega o HTML inteiro da Univille, passa para o TR e passa tudo do minusculo para o maiusculo, e pega as últimas linhas
- **w get:** baixa em arquivo.