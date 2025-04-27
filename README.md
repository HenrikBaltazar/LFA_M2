# LFA M2

## Build
```shell
mkdir -p build
javac -d build src/main/java/org/example/*.java
jar cfm build/lfa.jar MANIFEST.MF -C build .
jpackage --input build --name lfa --main-jar lfa.jar --main-class org.example.Main.Class --type exe --dest build/
```


## Trabalho


```
Fazer um programa para o reconhecimento de sentenças da linguagem
L = { w | w  {a, b, c, d, e}
+  w
segue o padrão de formação (ab)^n c^m d^p e^q
em que (n + m) é ímpar,
p é um número qualquer e q é par }
```

### ENTRADA
sequência de caracteres (digitada na parte superior da janela - campo A), podendo
conter qualquer caracter da tabela ASCII, incluindo operadores aritméticos (+ - * /),
caracteres de controle (espaço em branco, quebra de linha, tabulação), entre outros.


### SAÍDA
os caracteres da entrada devem ser agrupados, apresentados (na parte inferior da
janela - campo B) e classificados nas seguintes categorias:
• sentença válida: sentença que pertence a linguagem L;
• operador aritmético: um dos símbolos especiais (+ ou - ou * ou /);
• ERRO – sentença inválida: sentença que inicia com um dos símbolos do alfabeto
da linguagem, mas não segue o padrão de formação especificado ou contém na
sequência símbolos inválidos;
• ERRO – símbolo(s) inválido(s): sequência de caracteres que inicia com símbolos
que não pertencem ao alfabeto da linguagem em questão, não são operadores
aritméticos, nem caracteres de controle.

### EXEMPLOS

|ENTRADA  |SAIDA  |
|---------|---------|
|```ababcdd +abccee ccc ab bca cceee c  / abcdyyyyy** bcbcbcddddd abababee  dddaa  834aad xxxycde```     |sentença válida: ababcdd operador aritmético: + sentença válida: abccee sentença válida: ccc sentença válida: ab ERRO: sentença inválida: bca ERRO: sentença inválida: cceee sentença válida: c operador aritmético: / ERRO: sentença inválida: abcdyyyyy operador aritmético: * operador aritmético: * ERRO: sentença inválida: bcbcbcddddd sentença válida: abababee ERRO: sentença inválida: dddaa ERRO: símbolo(s) inválido(s): 834aad ERRO: símbolo(s) inválido(s): xxxycde         |


### OBSERVAÇÕES
- os caracteres de controle devem ser desprezados, ou seja, não devem aparecer na saída;
- os caracteres que indicam que uma sentença foi completamente lida e pode ser classificada são operadores aritméticos e caracteres de controle (separadores de tokens);
- os caracteres devem ser lidos símbolo a símbolo, exclusivamente, sob pena de receber nota zero, caso seja feito de outra forma;
- para efetuar o reconhecimento de sentenças pertencentes (ou não) à linguagem L, deve ser implementado o autômato finito determinístico mínimo, utilizando a forma de implementação genérica apresentada na disciplina, sob pena de receber nota zero, caso não seja utilizado o algoritmo genérico de implementação de autômatos finitos;
- a prova P2 poderá conter perguntas a respeito do trabalho

### ENTREGA
- o diagrama de transição do AFDm;
- o programa fonte e o programa executável (ou seja, todo do projeto)
postados no link da atividade, compactados com o nome da equipe.