package org.example;

import java.util.ArrayList;

public class Analyzer {

    private String text;
    private ArrayList<ArrayList<Integer>> matrizDeTransicao = new ArrayList<>(); // [estado][simbolo]
    private ArrayList<Boolean> estadosFinais = new ArrayList<>();

    public Analyzer(String text) {
        this.text = text;
        geraMatrizTransicao(11);
    }

    private void geraMatrizTransicao(int numEstados){
        for(int i = 0; i < numEstados; i++){
            this.matrizDeTransicao.add(new ArrayList<>());
        }
        this.matrizDeTransicao.get(0).add(1); this.matrizDeTransicao.get(0).add(9); this.matrizDeTransicao.get(0).add(4); this.matrizDeTransicao.get(0).add(9); this.matrizDeTransicao.get(0).add(9);
        this.matrizDeTransicao.get(1).add(9); this.matrizDeTransicao.get(1).add(2); this.matrizDeTransicao.get(1).add(9); this.matrizDeTransicao.get(1).add(9); this.matrizDeTransicao.get(1).add(9);
        this.matrizDeTransicao.get(2).add(3); this.matrizDeTransicao.get(2).add(9); this.matrizDeTransicao.get(2).add(5); this.matrizDeTransicao.get(2).add(6); this.matrizDeTransicao.get(2).add(7);
        this.matrizDeTransicao.get(3).add(9); this.matrizDeTransicao.get(3).add(0); this.matrizDeTransicao.get(3).add(9); this.matrizDeTransicao.get(3).add(9); this.matrizDeTransicao.get(3).add(9);
        this.matrizDeTransicao.get(4).add(9); this.matrizDeTransicao.get(4).add(9); this.matrizDeTransicao.get(4).add(5); this.matrizDeTransicao.get(4).add(6); this.matrizDeTransicao.get(4).add(7);
        this.matrizDeTransicao.get(5).add(9); this.matrizDeTransicao.get(5).add(9); this.matrizDeTransicao.get(5).add(4); this.matrizDeTransicao.get(5).add(9); this.matrizDeTransicao.get(5).add(9);
        this.matrizDeTransicao.get(6).add(9); this.matrizDeTransicao.get(6).add(9); this.matrizDeTransicao.get(6).add(9); this.matrizDeTransicao.get(6).add(6); this.matrizDeTransicao.get(6).add(7);

        this.matrizDeTransicao.get(7).add(9); this.matrizDeTransicao.get(7).add(9); this.matrizDeTransicao.get(7).add(9); this.matrizDeTransicao.get(7).add(9); this.matrizDeTransicao.get(7).add(8);
        this.matrizDeTransicao.get(8).add(9); this.matrizDeTransicao.get(8).add(9); this.matrizDeTransicao.get(8).add(9); this.matrizDeTransicao.get(8).add(9); this.matrizDeTransicao.get(8).add(7);
        this.matrizDeTransicao.get(9).add(9); this.matrizDeTransicao.get(9).add(9); this.matrizDeTransicao.get(9).add(9); this.matrizDeTransicao.get(9).add(9); this.matrizDeTransicao.get(9).add(9);
        this.matrizDeTransicao.get(10).add(10); this.matrizDeTransicao.get(10).add(10); this.matrizDeTransicao.get(10).add(10); this.matrizDeTransicao.get(10).add(10); this.matrizDeTransicao.get(10).add(10);

        this.estadosFinais.add(false);this.estadosFinais.add(false);
        this.estadosFinais.add(true);this.estadosFinais.add(false);
        this.estadosFinais.add(true);this.estadosFinais.add(false);
        this.estadosFinais.add(true);this.estadosFinais.add(false);
        this.estadosFinais.add(true);this.estadosFinais.add(false);
        this.estadosFinais.add(false);

    }

    public String Analyzer() {
        return text;
    }

    public String AnalizaEntrada(String entrada){
        String result = "";
        String tempResult = "";
        int estado = 0;
        char simbolo = ' ';
        for(int i=0; i<entrada.length();i++){
            simbolo = entrada.charAt(i);
            if(simbolo == ' ' || simbolo == '\n' || simbolo == '\t'){
                result += verificaSentenca(tempResult, estado);
                estado = 0;
                tempResult = "";
            }
            else if(ehOperador(simbolo)) {
                if (!tempResult.isEmpty()){
                    result += verificaSentenca(tempResult, estado);
                    estado = 0;
                    tempResult = "";
                }
                result += " operador aritmético:               " + simbolo + "\n";
            }

            else {
                tempResult += simbolo;
                estado = matrizDeTransicao.get(estado).get(getSimbolIndex(simbolo));
            }
        }
        if(tempResult.length() > 0){
            result += verificaSentenca(tempResult, estado);
        }
        return result.toString();
    }

    public int getSimbolIndex(char simbolo){ // Traduz o simbolo em char pra um indice da matriz
        if(simbolo == 'a'){
            return 0;
        } else if (simbolo == 'b') {
            return 1;
        }else if(simbolo == 'c'){
            return 2;
        }else {
            return 3;
        }
    }

    public String verificaSentenca(String tempResult, int estado){

        if(estadosFinais.get(estado) && !tempResult.toString().equals(" ") && !tempResult.toString().equals("")){
            tempResult = " sentença reconhecida:            " + tempResult + "\n";
        }else if(!tempResult.toString().equals(" ") && !tempResult.toString().equals("")){
            if(tempResult.charAt(0) == 'a' || tempResult.charAt(0) == 'b' || tempResult.charAt(0) == 'c' || tempResult.charAt(0) == 'd' || tempResult.charAt(0) == 'e')
                tempResult = " ERRO: sentença inválida:       " + tempResult + "\n";
            else {
                tempResult = " ERRO: simbolo(s) inválido(s): " + tempResult + "\n";
            }
        }
        return tempResult;
    }

    public boolean ehOperador(char simbolo){
        return simbolo == '+' || simbolo == '-' || simbolo == '*' || simbolo == '/';
    }
}
