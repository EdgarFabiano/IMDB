Implementa��o do Game of Life de Conway
Aluno: Edgar Fabiano de Souza Filho - 14/0019201


Notas de compilacao e execucao
----------------------------------

para compilar todos os arquivos fonte, entre no diretorio src e 
execute: 

 $ javac br/unb/cic/lp/gol/Main.java -d ../bin 

como o codigo fonte Main.java depende das outras classes, o compilador 
java (javac) eh inteligente o suficiente para compilar todas as outras 
classes dependentes. 

para executar, entre no diretorio bin (note que esse diretorio deve 
existir antes da compilacao), e execute a classe Main, com o seguinte 
comando:

 $ java br.unb.cic.lp.gol.Main 
 
 Ou simplesmente execute o arquivo "GoL.jar" dispon�vel neste diret�rio


Notas de c�digo
----------------------------------
Para visualizar o c�digo, pode-se importar o projeto no eclipse
 da forma convencional

Import -> Existing Project into Workspace -> ../Path/to/GameOfLife-Strategy

A implementa��o � a mesma desenvolvida em sala do GameOfLife-Strategy, com 
apenas algumas modifica��es e adapta��es.

A interface foi feita utilizando o Java Swing, uma biblioteca gr�fica completa 
e amplamente utilizada no meio da computa��o.
Ela conta com:
- Um contador de gera��o na parte superior direita;
- Um array bidimensional 80x80 de bot�es simbolizando c�lulas vivas e mortas;
- Contadores de c�lulas vivas e mortas na gera��o atual;
- Radio Buttons para selecional qual das 5 estrat�gias dispon�veis ser� utilizada;
- Bot�es de a��o:
	*Next Generation - mostra a pr�xima gera��o
	*Play/Pause - inicia um Thread para mostrar as pr�ximas gera��es quando ativado
	*Rand! - Gera um n�mero aleat�rio de c�lulas vivas e as disp�e em posi��es aleat�rias do quadro 
	*Clear - Limpa todo o quadro, matando todas as c�lulas vivas
	
		
Notas de Inje��o de Depend�ncias
----------------------------------
Para fazer a inje��o de depend�ncias foi utilizado o framewok "Google Guice-2.0"
que facilita o processo de inje��o de depend�ncias. Foram importadas as bibliotecas do
framework no projeto, e foi feito o uso das classes criadas:
 - Estrategia -> Encapsula a estrategia selecionada na Engine
 - Injector -> Sobrescreve o m�todo da classe AbstractModule da biblioteca do Guice
 e configura a Engine inicialmente com a estrategia Conway
 - Gerenciador -> Classe an�nima que injeta a estrategia selecionada na engine
 
 Na classe GameView, onde � feita a interface, � tamb�m selecionada a estrat�gia, por
 meio de um RadioButton escolido pelo usu�rio, ent�o para cada evento de RadioButton,
 uma depend�ncia � injetada na engine assim:
 
 Estrategia.selectInjection(RadioButton.getText(), engine);
 
 Por meio da String do RadioButton que cada estrat�gia de jogo tem na interface. Esse tipo 
 de arquitetura permite adicionar facilmente outras estrategias de jogo, pois a solu��o �
 bastante elegante, fazendo com que o c�digo seja bastante flex�vel.


Notas de estrat�gias implementadas
----------------------------------
Conway - Mant�m viva a c�lula que tem 2 ou 3 vizinhos, e revive a que tem 3 vizinhos
� a estrat�gia cl�ssica do Game of Life

High Life - Mant�m viva a c�lula que tem 2 ou 3 vizinhos, e revive a que tem 3 ou 6 vizinhos

Live free or die - Mant�m viva a c�lula que n�o tem vizinhos, e revive a que tem 2 vizinhos 

Fireworks - Mant�m viva a c�lula que n�o tem vizinhos, e revive a que tem 1 vizinho
Desenvolvida por mim, essa estrat�gia produz comportamentos explosivos parecidos com
fogos de artif�cio, mesmo a partir de apenas 1 ponto

Seeds - A c�lula nunca morre em gera��es futuras, e revive se tiver 2 vizinhos
Proporciona fractais impressionantes com apenas 2 c�lulas adjacentes


Notas de cobertura de c�digo
----------------------------------
Foi utilizado o plugin do eclipse "EclEmma Java Code Coverage 2.3.2" 
para fazer os testes de cobertura de aplica��o, e em diversos testes, a m�dia 
de cobertura ficou entre 89,8% e 92,9% representando uma boa taxa de 
cobertura do c�digo.


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

