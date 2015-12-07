Implementa��o do Internet Media Data Bank - Imdb
Alunos: Bruno Jorge Siqueira Rodrigues - 14/0017658
	Edgar Fabiano de Souza Filho - 14/0019201
	Lucas Rezende de Macedo - 14/0026363


Notas de compilacao e execucao
----------------------------------

para compilar todos os arquivos fonte, entre no diretorio "src" e 
execute: 

 $ javac main/java/br/unb/cic/imdb/negocio/Main.java -d ../bin 

como o codigo fonte Main.java depende das outras classes, o compilador 
java (javac) � inteligente o suficiente para compilar todas as outras 
classes dependentes. 

Ou pode executar o programa diretamente do eclipse
run -> Main a partir de br.unb.cic.imdb.negocio.Main


Notas de c�digo
----------------------------------
Para visualizar o c�digo, deve-se importar o projeto no eclipse
 como um "Existing Maven Project"

Import -> "Existing Maven Project into Workspace" -> ../Path/to/IMDB

A implementa��o � a mesma desenvolvida em sala do imdb, com 
apenas algumas modifica��es e adapta��es para o banco de dados


Notas de GUI
----------------------------------
A interface gr�fica foi feita utilizando o Java Swing, uma biblioteca 
gr�fica completa e amplamente utilizada no desenvolvimento de programas
juntamente com o plug-in windowbuilder para facilitar.
Ela conta com:
- Elementos intuitivos e f�ceis de utilizar
- Um JFrame onde ser�o inseridos os pain�is
- JPanels de cada parte do programa
 * Painel de Login
 * Painel de Cadatro
 * Painel de filtros por autor, trabalho art�stico e g�nero
 * Painel de avalia��o e visualizar avalia��es de um trabalho art�stico
 * Painel de criar um trabalho art�stico novo
 * Painel para visualizar as faixas de um trabalho art�stico se ele for um �lbum
   	
		
Notas de Inje��o de Depend�ncias
----------------------------------
O programa sustenta implementacoes em memoria e em JPA para os DAOs, para
alternar entre elas basta comentar o bloco referente � implementacao desejada.

Para utilizar a implementacao em memoria tamb�m � necessario retirar comentarios
dos setters sinalizados na classe *Populador.java* no pacote *br.unb.cic.imdb.negocio*.


Notas de Banco de dados
----------------------------------
O banco de dados utilizado foi o PostgreSQL 9.4.5, para utiliz�-lo � necessario seguir
os seguintes passos;
- Criar um novo usuario "postgres" e senha "postgres";
  Alternativamente, pode-se mudar a o usuario e a senha no arquivo *persistence.xml*
  caso o usuario ja possua o pgAdmin com usuario e senha diferente.
- Para criar o database basta entrar no servidor do usuario, digitar sua senha;
- Clicar com o botao direito em Databases->New Database...;
- Nomear o database "imdb".

Notas de cobertura de c�digo
----------------------------------
Foi utilizado o plugin do eclipse "EclEmma Java Code Coverage 2.3.2" 
para fazer os testes de cobertura de aplica��o, e em diversos testes, a m�dia 
de cobertura ficou entre 70% representando uma taxa de cobertura razo�vel
pois na maioria dos casos, a cobertura depende do usu�rio, ou seja, os m�todos
n�o ser�o chamados nem objetos instanciados se o usu�rio n�o requisitar pela GUI.


Pontos positivos
----------------------------------
Da forma que est� implementado, � poss�vel trocar de estrat�gia durante uma 
gera��o do jogo, ou seja, pode-se iniciar um tabuleiro aleat�rio utilizando uma
regra espec�fica, e ao longo do jogo trocar de regra, sem perder a configura��o.
Pode-se fazer isso inclusive quando o Thread est� ativo, ou seja, quando estiver
passando de gera��es de forma automatizada, pode-se tornar vivas ou matar c�lular,
e trocar as regras do jogo independentemente. E devido a inje��o de dependencias, �
relativamente f�cil de implementar novas regras, bastnado criar uma classe que herda
de uma interface e sobrescrever alguns m�todos.

