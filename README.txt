Implementação do Internet Media Data Bank - Imdb
Alunos: Bruno Jorge Siqueira Rodrigues - 14/0017658
	Edgar Fabiano de Souza Filho - 14/0019201
	Lucas Rezende de Macedo - 14/0026363


Notas de compilacao e execucao
----------------------------------

para compilar todos os arquivos fonte, entre no diretorio "src" e 
execute: 

 $ javac main/java/br/unb/cic/imdb/negocio/Main.java -d ../bin 

como o codigo fonte Main.java depende das outras classes, o compilador 
java (javac) é inteligente o suficiente para compilar todas as outras 
classes dependentes. 

Ou pode executar o programa diretamente do eclipse
run -> Main a partir de br.unb.cic.imdb.negocio.Main


Notas de código
----------------------------------
Para visualizar o código, deve-se importar o projeto no eclipse
 como um "Existing Maven Project"

Import -> "Existing Maven Project into Workspace" -> ../Path/to/IMDB

A implementação é a mesma desenvolvida em sala do imdb, com 
apenas algumas modificações e adaptações para o banco de dados


Notas de GUI
----------------------------------
A interface gráfica foi feita utilizando o Java Swing, uma biblioteca 
gráfica completa e amplamente utilizada no desenvolvimento de programas
juntamente com o plug-in windowbuilder para facilitar.
Ela conta com:
- Elementos intuitivos e fáceis de utilizar
- Um JFrame onde serão inseridos os painéis
- JPanels de cada parte do programa
 * Painel de Login
 * Painel de Cadatro
 * Painel de filtros por autor, trabalho artístico e gênero
 * Painel de avaliação e visualizar avaliações de um trabalho artístico
 * Painel de criar um trabalho artístico novo
 * Painel para visualizar as faixas de um trabalho artístico se ele for um álbum
   	
		
Notas de Injeção de Dependências
----------------------------------
O programa sustenta implementacoes em memoria e em JPA para os DAOs, para
alternar entre elas basta comentar o bloco referente à implementacao desejada.

Para utilizar a implementacao em memoria também é necessario retirar comentarios
dos setters sinalizados na classe *Populador.java* no pacote *br.unb.cic.imdb.negocio*.


Notas de Banco de dados
----------------------------------
O banco de dados utilizado foi o PostgreSQL 9.4.5, para utilizá-lo é necessario seguir
os seguintes passos;
- Criar um novo usuario "postgres" e senha "postgres";
  Alternativamente, pode-se mudar a o usuario e a senha no arquivo *persistence.xml*
  caso o usuario ja possua o pgAdmin com usuario e senha diferente.
- Para criar o database basta entrar no servidor do usuario, digitar sua senha;
- Clicar com o botao direito em Databases->New Database...;
- Nomear o database "imdb".

Notas de cobertura de código
----------------------------------
Foi utilizado o plugin do eclipse "EclEmma Java Code Coverage 2.3.2" 
para fazer os testes de cobertura de aplicação, e em diversos testes, a média 
de cobertura ficou entre 70% representando uma taxa de cobertura razoável
pois na maioria dos casos, a cobertura depende do usuário, ou seja, os métodos
não serão chamados nem objetos instanciados se o usuário não requisitar pela GUI.


Pontos positivos
----------------------------------
Da forma que está implementado, é possível trocar de estratégia durante uma 
geração do jogo, ou seja, pode-se iniciar um tabuleiro aleatório utilizando uma
regra específica, e ao longo do jogo trocar de regra, sem perder a configuração.
Pode-se fazer isso inclusive quando o Thread está ativo, ou seja, quando estiver
passando de gerações de forma automatizada, pode-se tornar vivas ou matar célular,
e trocar as regras do jogo independentemente. E devido a injeção de dependencias, é
relativamente fácil de implementar novas regras, bastnado criar uma classe que herda
de uma interface e sobrescrever alguns métodos.

