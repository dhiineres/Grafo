package br.ufg.inf.es.grafos;

import java.util.Scanner;

public class Main {
    public static Grafo grafo;
    public static Scanner input = new Scanner(System.in);
    
    public static void iniciaGrafo(){
        System.out.println("Digite a quantidade de Vértices do grafo:");
        System.out.print(" - ");
        int numV = Integer.parseInt(input.nextLine());
        grafo = new Grafo(numV);
        for (int i = 1; i <= numV; i++){
            for (int j = 1; j<= i; j++){
                if (i == j){
                    grafo.addAresta(false);
                }else{
                    System.out.println("Os vértices ["+ i +"]["+ j +
                            "] são vizinhos? S/N");
                    System.out.print(" - ");
                    String resp = input.nextLine();
                    grafo.addAresta(resp.charAt(0) == 'S' || resp.charAt(0) == 's');
                }
            }
        }
        grafo.setOrdemGraus();
    }
    
    public static void main(String[] args){
        iniciaGrafo();
        
        System.out.println(grafo.printListas());
        
        System.out.println(grafo.getOrdemGraus());
        System.out.println(grafo.getVerticeMaior());
        System.out.println(grafo.getVerticeMenor());
        for(int i = 1; i <= grafo.getSize(); i++){
            System.out.println(grafo.getVizinhos(i));
        }
        
        if (!grafo.isCaminho()){
            System.out.print("Não ");
        }System.out.println("é caminho");
        if(!grafo.isCiclo()){
            System.out.print("Não ");
        }System.out.println("é ciclo");
        if(!grafo.isCompleto()){
            System.out.print("Não ");
        }System.out.println("é completo");
        
    }
}
