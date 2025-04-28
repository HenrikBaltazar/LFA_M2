package org.example;

import java.util.ArrayList;

public class Analyzer {

    private String text;
    private ArrayList<ArrayList<Integer>> matrizDeTransicao = new ArrayList<>(); // [estado][simbolo]
    private ArrayList<Boolean> estadosFinais = new ArrayList<>();

    public Analyzer(String text) {

        this.text = text;
        // MOCK DE EXEMPLO DA MATRIZ DE TRANSICAO E ESTADOS FINAIS DO ENUNCIADO SO PARA TESTE
        this.matrizDeTransicao.add(new ArrayList<>());
        this.matrizDeTransicao.get(0).add(0);
        this.matrizDeTransicao.get(0).add( 1);
        this.matrizDeTransicao.get(0).add( 3);
        this.matrizDeTransicao.get(0).add( 3);
        this.matrizDeTransicao.add(new ArrayList<>());
        this.matrizDeTransicao.get(1).add(3);
        this.matrizDeTransicao.get(1).add(1);
        this.matrizDeTransicao.get(1).add(2);
        this.matrizDeTransicao.get(1).add(3);
        this.matrizDeTransicao.add(new ArrayList<>());
        this.matrizDeTransicao.get(2).add(0);
        this.matrizDeTransicao.get(2).add(3);
        this.matrizDeTransicao.get(2).add(2);
        this.matrizDeTransicao.get(2).add(3);
        this.matrizDeTransicao.add(new ArrayList<>());
        this.matrizDeTransicao.get(3).add(3);
        this.matrizDeTransicao.get(3).add(3);
        this.matrizDeTransicao.get(3).add(3);
        this.matrizDeTransicao.get(3).add(3);

        this.estadosFinais.add(false);
        this.estadosFinais.add(false);
        this.estadosFinais.add(true);
        this.estadosFinais.add(false);

    }

    public String Analyzer() {
        return text;
    }

    public String AnalizaEntrada(String entrada){
        StringBuilder result = new StringBuilder();
        StringBuilder tempResult = new StringBuilder();
        int estado = 0;
        for(int i=0; i<entrada.length();i++){
            char simbolo = entrada.charAt(i);
            if(simbolo == ' ' || simbolo == '\n'){
                if(estadosFinais.get(estado) && !tempResult.toString().equals(" ") && !tempResult.toString().equals("")){
                    result.append(tempResult).append(" Sentença reconhecida \n");
                    tempResult = new StringBuilder();
                    estado = 0;
                }else if(!tempResult.toString().equals(" ") && !tempResult.toString().equals("")){
                    result.append(tempResult).append(" Sentença não reconhecida \n");
                    tempResult = new StringBuilder();
                    estado = 0;
                }
            }
            else {
                tempResult.append(simbolo);
                estado = matrizDeTransicao.get(estado).get(getSimbolIndex(simbolo));
            }
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
}
