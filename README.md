#Iniciando

git clone https://github.com/lazarocoder/lamppSpring.git

cd: lamppSpring

#Pré-requisitos:

mvn --version

você deverá ver a versão do Maven instalada e a versão do JDK, dentre outras. Observe que o JDK é obrigatório, assim como a definição das variáveis de ambiente JAVA_HOME e M2_HOME para que a aplicação consiga ser executada corretamente.

mvn clean

remove diretório target

mvn compile

compila o projeto, deposita resultados no diretório target

mvn package

Gerar arquivo teste.jar no diretório target. Observe que o arquivo gerado não é executável. Um arquivo jar é um arquivo no formato zip. Você pode verificar o conteúdo deste arquivo ao executar o comando jar vft teste.jar.

mvn package -P executavel-dir

Gerar teste-dir.jar, executável, mas dependente do diretório jars, também criado no diretório target. Para executar basta o comando java -jar target/teste-dir.jar. Observe que se o diretório jars for removido, então este comando falha. Por último, o diretório jars deve ser depósitado no mesmo diretório do arquivo teste.jar.

mvn package -P executavel-unico

Gerar jar executável correspondente ao aplicativo a ser executado via linha de comandos, em um único arquivo, target/teste-unico.jar, suficiente para ser transferido e executado. Para executá-lo basta o comando java -jar target/teste-unico.jar.

mvn package -P api

Gerar jar executável juntamente com todas as dependências reunidas em um único arquivo, target/api.jar. Este arquivo jar pode ser transferido para outro diretório ou máquina e ser executado pelo comando java -jar target/api.jar. A execução e exemplos de chamadas são estão correlatas logo abaixo:

mvn exec:java -Dexec.mainClass="nome.completo.Classe" -Dexec.args="arg3 arg4" Executa o método main da classe indicada na configuração do plugin pertinente no arquivo pom.xml. Depende de mvn compile.

java -jar target/teste-unico.jar Executa o aplicativo por meio do arquivo jar criado pelo comando mvn package -P executavel-único, conforme comentado anteriormente. O arquivo jar permite que seja enviado para um outro diretório ou outro computador, onde pode ser executado, enquanto o comando anterior (acima) exige, inclusive, a disponibilidade do Maven (o que pode ser útil em tempo de desenvolvimento).

java -jar target/api.jar ou ainda mvn spring-boot:run Coloca em execução a API gerada por mvn package -P api na porta padrão (8080). Para fazer uso de porta diferente use java -jar -Dserver.port=9876 target/api.jar, como podemos usar por exemplo.
