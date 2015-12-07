Implementação do Game of Life de Conway
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
 
 Ou simplesmente execute o arquivo "GoL.jar" disponível neste diretório


Notas de código
----------------------------------
Para visualizar o código, pode-se importar o projeto no eclipse
 da forma convencional

Import -> Existing Project into Workspace -> ../Path/to/GameOfLife-Strategy

A implementação é a mesma desenvolvida em sala do GameOfLife-Strategy, com 
apenas algumas modificações e adaptações.

A interface foi feita utilizando o Java Swing, uma biblioteca gráfica completa 
e amplamente utilizada no meio da computação.
Ela conta com:
- Um contador de geração na parte superior direita;
- Um array bidimensional 80x80 de botões simbolizando células vivas e mortas;
- Contadores de células vivas e mortas na geração atual;
- Radio Buttons para selecional qual das 5 estratégias disponíveis será utilizada;
- Botões de ação:
	*Next Generation - mostra a próxima geração
	*Play/Pause - inicia um Thread para mostrar as próximas gerações quando ativado
	*Rand! - Gera um número aleatório de células vivas e as dispõe em posições aleatórias do quadro 
	*Clear - Limpa todo o quadro, matando todas as células vivas
	
		
Notas de Injeção de Dependências
----------------------------------
Para fazer a injeção de dependências foi utilizado o framewok "Google Guice-2.0"
que facilita o processo de injeção de dependências. Foram importadas as bibliotecas do
framework no projeto, e foi feito o uso das classes criadas:
 - Estrategia -> Encapsula a estrategia selecionada na Engine
 - Injector -> Sobrescreve o método da classe AbstractModule da biblioteca do Guice
 e configura a Engine inicialmente com a estrategia Conway
 - Gerenciador -> Classe anônima que injeta a estrategia selecionada na engine
 
 Na classe GameView, onde é feita a interface, é também selecionada a estratégia, por
 meio de um RadioButton escolido pelo usuário, então para cada evento de RadioButton,
 uma dependência é injetada na engine assim:
 
 Estrategia.selectInjection(RadioButton.getText(), engine);
 
 Por meio da String do RadioButton que cada estratégia de jogo tem na interface. Esse tipo 
 de arquitetura permite adicionar facilmente outras estrategias de jogo, pois a solução é
 bastante elegante, fazendo com que o código seja bastante flexível.


Notas de estratégias implementadas
----------------------------------
Conway - Mantém viva a célula que tem 2 ou 3 vizinhos, e revive a que tem 3 vizinhos
é a estratégia clássica do Game of Life

High Life - Mantém viva a célula que tem 2 ou 3 vizinhos, e revive a que tem 3 ou 6 vizinhos

Live free or die - Mantém viva a célula que não tem vizinhos, e revive a que tem 2 vizinhos 

Fireworks - Mantém viva a célula que não tem vizinhos, e revive a que tem 1 vizinho
Desenvolvida por mim, essa estratégia produz comportamentos explosivos parecidos com
fogos de artifício, mesmo a partir de apenas 1 ponto

Seeds - A célula nunca morre em gerações futuras, e revive se tiver 2 vizinhos
Proporciona fractais impressionantes com apenas 2 células adjacentes


Notas de cobertura de código
----------------------------------
Foi utilizado o plugin do eclipse "EclEmma Java Code Coverage 2.3.2" 
para fazer os testes de cobertura de aplicação, e em diversos testes, a média 
de cobertura ficou entre 89,8% e 92,9% representando uma boa taxa de 
cobertura do código.


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

